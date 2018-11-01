package com.boardgame.tmstats.resource;

import com.boardgame.tmstats.domain.Player;
import com.boardgame.tmstats.service.PlayerService;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Log4j2
@RestController
@RequestMapping("/player")
@RequiredArgsConstructor
public class PlayerResource {

  private final PlayerService playerService;

  @ApiOperation(value = "Get all players")
  @GetMapping
  public ResponseEntity<List<Player>> getPlayers() {
    return ResponseEntity.ok(playerService.getAllPlayers());
  }
}
