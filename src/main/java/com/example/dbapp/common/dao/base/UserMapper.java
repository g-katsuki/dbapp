package com.example.dbapp.common.dao.base;

import com.example.dbapp.common.dto.base.User;
import com.example.dbapp.common.dto.base.UserExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

@Mapper
public interface UserMapper {
    /**
     * @mbg.generated generated automatically, do not modify!
     */
    long countByExample(UserExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByExample(UserExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insert(User row);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insertSelective(User row);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    List<User> selectByExample(UserExample example, RowBounds rowBounds);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    List<User> selectByExample(UserExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    User selectByPrimaryKey(Integer id);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExampleSelective(@Param("row") User row, @Param("example") UserExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExample(@Param("row") User row, @Param("example") UserExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKeySelective(User row);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKey(User row);
}