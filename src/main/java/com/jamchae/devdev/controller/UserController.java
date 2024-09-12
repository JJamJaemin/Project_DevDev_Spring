package com.jamchae.devdev.controller;

import com.jamchae.devdev.DTO.UserDTO;
import com.jamchae.devdev.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

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

    @PutMapping("/user/update")
//    public ResponseEntity<String> updateUserInfo(@RequestBody UserDTO userDTO) {
//        try {
//            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//            String username = authentication.getName();  // 현재 로그인된 사용자
//            userService.updateCurrentUserInfo(username, userDTO);
//            return ResponseEntity.ok("User profile updated successfully");
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update user profile");
//        }
//    }
    public ResponseEntity<Map<String, String>> updateUser(@RequestBody UserDTO userDTO) {
        Map<String, String> response = new HashMap<>();
        try {
            userService.updateCurrentUserInfo(userDTO);  // 서비스 로직으로 유저 정보 업데이트
            response.put("message", "User profile updated successfully");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("message", "Error updating user");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
}
