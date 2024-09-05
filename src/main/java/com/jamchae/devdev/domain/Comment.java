package com.jamchae.devdev.domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; //고유번호

    private String content; //댓글 내용
    private LocalDateTime date; //작성 날짜

    @ManyToOne
    @JoinColumn(name = "board_id")
    private Board board; //게시물과의 관계
}