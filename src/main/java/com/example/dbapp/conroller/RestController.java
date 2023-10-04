package com.example.dbapp.conroller;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import com.example.dbapp.model.*;
import com.example.dbapp.mapper.*;

import java.util.List;

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

    @RequestMapping("/product")
    public ModelAndView product(){
        ProductExample ex = null;
        List<Product> products = productMapper.selectByExample(ex);
        ModelAndView model = new ModelAndView("product");
        model.addObject("products", products);
        return model;
    }

    // 登録後リダイレクトのでRequestMappingにする必要があったPostでもできるかはわからない
    @RequestMapping(value = "/addProduct", method = RequestMethod.POST)
    public ModelAndView addProduct(@ModelAttribute Product product){
        Product tmp_product = new Product();
        tmp_product.setName(product.getName());
        tmp_product.setCount(product.getCount());
        int i = productMapper.insert(tmp_product);

        // リダイレクト先のURLを指定してModelAndViewを作成
        ModelAndView modelAndView = new ModelAndView("redirect:/product");

        return modelAndView;
    }

}
