package result;

import org.codehaus.jackson.JsonNode;

/**
 * iTunes audiobook result
 */
public class AudioBookResult extends Result {

  /* Fields */
  private JsonNode json;

  /**
   * Constructor from JSON
   * @param json - JsonNode
   */
  public AudioBookResult (JsonNode json) {
    this.json = json;
  }



}
