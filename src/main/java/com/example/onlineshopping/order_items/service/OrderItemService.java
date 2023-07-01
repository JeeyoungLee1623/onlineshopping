package com.example.onlineshopping.order.service;

import com.example.onlineshopping.item.repository.ItemRepository;

import com.example.onlineshopping.member.domain.Member;
import com.example.onlineshopping.member.repository.MemberRepository;

import com.example.onlineshopping.order.domain.Ordering;

import com.example.onlineshopping.order.etc.OrderSearch;
import com.example.onlineshopping.order.repository.OrderingRepository;
import com.example.onlineshopping.order_items.domain.OrderItem;
import com.example.onlineshopping.order_items.repository.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderItemService {

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private MemberRepository memberRepository;


    public void create(OrderItem orderItem) throws SQLException {
//        Jpa 가 order 를 building 했을 때,
//        item 테이블의 변겨예정인값을 임시 저장하고 있다가, order 를 save 할 때, item 테이블도 같이 save(update)
        orderItemRepository.save(orderItem);
    }

    public List<OrderItem> findAll() throws SQLException {
        List<OrderItem> orderItems = orderItemRepository.findAll();
        return orderItems;
    }


    public List<OrderItem> findByOrderingId(Long order_id) throws SQLException {
        List<OrderItem> orderItem = orderItemRepository.findByOrderingId(order_id);
        return orderItem;
    }

    public void cancel (Long myId){
        OrderItem order1 = orderItemRepository.findById(myId).orElse(null);
        order1.getItem().addQuantity(order1.getQuantity().intValue());
        orderItemRepository.save(order1);
    }






}
