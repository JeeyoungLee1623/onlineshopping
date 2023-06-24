package com.example.onlineshopping.member.domain;


import com.example.onlineshopping.order.domain.Ordering;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    private String name;
    @Column(unique = true, length = 50)
    private String email;

    @Column(unique = true, length = 255)
    private String password;
    @Embedded
    private Address address;


    @Column(length = 50)
    private String role;

//    Member 를 조회할 때 Member 의 id 값을 가지고 Ordering 의 컬럼을 where 조건을 주고
//    조회할지에 대해서 mapping 정보를 Member 테이블에 알려주는 것.
//    OneToMany 또는 ManyToOne 을 할 때 fetch 전략이라는게 있다.
//    Member 객체 임장에서 fetch 전략은 즉시 Ordering 객체를 조회할지 말지에 대한 선택
//    LAZY 즉시 로딩 x -> 참조해서 사용할 때만 로팅 OK, EAGER 즉시 로딩 OK
//    스프링 부트 단골 질문: N+1 이슈를 해결하기 위해서는 LAZY 사용 추천.
    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
    private List<Ordering> orderings;

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
