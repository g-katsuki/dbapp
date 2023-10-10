package com.example.dbapp.service.merchant;

import org.springframework.stereotype.Service;

@Service
public class MerchantServiceImpl implements MerhantService{
    @Override
    public void output(){
        System.out.println("merchant");
    }
}
