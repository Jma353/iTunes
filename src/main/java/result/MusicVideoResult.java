package result;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;

/**
 * iTunes musicVideo result
 */
public class MusicVideoResult extends Result {

  /* Fields */
  private JsonNode json;

  /**
   * Constructor from JSON
   * @param json - JsonNode
   */
  public MusicVideoResult (JsonNode json) {
    this.json = json;
  }


}
