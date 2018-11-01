package com.boardgame.tmstats.repository;

import com.boardgame.tmstats.domain.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

  @Query("SELECT p FROM Player p WHERE p.name = :name")
  Optional<Player> findPlayerByName(@Param("name") String name);
}
