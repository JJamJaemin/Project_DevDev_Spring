package com.jamchae.devdev.controller;

import com.jamchae.devdev.DTO.UserDTO;
import com.jamchae.devdev.domain.User;
import com.jamchae.devdev.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
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
    //마이페이지
    @GetMapping("/mypage")
    public String myPage() {
        return "mypage";
    }
//    @GetMapping("/api/user")
//    public ResponseEntity<UserDTO> getUserInfo() {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        String username = authentication.getName();
//        User user = UserRepository.findByUsername(username);
//        return ResponseEntity.ok(userDTO);
//    }

}
