package com.jamchae.devdev.controller;

import com.jamchae.devdev.DTO.JoinDTO;
import com.jamchae.devdev.service.JoinService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@ResponseBody
public class JoinController {

    private final JoinService joinService;

    public JoinController(JoinService joinService) {

        this.joinService = joinService;
    }

    @PostMapping("/join") //회원가입
    public RedirectView joinProcess(@RequestParam("username") String username,
                                    @RequestParam("password") String password) {
        // JoinDTO 객체를 생성하여 서비스에 전달
        JoinDTO joinDTO = new JoinDTO();
        joinDTO.setUsername(username);
        joinDTO.setPassword(password);
        joinService.joinProcess(joinDTO);

        // 로그인 페이지로 리다이렉트
        return new RedirectView("/loginpage");
    }
}
