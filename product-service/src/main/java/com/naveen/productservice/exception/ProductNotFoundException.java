package com.naveen.productservice.exception;

import lombok.ToString;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ToString
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProductNotFoundException extends  RuntimeException{

    private String message;

    public ProductNotFoundException(String message) {
        super(message);
    }
}
