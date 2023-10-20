package com.example.dbapp.conroller.product;

import com.example.dbapp.common.dao.base.UserMapper;
import com.example.dbapp.common.dto.base.User;
import com.example.dbapp.common.dto.base.UserExample;
import com.example.dbapp.delegator.ProductDelegator;
import com.example.dbapp.common.dao.base.ProductMapper;
import com.example.dbapp.common.dto.base.Product;
import com.example.dbapp.common.dto.base.ProductExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
//@MapperScan(basePackages = {"com.example.dbapp.mapper"})
@RequestMapping("/product")
@Controller
public class ProductController {

    @Autowired
    ProductMapper productMapper;

    @Autowired
    UserMapper userMapper;

    @Autowired
    ProductDelegator productDelegator;

    @RequestMapping("/list")
    public ModelAndView list() {
        List<Product> products = productDelegator.createProductDelegator();
        UserExample ex = null;
        List<User> user = userMapper.selectByExample(ex);
        String name = user.get(0).getName();
        System.out.println(name);
        ModelAndView model = new ModelAndView("/product/list");
        model.addObject("products", products);
        return model;
    }

    @RequestMapping("/register")
    public ModelAndView register() {
        ProductExample ex = null;
        List<Product> products = productMapper.selectByExample(ex);
        ModelAndView model = new ModelAndView("/product/register");
        model.addObject("products", products);
        return model;
    }

    // 登録後リダイレクトしたいのでRequestMappingにする必要があったPostでもできるかはわからない
    @PostMapping(value = "/addProduct")
    public ModelAndView addProduct(@ModelAttribute Product product) {
        Product tmp_product = new Product();
        tmp_product.setName(product.getName());
        tmp_product.setCount(product.getCount());
        int i = productMapper.insert(tmp_product);
        ModelAndView modelAndView = new ModelAndView("redirect:/product/register");
        return modelAndView;
    }

    @RequestMapping("/delete")
    public ModelAndView delete() {
        List<Product> products = productDelegator.createProductDelegator();
        ModelAndView model = new ModelAndView("/product/delete");
        model.addObject("products", products);
        return model;
    }

    @PostMapping(value = "/deleteProduct")
    public ModelAndView deleteProduct(@ModelAttribute Product product) {
        productDelegator.deleteProductDelegator(product.getId());
        ModelAndView modelAndView = new ModelAndView("redirect:/product/delete");
        return modelAndView;
    }

}
