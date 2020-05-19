package com.naveen.productservice.exception.controller.advice;

import com.naveen.productservice.exception.ProductNotFoundException;
import com.naveen.productservice.exception.model.ExceptionMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@RestController
@ControllerAdvice
public class CustomizedResponseEntityException extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ProductNotFoundException.class)
    public final ResponseEntity<Object> productNotFoundException(final Exception exception, final WebRequest request)
        throws ProductNotFoundException {

        System.out.println("--------->>>"+exception);
        final ExceptionMessage exceptionMessage = new ExceptionMessage(new Date(), exception.getMessage(), request.getDescription(false));
        return  new ResponseEntity<>(exceptionMessage, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
        public final ResponseEntity<Object> handleAllException(final Exception exception, final WebRequest request){
        ExceptionMessage exceptionMessage = new ExceptionMessage(new Date(), exception.getMessage(), request.getDescription(false));

       return  new ResponseEntity(exceptionMessage, HttpStatus.INTERNAL_SERVER_ERROR);

        }
}
