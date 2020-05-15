package com.naveen.productservice.sevice;

import com.naveen.productservice.exception.ProductNotFoundException;
import com.naveen.productservice.model.Product;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface IProductService {
    public Product insertProduct(Product product);

    public Product updateProduct(Product product) throws ProductNotFoundException;

    public Product getProduct(Integer productId);

    public List<Product> getAllProducts();

    public void deleteProduct(Integer productId);

    // Custom Question
    // to get only product names

    public List<String> getProductByNames();
}
