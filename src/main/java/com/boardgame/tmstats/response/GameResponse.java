package com.boardgame.tmstats.response;

import lombok.Data;

import java.util.List;

@Data
public class GameResponse {

  private List<String> players;
  private String boardName;
}
