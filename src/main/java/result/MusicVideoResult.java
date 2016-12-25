package result;

import lombok.AllArgsConstructor;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;

/**
 * iTunes musicVideo result
 */
@AllArgsConstructor
public class MusicVideoResult extends Result {
  /* Fields */
  private JsonNode json;
}
