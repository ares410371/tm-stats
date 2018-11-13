package com.boardgame.tmstats.resource;

import com.boardgame.tmstats.domain.Corporation;
import com.boardgame.tmstats.service.CorporationService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Log4j2
@RestController
@RequestMapping("/corporation")
@RequiredArgsConstructor
public class CorporationResource {

  private final CorporationService corporationService;

  @ApiOperation(value = "Get all corporation")
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Get all corporations")
  })
  @GetMapping
  public ResponseEntity<List<Corporation>> getCorporations() {
    return ResponseEntity.ok(corporationService.getAllCorporations());
  }

  @ApiOperation(value = "Get corporation")
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Get corporation"),
      @ApiResponse(code = 404, message = "Corporation not found")
  })
  @GetMapping("/{id}")
  public ResponseEntity<Corporation> getCorporation(@PathVariable Long id) {
    return ResponseEntity.ok(corporationService.getById(id));
  }
}
