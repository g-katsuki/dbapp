package com.example.dbapp.delegator;

import com.example.dbapp.common.dto.base.Product;
import com.example.dbapp.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDelegator {

    @Autowired
    UserService userService;

    public List<Product> getInventoryDelegator(int userId){
        List<Product> products = userService.getInventory(userId);
        return products;
    }
}
