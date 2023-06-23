package com.example.onlineshopping.member.controller;


import com.example.onlineshopping.member.domain.Address;
import com.example.onlineshopping.member.domain.Member;
import com.example.onlineshopping.member.etc.MemberForm;
import com.example.onlineshopping.member.service.MemberService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.SQLException;
import java.util.List;

@Controller
public class MemberController {

    @Autowired
    private MemberService memberService;


    @GetMapping("/")
    public String Home() {
        return "home";
    }

//  회원가입
    @GetMapping("/members/new")
    public String createForm (Model model){
//        createMemberForm 에서 memberForm  이라는 dto 객체를 필요로 하므로 dto 객체를 만들어서 model 을 통해 전달
//        Dto 에서 NotNull, NotEmpty 등 validation 처리를 할 수가 있고, 해당 객체를 createMemberForm 화면에 전달함므로써
//        화면에서 validation 체크를 할 수가 있다.
        model.addAttribute("memberForm", new MemberForm());
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String memberCreate(MemberForm memberForm) throws Exception{
        Address address = new Address(memberForm.getCity(),memberForm.getStreet(), memberForm.getZipcode());
        Member member1 = Member.builder()
                .name(memberForm.getName())
                .email(memberForm.getEmail())
                .address(address)
                .build();
        memberService.create(member1);
        return "redirect:/members";
    }
    
//    회원 목록 조회

    @GetMapping("members")
    public String memberFindAll(Model model) throws SQLException {
        List<Member> members = memberService.findAll();
        model.addAttribute("memberlist", members);
        return "members/memberList";
    }




































}
