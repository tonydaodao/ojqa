/**
 * 
 */
package org.ojqa.ui.spring;

import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.math.RandomUtils;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.queryParser.ParseException;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.store.LockObtainFailedException;
import org.apache.lucene.util.Version;
import org.ojqa.domain.pojo.Hit;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controller for Search function.
 * 
 * @author ybak
 */
@Controller
@RequestMapping(value = "/search")
public class SearchController {
    public static final String INDEX_DIR = System.getProperty("java.io.tmpdir") + "index";

    public static final String DATA_DIR = System.getProperty("webapp.root") + "WEB-INF\\classes\\data";

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String input() {
        return "search/form";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ModelAndView search(@RequestParam("keyword") String keyword) throws IOException, ParseException {

        Directory dir = FSDirectory.open(new File(INDEX_DIR));
        IndexSearcher is = new IndexSearcher(dir);

        QueryParser parser = new QueryParser(Version.LUCENE_30, "contents", new StandardAnalyzer(Version.LUCENE_30));
        Query query = parser.parse(keyword);
        TopDocs hits = is.search(query, 10);
        List<Hit> results = new ArrayList<Hit>();

        for (ScoreDoc scoreDoc : hits.scoreDocs) {
            Hit hit = new Hit();
            Document doc = is.doc(scoreDoc.doc);
            hit.setKeyword(keyword);
            hit.setLocation(doc.get("fullpath"));
            hit.setProbability(RandomUtils.nextFloat());
            hit.setText("this is the text");
            results.add(hit);
        }
        is.close();

        ModelAndView mav = new ModelAndView();
        mav.setViewName("/search/list");
        mav.addObject("hits", results);
        return mav;
    }

    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String index() throws IOException, CorruptIndexException, LockObtainFailedException, Exception {
        indexFile();
        return "search/form";
    }

    private void indexFile() throws IOException, CorruptIndexException, LockObtainFailedException, Exception {
        Directory dir = FSDirectory.open(new File(INDEX_DIR));
        IndexWriter writer =
                new IndexWriter(dir, new StandardAnalyzer(Version.LUCENE_30), true,
                        IndexWriter.MaxFieldLength.UNLIMITED);
        try {
            FileFilter filter = new FileFilter() {
                public boolean accept(File pathname) {
                    return pathname.getName().toLowerCase().endsWith(".txt");
                }
            };
            File[] files = new File(DATA_DIR).listFiles();

            for (File f : files) {
                if (!f.isDirectory() && !f.isHidden() && f.exists() && f.canRead()
                        && (filter == null || filter.accept(f))) {
                    indexFile(f, writer);
                }
            }
            writer.numDocs();
        } finally {
            writer.close();
        }
    }

    private void indexFile(final File f, IndexWriter writer) throws Exception {
        Document doc1 = new Document();
        doc1.add(new Field("contents", new FileReader(f)));
        doc1.add(new Field("filename", f.getName(), Field.Store.YES, Field.Index.NOT_ANALYZED));
        doc1.add(new Field("fullpath", f.getCanonicalPath(), Field.Store.YES, Field.Index.NOT_ANALYZED));
        writer.addDocument(doc1);
    }
}
