package itunes.result;

import lombok.AllArgsConstructor;
import org.codehaus.jackson.JsonNode;

/**
 * itunes.iTunes ebook itunes.result
 */
@AllArgsConstructor
public class EBookResult extends Result {
  public EBookResult (JsonNode json) {
    this.json = json;
  }
}
