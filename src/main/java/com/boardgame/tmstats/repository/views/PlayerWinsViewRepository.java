package com.boardgame.tmstats.repository.views;

import com.boardgame.tmstats.domain.views.PlayerWinsView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PlayerWinsViewRepository extends JpaRepository<PlayerWinsView, Long> {

  @Query("SELECT pw FROM PlayerWinsView pw WHERE pw.name = :player")
  PlayerWinsView getByName(@Param("player") String player);
}
