package com.example.onlineshopping.order.etc;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderFormDto {

    private String id;
    private String members;
    private String items;
    private String status;

    private Long count;


}
