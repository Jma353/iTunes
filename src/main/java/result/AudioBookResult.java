package result;

import lombok.AllArgsConstructor;
import org.codehaus.jackson.JsonNode;

/**
 * iTunes audiobook result
 */
@AllArgsConstructor
public class AudioBookResult extends Result {
  /* Fields */
  private JsonNode json;
}
