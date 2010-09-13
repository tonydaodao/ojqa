package org.ojqa.ui.spring;

import org.ojqa.domain.pojo.User;
import org.ojqa.service.UserService;
import org.ojqa.ui.spring.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author ybak
 * 
 */
@Controller
@RequestMapping(value = "/user")
public class UserController extends BaseController<User> {
    @Autowired
    public UserController(UserService service) {
        super(service);
    }

    @Override
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String get(@PathVariable Long id, Model model) {
        User entity = getService().get(id);
        entity.setConfirmPassword(entity.getPassword());
        model.addAttribute("entity", entity);
        return getRootPath() + "/form";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String save(@ModelAttribute("entity") User entity, BindingResult result) {
        UserValidator.validate(entity, result);
        if (result.hasErrors()) {
            return getRootPath() + "/form";
        } else {
            getService().save(entity);
            return "redirect:" + getRootPath() + "/list";
        }
    }
}
