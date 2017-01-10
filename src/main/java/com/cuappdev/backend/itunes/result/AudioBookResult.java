package com.cuappdev.backend.itunes.result;

import lombok.AllArgsConstructor;
import org.codehaus.jackson.JsonNode;

/**
 * itunes.iTunes audiobook itunes.result
 */
@AllArgsConstructor
public class AudioBookResult extends Result {
  public AudioBookResult (JsonNode json) {
    this.json = json;
  }
}
