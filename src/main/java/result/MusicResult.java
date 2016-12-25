package result;

import lombok.AllArgsConstructor;
import media.Music;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.util.Date;

/**
 * iTunes music result
 */
@AllArgsConstructor
public class MusicResult extends Result {
  /* Fields */
  private JsonNode json;
}
