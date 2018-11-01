package com.boardgame.tmstats.resource;

import com.boardgame.tmstats.domain.Corporation;
import com.boardgame.tmstats.service.CorporationService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Log4j2
@RestController
@RequestMapping("/corporation")
@RequiredArgsConstructor
public class CorporationResource {

  private final CorporationService corporationService;

  @GetMapping
  public ResponseEntity<List<Corporation>> getCorporations() {
    return ResponseEntity.ok(corporationService.getAllCorporations());
  }
}
