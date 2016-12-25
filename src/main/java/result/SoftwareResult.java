package result;

import lombok.AllArgsConstructor;
import org.codehaus.jackson.JsonNode;

/**
 * iTunes software result
 */
@AllArgsConstructor
public class SoftwareResult extends Result {
  /* Fields */
  private JsonNode json;

}
