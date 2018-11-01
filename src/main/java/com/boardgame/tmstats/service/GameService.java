package com.boardgame.tmstats.service;

import com.boardgame.tmstats.domain.Game;
import com.boardgame.tmstats.request.GameRequest;
import com.boardgame.tmstats.response.GameResponse;

import java.util.List;

public interface GameService {

  Game createGame(GameRequest gameRequest);

  List<GameResponse> getAllGames();
}
