package result;

import org.json.JSONObject;

/**
 * Result of querying iTunes
 */
public abstract class Result {

  /**
   * Result in JSON form
   * @return - JSONObject
   */
  public abstract JSONObject asJson ();

  /**
   * Accept ResultJSONSerializerVisitor for the purposes
   * of JSON creation
   * @param visitor - ResultJSONSerializerVisitor
   */
  public abstract void accept (ResultJSONSerializerVisitor visitor);

}
