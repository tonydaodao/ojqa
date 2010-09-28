/**
 * 
 */
package org.ojqa.ui.spring;

import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.io.IOException;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.store.LockObtainFailedException;
import org.apache.lucene.util.Version;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
        doc1.add(new Field("contents", new FileReader(f))); // 7
        doc1.add(new Field("filename", f.getName(), // 8
                Field.Store.YES, Field.Index.NOT_ANALYZED));// 8
        doc1.add(new Field("fullpath", f.getCanonicalPath(), // 9
                Field.Store.YES, Field.Index.NOT_ANALYZED));// 9
        writer.addDocument(doc1);
    }
}
