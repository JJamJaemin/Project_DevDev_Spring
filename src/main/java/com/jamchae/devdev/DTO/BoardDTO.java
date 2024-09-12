package com.jamchae.devdev.DTO;

import com.jamchae.devdev.domain.Board;

public class BoardDTO {
    private int board_id;
    private String title;
    private String content;
    private String date;
    private String comment;
    private Board.BoardType boardType;

    public int getBoard_id() {
        return board_id;
    }

    public void setBoard_id(int board_id) {
        this.board_id = board_id;
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

    public Board.BoardType getBoardType() {
        return boardType;
    }

    public void setBoardType(Board.BoardType boardType) {
        this.boardType = boardType;
    }

    // 게시판 유형의 표시 이름을 반환하는 편의 메서드
    public String getBoardTypeDisplayName() {
        return boardType != null ? boardType.getDisplayName() : "";
    }
}