package com.boardgame.tmstats.response;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class GameResponse {

  private List<PlayerResponse> players;
  private String boardName;
  private LocalDate playedAt;
  private int generationCount;
}
