package com.example.onlineshopping.order.etc;


import com.example.onlineshopping.item.domain.Item;
import com.example.onlineshopping.member.domain.Member;
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
