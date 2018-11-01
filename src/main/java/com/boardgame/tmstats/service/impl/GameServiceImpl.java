package com.boardgame.tmstats.service.impl;

import com.boardgame.tmstats.domain.Board;
import com.boardgame.tmstats.domain.Corporation;
import com.boardgame.tmstats.domain.Game;
import com.boardgame.tmstats.domain.Player;
import com.boardgame.tmstats.domain.wrapper.PlayerWrapper;
import com.boardgame.tmstats.repository.BoardRepository;
import com.boardgame.tmstats.repository.CorporationRepository;
import com.boardgame.tmstats.repository.GameRepository;
import com.boardgame.tmstats.repository.PlayerRepository;
import com.boardgame.tmstats.request.GameRequest;
import com.boardgame.tmstats.response.GameResponse;
import com.boardgame.tmstats.service.GameService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Log4j2
@Service
@Transactional
@RequiredArgsConstructor
public class GameServiceImpl implements GameService {

  private final GameRepository gameRepository;
  private final PlayerRepository playerRepository;
  private final BoardRepository boardRepository;
  private final CorporationRepository corporationRepository;

  @Override
  public Game createGame(GameRequest gameRequest) {
    Game game = new Game();
    game.setCreatedAt(LocalDateTime.now());
    game.setVenusExpansion(gameRequest.getVenusExpansion());
    game.setPreludeExpansion(gameRequest.getPreludeExpansion());
    game.setColoniesExpansion(gameRequest.getColoniesExpansion());
    game.setGenerationCount(gameRequest.getGenerationCount());

    Board board = boardRepository.findBoardByName(gameRequest.getBoardName())
        .orElseThrow(() -> new RuntimeException("Board not found."));
    game.setBoard(board);
    gameRepository.save(game);
    if (gameRequest.getPlayerOne() != null) {
      game.getPlayers().add(createPlayer(gameRequest.getPlayerOne()));
    }
    if (gameRequest.getPlayerTwo() != null) {
      game.getPlayers().add(createPlayer(gameRequest.getPlayerTwo()));
    }
    if (gameRequest.getPlayerThree() != null) {
      game.getPlayers().add(createPlayer(gameRequest.getPlayerThree()));
    }
    if (gameRequest.getPlayerFour() != null) {
      game.getPlayers().add(createPlayer(gameRequest.getPlayerFour()));
    }
    if (gameRequest.getPlayerFive() != null) {
      game.getPlayers().add(createPlayer(gameRequest.getPlayerFive()));
    }
    return game;
  }

  @Override
  public List<GameResponse> getAllGames() {
    return gameRepository.findAll().stream().map(game -> {
      GameResponse gameResponse = new GameResponse();
      Set<Player> players = game.getPlayers();
      gameResponse.setPlayers(players.stream().map(Player::getName).collect(Collectors.toList()));
      gameResponse.setBoardName(game.getBoard().getName());
      return gameResponse;
    }).collect(Collectors.toList());
  }

  private Player createPlayer(PlayerWrapper playerWrapper) {
    Player player = new Player();
    player.setName(playerWrapper.getName());
    player.setPoints(playerWrapper.getPoints());
    Corporation corporation = corporationRepository.findCorporationByName(playerWrapper.getCorporation())
        .orElseThrow(() -> new IllegalArgumentException("Invalid corporation name"));
    player.setCorporation(corporation);
    playerRepository.save(player);
    return player;
  }
}
