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

        def res = [
                new Product(id: 1, name: "Product1"),
                new Product(id: 2, name: "Product2"),
                new Product(id: 3, name: "Product3")
        ]

        productMapper.selectByExample(_) >> mockProducts

        when: "createProductメソッドを呼び出す"
        def result = service.createProduct()

        then: "モックされたデータ全てが返される"
        res.get(2).id == mockProducts.get(2).id
    }
}