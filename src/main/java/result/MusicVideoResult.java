package result;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import java.util.Date;

/**
 * iTunes musicVideo result
 */
public class MusicVideoResult extends Result {

  /* Fields */
  private long trackId;
  private String artistName;
  private String trackName;
  private String trackViewUrl;
  private String previewUrl;
  private String artworkUrl30;
  private String artworkUrl60;
  private String artworkUrl100;
  private String country;
  private String primaryGenreName;
  private Date releaseDate;
  private double trackPrice;
  private long trackTimeMillis;

  /**
   * Constructor from JsonNode
   * @param json - JsonNode
   */
  public static MusicVideoResult fromJson (JsonNode json) {
    try {
      ObjectMapper mapper = new ObjectMapper();
      return mapper.readValue(json.toString(), MusicVideoResult.class);
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  /* Getters */
  public long getTrackId() { return trackId; }
  public String getArtistName() { return artistName; }
  public String getTrackName() { return trackName; }
  public String getTrackViewUrl() { return trackViewUrl; }
  public String getPreviewUrl() { return previewUrl; }
  public String getArtworkUrl30() { return artworkUrl30; }
  public String getArtworkUrl60() { return artworkUrl60; }
  public String getArtworkUrl100() { return artworkUrl100; }
  public String getCountry() {return country; }
  public String getPrimaryGenreName() { return primaryGenreName; }
  public Date getReleaseDate() { return releaseDate; }
  public double getTrackPrice() { return trackPrice; }
  public long getTrackTimeMillis() { return trackTimeMillis; }

}
