package com.naveen.productservice;
import org.assertj.core.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


//01
@SpringBootTest
class ProductServiceApplicationTests {

    @Autowired
    ProductServiceApplication controller;


//    @Test
    void contextLoads() {
        Assertions.assertThat(controller).isNotNull();
    }

}
