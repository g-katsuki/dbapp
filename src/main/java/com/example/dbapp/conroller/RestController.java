package com.example.dbapp.conroller;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.example.dbapp.model.*;
import com.example.dbapp.mapper.*;

@org.springframework.web.bind.annotation.RestController
@MapperScan(basePackages = {"com.example.dbapp"})
public class RestController {
    int a = 0;

    @Autowired
    ProductMapper productMapper;

    @RequestMapping("/")
    public String test(){
        System.out.println("test");
        return "test2";
    }

    @GetMapping(value = {"/index", ""})
    public ModelAndView index() {
        System.out.println("index");
        a++;
        ModelAndView model = new ModelAndView("index");
        model.addObject("message", "ハローワールド!");
        model.addObject("num", a);
        return model;
    }

    @RequestMapping("/map")
    public String map(){
        System.out.println("before DB");
        Product product = productMapper.selectByPrimaryKey(2);
        System.out.println("After DB");
        System.out.println("Name :" + product.getName());
        return product.getName();
    }

}
