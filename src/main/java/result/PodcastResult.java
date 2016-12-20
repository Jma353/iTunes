package result;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.xml.XmlPage;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import utils.XPathUtils;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
  private PodcastEpisodeResult[] episodeResults;

  /**
   * PodcastResult from channel DomElement
   * @param channel - DomElement
   */
  public PodcastResult (DomElement channel) {
    /* Fill all fields */
    this.title = XPathUtils.firstByName(channel, "title");
    this.link = XPathUtils.firstByName(channel, "link");
    this.language = XPathUtils.firstByName(channel, "language");
    this.subtitle = XPathUtils.firstByName(channel, "itunes:subtitle");
    this.author = XPathUtils.firstByName(channel, "itunes:author");
    this.summary = XPathUtils.firstByName(channel, "itunes:summary");
    this.description = XPathUtils.firstByName(channel, "description");
    this.imageURL = XPathUtils.firstByAttr(channel, "itunes:image/@href");
    this.category = XPathUtils.firstByName(channel, "itunes:category");
    this.keywords = XPathUtils.firstByName(channel, "itunes:keywords").split(",");
    /* Episode children */
    List<DomElement> items = (List<DomElement>) channel.getByXPath("./item");
    this.episodeResults = new PodcastEpisodeResult[items.size()];
    for (int i = 0; i < items.size(); i++) {
      this.episodeResults[i] = new PodcastEpisodeResult(items.get(i));
    }
  }

  /**
   * PodcastResult from JsonNode
   * @param json - JsonNode
   */
  public static PodcastResult fromJson (JsonNode json) {
    try {
      WebClient client = new WebClient();
      client.getOptions().setCssEnabled(false);
      client.getOptions().setJavaScriptEnabled(false);
      XmlPage page = client.getPage(json.get("feedUrl").getTextValue());
      DomElement channel = (DomElement) page.getFirstByXPath("//channel");
      PodcastResult result = new PodcastResult(channel);
      return new PodcastResult (channel);
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  /** Getters **/
  public String getTitle () { return title; }
  public String getLink () { return link; }
  public String getLanguage () { return language; }
  public String getSubtitle () { return subtitle; }
  public String getAuthor () { return author; }
  public String getSummary () { return summary; }
  public String getDescription () { return description; }
  public String getImageURL () { return imageURL; }
  public String getCategory () { return category; }
  public String[] getKeywords () { return keywords; }
  public PodcastEpisodeResult[] getEpisodeResults () { return episodeResults; }

  /**
   * Inner class describing a podcast episode result
   */
  public static class PodcastEpisodeResult extends Result {

    /* Fields */
    private String title;
    private String author;
    private String subtitle;
    private String summary;
    private String imageURL;
    private String duration;
    private String[] keywords;
    private String audioURL;
    private Date pubDate;

    /**
     * PodcastEpisodeResult from item DomElement
     * @param item - DomElement
     */
    public PodcastEpisodeResult (DomElement item) {
      /* Non-date fields */
      this.title = XPathUtils.firstByName(item, "title");
      this.author = XPathUtils.firstByName(item, "itunes:author");
      this.subtitle = XPathUtils.firstByName(item, "itunes:subtitle");
      this.summary = XPathUtils.firstByName(item, "itunes:summary");
      this.imageURL = XPathUtils.firstByAttr(item, "itunes:image/@href");
      this.duration = XPathUtils.firstByName(item, "itunes:duration");
      this.keywords = XPathUtils.firstByName(item, "itunes:keywords").split(",");
      this.audioURL = XPathUtils.firstByAttr(item, "enclosure/@url");
      /* Date processing */
      DateFormat df = new SimpleDateFormat("d MMM yyyy");
      String dateString = XPathUtils.firstByName(item, "pubDate");
      int comma = dateString.indexOf(",") + 2;
      dateString = dateString.substring(comma, comma + 11);
      try {
        this.pubDate = df.parse(dateString);
      } catch (Exception e) {
        this.pubDate = null;
      }
    }

    /** Getters **/
    public String getTitle () { return this.title; }
    public String getAuthor () { return this.author; }
    public String getSubtitle () { return this.subtitle; }
    public String getSummary () { return this.summary; }
    public String getImageURL () { return this.imageURL; }
    public String getDuration () { return this.duration; }
    public String[] getKeywords () { return this.keywords; }
    public String getAudioURL () { return this.audioURL; }
    public Date getPubDate () { return this.pubDate; }

  }

}
