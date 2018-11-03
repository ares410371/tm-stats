package com.boardgame.tmstats.resource;

import com.boardgame.tmstats.response.StatsResponse;
import com.boardgame.tmstats.service.StatsService;

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
@RequestMapping("/stats")
@RequiredArgsConstructor
public class StatsResource {

  private final StatsService statsService;

  @ApiOperation(value = "Get corporation stats")
  @GetMapping("/corporation")
  public ResponseEntity<List<StatsResponse>> getCorporationStats() {
    return ResponseEntity.ok(statsService.getCorporationStats());
  }

  @ApiOperation(value = "Get player stats")
  @GetMapping("/player")
  public ResponseEntity<List<StatsResponse>> getPlayerStats() {
    return ResponseEntity.ok(statsService.getPlayerStats());
  }
}
