package com.example.firstproject.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FirstController {

    @GetMapping("/hi") //이 요청 받으면 아래 처리
    public String niceToMeetYou(Model model) { //model 객체 매개변수 선언
        model.addAttribute("username", "류진"); //모델서 사용할 변수 선언
        return "greetings"; // greetings.mustache 파일 반환
    }

    @GetMapping("/bye")
    public String seeYouNext(Model model) {
        model.addAttribute("username", "류진");
        return "goodbye";
    }

}
