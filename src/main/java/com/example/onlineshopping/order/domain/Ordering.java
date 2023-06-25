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
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private Item item;

//    주문자(회원)정보 : 1:n
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private Member member;


//    Eumtype.String 을 주지 않으면 순서 숫자가 들어가게 된다.
//    즉 0,1,2 등의 숫자값이 디폴트
    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @Column
    private LocalDateTime createDate;





    @Builder
    public Ordering(Long quantity, Item item, Member member) throws Exception {
        this.quantity = quantity;
        this.item = item;
        this.member = member;
        this.status = OrderStatus.ORDERED;
        this.createDate = LocalDateTime.now();
//        Ordering 객체 안에 Item 객체를 OnetoOne 으로 가지고 있기 때문에, item 객체에 quantity 를
//        변경시키는 removeQuantity 를 호출하고, Ordering 만 save 하여도 Item 테이블에 item 객체가 변경 된다.
        this.item.removeQuantity(quantity.intValue());
    }

    public void updateCancelStatus(){
        this.status = OrderStatus.CANCEL;
    }



















}
