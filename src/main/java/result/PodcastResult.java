package result;

import org.json.JSONObject;

/**
 * iTunes podcast result
 */
public class PodcastResult extends Result {

  /* Fields */
  private String title;
  private String link;
  private String language;
  private String subtitle;
  private String author;
  private String summary;
  private String description;
  private String imageURL;


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







  /**
   * Inner class describing a podcast episode result
   */
  public class PodcastEpisodeResult extends Result {



    /**
     * @see Result#asJson()
     */
    public JSONObject asJson () { return null; }

    /**
     * @see Result#accept(ResultJSONSerializerVisitor)
     */
    public void accept (ResultJSONSerializerVisitor visitor) { visitor.visit(this); }

  }

}
