package com.github.Jma353.itunes.result;

import org.codehaus.jackson.JsonNode;
import java.util.ArrayList;
import java.util.Iterator;
import lombok.Getter;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

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
  private String imageURL;
  @Getter
  private String feedURL;
  @Getter
  private String[] genres;

  /**
   * PodcastResult from JsonNode
   *
   * @param json - JsonNode
   */
  public PodcastResult(JsonNode json) {
    this.json = json;
    this.id = json.get("collectionId").asLong();
    this.title = json.get("collectionName").getTextValue();
    this.country = json.get("country").getTextValue();
    this.author = json.get("artistName").getTextValue();
    this.imageURL = json.get("artworkUrl60").getTextValue();
    this.feedURL = json.get("feedUrl").getTextValue();
    ArrayList<String> genres = new ArrayList<String>();
    Iterator<JsonNode> it = json.get("genres").iterator();
    while (it.hasNext()) {
      genres.add(it.next().asText());
    }
    this.genres = genres.toArray(new String[genres.size()]);

  }




}

