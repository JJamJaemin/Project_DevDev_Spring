package com.jamchae.devdev.repository;

import com.jamchae.devdev.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardRepository extends JpaRepository<Board, Integer> {
    List<Board> findByBoardType(Board.BoardType boardType);
}
