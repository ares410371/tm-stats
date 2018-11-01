package com.boardgame.tmstats.resource;

import com.boardgame.tmstats.domain.Player;
import com.boardgame.tmstats.request.PlayerRequest;
import com.boardgame.tmstats.service.PlayerService;
import com.boardgame.tmstats.utils.HeadersUtils;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@Log4j2
@RestController
@RequestMapping("/player")
@RequiredArgsConstructor
public class PlayerResource {

  private final PlayerService playerService;

  @PostMapping
  public ResponseEntity<Player> createPlayer(@Valid @RequestBody PlayerRequest playerRequest) {
    Player player = playerService.createPlayer(playerRequest);
    return new ResponseEntity<>(player, HeadersUtils.getLocationHeaders(player.getId()),HttpStatus.CREATED);
  }

  @GetMapping
  public ResponseEntity<List<Player>> getPlayers() {
    return ResponseEntity.ok(playerService.getAllPlayers());
  }
}
