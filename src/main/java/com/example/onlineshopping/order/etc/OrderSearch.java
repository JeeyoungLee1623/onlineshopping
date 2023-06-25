package com.example.onlineshopping.order.etc;


import com.example.onlineshopping.order.domain.OrderStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderSearch {

    private String memberName;
    private OrderStatus orderStatus;



}
