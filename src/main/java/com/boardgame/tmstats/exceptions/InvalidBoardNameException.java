package com.boardgame.tmstats.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class InvalidBoardNameException extends RuntimeException {

  public InvalidBoardNameException(String boardName) {
    super(String.format("Invalid board name %s", boardName));
  }

}
