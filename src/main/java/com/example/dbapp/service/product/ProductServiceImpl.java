package com.example.dbapp.service.product;

import com.example.dbapp.mapper.ProductMapper;
import com.example.dbapp.model.Product;
import com.example.dbapp.model.ProductExample;
import com.example.dbapp.service.AbstructCreateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl extends AbstructCreateService implements ProductService {

    @Autowired
    ProductMapper productMapper;

    @Override
    public List<Product> createProduct() {
        ProductExample ex = null;
        List<Product> products = productMapper.selectByExample(ex);
        doCommonLogic();
        return products;
    }
}
