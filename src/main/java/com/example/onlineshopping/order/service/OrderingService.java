package com.example.onlineshopping.order.service;

import com.example.onlineshopping.item.domain.Item;
import com.example.onlineshopping.item.repository.ItemRepository;
import com.example.onlineshopping.item.service.ItemService;
import com.example.onlineshopping.member.domain.Member;
import com.example.onlineshopping.member.repository.MemberRepository;
import com.example.onlineshopping.member.service.MemberService;
import com.example.onlineshopping.order.domain.Ordering;
import com.example.onlineshopping.order.etc.OrderFormDto;
import com.example.onlineshopping.order.repository.OrderingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class OrderingService {

    @Autowired
    private OrderingRepository orderingRepository;




    @Autowired
    private MemberRepository memberRepository;


    public void create(Ordering ordering) throws SQLException {
        orderingRepository.save(ordering);
    }

    public List<Ordering> findAll() throws SQLException {
        List<Ordering> orderings = orderingRepository.findAll();
        return orderings;
    }





//    public void create(OrderFormDto orderFormDto) throws SQLException {
//        Member member1 = memberService.findByEmail(orderFormDto.getMembers());
//        Item item1 = itemService.findByName(orderFormDto.getItems());
//        Ordering ordering1 = Ordering.builder()
//                .members(member1)
//                .items(item1)
//                .Count(orderFormDto.getCount())
//                .build();
//        orderingRepository.save(ordering1);
//    }












}
