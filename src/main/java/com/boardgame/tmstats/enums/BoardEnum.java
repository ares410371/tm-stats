package com.boardgame.tmstats.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum  BoardEnum {
  BASE("base"),
  HELLAS("hellas"),
  ELYSIUM("elysium");

  private final String name;

  public static BoardEnum findByName(String name) {
    for (BoardEnum be : values()) {
      if (be.getName().equals(name)) {
        return be;
      }
    }
    throw new IllegalArgumentException(String.format("Invalid board name '%s'", name));
  }
}
