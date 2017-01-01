package result;

import lombok.AllArgsConstructor;
import org.codehaus.jackson.JsonNode;

/**
 * iTunes movie result
 */
@AllArgsConstructor
public class MovieResult extends Result {
  public MovieResult (JsonNode json) {
    this.json = json;
  }
}
