package result;

import org.json.JSONObject;

/**
 * Visitor to serialize iTunes search / lookup results as JSOn
 */
public class ResultJSONSerializerVisitor {

  /* Fields */
  JSONObject result;

  /**
   * Constructor
   */
  public ResultJSONSerializerVisitor () {
    this.result = new JSONObject ();
  }

  /**
   * Result getter
   * @return - JSONObject (created as a result of visiting)
   */
  public JSONObject getResult () {
    return this.result;
  }

  /**
   * Visit PodcastResult
   * @param p - PodcastResult
   */
  public void visit (PodcastResult p) {
    // TODO - define logic
  }

}
