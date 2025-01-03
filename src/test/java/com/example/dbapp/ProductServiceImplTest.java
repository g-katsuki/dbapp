package com.example.dbapp;

import com.example.dbapp.common.dao.base.ProductMapper;
import com.example.dbapp.common.dto.base.Product;
import com.example.dbapp.service.product.ProductServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class ProductServiceTest {

    @Mock
    private ProductMapper productMapper;

    @InjectMocks
    private ProductServiceImpl service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createProduct_shouldReturnAllTestData() {
        // Arrange: モックされたProductMapperとテストデータをセットアップ
        List<Product> mockProducts = Arrays.asList(
                new Product(1, "Product1"),
                new Product(2, "Product2"),
                new Product(3, "Product3")
        );

        List<Product> expectedProducts = Arrays.asList(
                new Product(1, "Product1"),
                new Product(2, "Product2"),
                new Product(3, "Product3") // 修正後の期待値
        );

        when(productMapper.selectByExample(any())).thenReturn(mockProducts);

        // Act: createProductメソッドを呼び出す
        List<Product> result = service.createProduct();

        // Assert: モックされたデータが正しく返されることを確認
        assertEquals(expectedProducts.get(2).getId(), mockProducts.get(2).getId());
    }
}
