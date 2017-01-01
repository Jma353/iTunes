package result;

import lombok.AllArgsConstructor;
import org.codehaus.jackson.JsonNode;

/**
 * iTunes audiobook result
 */
@AllArgsConstructor
public class AudioBookResult extends Result {
  public AudioBookResult (JsonNode json) {
    this.json = json;
  }
}
