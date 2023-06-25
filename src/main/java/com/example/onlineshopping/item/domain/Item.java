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


    @Column(unique = true)
    private String name;
    @Column(length = 255)
    private int price;
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


    public void updateItem(String name, int price, int stockQuantity){
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }

    public void removeQuantity(int stockQuantity) throws Exception{
        int new_Quantity = this.stockQuantity - stockQuantity;
        if(new_Quantity < 0){
            throw new Exception();
        }
        this.stockQuantity = new_Quantity;
    }

    public void addQuantity(int stockQuantity) {
        int new_Quantity = this.stockQuantity + stockQuantity;
        this.stockQuantity = new_Quantity;
    }


}
