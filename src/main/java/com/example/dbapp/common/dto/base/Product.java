package com.example.dbapp.common.dto.base;

/**
 * Table: product
 */
public class Product {
    /**
     * Column: id
     * Type: INT
     */
    private Integer id;

    /**
     * Column: name
     * Type: VARCHAR(255)
     */
    private String name;

    /**
     * Column: count
     * Type: INT
     */
    private Integer count;

    // デフォルトコンストラクタ
    public Product() {
    }

    // 引数を受け取るコンストラクタ
    public Product(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
