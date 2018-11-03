package com.boardgame.tmstats.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
public class StatsResponse {

  private String name;
  private Long numberOfGames;
  private Long numberOfWins;
  private BigDecimal percentageWin;
  private BigDecimal pointsAverage;
}
