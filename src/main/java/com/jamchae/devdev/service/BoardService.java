package com.jamchae.devdev.service;

import com.jamchae.devdev.DTO.BoardDTO;
import com.jamchae.devdev.domain.Board;
import com.jamchae.devdev.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    // 게시물 생성
    public Board createBoard(BoardDTO boardDTO) {
        Board board = new Board();
        board.setTitle(boardDTO.getTitle());
        board.setContent(boardDTO.getContent());
        board.setDate(boardDTO.getDate()); // 혹은 현재 날짜와 시간으로 설정
        return boardRepository.save(board);
    }

    // 모든 게시물 조회
    public List<Board> getAllBoards() {
        return boardRepository.findAll();
    }

    // ID로 게시물 조회
    public Optional<Board> getBoardById(int id) {
        return boardRepository.findById(id);
    }

    // 게시물 삭제
    public void deleteBoard(int id) {
        boardRepository.deleteById(id);
    }
}
