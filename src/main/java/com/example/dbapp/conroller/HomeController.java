package com.example.dbapp.conroller;

import com.example.dbapp.common.dao.base.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@org.springframework.web.bind.annotation.RestController
//@MapperScan(basePackages = {"com.example.dbapp"})
public class HomeController {

    @Autowired
    ProductMapper productMapper;

    @RequestMapping("/")
    public ModelAndView home(){
        ModelAndView model = new ModelAndView("home");
        return model;
    }

}
