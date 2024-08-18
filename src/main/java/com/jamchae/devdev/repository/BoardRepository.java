package com.jamchae.devdev.repository;

import com.jamchae.devdev.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
}
