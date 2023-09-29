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

    @RequestMapping("/map")
    public String map(){
        Product product = productMapper.selectByPrimaryKey(2);
        return product.getName();
    }

}
