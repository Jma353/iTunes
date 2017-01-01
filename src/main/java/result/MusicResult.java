package result;

import lombok.AllArgsConstructor;
import org.codehaus.jackson.JsonNode;

/**
 * iTunes music result
 */
@AllArgsConstructor
public class MusicResult extends Result {
  public MusicResult (JsonNode json) {
    this.json = json;
  }
}
