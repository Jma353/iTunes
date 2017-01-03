package itunes.result;

import lombok.AllArgsConstructor;
import org.codehaus.jackson.JsonNode;

/**
 * itunes.iTunes tvShow itunes.result
 */
@AllArgsConstructor
public class TVShowResult extends Result {
  public TVShowResult (JsonNode json) {
    this.json = json;
  }
}
