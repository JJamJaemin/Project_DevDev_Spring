package com.jamchae.devdev.controller;

import com.jamchae.devdev.DTO.JoinDTO;
import com.jamchae.devdev.service.JoinService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class JoinController {

    private final JoinService joinService;

    public JoinController(JoinService joinService) {

        this.joinService = joinService;
    }

    @PostMapping("/join") //회원가입
    public String joinProcess(JoinDTO joinDTO) { //RequestBody 파싱을 해야 들어감

        System.out.println(joinDTO.getUsername());
        joinService.joinProcess(joinDTO);

        return "ok";
    }
}
