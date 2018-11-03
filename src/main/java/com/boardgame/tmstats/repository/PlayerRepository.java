package com.boardgame.tmstats.repository;

import com.boardgame.tmstats.domain.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

  @Query("SELECT sum(p.points) FROM Player p JOIN Corporation c ON c.id = p.corporation.id WHERE c.name = :corporation GROUP BY c.name")
  long sumOfCorporationPoints(@Param("corporation") String corporation);

  @Query("SELECT sum(p.points) FROM Player p WHERE p.name = :player GROUP BY p.name")
  long sumOfPlayerPoints(@Param("player") String player);
}
