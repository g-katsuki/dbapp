package com.example.dbapp.service.product;

import com.example.dbapp.service.AbstructCreateService;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    @Override
    public void product(){
        System.out.println("create");
//        doCommonLogic();
    }
}
