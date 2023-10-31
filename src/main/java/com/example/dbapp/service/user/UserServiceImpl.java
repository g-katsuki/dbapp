package com.example.dbapp.service.user;

import com.example.dbapp.common.dao.InventoryMapper;
import com.example.dbapp.common.dto.base.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    InventoryMapper inventoryMapper;

    @Override
    public List<Product> getInventory(int userId){
        List<Product> products = inventoryMapper.findByUserId(userId);
        return  products;
    }
}
