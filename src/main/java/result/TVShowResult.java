package result;

import org.codehaus.jackson.JsonNode;

/**
 * iTunes tvShow result
 */
public class TVShowResult extends Result {

  /* Fields */
  private JsonNode json;

  /**
   * Constructor from JSON
   * @param json - JsonNode
   */
  public TVShowResult (JsonNode json) {
    this.json = json;
  }

}
