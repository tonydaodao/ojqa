package org.ojqa.service.impl;

import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriter.MaxFieldLength;
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
import org.ojqa.ui.spring.SearchController;
import org.springframework.stereotype.Service;

/**
 * @author Isaac.yu
 * 
 */
@Service
public class SearchService {

    public List<Hit> search(SearchController searchController, String keyword) throws IOException,
            CorruptIndexException, ParseException {
        Directory dir = FSDirectory.open(new File(SearchController.INDEX_DIR));
        IndexSearcher is = new IndexSearcher(dir);

        QueryParser parser = new QueryParser(Version.LUCENE_30, "contents", new StandardAnalyzer(Version.LUCENE_30));
        Query query = parser.parse(keyword);
        TopDocs hits = is.search(query, 100);
        List<Hit> results = new ArrayList<Hit>();

        for (ScoreDoc scoreDoc : hits.scoreDocs) {
            Hit hit = new Hit();
            Document doc = is.doc(scoreDoc.doc);
            hit.setKeyword(keyword);
            hit.setLocation(doc.get("fullpath"));
            hit.setProbability(scoreDoc.score);
            hit.setText(doc.get("contents"));
            hit.setLinenumber(doc.get("linenumber"));
            results.add(hit);
        }
        is.close();
        return results;
    }

    public int index() throws IOException, CorruptIndexException, LockObtainFailedException, Exception {
        Directory dir = FSDirectory.open(new File(SearchController.INDEX_DIR));
        IndexWriter writer =
                new IndexWriter(dir, new StandardAnalyzer(Version.LUCENE_30), true, MaxFieldLength.UNLIMITED);
        try {
            FileFilter filter = new FileFilter() {
                public boolean accept(File pathname) {
                    return pathname.getName().toLowerCase().endsWith(".txt");
                }
            };
            File[] files = new File(SearchController.DATA_DIR).listFiles();

            for (File f : files) {
                if (!f.isDirectory() && !f.isHidden() && f.exists() && f.canRead()
                        && ((filter == null) || filter.accept(f))) {
                    indexFile(writer, f);
                }
            }
            return writer.numDocs();
        } finally {
            writer.close();
        }
    }

    public void indexFile(IndexWriter writer, File f) throws FileNotFoundException, IOException, CorruptIndexException {
        Scanner scanner = new Scanner(f);
        int lineNum = 1;
        while (scanner.hasNextLine()) {
            String nextLine = scanner.nextLine();
            Document doc1 = new Document();
            doc1.add(new Field("contents", nextLine, Field.Store.YES, Field.Index.ANALYZED));
            doc1.add(new Field("filename", f.getName(), Field.Store.YES, Field.Index.NOT_ANALYZED));
            doc1.add(new Field("fullpath", f.getCanonicalPath(), Field.Store.YES, Field.Index.NOT_ANALYZED));
            doc1.add(new Field("linenumber", "" + lineNum++, Field.Store.YES, Field.Index.NOT_ANALYZED));
            writer.addDocument(doc1);
        }
    }

}
