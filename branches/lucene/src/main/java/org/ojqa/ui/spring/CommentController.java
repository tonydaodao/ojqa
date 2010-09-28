package org.ojqa.ui.spring;

import org.ojqa.domain.pojo.Comment;
import org.ojqa.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author ybak
 * 
 */
@Controller
@RequestMapping(value = "/comment")
public class CommentController extends BaseController<Comment> {
    @Autowired
    public CommentController(CommentService service) {
        super(service);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String save(@ModelAttribute("entity") Comment entity, BindingResult result) {
        getService().save(entity);
        return "redirect:" + getRootPath() + "/list";
    }
}
