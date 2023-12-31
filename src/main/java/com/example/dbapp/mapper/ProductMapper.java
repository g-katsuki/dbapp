package com.example.dbapp.mapper;

import com.example.dbapp.model.Product;
import com.example.dbapp.model.ProductExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

@Mapper
public interface ProductMapper {
    /**
     * @mbg.generated generated automatically, do not modify!
     */
    long countByExample(ProductExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByExample(ProductExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insert(Product row);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insertSelective(Product row);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    List<Product> selectByExample(ProductExample example, RowBounds rowBounds);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    List<Product> selectByExample(ProductExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    Product selectByPrimaryKey(Integer id);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExampleSelective(@Param("row") Product row, @Param("example") ProductExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExample(@Param("row") Product row, @Param("example") ProductExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKeySelective(Product row);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKey(Product row);
}