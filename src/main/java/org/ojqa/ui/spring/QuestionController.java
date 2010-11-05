/**
 * 
 */
package org.ojqa.ui.spring;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.math.RandomUtils;
import org.ojqa.domain.pojo.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Controller for question.
 * 
 * @author Isaac.Yu
 * 
 */
@Controller
@RequestMapping("/question")
public class QuestionController {

    /**
     * Common JPA repository.
     */
    private JpaTemplate jpaTemplate;
    private static final int FOOL_LENGTH = 102400;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String input(HttpSession session) {

        Map<String, int[]> cacheMap = getCache(session);

        int[] bigFool = getBigFool(cacheMap);

        processBigFool(bigFool);
        return "question/form";
    }

    private int[] getBigFool(Map<String, int[]> cacheMap) {
        int[] bigFool = null;
        int position = new Float(RandomUtils.nextFloat() * FOOL_LENGTH).intValue();
        String entryKey = Integer.toString(position);

        if (cacheMap.containsKey(entryKey)) {
            bigFool = cacheMap.get(entryKey);
        } else {
            bigFool = createBigArray(FOOL_LENGTH, position);
            cacheMap.put(entryKey, bigFool);
        }
        return bigFool;
    }

    private Map<String, int[]> getCache(HttpSession session) {
        ServletContext servletContext = session.getServletContext();
        Map<String, int[]> cacheMap = (Map) servletContext.getAttribute("cacheMap");
        synchronized (servletContext) {
            if (cacheMap == null) {
                // cacheMap = new WeakHashMap<String, int[]>();
                cacheMap = new HashMap<String, int[]>();
                servletContext.setAttribute("cacheMap", cacheMap);
            }
        }
        return cacheMap;
    }

    private void processBigFool(int[] smallFool) {
    }

    private int[] createBigArray(int foolLength, int position) {
        int[] smallFool = new int[foolLength];
        smallFool[position] = RandomUtils.nextInt();
        return smallFool;
    }

    @Transactional
    @RequestMapping(value = "", method = RequestMethod.POST)
    public String save(@ModelAttribute("question") Question entity, BindingResult result) {
        this.jpaTemplate.persist(entity);
        return "redirect:/";
    }

    @Autowired
    public void setJpaTemplate(JpaTemplate jpaTemplate) {
        this.jpaTemplate = jpaTemplate;
    }
}
