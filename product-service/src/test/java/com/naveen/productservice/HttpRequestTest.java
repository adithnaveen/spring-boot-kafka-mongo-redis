package com.naveen.productservice;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;

// help document https://spring.io/guides/gs/testing-web/

//02
// generally RANDOM_PORT is use to write the test case then write the development
// code
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HttpRequestTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

//    @Test
    public void getProductsTest() throws  Exception {
        System.out.println("Local port number started @ " + port);
        String uri ="http://localhost:8765/product-service/products";
        assertThat(this.restTemplate.getForObject(uri, String.class)).contains("Key Board");
    }

}
