package com.jamchae.devdev.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
    @GetMapping("/")
    public String mainP() {
        return "homepage";
    }

    @GetMapping("/loginpage")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/joinpage")
    public String joinPage() {
        return "join";
    }

    @GetMapping("/myapge")
    public String myPage() {return "mypage";}
}
