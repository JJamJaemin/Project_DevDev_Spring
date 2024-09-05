package com.jamchae.devdev.controller;

import com.jamchae.devdev.DTO.UserDTO;
import com.jamchae.devdev.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public ResponseEntity<UserDTO> getUserInfo() {
        UserDTO userDTO = userService.getCurrentUserInfo();
        return ResponseEntity.ok(userDTO);
    }
}
