package com.example.dbapp.conroller;

import org.mybatis.spring.annotation.MapperScans;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@org.springframework.web.bind.annotation.RestController
public class RestController {
    int a = 0;

    @RequestMapping("/")
    public String test(){
        return "test";
    }

    @GetMapping(value = {"/index", ""})
    public ModelAndView index() {
        a++;
        ModelAndView model = new ModelAndView("index");
        model.addObject("message", "ハローワールド!");
        model.addObject("num", a);
        return model;
    }
}
