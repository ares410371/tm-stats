package com.boardgame.tmstats.response;

import lombok.Data;

@Data
public class PlayerResponse {

  private String name;
  private int points;
  private String corporationName;
}
