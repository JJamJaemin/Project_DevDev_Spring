package com.jamchae.devdev.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
//    @GetMapping("/")
//    public String home() {
//        return "home";
//    }
    @GetMapping("/")
    public String mainP() {

        return "main Controller";
    }
}
