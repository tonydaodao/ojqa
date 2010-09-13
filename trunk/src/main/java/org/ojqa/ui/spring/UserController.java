package org.ojqa.ui.spring;

import org.apache.commons.lang.StringUtils;
import org.ojqa.domain.pojo.User;
import org.ojqa.service.UserService;
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
    public UserController(final UserService service) {
        super(service);
    }

    @Override
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String get(@PathVariable final Long id, final Model model) {
        User entity = this.getService().get(id);
        entity.setConfirmPassword(entity.getPassword());
        model.addAttribute("entity", entity);
        return this.getRootPath() + "/form";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String save(@ModelAttribute("entity") final User entity, final BindingResult result) {
        this.validate(entity, result);
        if (result.hasErrors()) {
            return this.getRootPath() + "/form";
        } else {
            this.getService().save(entity);
            return "redirect:" + this.getRootPath() + "/list";
        }
    }

    private void validate(final User entity, final BindingResult result) {
        if (!StringUtils.isNotBlank(entity.getName())) {
            result.rejectValue("name", "required", "required");
        }
        if (!StringUtils.isNotBlank(entity.getPassword())) {
            result.rejectValue("password", "required", "required");
        }
        if (!StringUtils.isNotBlank(entity.getConfirmPassword())) {
            result.rejectValue("confirmPassword", "required", "required");
        }
    }
}
