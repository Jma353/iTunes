package com.cuappdev.backend.itunes.result;

import lombok.AllArgsConstructor;
import org.codehaus.jackson.JsonNode;

/**
 * itunes.iTunes movie itunes.result
 */
@AllArgsConstructor
public class MovieResult extends Result {
  public MovieResult (JsonNode json) {
    this.json = json;
  }
}
