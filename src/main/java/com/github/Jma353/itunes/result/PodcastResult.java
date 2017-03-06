package com.github.Jma353.itunes.result;

import lombok.AllArgsConstructor;
import org.codehaus.jackson.JsonNode;

/**
 * itunes.iTunes podcast itunes.result
 */
@AllArgsConstructor
public class PodcastResult extends Result {
  public PodcastResult (JsonNode json) {
    this.json = json;
  }
}

