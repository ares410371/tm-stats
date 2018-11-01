package com.boardgame.tmstats.service.impl;

import com.boardgame.tmstats.domain.Board;
import com.boardgame.tmstats.domain.Corporation;
import com.boardgame.tmstats.domain.Game;
import com.boardgame.tmstats.domain.Player;
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
      Player player = new Player();
      player.setName(gameRequest.getPlayerOne().getName());
      player.setPoints(gameRequest.getPlayerOne().getPoints());
      Corporation corporation = corporationRepository.findCorporationByName(gameRequest.getPlayerOne().getCorporation())
          .orElseThrow(() -> new IllegalArgumentException("Invalid corporation name"));
      player.setCorporation(corporation);
      playerRepository.save(player);
      game.getPlayers().add(player);
    }
    if (gameRequest.getPlayerTwo() != null) {
      Player player = new Player();
      player.setName(gameRequest.getPlayerTwo().getName());
      player.setPoints(gameRequest.getPlayerTwo().getPoints());
      Corporation corporation = corporationRepository.findCorporationByName(gameRequest.getPlayerTwo().getCorporation())
          .orElseThrow(() -> new IllegalArgumentException("Invalid corporation name"));
      player.setCorporation(corporation);
      playerRepository.save(player);
      game.getPlayers().add(player);
    }
    if (gameRequest.getPlayerThree() != null) {
      Player player =  new Player();
      player.setName(gameRequest.getPlayerThree().getName());
      player.setPoints(gameRequest.getPlayerThree().getPoints());
      Corporation corporation = corporationRepository.findCorporationByName(gameRequest.getPlayerThree().getCorporation())
          .orElseThrow(() -> new IllegalArgumentException("Invalid corporation name"));
      player.setCorporation(corporation);
      playerRepository.save(player);
      game.getPlayers().add(player);
    }
    if (gameRequest.getPlayerFour() != null) {
      Player player = new Player();
      player.setName(gameRequest.getPlayerFour().getName());
      player.setPoints(gameRequest.getPlayerFour().getPoints());
      Corporation corporation = corporationRepository.findCorporationByName(gameRequest.getPlayerFour().getCorporation())
          .orElseThrow(() -> new IllegalArgumentException("Invalid corporation name"));
      player.setCorporation(corporation);
      playerRepository.save(player);
      game.getPlayers().add(player);
    }
    if (gameRequest.getPlayerFive() != null) {
      Player player = new Player();
      player.setName(gameRequest.getPlayerFive().getName());
      player.setPoints(gameRequest.getPlayerFive().getPoints());
      Corporation corporation = corporationRepository.findCorporationByName(gameRequest.getPlayerFive().getCorporation())
          .orElseThrow(() -> new IllegalArgumentException("Invalid corporation name"));
      player.setCorporation(corporation);
      playerRepository.save(player);
      game.getPlayers().add(player);
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
}
