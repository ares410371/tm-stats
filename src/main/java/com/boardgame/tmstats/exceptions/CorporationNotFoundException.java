package com.boardgame.tmstats.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CorporationNotFoundException extends RuntimeException {

  public CorporationNotFoundException() {
    super("Corporation not found");
  }

}
