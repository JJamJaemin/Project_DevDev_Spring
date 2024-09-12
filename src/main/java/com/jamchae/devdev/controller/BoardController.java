package com.jamchae.devdev.controller;

import com.jamchae.devdev.DTO.BoardDTO;
import com.jamchae.devdev.domain.Board;
import com.jamchae.devdev.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/boards") //게시물 기본 url
public class BoardController {

    @Autowired
    private BoardService boardService;

    // 모든 게시물 목록 표시
    @GetMapping
    public String getAllBoards(Model model) {
        List<Board> freeBoards = boardService.getBoardsByType(Board.BoardType.FREE);
        List<Board> recruitmentBoards = boardService.getBoardsByType(Board.BoardType.PROJECT_RECRUITMENT);
        List<Board> completedBoards = boardService.getBoardsByType(Board.BoardType.COMPLETED_PROJECT);

        // 모든 게시물을 하나의 리스트로 합치기
        List<Board> allBoards = new ArrayList<>();
        allBoards.addAll(freeBoards);
        allBoards.addAll(recruitmentBoards);
        allBoards.addAll(completedBoards);

        // 합친 리스트를 모델에 추가
        model.addAttribute("boards", allBoards);

        // 필요하다면 각각의 게시판 목록도 따로 추가 가능
        model.addAttribute("freeBoards", freeBoards);
        model.addAttribute("recruitmentBoards", recruitmentBoards);
        model.addAttribute("completedBoards", completedBoards);

        return "boardList"; // boardList.html 템플릿으로 반환
    }

    // 게시물 작성 페이지 들어가기
    @GetMapping("/create-post")
    public String createFormPage(Model model) {
        model.addAttribute("boardTypes", Board.BoardType.values());
        return "createPost";
    }

    // 게시물 작성 API
    @PostMapping("/create-post-form")
    public RedirectView createPost(@ModelAttribute BoardDTO boardDTO) {
        System.out.println("Received BoardDTO: " + boardDTO.getBoardType()); // 디버깅을 위한 로그
        boardDTO.setDate(LocalDateTime.now().toString()); // 현재 날짜와 시간 설정
        boardService.createBoard(boardDTO);
        return new RedirectView("/boards"); // 작성 후 게시물 목록 페이지로 리다이렉트
    }

    // 게시물 자세히 보기
    @GetMapping("/{id}")
    public String viewBoard(@PathVariable("id") int id, Model model) {
        Board board = boardService.getBoardById(id);
        if (board == null) {
            return "error"; // 게시물이 없을 경우 에러 페이지로
        }
        model.addAttribute("board", board);
        return "boardDetail"; // boardDetail.html 템플릿을 사용
    }

    // 게시판 유형별 목록 보기
    @GetMapping("/type/{boardType}")
    public String getBoardsByType(@PathVariable("boardType") String boardType, Model model) {
        Board.BoardType type = Board.BoardType.valueOf(boardType.toUpperCase());
        List<Board> boards = boardService.getBoardsByType(type);
        model.addAttribute("boards", boards);
        model.addAttribute("boardType", type);
        return "boardList";
    }
}