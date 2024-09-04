package com.jamchae.devdev.repository;

import com.jamchae.devdev.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    //기능 모듈화 ex) 회원정보 저장, 수정, 로그인, 비밀번호 변경, 찾기
    Boolean existsByUsername(String username); //아이디 중복 체크
}
