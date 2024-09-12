package com.jamchae.devdev.controller;

import com.jamchae.devdev.domain.Board;
import com.jamchae.devdev.service.BoardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    private BoardService boardService;

    //메인페이지
    @GetMapping("/")
    public String mainP() {
        return "homepage";
    }

    //로그인 페이지
    @GetMapping("/loginpage")
    public String loginPage() {
        return "login";
    }

    //회원가입 페이지
    @GetMapping("/joinpage")
    public String joinPage() {
        return "join";
    }

    //게시물 페이지
    @GetMapping("/postpage")
    public String postPage(Model model) {
        try {
            List<Board> boards = boardService.getAllBoards();
            logger.info("Retrieved {} boards", boards.size());
            model.addAttribute("boards", boards);
            return "post";
        } catch (Exception e) {
            logger.error("Error retrieving boards", e);
            model.addAttribute("error", "게시물을 불러오는 중 오류가 발생했습니다.");
            return "error";
        }
    }

    //마이페이지
    @GetMapping("/mypage")
    public String myPage() {
        return "mypage";
    }
}