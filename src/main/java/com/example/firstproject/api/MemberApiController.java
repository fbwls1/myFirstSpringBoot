package com.example.firstproject.api;

import com.example.firstproject.dto.MemberForm;
import com.example.firstproject.entity.Member;
import com.example.firstproject.repository.MemberRepository;
import com.example.firstproject.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.List;

@RestController
@Slf4j
public class MemberApiController {
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    private MemberService memberService;

    @GetMapping("/api/members/{id}")
    public ResponseEntity<Member> show(@PathVariable Long id) {
        Member target = memberService.show(id);
        return (target != null) ?
                ResponseEntity.status(HttpStatus.OK).body(target) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @GetMapping("/api/members")
    public List<Member> index() {
        return memberService.index();
    }

    @PostMapping("/api/members/create")
    public ResponseEntity<Member> create(@RequestBody MemberForm dto) {
        Member created = memberService.create(dto);
        return (created != null) ?
                ResponseEntity.status(HttpStatus.OK).body(created) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @PatchMapping("/api/members/update/{id}")
    public ResponseEntity<Member> update(@RequestBody MemberForm dto,
                                         @PathVariable Long id) {
        Member updated = memberService.update(id, dto);
        return (updated != null) ?
                ResponseEntity.status(HttpStatus.OK).body(updated) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @DeleteMapping("/api/members/{id}")
    public ResponseEntity<Member> delete(@PathVariable Long id) {
        Member target = memberRepository.findById(id).orElse(null);
        if(target == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        memberRepository.delete(target);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
