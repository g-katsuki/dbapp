package com.example.dbapp.conroller;

import org.mybatis.spring.annotation.MapperScans;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @RequestMapping("/")
    public String test(){
        return "test";
    }
}
