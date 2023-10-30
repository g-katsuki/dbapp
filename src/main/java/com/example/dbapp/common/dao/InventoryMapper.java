package com.example.dbapp.common.dao;

import com.example.dbapp.common.dto.base.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface InventoryMapper {
    List<Product> findByUserId(@Param("userId") int userId);
}
