package com.example.dbapp.delegator;

import com.example.dbapp.service.merchant.MerhantService;
import com.example.dbapp.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductDelegator {
    @Autowired
    ProductService productService;

    @Autowired
    MerhantService merhantService;

    public void createProductDelegator() {

        System.out.println("delegator");
        productService.createProduct();
        merhantService.output();

    }
}
