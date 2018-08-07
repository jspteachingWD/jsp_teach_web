package com.jsptw.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@RestController
public class UserMenuController {

    @GetMapping(value = "/menu")
    public ModelAndView menu(){
        ModelAndView model = new ModelAndView();
        model.addObject("title", "权限管理");
        model.setViewName("permission/menu");
        return model;
    }

}
