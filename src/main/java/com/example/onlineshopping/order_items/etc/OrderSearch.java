package com.example.onlineshopping.order_items.etc;


import com.example.onlineshopping.order_items.domain.OrderItemStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderSearch {

    private String memberName;
    private OrderItemStatus orderStatus;



}
