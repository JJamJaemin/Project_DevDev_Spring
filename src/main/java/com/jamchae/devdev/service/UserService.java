package com.jamchae.devdev.service;

import com.jamchae.devdev.DTO.UserDTO;
import com.jamchae.devdev.domain.User;
import com.jamchae.devdev.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    //토큰에 있는 사용자 정보 들고오기
    public UserDTO getCurrentUserInfo() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication(); //토큰에 있는 값 들고오기
        String username = authentication.getName(); // 현재 로그인된 사용자의 이름을 가져옴
        User user = userRepository.findByUsername(username);
        if (user != null) {
            UserDTO userDTO = new UserDTO();
            userDTO.setUsername(user.getUsername());
            return userDTO;
        }
        throw new RuntimeException("User not found");
    }
}
