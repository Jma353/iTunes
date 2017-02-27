package com.github.Jma353.itunes.result;

import com.github.Jma353.itunes.HTTP;
import com.rometools.rome.feed.synd.SyndCategory;
import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.SyndFeedInput;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.codehaus.jackson.JsonNode;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import lombok.Getter;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.jdom2.Element;

/**
 * itunes.iTunes podcast itunes.result
 */
@JsonIgnoreProperties(value = {"json"})
public class PodcastResult extends Result {

  /* Fields */
  @Getter
  private Long id;
  @Getter
  private String title;
  @Getter
  private String country;
  @Getter
  private String author;
  @Getter
  private String description;
  @Getter
  private String imageURL;
  @Getter
  private String feedURL;
  @Getter
  private String[] genres;
  @Getter
  private PodcastEpisodeResult[] episodeResults;

  /**
   * PodcastResult from JsonNode
   *
   * @param json - JsonNode
   */
  public PodcastResult(JsonNode json) {
    this.json = json;

    /* Prepare to get RSS */
    SyndFeedInput input = new SyndFeedInput();
    SyndFeed feed = null;
    String dataSource = json.get("feedUrl").getTextValue();

    try {
      /* Stream RSS feed */
      CloseableHttpClient httpClient = HttpClients.createDefault();
      BufferedReader reader = HTTP.getResponseRSS(httpClient, dataSource);
      feed = input.build(reader);

      /* Close stuff */
      reader.close();
      httpClient.close();

      /* Instantiate */
      setValues(feed, json);
    } catch (Exception e) {
      setFailValues();
    }
  }

  /**
   * Bulk-set values
   *
   * @param feed - SyndFeed
   */
  public void setValues(SyndFeed feed, JsonNode json) {
    try {
    /* Fill all fields */
      this.id = json.get("collectionId").asLong();
      this.title = json.get("collectionName").getTextValue();
      this.country = json.get("country").getTextValue();
      this.author = json.get("artistName").getTextValue();
      this.imageURL = json.get("artworkUrl60").getTextValue();
      this.feedURL = json.get("feedUrl").getTextValue();
      this.description = feed.getDescription();
      ArrayList<String> genres = new ArrayList<String>();
      Iterator<JsonNode> it = json.get("genres").iterator();
      while (it.hasNext()) {
        genres.add(it.next().asText());
        this.genres = genres.toArray(new String[genres.size()]);

      }

      List<SyndEntry> entries = feed.getEntries();
      this.episodeResults = new PodcastEpisodeResult[entries.size()];
      for (int i = 0; i < entries.size(); i++) {
        this.episodeResults[i] = new PodcastEpisodeResult(entries.get(i));
      }

    } catch (Exception e) {
      setFailValues();
    }
  }

  /**
   * On failure, set these values to flag failure
   */
  public void setFailValues() {
    this.id = -1L;
    this.episodeResults = new PodcastEpisodeResult[0];
    this.genres = new String[0];
  }

  /**
   * Inner class describing a podcast episode itunes.result
   */
  @JsonIgnoreProperties(value = {"json"})
  public static class PodcastEpisodeResult extends Result {

    /* Fields */
    @Getter
    private String title;
    @Getter
    private String author;
    @Getter
    private String summary;
    @Getter
    private String audioURL;
    @Getter
    private String imageURL;
    @Getter
    private String duration;
    @Getter
    private String[] keywords;
    @Getter
    private Date pubDate;

    /**
     * PodcastEpisodeResult from item DomElement
     * @param item - DomElement
     */
    public PodcastEpisodeResult(SyndEntry item) {
      /* Non-date fields */
      this.title = item.getTitle();
      this.summary = item.getDescription() != null ? item.getDescription().getValue() : "";
      this.pubDate = item.getPublishedDate();
      this.author = item.getAuthor();
      this.audioURL = item.getEnclosures().size() > 0 ? item.getEnclosures().get(0).getUrl() : "";
      this.imageURL = item.getUri();

      // Keywords
      List<SyndCategory> categories = item.getCategories();
      String[] kws = new String[categories.size()];
      for (int i = 0; i < categories.size(); i++) {
        kws[i] = categories.get(i).getName();
      }
      this.keywords = kws;

      // Duration
      List<Element> markup = item.getForeignMarkup();
      for(Element e : markup) {
        if(e.getName().contains("duration")) {
          this.duration = e.getValue();
        }
      }

    }
  }

}

