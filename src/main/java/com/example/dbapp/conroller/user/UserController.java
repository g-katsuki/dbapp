package com.example.dbapp.conroller.user;

import com.example.dbapp.common.dao.InventoryMapper;
import com.example.dbapp.common.dao.base.UserProductMappingMapper;
import com.example.dbapp.common.dto.base.Product;
import com.example.dbapp.common.dto.base.ProductExample;
import com.example.dbapp.common.dto.base.UserProductMapping;
import com.example.dbapp.common.dto.base.UserProductMappingExample;
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
    UserProductMappingMapper userProductMappingMapper;
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

    @RequestMapping("/register")
    public ModelAndView register() {
        UserProductMappingExample ex = null;
        List<UserProductMapping> userProductMappings = userProductMappingMapper.selectByExample(ex);
        ModelAndView model = new ModelAndView("/user/register");
        model.addObject("userProductMappings", userProductMappings);
        return model;
    }

    @PostMapping(value = "/addProduct")
    public ModelAndView addProduct(@ModelAttribute UserProductMapping userProductMapping) {
        UserProductMapping tmp_userProductMapping = new UserProductMapping();
        tmp_userProductMapping.setUserId(userProductMapping.getUserId());
        tmp_userProductMapping.setProductId(userProductMapping.getProductId());
        int i = userProductMappingMapper.insert(tmp_userProductMapping);
        ModelAndView modelAndView = new ModelAndView("redirect:/user/register");
        return modelAndView;
    }
}
