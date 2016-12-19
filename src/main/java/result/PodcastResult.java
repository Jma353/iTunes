package result;

import com.gargoylesoftware.htmlunit.html.DomElement;
import org.codehaus.jackson.map.ObjectMapper;
import utils.XPathUtils;

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
  private String category;
  private String[] keywords;

  /**
   * Channel element
   * @param channel - DomElement
   */
  public PodcastResult (DomElement channel) {
    this.title = XPathUtils.firstByName(channel, "title");
    this.link = XPathUtils.firstByName(channel, "link");
    this.language = XPathUtils.firstByName(channel, "language");
    this.subtitle = XPathUtils.firstByName(channel, "itunes:subtitle");
    this.author = XPathUtils.firstByName(channel, "itunes:summary");
    this.summary = XPathUtils.firstByName(channel, "itunes:summary");
    this.description = XPathUtils.firstByName(channel, "description");
    this.imageURL = XPathUtils.firstByAttr(channel, "itunes:image/@href");
    this.category = XPathUtils.firstByName(channel, "media:category");
    this.keywords = XPathUtils.firstByName(channel, "itunes:keywords").split(",");
  }

  /** Getters **/
  public String getTitle() { return title; }
  public String getLink() { return link;}
  public String getLanguage() { return language; }
  public String getSubtitle() { return subtitle;}
  public String getAuthor() { return author; }
  public String getSummary() { return summary; }
  public String getDescription() { return description;}
  public String getImageURL() { return imageURL;}
  public String getCategory() { return category; }
  public String[] getKeywords() { return keywords;}

  /**
   * JSON representation of this Podcast
   * @return - String
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
   * Inner class describing a podcast episode result
   */
  public class PodcastEpisodeResult extends Result {

    /* Fields */
    private String title;
    private String author;



  }

}
