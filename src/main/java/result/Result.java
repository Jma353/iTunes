package result;

import org.codehaus.jackson.map.ObjectMapper;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Result of querying iTunes
 */
public abstract class Result {

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
   * Date object from iTunes-formatted String
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



}
