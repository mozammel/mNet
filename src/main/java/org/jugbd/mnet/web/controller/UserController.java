package org.jugbd.mnet.web.controller;

import org.jugbd.mnet.domain.User;
import org.jugbd.mnet.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Bazlur Rahman Rokon on 7/15/14.
 */
@PreAuthorize("hasRole('ROLE_ADMIN')")
@Controller
@RequestMapping("/user")
public class UserController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @ModelAttribute("user")
    private User getUser() {
        return new User();
    }

    @RequestMapping(value = "create", method = RequestMethod.GET)
    public String create() {
        log.debug("create()");

        return "user/create";
    }

    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String save(@Valid @ModelAttribute("user") User user, BindingResult result, RedirectAttributes redirectAttrs) {
        log.debug("save()");

        if (result.hasErrors()) {
            return "user/create";
        }

        User userFound = userService.findByUserName(user.getUsername());

        if (userFound != null) {
            result.rejectValue("username", "error.user.username.already.available", "Its look like someone already has that username. Try another");
            return "user/create";
        }

        userService.save(user);
        redirectAttrs.addFlashAttribute("message", "Successfully user created");
        return "redirect:/user/show/" + user.getId().toString();
    }

    @RequestMapping(method = RequestMethod.GET)
    public String index(Model uiModel) {
        log.debug("index()");
        List<User> users = userService.findAll();
        uiModel.addAttribute("users", users);
        return "user/index";
    }

    @RequestMapping(value = "show/{id}", method = RequestMethod.GET)
    public String show(@PathVariable("id") Long id, Model uiModel) {
        User user = userService.findById(id);
        uiModel.addAttribute("user", user);
        return "user/show";
    }

    @RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable("id") Long id, Model uiModel) {
        User user = userService.findById(id);
        user.setPassword(null);
        uiModel.addAttribute("user", user);
        return "user/edit";
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String update(@Valid @ModelAttribute("user") User user, BindingResult result, RedirectAttributes redirectAttrs) {
        log.debug("save()");

        if (result.hasErrors()) {
            return "user/edit";
        }

        userService.save(user);
        redirectAttrs.addFlashAttribute("message", "Successfully user updated");
        return "redirect:/user/show/" + user.getId().toString();
    }
}
