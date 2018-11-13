package com.boardgame.tmstats.resource;

import com.boardgame.tmstats.domain.Game;
import com.boardgame.tmstats.request.GameRequest;
import com.boardgame.tmstats.response.GameResponse;
import com.boardgame.tmstats.service.GameService;
import com.boardgame.tmstats.utils.HeadersUtils;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@Log4j2
@RestController
@RequestMapping("/game")
@RequiredArgsConstructor
public class GameResource {

  private final GameService gameService;

  @ApiOperation(value = "Create new game stats")
  @ApiResponses(value = {
      @ApiResponse(code = 201, message = "Successfully created.")
  })
  @PostMapping
  public ResponseEntity<Game> createGame(@Valid @RequestBody GameRequest gameRequest) {
    Game game = gameService.createGame(gameRequest);
    return new ResponseEntity<>(game, HeadersUtils.getLocationHeaders(game.getId()), HttpStatus.CREATED);
  }

  @ApiOperation(value = "Get games by player counts. Available values 1..5")
  @GetMapping("/{players}")
  public ResponseEntity<List<GameResponse>> getGamesByPlayerCount(@PathVariable int players) {
    return ResponseEntity.ok(gameService.getGamesByPlayerCount(players));
  }
}
