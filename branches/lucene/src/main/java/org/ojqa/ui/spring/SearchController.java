/**
 * 
 */
package org.ojqa.ui.spring;

import java.io.IOException;
import java.util.List;

import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.queryParser.ParseException;
import org.apache.lucene.store.LockObtainFailedException;
import org.ojqa.domain.pojo.Hit;
import org.ojqa.service.impl.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    public SearchService searchService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String input() {
        return "search/form";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ModelAndView doSearch(@RequestParam("keyword") String keyword) throws IOException, ParseException {
        List<Hit> results = searchService.search(this, keyword);
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/search/list");
        mav.addObject("hits", results);
        return mav;
    }

    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String doIndex() throws IOException, CorruptIndexException, LockObtainFailedException, Exception {
        searchService.index();
        return "redirect:/search";
    }

    public void setSearchService(SearchService searchService) {
        this.searchService = searchService;
    }
}
