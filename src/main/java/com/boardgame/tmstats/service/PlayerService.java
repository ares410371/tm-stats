package com.boardgame.tmstats.service;

import com.boardgame.tmstats.domain.Player;
import com.boardgame.tmstats.request.PlayerRequest;

import java.util.List;

public interface PlayerService {

  Player createPlayer(PlayerRequest playerRequest);

  List<Player> getAllPlayers();
}
