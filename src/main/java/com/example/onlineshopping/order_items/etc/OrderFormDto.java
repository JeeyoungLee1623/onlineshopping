package com.example.onlineshopping.order_items.etc;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderFormDto {

//    private String id;
    private Long memberId;
    private List<Long> itemId;
    private List<Long> count;


}
