package com.boardgame.tmstats.service.impl;

import com.boardgame.tmstats.domain.Corporation;
import com.boardgame.tmstats.repository.CorporationRepository;
import com.boardgame.tmstats.service.CorporationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Log4j2
@Service
@Transactional
@RequiredArgsConstructor
public class CorporationServiceImpl implements CorporationService {

  private final CorporationRepository corporationRepository;

  @Override
  public List<Corporation> getAllCorporations() {
    return corporationRepository.findAll();
  }
}
