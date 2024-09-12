package com.jamchae.devdev.domain;

import jakarta.persistence.*;

@Entity
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int board_id; //고유번호
    private String title; //게시물 제목
    private String content; //게시물 내용
    private String date; //작성 날짜
    private String comment; //댓글

    @Enumerated(EnumType.STRING)
    private BoardType boardType; // 게시판 유형

    public enum BoardType {
        FREE("일반 자유"),
        PROJECT_RECRUITMENT("프로젝트 모집"),
        COMPLETED_PROJECT("완성된 프로젝트");

        private final String displayName;

        BoardType(String displayName) {
            this.displayName = displayName;
        }

        public String getDisplayName() {
            return displayName;
        }
    }

    // Existing getters and setters

    public BoardType getBoardType() {
        return boardType;
    }

    public void setBoardType(BoardType boardType) {
        this.boardType = boardType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getBoard_id() {
        return board_id;
    }

    public void setBoard_id(int board_id) {
        this.board_id = board_id;
    }
}