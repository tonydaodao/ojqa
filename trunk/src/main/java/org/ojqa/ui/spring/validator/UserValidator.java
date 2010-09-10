package org.ojqa.ui.spring.validator;

import org.apache.commons.lang.StringUtils;
import org.ojqa.domain.pojo.User;
import org.springframework.validation.Errors;

/**
 * @author ybak
 * 
 */
public final class UserValidator {
    private UserValidator() {
    }

    public static void validate(User user, Errors errors) {
        if (!StringUtils.isNotBlank(user.getName())) {
            errors.rejectValue("name", "required", "required");
        }
        if (!StringUtils.isNotBlank(user.getPassword())) {
            errors.rejectValue("password", "required", "required");
        }
        if (!StringUtils.isNotBlank(user.getConfirmPassword())) {
            errors.rejectValue("confirmPassword", "required", "required");
        }

    }

}
