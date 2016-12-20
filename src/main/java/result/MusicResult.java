package result;

import media.Music;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.util.Date;

/**
 * iTunes music result
 */
public class MusicResult extends Result {

  /* Fields */
  private JsonNode json;

  /**
   * Constructor from JSON
   * @param json - JsonNode
   */
  public MusicResult (JsonNode json) {
    this.json = json;
  }



}
