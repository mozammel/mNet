package org.jugbd.mnet.web.controller;

import org.jugbd.mnet.domain.User;
import org.jugbd.mnet.domain.enums.Role;
import org.jugbd.mnet.service.UserService;
import org.jugbd.mnet.utils.PageWrapper;
import org.jugbd.mnet.web.editor.AuthorityEditor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

/**
 * Created by Bazlur Rahman Rokon on 7/15/14.
 */

@Controller
@RequestMapping("/user")
@Secured("ROLE_ADMIN")
public class UserController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {

        binder.registerCustomEditor(Role.class, new AuthorityEditor());
    }

    @RequestMapping(value = "create", method = RequestMethod.GET)
    public String create(User user) {

        return "user/create";
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String save(@Valid User user,
                       BindingResult result,
                       RedirectAttributes redirectAttrs) {

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
    public String index(Model uiModel, Pageable pageable) {

        Page<User> users = userService.findAll(pageable);
        PageWrapper<User> page = new PageWrapper<>(users, "/user");
        uiModel.addAttribute("page", page);

        return "user/index";
    }

    @RequestMapping(value = "show/{id}", method = RequestMethod.GET)
    public String show(@PathVariable("id") Long id, Model uiModel) {
        log.debug("show() id ={}", id);

        User user = userService.findById(id);
        uiModel.addAttribute("user", user);

        return "user/show";
    }

    @RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable("id") Long id, Model uiModel) {
        log.debug("edit() id ={}", id);

        User user = userService.findById(id);
        user.setPassword(null);
        uiModel.addAttribute("user", user);

        return "user/edit";
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String update(@Valid @ModelAttribute("user") User user,
                         BindingResult result,
                         RedirectAttributes redirectAttrs) {
        log.debug("update() user ={}", user);

        if (result.hasErrors()) {
            return "user/edit";
        }

        userService.save(user);
        redirectAttrs.addFlashAttribute("message", "Successfully user updated");

        return "redirect:/user/show/" + user.getId().toString();
    }

    @RequestMapping(value = "cancel", method = RequestMethod.GET)
    public String cancel() {
        log.debug("cancel()");

        return "redirect:/user";
    }
}
