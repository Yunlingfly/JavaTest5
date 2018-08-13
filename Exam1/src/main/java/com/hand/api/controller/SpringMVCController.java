package com.hand.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class SpringMVCController {

    @RequestMapping(value = "/mvc", method = RequestMethod.GET)
    public ModelAndView hello(HttpServletRequest request, HttpServletResponse response,
                              @RequestParam(defaultValue = "5") Integer num) {

        ModelAndView modelAndView=new ModelAndView("hello");
        modelAndView.addObject("some","some");
        modelAndView.getModelMap().put("map","sometest");
        return modelAndView;
    }

    @RequestMapping(value = "/identity", method = RequestMethod.GET)
    public String identity(HttpServletRequest request, HttpServletResponse response) {

        return "identity";
    }
}
