package org.ojqa.ui.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Isaac.Yu
 *
 */
@Controller
@RequestMapping(value = "/")
public class HomePageController {

    @RequestMapping("")
    public String homePage() {
        return "redirect:/user/list";
    }
}
