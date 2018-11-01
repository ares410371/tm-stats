package com.boardgame.tmstats.service.impl;

import com.boardgame.tmstats.domain.Player;
import com.boardgame.tmstats.repository.PlayerRepository;
import com.boardgame.tmstats.request.PlayerRequest;
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
  public Player createPlayer(PlayerRequest playerRequest) {
    playerRepository.findPlayerByName(playerRequest.getName()).ifPresent(player -> {
      throw new RuntimeException("Player already exist in db.");
    });

    Player player = new Player();
    player.setName(playerRequest.getName());
    playerRepository.save(player);

    return player;
  }

  @Override
  public List<Player> getAllPlayers() {
    List<Player> allPlayers = playerRepository.findAll();
    return allPlayers;
  }
}
