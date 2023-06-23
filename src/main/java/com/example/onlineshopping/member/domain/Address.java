package com.example.onlineshopping.member.domain;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;


// 별도의 테이블로 존재하지 않고, 다른 entity 에 첨부되는 것.
//Embedded 와 한 쌍
@Embeddable
@Getter
@NoArgsConstructor
public class Address {

    @Setter
    @Column(length = 255)
    private String city;

    @Setter
    @Column(length = 255)
    private String street;

    @Setter
    @Column(length = 10)
    private String zipcode;



    @Builder
    public   Address (String city, String street, String zipcode){
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }




}


