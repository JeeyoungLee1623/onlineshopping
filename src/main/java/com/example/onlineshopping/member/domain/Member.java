package com.example.onlineshopping.member.domain;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Column(length = 50)
    private String name;
    @Setter
    @Column(unique = true, length = 50)
    private String email;

    @Setter
    @Column(unique = true, length = 255)
    private String password;
    @Embedded
    private Address address;


    @Column(length = 50)
    private String role;
    @Column
    private LocalDateTime createDate;


    @Builder
    public Member(String name, String email, String password, Address address){
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = "user";
        this.address = address;
        this.createDate = LocalDateTime.now();
    }







}
