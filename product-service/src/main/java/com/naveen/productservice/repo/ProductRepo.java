package com.naveen.productservice.repo;


import com.naveen.productservice.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface ProductRepo extends MongoRepository<Product, Integer> {
    @Query(value="{}", fields="{'productName':1}")
    public List<String> getProductByNames();
}
