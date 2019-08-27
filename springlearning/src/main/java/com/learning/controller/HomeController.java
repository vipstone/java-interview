package com.learning.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    /**
     * index 方法
     **/
    @RequestMapping("/")
    public ModelAndView index() {
        System.out.println("do index()");
        ModelAndView modelAndView = new ModelAndView("index",
                "message", "用户信息");
        return modelAndView;
    }

}
