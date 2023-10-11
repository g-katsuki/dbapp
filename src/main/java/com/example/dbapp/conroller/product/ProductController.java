package com.example.dbapp.conroller.product;

import com.example.dbapp.delegator.ProductDelegator;
import com.example.dbapp.mapper.ProductMapper;
import com.example.dbapp.model.Product;
import com.example.dbapp.model.ProductExample;
import com.example.dbapp.service.product.ProductService;
import com.example.dbapp.service.product.ProductServiceImpl;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
    ProductService productService;

    @Autowired
    ProductDelegator productDelegator;

    @RequestMapping("/list")
    public ModelAndView list() {
        productDelegator.createProductDelegator();
        ProductExample ex = null;
        List<Product> products = productMapper.selectByExample(ex);
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
    @RequestMapping(value = "/addProduct", method = RequestMethod.POST)
    public ModelAndView addProduct(@ModelAttribute Product product) {
        Product tmp_product = new Product();
        tmp_product.setName(product.getName());
        tmp_product.setCount(product.getCount());
        int i = productMapper.insert(tmp_product);
        ModelAndView modelAndView = new ModelAndView("redirect:/product/register");
        return modelAndView;
    }
    
    @RequestMapping("/test")
    public void test(){
        ProductService createProductService = null;
    }

}
