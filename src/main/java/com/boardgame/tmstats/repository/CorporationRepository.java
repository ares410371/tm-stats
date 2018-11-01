package com.boardgame.tmstats.repository;

import com.boardgame.tmstats.domain.Corporation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CorporationRepository extends JpaRepository<Corporation, Long> {

  Optional<Corporation> findCorporationByName(String name);
}
