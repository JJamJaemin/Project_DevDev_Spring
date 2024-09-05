package com.jamchae.devdev.service;

import com.jamchae.devdev.DTO.CustomUserDTO;
import com.jamchae.devdev.domain.User;
import com.jamchae.devdev.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {

        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // DB에서 사용자 정보 조회
        User userData = userRepository.findByUsername(username);

        if (userData != null) {
            // 사용자 정보를 UserDetails로 변환하여 반환
            return new CustomUserDTO(userData);
        } else {
            // 사용자 정보가 없을 경우 예외 던지기
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }
}
