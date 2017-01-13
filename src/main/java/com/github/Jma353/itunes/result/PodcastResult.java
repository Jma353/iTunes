package com.github.Jma353.itunes.result;

import com.gargoylesoftware.htmlunit.StringWebResponse;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.HTMLParser;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.codehaus.jackson.JsonNode;
import com.github.Jma353.itunes.utils.XPathUtils;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import lombok.Getter;

/**
 * itunes.iTunes podcast itunes.result
 */
public class PodcastResult extends Result {

  /* Fields */
  @Getter private Long id;
  @Getter private String title;
  @Getter private String country;
  @Getter private String author;
  @Getter private String description;
  @Getter private String imageURL;
  @Getter private String[] genres;
  @Getter private PodcastEpisodeResult[] episodeResults;

  /**
   * PodcastResult from JsonNode
   * @param json - JsonNode
   */
  public PodcastResult (JsonNode json) {
    this.json = json;
    try {

      /* Setup stream */
      URL src = new URL(json.get("feedUrl").getTextValue());
      URLConnection srcConn = src.openConnection();
      BufferedReader in =
        new BufferedReader(new InputStreamReader(srcConn.getInputStream(), "UTF-8"));

      /* Build String from stream */
      String inputLine;
      StringBuilder builder = new StringBuilder();
      while ((inputLine = in.readLine()) != null)
        builder.append(inputLine);
      in.close();
      String xString = builder.toString();

      /* Clean + process String */
      xString = xString.replaceAll("[^\\x20-\\x7e\\x0A]", "");
      StringWebResponse response = new StringWebResponse(xString, src);
      WebClient client = new WebClient();
      client.getOptions().setCssEnabled(false);
      client.getOptions().setJavaScriptEnabled(false);

      /* Get HTML page + grab values */
      HtmlPage page = HTMLParser.parseHtml(response, client.getCurrentWindow());
      DomElement channel = (DomElement) page.getFirstByXPath("//channel");
      setValues(channel, json);
    }
    /**/
    catch (Exception e) {
      setValues(null, null);
    }
  }

  /**
   * Bulk-set values
   * @param channel - DomElement
   */
  public void setValues (DomElement channel, JsonNode json) {

    /* Fill all fields */
    this.id = json != null ? json.get("collectionId").asLong() : -1;
    this.title = channel != null ? XPathUtils.firstByName(channel, "title") : "";
    this.country = json != null ? json.get("country").asText() : "";
    this.author = channel != null ? XPathUtils.firstByName(channel, "author") : "";
    this.description = channel != null ? XPathUtils.firstByName(channel, "description") : "";
    this.imageURL = channel != null ? XPathUtils.firstByAttr(channel, "image/@href") : "";
    ArrayList<String> genres = new ArrayList<String>();
    if (json != null) {
      Iterator<JsonNode> it = json.get("genres").iterator();
      while (it.hasNext()) { genres.add(it.next().asText()); }
    }
    this.genres = genres.toArray(new String[genres.size()]);

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

  /**
   * Inner class describing a podcast episode itunes.result
   */
  public static class PodcastEpisodeResult extends Result {

    /* Fields */
    @Getter private String title;
    @Getter private String author;
    @Getter private String subtitle;
    @Getter private String summary;
    @Getter private String imageURL;
    @Getter private String duration;
    @Getter private String[] keywords;
    @Getter private String audioURL;
    @Getter private Date pubDate;

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
  }

}
