package com.example.dbapp.conroller.user;

import com.example.dbapp.common.dao.InventoryMapper;
import com.example.dbapp.common.dto.base.Product;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequestMapping("/user")
@Controller
public class UserController {

    @Autowired
    InventoryMapper inventoryMapper;

    @RequestMapping("/inventory")
    public ModelAndView inventory(){
        List<Product> products = inventoryMapper.findByUserId(1);
        for(int i=0; i<products.size(); i++){
            System.out.println(products.get(i).getName());
        }
//        System.out.println(products.get(0).getName());
        ModelAndView model = new ModelAndView("/user/inventory");
        return model;
    }
}
