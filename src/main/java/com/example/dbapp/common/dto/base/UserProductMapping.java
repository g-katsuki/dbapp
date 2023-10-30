package com.example.dbapp.common.dto.base;

/**
 * Table: user_product_mapping
 */
public class UserProductMapping {
    /**
     * Column: id
     * Type: INT
     */
    private Integer id;

    /**
     * Column: user_id
     * Type: INT
     */
    private Integer userId;

    /**
     * Column: product_id
     * Type: INT
     */
    private Integer productId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }
}