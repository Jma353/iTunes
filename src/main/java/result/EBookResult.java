package result;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

/**
 * iTunes ebook result
 */
public class EBookResult extends Result {

  /* Fields */
  private JsonNode json;

  /**
   * Constructor from JSON
   * @param json - JsonNode
   */
  public EBookResult (JsonNode json) {
    this.json = json;
  }


}
