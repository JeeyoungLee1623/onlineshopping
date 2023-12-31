package com.example.onlineshopping.order.controller;
import com.example.onlineshopping.item.repository.ItemRepository;
import com.example.onlineshopping.member.repository.MemberRepository;

import com.example.onlineshopping.order.domain.Ordering;
import com.example.onlineshopping.order.etc.OrderFormDto;
import com.example.onlineshopping.order.etc.OrderSearch;
import com.example.onlineshopping.order.service.OrderingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.SQLException;
import java.util.List;

@Controller
public class OrderingController {

    @Autowired
    private OrderingService orderingService;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private MemberRepository memberRepository;



    @GetMapping("/order")
    public String createForm (Model model){
        model.addAttribute("members", memberRepository.findAll());
        model.addAttribute("items", itemRepository.findAll());
        return "order/orderForm";
    }

    @PostMapping("/order")
    public String orderingCreate(OrderFormDto orderFormDto) throws Exception{;
//        Member member1 = memberRepository.findById(orderFormDto.getMemberId()).orElse(null);
//        Ordering ordering = Ordering.builder()
//                .member(member1)
//                .build();

//        order_item까지 고려하여 로직이 복잡해지므로, service에서 로직처리.
        orderingService.create(orderFormDto);
        return "redirect:/";
    }

//    회원 목록 조회

    @GetMapping("orders")
//    @ModelAttribute("orderSearch") 명시적으로 OrderSearchDto 와 mapping 을 할 수도 있다.
    public String orderFindAll(OrderSearch orderSearch, Model model) throws SQLException {
//        System.out.println(orderSearch.getMemberName());
        List<Ordering> orderings = orderingService.findByFilter(orderSearch);
        model.addAttribute("orders", orderings);
        return "order/orderList";
    }

    @PostMapping("/orders/{id}/cancel")
    public String ordersCancel(@PathVariable("id")Long myId) throws Exception {
        orderingService.cancel(myId);
        return "redirect:/orders";
    }








}