package com.boardgame.tmstats.service.impl;

import com.boardgame.tmstats.domain.Board;
import com.boardgame.tmstats.domain.Corporation;
import com.boardgame.tmstats.domain.Game;
import com.boardgame.tmstats.domain.Player;
import com.boardgame.tmstats.domain.wrapper.PlayerWrapper;
import com.boardgame.tmstats.exceptions.InvalidBoardNameException;
import com.boardgame.tmstats.exceptions.InvalidCorporationNameException;
import com.boardgame.tmstats.repository.BoardRepository;
import com.boardgame.tmstats.repository.CorporationRepository;
import com.boardgame.tmstats.repository.GameRepository;
import com.boardgame.tmstats.repository.PlayerRepository;
import com.boardgame.tmstats.request.GameRequest;
import com.boardgame.tmstats.response.GameResponse;
import com.boardgame.tmstats.response.PlayerResponse;
import com.boardgame.tmstats.service.GameService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
        .orElseThrow(() -> new InvalidBoardNameException(gameRequest.getBoardName()));
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
    game.setPlayerCount(game.getPlayers().size());
    return game;
  }

  @Override
  public List<GameResponse> getGamesByPlayerCount(int playerCount) {
    if (IntStream.rangeClosed(1,5).noneMatch(x -> x == playerCount)) {
      throw new IllegalArgumentException("Player count is out of range.");
    }

    return gameRepository.getByPlayerCount(playerCount).stream().map(game -> {
      GameResponse response = new GameResponse();
      response.setBoardName(game.getBoard().getName());
      response.setGenerationCount(game.getGenerationCount());
      response.setPlayedAt(LocalDate.now()); // Todo add field to 'db'
      response.setPlayers(game.getPlayers().stream().map(player -> {
        PlayerResponse playerResponse = new PlayerResponse();
        playerResponse.setName(player.getName());
        playerResponse.setPoints(player.getPoints());
        playerResponse.setCorporationName(player.getCorporation().getName());
        return playerResponse;
      }).collect(Collectors.toList()));
      return response;
    }).collect(Collectors.toList());
  }

  private Player createPlayer(PlayerWrapper playerWrapper) {
    Player player = new Player();
    player.setName(playerWrapper.getName());
    player.setPoints(playerWrapper.getPoints());
    Corporation corporation = corporationRepository.findCorporationByName(playerWrapper.getCorporation())
        .orElseThrow(() -> new InvalidCorporationNameException(playerWrapper.getCorporation()));
    player.setCorporation(corporation);
    playerRepository.save(player);
    return player;
  }
}
