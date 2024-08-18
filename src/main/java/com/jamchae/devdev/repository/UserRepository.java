package com.jamchae.devdev.repository;

import com.jamchae.devdev.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    //기능 모듈화 ex) 회원정보 저장, 수정, 로그인, 비밀번호 변경, 찾기
    User save(User user);
    Optional<User> findByUsername(String username);

}
