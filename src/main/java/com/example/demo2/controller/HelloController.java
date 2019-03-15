package com.example.demo2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author yangs
 */
@Controller
@RequestMapping("hello")
public class HelloController {

    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String index(ModelMap modelMap){
        modelMap.addAttribute("message", "tomcat");
        return "hello";
    }
}
