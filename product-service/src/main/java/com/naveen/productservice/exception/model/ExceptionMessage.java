package com.naveen.productservice.exception.model;

import lombok.*;

import java.util.Date;

@AllArgsConstructor
@Getter
@Setter
@ToString
@NoArgsConstructor
public class ExceptionMessage {
    private Date timeStamp;
    private String message;
    private String details;

}
