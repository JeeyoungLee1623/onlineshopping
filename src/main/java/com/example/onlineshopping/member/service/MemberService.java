package com.example.onlineshopping.member.service;


import com.example.onlineshopping.item.domain.Item;
import com.example.onlineshopping.member.domain.Member;
import com.example.onlineshopping.member.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;


    public void create(Member member) throws SQLException {
        memberRepository.save(member);
    }

    public List<Member> findAll() throws SQLException {
        List<Member> members = memberRepository.findAll();
        return members;
    }


    public Member findByEmail (String email) {
        return memberRepository.findByEmail(email);
    }

















}
