package com.boardgame.tmstats.repository.views;

import com.boardgame.tmstats.domain.views.CorporationWinsView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CorporationWinsViewRepository extends JpaRepository<CorporationWinsView, Long> {

  @Query("SELECT cw FROM CorporationWinsView cw WHERE cw.name = :corporation")
  CorporationWinsView getByName(@Param("corporation") String corporation);
}
