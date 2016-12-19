package result;

import org.codehaus.jackson.JsonNode;
import java.util.Date;

/**
 * iTunes movie result
 */
public class MovieResult extends Result {

  /* Fields */
  private long trackId;
  private String name;
  private String description;
  private String artistName;
  private String trackViewUrl;
  private String previewUrl;
  private String country;
  private String primaryGenreName;
  private String artworkUrl30;
  private String artworkUrl60;
  private String artworkUrl100;
  private Date releaseDate;
  private double collectionPrice;
  private double collectionHdPrice;
  private long trackTimeMillis;

  /**
   * Constructor from JsonNode
   * @param json - JsonNode
   */
  public MovieResult (JsonNode json) {
    this.trackId = json.get("trackId").getLongValue();
    this.name = json.get("trackName").getTextValue();
    this.description = json.get("longDescription").getTextValue();
    this.artistName = json.get("artistName").getTextValue();
    this.trackViewUrl = json.get("trackViewUrl").getTextValue();
    this.previewUrl = json.get("previewUrl").getTextValue();
    this.country = json.get("country").getTextValue();
    this.primaryGenreName = json.get("primaryGenreName").getTextValue();
    this.artworkUrl30 = json.get("artworkUrl30").getTextValue();
    this.artworkUrl60 = json.get("artworkUrl60").getTextValue();
    this.artworkUrl100 = json.get("artworkUrl100").getTextValue();
    this.releaseDate = dateFromString(json.get("releaseDate").getTextValue());
    this.collectionPrice = json.get("collectionPrice").getDoubleValue();
    this.collectionHdPrice = json.get("collectionHdPrice").getDoubleValue();
    this.trackTimeMillis = json.get("trackTimeMillis").getLongValue();
  }

  /* Getters */
  public long getTrackId () { return this.trackId; }
  public String getName () { return this.name; }
  public String getDescription () { return this.description; }
  public String getArtistName () { return this.artistName; }
  public String getTrackViewUrl () { return this.trackViewUrl; }
  public String getPreviewUrl () { return this.previewUrl; }
  public String getCountry() { return country; }
  public String getPrimaryGenreName() { return primaryGenreName; }
  public String getArtworkUrl30() { return artworkUrl30; }
  public String getArtworkUrl60() { return artworkUrl60; }
  public String getArtworkUrl100() { return artworkUrl100; }
  public Date getReleaseDate() { return releaseDate; }
  public double getCollectionPrice () { return collectionPrice; }
  public double getCollectionHdPrice() { return collectionHdPrice; }
  public long getTrackTimeMillis() { return trackTimeMillis; }

}
