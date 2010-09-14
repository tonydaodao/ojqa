/**
 * 
 */
package org.ojqa.ui.spring;

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
@RequestMapping(value = "/question")
public class QuestionController {

    /**
     * Common JPA repository.
     */
    private JpaTemplate jpaTemplate;

    @RequestMapping("")
    public String input() {
        return "question/form";
    }

    @Transactional
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String save(@ModelAttribute("entity") Question entity, BindingResult result) {
        this.jpaTemplate.persist(entity);
        return "redirect:/";
    }

    @Autowired
    public void setJpaTemplate(JpaTemplate jpaTemplate) {
        this.jpaTemplate = jpaTemplate;
    }
}
