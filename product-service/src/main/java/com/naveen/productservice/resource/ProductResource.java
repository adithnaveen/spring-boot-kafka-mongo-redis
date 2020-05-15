package com.naveen.productservice.resource;

import com.naveen.productservice.exception.ProductNotFoundException;
import com.naveen.productservice.model.Product;
import com.naveen.productservice.sevice.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/api")
@RestController
public class ProductResource {
    @Autowired
    private IProductService productService;

    @PostMapping("/product")
    @ResponseStatus(HttpStatus.CREATED)
    public Product insertProduct(@RequestBody Product product) {
        return productService.insertProduct(product);
    }


    @GetMapping("/product/{productId}")
    public Product getProduct(@PathVariable Integer productId){

        System.out.println("in ProductResource Requesting for -> " + productId);
        final Product product = this.productService.getProduct(productId);
        try {
            if(product == null){
                throw new ProductNotFoundException("Sorry product not found " + productId);
            }
          return product;
        }catch (ProductNotFoundException pnfe){
            pnfe.printStackTrace();
            throw new ProductNotFoundException("Sorry Product Not Found");
        }
    }

    @GetMapping("/products")
    public List<Product> getAllProducts(){
        return this.productService.getAllProducts();
    }

    @PutMapping(value = "/product", produces = "application/json" )
    public Product  updateProduct(@RequestBody Product product) throws ProductNotFoundException {
        try {
             return this.productService.updateProduct(product);
        }catch (ProductNotFoundException pnfe){
            pnfe.printStackTrace();
            throw new ProductNotFoundException("Sorry Product Not Found : " + product.toString());
        }
    }

    @DeleteMapping("/product/{productId}")
    public ResponseEntity<Void> deleteProduct(@RequestParam Integer productId){
        this.productService.deleteProduct(productId);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    // getting product names
    @GetMapping("/product/names")
    public List<String> getProductNames(){
        return this.productService.getProductByNames();
    }

}
