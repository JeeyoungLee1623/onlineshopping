package com.example.onlineshopping.order_items.repository;


import com.example.onlineshopping.order_items.domain.OrderItemStatus;
import com.example.onlineshopping.order_items.domain.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface OrderItemRepository extends JpaRepository <OrderItem, Long> {

//    findByA 를 하면  A 컬럼을 where 조건으로 넣는 것.

//    2개 이상의 컬럼으로 where 조건을 걸 때는 And 포함
    List<OrderItem> findByOrderingId (Long order_id);


}
