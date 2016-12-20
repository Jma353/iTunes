package result;

import org.codehaus.jackson.JsonNode;

/**
 * iTunes shortFilm result
 */
public class ShortFilmResult extends Result {

  /* Fields */
  private JsonNode json;

  /**
   * Constructor from JSON
   * @param json - JsonNode
   */
  public ShortFilmResult (JsonNode json) {
    this.json = json;
  }

}
