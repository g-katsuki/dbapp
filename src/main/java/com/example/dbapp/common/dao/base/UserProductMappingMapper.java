package com.example.dbapp.common.dao.base;

import com.example.dbapp.common.dto.base.UserProductMapping;
import com.example.dbapp.common.dto.base.UserProductMappingExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

@Repository
public interface UserProductMappingMapper {
    /**
     * @mbg.generated generated automatically, do not modify!
     */
    long countByExample(UserProductMappingExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByExample(UserProductMappingExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insert(UserProductMapping row);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insertSelective(UserProductMapping row);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    List<UserProductMapping> selectByExample(UserProductMappingExample example, RowBounds rowBounds);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    List<UserProductMapping> selectByExample(UserProductMappingExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    UserProductMapping selectByPrimaryKey(Integer id);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExampleSelective(@Param("row") UserProductMapping row, @Param("example") UserProductMappingExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExample(@Param("row") UserProductMapping row, @Param("example") UserProductMappingExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKeySelective(UserProductMapping row);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKey(UserProductMapping row);
}