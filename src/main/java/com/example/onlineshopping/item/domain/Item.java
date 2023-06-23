package com.example.onlineshopping.item.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;


@Getter
@Entity
@NoArgsConstructor

public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Column(unique = true)
    private String name;
    @Setter
    @Column(length = 255)
    private int price;
    @Setter
    @Column(length = 255)
    private int stockQuantity;
    @Column
    private LocalDateTime createDate;

    @Builder
    public Item(String name, int price, int stockQuantity){
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.createDate = LocalDateTime.now();
    }

}
