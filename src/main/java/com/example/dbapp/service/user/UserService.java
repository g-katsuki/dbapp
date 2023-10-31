package com.example.dbapp.service.user;

import com.example.dbapp.common.dto.base.Product;

import java.util.List;

public interface UserService {
    List<Product> getInventory(int userId);
}
