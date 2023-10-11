package com.example.dbapp.service.product;

import com.example.dbapp.service.AbstructCreateService;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl extends AbstructCreateService implements ProductService {
    @Override
    public void createProduct(){
        System.out.println("create");
        doCommonLogic();
    }
}
