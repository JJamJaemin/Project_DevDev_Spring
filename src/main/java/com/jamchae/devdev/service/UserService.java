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

    // 토큰에 있는 사용자 정보 들고오기
    public UserDTO getCurrentUserInfo() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication(); // 토큰에 있는 값 들고오기
        String username = authentication.getName(); // 현재 로그인된 사용자의 이름을 가져옴
        User user = userRepository.findByUsername(username);

        if (user != null) {
            UserDTO userDTO = new UserDTO();
            userDTO.setUsername(user.getUsername());
            userDTO.setSkill(user.getSkill()); // 기술 스택 추가
            userDTO.setEmail(user.getEmail());
            return userDTO;
        }

        throw new RuntimeException("User not found");
    }

    // 사용자 정보 업데이트
    @Transactional
    public void updateUserInfo(UserDTO userDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        User user = userRepository.findByUsername(username);

        if (user != null) {
            user.setUsername(userDTO.getUsername());
            user.setSkill(userDTO.getSkill());  // 기술 스택 업데이트
            user.setPassword(userDTO.getPassword());  // 비밀번호 업데이트 (필요 시 암호화)
            user.setEmail(userDTO.getEmail());
            userRepository.save(user);  // 사용자 정보 저장
        } else {
            throw new RuntimeException("User not found");
        }
    }
}
