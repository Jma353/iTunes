package itunes.result;

import lombok.AllArgsConstructor;
import org.codehaus.jackson.JsonNode;

/**
 * itunes.iTunes musicVideo itunes.result
 */
@AllArgsConstructor
public class MusicVideoResult extends Result {
  public MusicVideoResult (JsonNode json) {
    this.json = json;
  }
}
