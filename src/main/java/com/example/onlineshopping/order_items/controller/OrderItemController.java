package com.example.onlineshopping.order_items.controller;

import com.example.onlineshopping.member.repository.MemberRepository;
import com.example.onlineshopping.order.service.OrderItemService;
import com.example.onlineshopping.order_items.domain.OrderItem;
import com.example.onlineshopping.order_items.domain.OrderItemStatus;
import com.example.onlineshopping.order_items.repository.OrderItemRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.SQLException;
import java.util.List;

@Controller
public class OrderItemController {

    @Autowired
    private OrderItemService orderItemService;

    @Autowired
    private OrderItemRepository itemRepository;

    @Autowired
    private MemberRepository memberRepository;


    @GetMapping("orderitems")
    public String orderItemFindById(@RequestParam("id") Long order_id, Model model) throws SQLException {
        List<OrderItem> orderItems = orderItemService.findByOrderingId(order_id);
        model.addAttribute("order_items", orderItems);
        return "order/orderDetail";
    }



}
