package result;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

/**
 * iTunes ebook result
 */
public class EBookResult extends Result {

  /* Fields */
  private long trackId;
  private String trackName;
  private String descriptionLong;
  private String artistName;
  private String trackViewUrl;
  private String country;
  private String artworkUrl30;
  private String artworkUrl60;
  private String artworkUrl100;
  private Date releaseDate;
  private double price;
  private long fileSizeBytes;
  private ArrayList<String> genres;

  /**
   * Constructor from JsonNode
   * @param json - JsonNode
   */
  public static EBookResult fromJson (JsonNode json) throws IOException {
    ObjectMapper mapper = new ObjectMapper();
    return mapper.readValue(json.toString(), EBookResult.class);
  }

  /* Getters */
  public long getTrackId () { return trackId; }
  public String getTrackName () { return trackName; }
  public String getDescriptionLong () { return descriptionLong; }
  public String getArtistName () { return artistName; }
  public String getTrackViewUrl () { return trackViewUrl; }
  public String getCountry () { return country; }
  public String getArtworkUrl30 () { return artworkUrl30; }
  public String getArtworkUrl60 () { return artworkUrl60; }
  public String getArtworkUrl100 () { return artworkUrl100; }
  public Date getReleaseDate () { return releaseDate; }
  public double getPrice () { return price; }
  public long getFileSizeBytes () { return fileSizeBytes; }
  public ArrayList<String> getGenres () { return genres; }

}
