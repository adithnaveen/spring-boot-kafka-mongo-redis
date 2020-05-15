package com.naveen.productservice.sevice;


import com.naveen.productservice.exception.ProductNotFoundException;
import com.naveen.productservice.model.Product;
import com.naveen.productservice.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService{

    @Autowired
    private ProductRepo productRepo;

    @Override
    public Product insertProduct(Product product) {
        return productRepo.insert(product);
    }

    @Override
    public Product updateProduct(Product product) throws ProductNotFoundException {
        final Optional<Product> currentProduct = productRepo.findById(product.getProductId());
        if(currentProduct.isPresent()){
            return this.productRepo.save(product);
        }
        return currentProduct.orElseThrow( () ->  {
            return new ProductNotFoundException("Sorry Product with Id: " + product.getProductId() +" not found");
        });
    }

    @Override
    @Cacheable(value = "get-product") // , key = "#product") //, unless = "#result==null")
    public Product getProduct(Integer productId) {
        System.out.println("in ProductService Requesting for -> " + productId);

        if(!productRepo.findById(productId).isPresent()){
            throw  new ProductNotFoundException("Sorry Product Not Found with Id " + productId);
        }
        return productRepo.findById(productId).get();
    }

    @Override
    @Cacheable(value = "products") // , key = "#products")
    public List<Product> getAllProducts() {
        return this.productRepo.findAll();
    }

    @Override
    public void deleteProduct(Integer productId) {
        productRepo.deleteById(productId);
    }

    @Override
    @Cacheable(value = "productByNames")
    public List<String> getProductByNames() {
       return productRepo.getProductByNames();
    }
}
