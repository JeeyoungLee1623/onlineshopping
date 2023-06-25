package com.example.onlineshopping.order.repository;

import com.example.onlineshopping.member.domain.Member;
import com.example.onlineshopping.order.domain.OrderStatus;
import com.example.onlineshopping.order.domain.Ordering;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface OrderingRepository extends JpaRepository <Ordering, Long> {

//    findByA 를 하면  A 컬럼을 where 조건으로 넣는 것.
    List<Ordering> findByMember (Member member);
    List<Ordering> findByStatus (OrderStatus orderStatus);

//    2개 이상의 컬럼으로 where 조건을 걸 때는 And 포함
    List<Ordering> findByMemberAndStatus (Member member, OrderStatus orderStatus);


}
