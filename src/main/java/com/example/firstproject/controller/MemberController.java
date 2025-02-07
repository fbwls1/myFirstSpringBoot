package com.example.firstproject.controller;

import com.example.firstproject.dto.MemberForm;
import com.example.firstproject.entity.Member;
import com.example.firstproject.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Slf4j
@Controller
public class MemberController {
    @Autowired
    private MemberRepository memberRepository;
    @GetMapping("/members/signup")
    public String signUp() {
        return "members/signup";
    }

    @PostMapping("/join")
    public String create(MemberForm form) {
        //System.out.println(form.toString());
        log.info(form.toString());
        Member member = form.toEntity();
        //System.out.println(member.toString());
        log.info(member.toString());
        Member saved = memberRepository.save(member);
        //System.out.println(saved.toString());
        log.info(saved.toString());
        return "";
    }

    @GetMapping("/members")
    public String index(Model model) {
        List<Member> memberList = (List<Member>)memberRepository.findAll();
        model.addAttribute("memberList", memberList);
        return "members/memberIndex";
    }

    @GetMapping("/members/{id}")
    public String show(@PathVariable Long id, Model model) {
        Member memberEntity = memberRepository.findById(id).orElse(null);

        model.addAttribute("memberEntity", memberEntity);

        return "members/memberShow";

    }

}
