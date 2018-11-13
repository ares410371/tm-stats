package com.boardgame.tmstats.service;

import com.boardgame.tmstats.domain.Game;
import com.boardgame.tmstats.request.GameRequest;
import com.boardgame.tmstats.response.GameResponse;

import java.util.List;

public interface GameService {

  /**
   * Create game.
   *
   * @param gameRequest game parameters
   * @return created game
   */
  Game createGame(GameRequest gameRequest);

  /**
   * Return all game by player count.
   *
   * @param playerCount input parameter
   * @return List of games
   */
  List<GameResponse> getGamesByPlayerCount(int playerCount);
}
