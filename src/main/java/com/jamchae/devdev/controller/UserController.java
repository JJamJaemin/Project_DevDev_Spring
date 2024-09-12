package com.jamchae.devdev.controller;

import com.jamchae.devdev.DTO.UserDTO;
import com.jamchae.devdev.domain.User;
import com.jamchae.devdev.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@Controller
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping("/user")
    public ResponseEntity<UserDTO> getUserInfo() {
        UserDTO userDTO = userService.getCurrentUserInfo();
        return ResponseEntity.ok(userDTO);
    }

    @PutMapping("/user/update")
    public ResponseEntity<?> updateUser(@RequestBody UserDTO userDTO, @AuthenticationPrincipal User user) {
        // 비밀번호 암호화
        userDTO.setPassword(bCryptPasswordEncoder.encode(userDTO.getPassword()));

        // 사용자 정보를 UserService를 통해 업데이트
        userService.updateUserInfo(userDTO);

        // JSON 형식으로 응답을 반환
        return ResponseEntity.ok(Collections.singletonMap("message", "User updated successfully"));
    }
}
