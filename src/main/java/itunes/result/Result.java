package itunes.result;

import lombok.Getter;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Result of querying itunes.iTunes
 */
public abstract class Result {

  /* Fields */
  @Getter protected JsonNode json;

  /** Default constructor **/
  public Result () {
  }

  /** Constructor w/JSON **/
  public Result (JsonNode json) {
    this.json = json;
  }

  /**
   * JSON representation of this podcast
   * @return - String (JSON form)
   */
  @Override
  public String toString () {
    try {
      ObjectMapper mapper = new ObjectMapper();
      return mapper.writeValueAsString(this);
    } catch (Exception e) {
      e.printStackTrace();
      return "";
    }
  }

  /**
   * Date object from itunes.iTunes-formatted String
   * @param s - String
   * @return - Date
   */
  protected Date dateFromString (String s) {
    try {
      DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSZ");
      return df.parse(s);
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  /**
   * Get a field from this itunes.result JSON
   * @param s - String
   * @return - JsonNode
   */
  public JsonNode getField (String s) {
    return this.json.get(s);
  }

}
