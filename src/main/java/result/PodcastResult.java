package result;

import org.json.JSONObject;

/**
 * iTunes podcast result
 */
public class PodcastResult extends Result {

  // TODO - define data model

  /**
   * @see Result#asJson()
   */
  public JSONObject asJson () {
    return null;
  }

  /**
   * @see Result#accept(ResultJSONSerializerVisitor)
   */
  public void accept (ResultJSONSerializerVisitor visitor) {
    visitor.visit(this);
  }

}
