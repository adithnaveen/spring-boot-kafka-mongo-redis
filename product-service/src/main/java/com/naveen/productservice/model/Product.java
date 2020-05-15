package com.naveen.productservice.model;

import lombok.*;
import org.springframework.data.annotation.Id;

import java.io.Serializable;


@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class Product implements Serializable {
    @Id
    private Integer productId;
    private String productName;
    private Double productPrice;
    private Double productDiscount;
}
