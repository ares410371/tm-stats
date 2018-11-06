package com.boardgame.tmstats.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class InvalidCorporationNameException extends RuntimeException {

  public InvalidCorporationNameException(String corporationName) {
    super(String.format("Invalid corporation name %s", corporationName));
  }

}
