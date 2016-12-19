package result;

import media.Music;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.util.Date;

/**
 * iTunes music result
 */
public class MusicResult extends Result {

  /* Fields */
  private long trackId;
  private String trackName;
  private String artistName;
  private String collectionName;
  private String trackViewUrl;
  private String collectionViewUrl;
  private String previewUrl;
  private String primaryGenreName;
  private String country;
  private Date releaseDate;
  private double collectionPrice;
  private double trackPrice;
  private long trackTimeMillis;

  /**
   * Constructor from JsonNode
   * @param json - JsonNode
   */
  public static MusicResult fromJson (JsonNode json) {
    try {
      ObjectMapper mapper = new ObjectMapper();
      return mapper.readValue(json.toString(), MusicResult.class);
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  /* Getters */
  public long getTrackId () { return trackId; }
  public String getTrackName () { return trackName; }
  public String getArtistName () { return artistName; }
  public String getCollectionName () { return collectionName; }
  public String getTrackViewUrl () { return trackViewUrl; }
  public String getCollectionViewUrl () { return collectionViewUrl; }
  public String getPreviewUrl () { return previewUrl; }
  public String getPrimaryGenreName () { return primaryGenreName; }
  public String getCountry () { return country; }
  public Date getReleaseDate () { return releaseDate; }
  public double getCollectionPrice () { return collectionPrice; }
  public double getTrackPrice () { return trackPrice; }
  public long getTrackTimeMillis () { return trackTimeMillis; }

}
