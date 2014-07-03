package org.jugbd.mnet.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Bazlur Rahman Rokon on 7/4/14.
 */
@Controller
public class AuthController {
    private static final Logger log = LoggerFactory.getLogger(AuthController.class);

    // Login form
    @RequestMapping("/login")
    public String login() {
        log.debug("login()");

        return "login";
    }

    // Login form with error
    @RequestMapping("/login-error")
    public String loginError(Model model) {
        log.debug("loginError()");

        model.addAttribute("loginError", true);
        return "login";
    }
}
