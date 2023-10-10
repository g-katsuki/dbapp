package com.example.dbapp.delegator;

import com.example.dbapp.service.merchant.MerhantService;
import com.example.dbapp.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.stereotype.Service;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

@Service
public class ProductDelegator {
    @Autowired
    ProductService productService;

    @Autowired
    MerhantService merhantService;
    public void createProductD(){
        
        System.out.println("delegator");
//        CreateProductService createProductService = null;
//        productService.product();
        merhantService.output();

    }
}
