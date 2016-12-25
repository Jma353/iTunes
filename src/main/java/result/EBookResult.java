package result;

import lombok.AllArgsConstructor;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

/**
 * iTunes ebook result
 */
@AllArgsConstructor
public class EBookResult extends Result {
  /* Fields */
  private JsonNode json;
}
