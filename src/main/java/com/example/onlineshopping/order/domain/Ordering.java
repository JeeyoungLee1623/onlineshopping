package com.example.onlineshopping.order.domain;


import com.example.onlineshopping.item.domain.Item;
import com.example.onlineshopping.member.domain.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Ordering {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    수량은 별개로 필요
    private Long quantity;

//    상품명 -> item_id 로 대체가능
    @OneToOne
    @JoinColumn(nullable = false)
    private Item item;

//    주문자(회원)정보 : 1:n
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private Member member;

    @Column
    private LocalDateTime createDate;

    @Builder
    public Ordering(Long quantity, Item item, Member member){
        this.quantity = quantity;
        this.item = item;
        this.member = member;
        this.createDate = LocalDateTime.now();
    }



















}
