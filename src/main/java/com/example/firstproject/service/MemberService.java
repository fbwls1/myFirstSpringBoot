package com.example.firstproject.service;

import com.example.firstproject.dto.MemberForm;
import com.example.firstproject.entity.Member;
import com.example.firstproject.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class MemberService {
    @Autowired
    MemberRepository memberRepository;

    public Member show(Long id) {
        return memberRepository.findById(id).orElse(null);
    }

    public List<Member> index() {
        return memberRepository.findAll();
    }

    public Member create(MemberForm dto) {
        Member target = dto.toEntity();
        return (target.getId() == null) ?
                memberRepository.save(target) :
                null;

    }

    public Member update(Long id, MemberForm dto) {
        Member member = dto.toEntity();
        Member target = memberRepository.findById(id).orElse(null);
        return (target != null) ?
                memberRepository.save(member) :
                null;
    }

}
