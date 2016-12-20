package result;

import org.codehaus.jackson.JsonNode;

/**
 * iTunes software result
 */
public class SoftwareResult extends Result {

  /* Fields */
  private JsonNode json;

  /**
   * Constructor from JSON
   * @param json - JsonNode
   */
  public SoftwareResult (JsonNode json) {
    this.json = json;
  }


}
