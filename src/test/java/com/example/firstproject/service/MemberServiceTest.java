package com.example.firstproject.service;

import com.example.firstproject.entity.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class MemberServiceTest {
    @Autowired
    MemberService memberService;

    @Test
    void index() {
        //1. 예상 데이터
        Member a = new Member(1L, "가가가가", "1111");
        Member b = new Member(2L, "나나나나", "2222");
        Member c = new Member(3L, "다다다다", "3333");
        List<Member> expected = new ArrayList<Member>(Arrays.asList(a, b, c));

        //2. 실제 데이터
        List<Member> members = memberService.index();
        //3. 비교 및 검증
        assertEquals(expected.toString(), members.toString());

    }
}