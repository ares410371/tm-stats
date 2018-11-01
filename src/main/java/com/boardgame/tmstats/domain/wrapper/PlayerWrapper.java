package com.boardgame.tmstats.domain.wrapper;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class PlayerWrapper {

  private String name;
  private int points;
  private String corporation;
}