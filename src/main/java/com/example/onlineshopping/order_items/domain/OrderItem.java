package com.example.onlineshopping.order_items.domain;


import com.example.onlineshopping.item.domain.Item;
import com.example.onlineshopping.member.domain.Member;
import com.example.onlineshopping.order.domain.Ordering;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.criterion.Order;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    수량은 별개로 필요
    private Long quantity;

//    상품명 -> item_id 로 대체가능
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private Item item;

//    주문자(회원)정보 : 1:n



//    Enumtype.String 을 주지 않으면 순서 숫자가 들어가게 된다.
//    즉 0,1,2 등의 숫자값이 디폴트
    @Enumerated(EnumType.STRING)
    private OrderItemStatus status;

    @Column
    private LocalDateTime createDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private Ordering ordering;



    @Builder
    public OrderItem(Long quantity, Item item, Ordering ordering) throws Exception {
        this.quantity = quantity;
        this.item = item;
        this.ordering = ordering;
        this.createDate = LocalDateTime.now();
        this.item.removeQuantity(quantity.intValue());
    }




}
