package org.jugbd.mnet.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by bazlur on 7/3/14.
 */
@Controller
@RequestMapping(value = "admin")
public class AdminController {

    @RequestMapping(value = {"index", "/"}, method = RequestMethod.GET)
    public String index() {
        return "admin/index";
    }
}
