package com.example.dbapp.service.product;

import com.example.dbapp.common.dto.base.Product;

import java.util.List;

public interface ProductService {
    List<Product> createProduct();
    void deleteProduct(int id);
}
