package result;

import lombok.AllArgsConstructor;
import org.codehaus.jackson.JsonNode;

/**
 * iTunes tvShow result
 */
@AllArgsConstructor
public class TVShowResult extends Result {
  public TVShowResult (JsonNode json) {
    this.json = json;
  }
}
