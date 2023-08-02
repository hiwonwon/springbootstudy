package com.example.firstproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FirstController {
    @GetMapping("/hi") // 연결
    public String niceToMeetYou(Model model){
        model.addAttribute("username","hiwon");
        return"greetings"; // templates/greetings.mustache ->에서 브라우저로 전송
    }
    @GetMapping("/bye") // 연결
    public String seeYouNext (Model model){
        model.addAttribute("nickname","hiwon");
        return"goodbye"; // templates/greetings.mustache ->에서 브라우저로 전송
    }

}
