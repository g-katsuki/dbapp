package com.example.dbapp.delegator;

import com.example.dbapp.model.Product;
import com.example.dbapp.service.merchant.MerhantService;
import com.example.dbapp.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductDelegator {
    @Autowired
    ProductService productService;

    @Autowired
    MerhantService merhantService;

    public List<Product> createProductDelegator() {
        List<Product> products = new ArrayList<>();
        System.out.println("delegator");
        products = productService.createProduct();
        merhantService.output();
        return products;
    }
}
