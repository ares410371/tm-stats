package com.boardgame.tmstats.utils;

import org.springframework.http.HttpHeaders;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

public class HeadersUtils {

  /**
   * do not allow new instance.
   */
  private HeadersUtils() {}

  /**
   * Expands given endpoint with Location header where new entity is created.
   *
   * @param identifier of new entity
   * @return Headers with Location Header set
   */
  public static HttpHeaders getLocationHeaders(Object identifier) {
    HttpHeaders responseHeaders = new HttpHeaders();
    responseHeaders.setLocation(ServletUriComponentsBuilder
        .fromCurrentRequest().path("/{id}")
        .buildAndExpand(identifier).toUri());

    return responseHeaders;
  }
}
