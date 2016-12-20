package result;

import com.gargoylesoftware.htmlunit.StringWebResponse;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.HTMLParser;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.codehaus.jackson.JsonNode;
import utils.XPathUtils;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
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
  private String language;
  private String author;
  private String description;
  private String imageURL;
  private String category;
  private String[] keywords;
  private PodcastEpisodeResult[] episodeResults;

  /**
   * PodcastResult from JsonNode
   * @param json - JsonNode
   */
  public PodcastResult (JsonNode json) {
    try {
      URL src = new URL(json.get("feedUrl").getTextValue());
      URLConnection srcConn = src.openConnection();
      BufferedReader in =
        new BufferedReader(new InputStreamReader(srcConn.getInputStream(), "UTF-8"));
      String inputLine;
      StringBuilder builder = new StringBuilder();
      while ((inputLine = in.readLine()) != null)
        builder.append(inputLine);
      in.close();
      String xString = builder.toString();
      xString = xString.replaceAll("[^\\x20-\\x7e\\x0A]", "");
      StringWebResponse response = new StringWebResponse(xString, src);
      WebClient client = new WebClient();
      client.getOptions().setCssEnabled(false);
      client.getOptions().setJavaScriptEnabled(false);
      HtmlPage page = HTMLParser.parseHtml(response, client.getCurrentWindow());
      DomElement channel = (DomElement) page.getFirstByXPath("//channel");
      setValues(channel);
    } catch (Exception e) {
      setValues(null);
      System.out.println(json.get("feedUrl").getTextValue());
      System.out.println(e.getMessage());
    }
  }

  /**
   * Bulk-set values
   * @param channel - DomElement
   */
  public void setValues (DomElement channel) {

    /* Fill all fields */
    this.title = channel != null ? XPathUtils.firstByName(channel, "title") : "";
    this.language = channel != null ? XPathUtils.firstByName(channel, "language") : "";
    this.author = channel != null ? XPathUtils.firstByName(channel, "author") : "";
    this.description = channel != null ? XPathUtils.firstByName(channel, "description") : "";
    this.imageURL = channel != null ? XPathUtils.firstByAttr(channel, "image/@href") : "";
    this.category = channel != null ? XPathUtils.firstByName(channel, "category") : "";
    this.keywords =
      channel != null ? XPathUtils.firstByName(channel, "keywords").split(",") : new String[0];

    /* Episode children */
    if (channel != null) {
      List<DomElement> items = (List<DomElement>) channel.getByXPath("./item");
      this.episodeResults = new PodcastEpisodeResult[items.size()];
      for (int i = 0; i < items.size(); i++) {
        this.episodeResults[i] = new PodcastEpisodeResult(items.get(i));
      }
    } else {
      this.episodeResults = new PodcastEpisodeResult[0];
    }

  }

  /** Getters **/
  public String getTitle () { return title; }
  public String getLanguage () { return language; }
  public String getAuthor () { return author; }
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
      this.author = XPathUtils.firstByName(item, "author");
      this.subtitle = XPathUtils.firstByName(item, "subtitle");
      this.summary = XPathUtils.firstByName(item, "summary");
      this.imageURL = XPathUtils.firstByAttr(item, "image/@href");
      this.duration = XPathUtils.firstByName(item, "duration");
      this.keywords = XPathUtils.firstByName(item, "keywords").split(",");
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
