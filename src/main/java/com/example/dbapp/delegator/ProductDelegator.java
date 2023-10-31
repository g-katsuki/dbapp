package com.example.dbapp.delegator;

import com.example.dbapp.common.dto.base.Product;
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

    public List<Product> createProductDelegator() { return productService.createProduct(); }

    public void deleteProductDelegator(int id) {
        productService.deleteProduct(id);
    }
}
