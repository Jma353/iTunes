package result;

import lombok.AllArgsConstructor;
import org.codehaus.jackson.JsonNode;

/**
 * iTunes musicVideo result
 */
@AllArgsConstructor
public class MusicVideoResult extends Result {
  public MusicVideoResult (JsonNode json) {
    this.json = json;
  }
}
