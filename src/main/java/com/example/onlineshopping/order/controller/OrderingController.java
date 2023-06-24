package com.example.onlineshopping.order.controller;


import com.example.onlineshopping.item.domain.Item;
import com.example.onlineshopping.item.service.ItemService;
import com.example.onlineshopping.member.domain.Address;
import com.example.onlineshopping.member.domain.Member;
import com.example.onlineshopping.member.etc.MemberForm;
import com.example.onlineshopping.member.service.MemberService;
import com.example.onlineshopping.order.domain.Ordering;
import com.example.onlineshopping.order.etc.OrderFormDto;
import com.example.onlineshopping.order.service.OrderingService;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.SQLException;
import java.util.List;

@Controller
public class OrderingController {

    @Autowired
    private OrderingService orderingService;



    @GetMapping("/order")
    public String createForm (Model model){
        return "order/orderForm";
    }

    @PostMapping("/order")
    public String orderingCreate() throws Exception{
        Ordering ordering = Ordering.builder()
                .quantity()
                .item()
                .member()
                .build();
        orderingService.create(ordering);
        return "redirect:/orders";
    }

//    회원 목록 조회

    @GetMapping("orders")
    public String orderFindAll(Model model) throws SQLException {
        List<Ordering> orderings = orderingService.findAll();
        model.addAttribute("orders", orderings);
        return "order/orderList";
    }



//    @GetMapping("/order")
//    public String createForm (@RequestParam(value = "id")Long myEmail,
//                              @RequestParam(value = "id")Long myName, Model model) throws Exception{
//            Member member1  = memberService.findByEmail(myEmail);
//            Item item1 = itemService.findByName(myName);
//
//        model.addAttribute("form", new OrderFormDto());
//        return "order/orderForm";
//    }

//    @PostMapping("/order")
//    public String orderCreate(OrderFormDto orderFormDto) throws Exception{
//        orderingService.create(orderFormDto);
//        return "redirect:/";
//    }







}
