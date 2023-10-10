package com.example.dbapp.conroller;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import com.example.dbapp.mapper.*;

@org.springframework.web.bind.annotation.RestController
//@MapperScan(basePackages = {"com.example.dbapp"})
public class HomeController {
    int a = 0;

    @Autowired
    ProductMapper productMapper;

    @RequestMapping("/")
    public ModelAndView home(){
        System.out.println("test");
        ModelAndView model = new ModelAndView("home");
        return model;
    }

    @GetMapping(value = {"/index", ""})
    public ModelAndView index() {
        System.out.println("index");
        a++;
        ModelAndView model = new ModelAndView("index");
        model.addObject("message", "count");
        model.addObject("num", a);
        return model;
    }

}
