package com.github.Jma353.itunes.result;

import lombok.AllArgsConstructor;
import org.codehaus.jackson.JsonNode;

/**
 * itunes.iTunes software itunes.result
 */
@AllArgsConstructor
public class SoftwareResult extends Result {
  public SoftwareResult (JsonNode json) {
    this.json = json;
  }
}
