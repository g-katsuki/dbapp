package com.example.dbapp

import com.example.dbapp.common.dao.base.ProductMapper
import com.example.dbapp.common.dto.base.Product
import com.example.dbapp.service.product.ProductServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest
class ProductServiceSpec extends Specification {

    @Autowired
    ProductServiceImpl service

    def "createProductメソッドが全てのテストデータを返す"() {
        given: "MockされたProductMapperとテストデータ"
        def productMapper = Mock(ProductMapper)
        service.productMapper = productMapper // Springの依存性をオーバーライド

        def mockProducts = [
                new Product(id: 1, name: "Product1"),
                new Product(id: 2, name: "Product2"),
                new Product(id: 3, name: "Product3")
        ]

        productMapper.selectByExample(_) >> mockProducts

        when: "createProductメソッドを呼び出す"
        def result = service.createProduct()

        then: "モックされたデータ全てが返される"
        result == mockProducts
    }

    def "createProductメソッドが一致しないデータセットの場合エラーをスローする"() {
        given: "MockされたProductMapperと一致しないテストデータ"
        def productMapper = Mock(ProductMapper)
        service.productMapper = productMapper // Springの依存性をオーバーライド

        def mockProducts = [
                new Product(id: 1, name: "Product1"),
                new Product(id: 2, name: "Product2"),
                new Product(id: 3, name: "Product3")
        ]

        def expectedProducts = [
                new Product(id: 1, name: "Product1"),
                new Product(id: 2, name: "Product2"),
                new Product(id: 4, name: "Product4") // 一致しないデータ
        ]

        productMapper.selectByExample(_) >> mockProducts

        when: "createProductメソッドを呼び出す"
        def result = service.createProduct()

        then: "データが一致しない場合エラーがスローされる"
        result != expectedProducts
    }

    def "テーブル記法でcreateProductメソッドのテストデータを検証する"() {
        given: "MockされたProductMapperとテストデータ"
        def productMapper = Mock(ProductMapper)
        service.productMapper = productMapper // Springの依存性をオーバーライド

        productMapper.selectByExample(_) >> mockProducts

        when: "createProductメソッドを呼び出す"
        def result = service.createProduct()

        then: "期待される結果と一致するかを検証する"
        (result == expected) == isValid

        where:
        mockProducts                                                | expected                                                  | isValid
        [new Product(1, "Product1"), new Product(2, "Product2"),
         new Product(3, "Product3")]                                | [new Product(1, "Product1"), new Product(2, "Product2"),
                                                                       new Product(3, "Product3")]                             | true
        [new Product(1, "Product1"), new Product(2, "Product2"),
         new Product(3, "Product3")]                                | [new Product(1, "Product1"), new Product(2, "Product2"),
                                                                       new Product(4, "Product4")]                             | false
    }

    def "テーブル記法、先にデータセットを宣言"() {
        given: "MockされたProductMapperとテストデータ"
        def productMapper = Mock(ProductMapper)
        service.productMapper = productMapper // Springの依存性をオーバーライド

        productMapper.selectByExample(_) >> { mockData }

        when: "createProductメソッドを呼び出す"
        def result = service.createProduct()

        then: "期待される結果と一致するかを検証する"
        (result == expected) == isValid

        where:
        mockData          | expected                | isValid
        getMockProducts() | getExpectedProducts()   | true
        getInvalidData()  | getExpectedProducts()   | false
    }

    // データセットをヘルパーメソッドとして定義
    def getMockProducts() {
        return [
                new Product(id: 1, name: "Product1"),
                new Product(id: 2, name: "Product2"),
                new Product(id: 3, name: "Product3")
        ]
    }

    def getExpectedProducts() {
        return [
                new Product(id: 1, name: "Product1"),
                new Product(id: 2, name: "Product2"),
                new Product(id: 3, name: "Product3")
        ]
    }

    def getInvalidData() {
        return [
                new Product(id: 1, name: "Product1"),
                new Product(id: 2, name: "Product2"),
                new Product(id: 4, name: "Product4") // 一致しないデータ
        ]
    }
}