package com.boardgame.tmstats.repository;

import com.boardgame.tmstats.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {

  Optional<Board> findBoardByName(String name);
}
