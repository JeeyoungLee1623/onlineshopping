package com.example.onlineshopping.order.service;

import com.example.onlineshopping.item.domain.Item;
import com.example.onlineshopping.item.repository.ItemRepository;
import com.example.onlineshopping.item.service.ItemService;
import com.example.onlineshopping.member.domain.Member;
import com.example.onlineshopping.member.repository.MemberRepository;
import com.example.onlineshopping.member.service.MemberService;
import com.example.onlineshopping.order.domain.Ordering;
import com.example.onlineshopping.order.etc.OrderFormDto;
import com.example.onlineshopping.order.etc.OrderSearch;
import com.example.onlineshopping.order.repository.OrderingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderingService {

    @Autowired
    private OrderingRepository orderingRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private MemberRepository memberRepository;


    public void create(Ordering ordering) throws SQLException {
//        Jpa 가 order 를 building 했을 때,
//        item 테이블의 변겨예정인값을 임시 저장하고 있다가, order 를 save 할 때, item 테이블도 같이 save(update)
        orderingRepository.save(ordering);


    }

    public List<Ordering> findAll() throws SQLException {
        List<Ordering> orderings = orderingRepository.findAll();
        return orderings;
    }

    public void cancel (Long myId){
        Ordering order1 = orderingRepository.findById(myId).orElse(null);
        order1.updateCancelStatus();
        order1.getItem().addQuantity(order1.getQuantity().intValue());
        orderingRepository.save(order1);
    }



    public List<Ordering> findByFilter(OrderSearch orderSearch) throws SQLException {
        List<Ordering> orders = new ArrayList<>();
        if (isNullOrEmpty(orderSearch.getMemberName()) && orderSearch.getOrderStatus() == null) {
            orders = orderingRepository.findAll();
        } else if (!isNullOrEmpty(orderSearch.getMemberName()) && orderSearch.getOrderStatus() == null) {
//            memberName 을 가지고 , member 찾아오고, member 를 가지고 order 를 찾는다.
             orders = new ArrayList<>();
//            List<Member> members = memberRepository.findByName(orderSearch.getMemberName());
                 for(Member m1 : memberRepository.findByName(orderSearch.getMemberName())){
//                orders = orderingRepository.findByMember(m1);
                      for(Ordering orders1 : orderingRepository.findByMember(m1)){
                          orders.add((orders1));
                }
            }
        } else if (isNullOrEmpty(orderSearch.getMemberName()) && orderSearch.getOrderStatus() != null) {
            orders = orderingRepository.findByStatus(orderSearch.getOrderStatus());

        } else if (!isNullOrEmpty(orderSearch.getMemberName()) && orderSearch.getOrderStatus() != null) {
            orders = new ArrayList<>();
            for(Member m1 : memberRepository.findByName(orderSearch.getMemberName())){
                for(Ordering orders1 : orderingRepository.findByMemberAndStatus(m1,orderSearch.getOrderStatus())){
                    orders.add((orders1));
                }
            }
        }
        return orders;
    }

    private boolean isNullOrEmpty(String str){
        if(str == null){
            return true;
        }else if (str != null && str.isEmpty()){
            return true;
        }else{
            return false;
        }
    }














}
