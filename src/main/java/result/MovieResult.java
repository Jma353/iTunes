package result;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.util.Date;

/**
 * iTunes movie result
 */
public class MovieResult extends Result {

  /* Fields */
  private long trackId;
  private String trackName;
  private String descriptionLong;
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
  public static MovieResult fromJson (JsonNode json) throws IOException {
    ObjectMapper mapper = new ObjectMapper();
    return mapper.readValue(json.toString(), MovieResult.class);
  }

  /* Getters */
  public long getTrackId () { return trackId; }
  public String getTrackName () { return trackName; }
  public String getDescriptionLong () { return descriptionLong; }
  public String getArtistName () { return artistName; }
  public String getTrackViewUrl () { return trackViewUrl; }
  public String getPreviewUrl () { return previewUrl; }
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
