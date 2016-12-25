package result;

import lombok.AllArgsConstructor;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import java.io.IOException;
import java.util.Date;

/**
 * iTunes movie result
 */
@AllArgsConstructor
public class MovieResult extends Result {
  /* Fields */
  private JsonNode json;
}
