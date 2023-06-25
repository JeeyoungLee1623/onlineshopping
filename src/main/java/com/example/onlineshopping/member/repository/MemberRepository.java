package com.example.onlineshopping.member.repository;


import com.example.onlineshopping.item.domain.Item;
import com.example.onlineshopping.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
    public interface MemberRepository extends JpaRepository<Member, Long> {

    Member findByEmail (String myEmail);

    List<Member> findByName(String name);


}
