package com.jamchae.devdev.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
    //메인페이지
    @GetMapping("/")
    public String mainP() {
        return "homepage";
    }
    //로그인 페이지
    @GetMapping("/loginpage")
    public String loginPage() {
        return "login";
    }
    //회원가입 페이지
    @GetMapping("/joinpage")
    public String joinPage() {
        return "join";
    }
    //게시물 페이지
    @GetMapping("/postpage")
    public String postPage() {
        return "post";
    }

}
