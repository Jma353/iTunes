package result;

import lombok.AllArgsConstructor;
import org.codehaus.jackson.JsonNode;

/**
 * iTunes ebook result
 */
@AllArgsConstructor
public class EBookResult extends Result {
  public EBookResult (JsonNode json) {
    this.json = json;
  }
}
