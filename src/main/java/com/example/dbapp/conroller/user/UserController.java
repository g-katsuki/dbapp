package com.example.dbapp.conroller.user;

import com.example.dbapp.common.dao.InventoryMapper;
import com.example.dbapp.common.dto.base.Product;
import com.example.dbapp.delegator.UserDelegator;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequestMapping("/user")
@Controller
public class UserController {

    @Autowired
    InventoryMapper inventoryMapper;
    @Autowired
    UserDelegator userDelegator;

    Integer userId = 0;

    @RequestMapping("/inventory")
    public ModelAndView inventory(){
        List<Product> products = userDelegator.getInventoryDelegator(userId);
        for(int i=0; i<products.size(); i++){
            System.out.println(products.get(i).getName());
        }
        ModelAndView model = new ModelAndView("/user/inventory");
        model.addObject("products", products);
        return model;
    }

    @GetMapping("/selectUser")
    public ModelAndView selectUser(@RequestParam("userId") int userId){
        this.userId=userId;
        ModelAndView model = inventory();
        return model;
    }
}
