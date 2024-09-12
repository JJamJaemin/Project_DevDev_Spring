package com.jamchae.devdev.controller;

import com.jamchae.devdev.DTO.BoardDTO;
import com.jamchae.devdev.domain.Board;
import com.jamchae.devdev.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/boards") //게시물 기본 url
public class BoardController {

    @Autowired
    private BoardService boardService;

    //게시물 작성 페이지 들어가기
    @GetMapping("/create-post")
    public String createformpage(){
        return "createPost";
    }

    //게시물 작성 API
    @PostMapping("/create-post-form")
    public RedirectView createPost(@ModelAttribute BoardDTO boardDTO) {
        // BoardDTO에서 DTO를 사용하여 게시물 생성
        boardDTO.setDate(LocalDateTime.now().toString()); // 현재 날짜와 시간 설정

        boardService.createBoard(boardDTO);

        return new RedirectView("/postpage"); // 작성 후 게시물 목록 페이지로 리다이렉트
    }
    //게시물 자세히 보기
    @GetMapping("/{id}")
    public String viewBoard(@PathVariable("id") int id, Model model) {
        Board board = boardService.getBoardById(id);
        if (board == null) {
            return "error"; // 게시물이 없을 경우 에러 페이지로
        }
        model.addAttribute("board", board);
        return "boardDetail"; // boardDetail.html 템플릿을 사용
    }
}



