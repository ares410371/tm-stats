package com.boardgame.tmstats.repository;

import com.boardgame.tmstats.domain.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {

  @Query("SELECT g FROM Game g WHERE g.playerCount = :playerCount")
  List<Game> getByPlayerCount(@Param("playerCount") int playerCount);
}
