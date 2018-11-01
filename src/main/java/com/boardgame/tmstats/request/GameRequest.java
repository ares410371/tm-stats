package com.boardgame.tmstats.request;

import com.boardgame.tmstats.domain.wrapper.PlayerWrapper;
import lombok.Data;

@Data
public class GameRequest {

  private Boolean venusExpansion;
  private Boolean preludeExpansion;
  private Boolean coloniesExpansion;
  private int generationCount;
  private PlayerWrapper playerOne;
  private PlayerWrapper playerTwo;
  private PlayerWrapper playerThree;
  private PlayerWrapper playerFour;
  private PlayerWrapper playerFive;
  private String boardName;
}
