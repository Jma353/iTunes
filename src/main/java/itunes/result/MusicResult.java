package itunes.result;

import lombok.AllArgsConstructor;
import org.codehaus.jackson.JsonNode;

/**
 * itunes.iTunes music itunes.result
 */
@AllArgsConstructor
public class MusicResult extends Result {
  public MusicResult (JsonNode json) {
    this.json = json;
  }
}
