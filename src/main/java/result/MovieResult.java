package result;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import java.io.IOException;
import java.util.Date;

/**
 * iTunes movie result
 */
public class MovieResult extends Result {

  /* Fields */
  private JsonNode json;

  /**
   * Constructor from JSON
   * @param json - JsonNode
   */
  public MovieResult (JsonNode json) {
    this.json = json;
  }



}
