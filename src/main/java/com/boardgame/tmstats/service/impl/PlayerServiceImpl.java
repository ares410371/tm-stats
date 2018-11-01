package com.boardgame.tmstats.service.impl;

import com.boardgame.tmstats.domain.Player;
import com.boardgame.tmstats.repository.PlayerRepository;
import com.boardgame.tmstats.service.PlayerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Log4j2
@Service
@Transactional
@RequiredArgsConstructor
public class PlayerServiceImpl implements PlayerService {

  private final PlayerRepository playerRepository;

  @Override
  public List<Player> getAllPlayers() {
    return playerRepository.findAll();
  }
}
