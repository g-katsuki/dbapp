package com.example.dbapp.common.dto.base;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id) && Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
