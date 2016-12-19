package result;

import org.codehaus.jackson.JsonNode;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

/**
 * iTunes ebook result
 */
public class EBookResult extends Result {

  /* Fields */
  private long trackId;
  private String name;
  private String description;
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
  public EBookResult (JsonNode json) {
    this.trackId = json.get("trackId").getLongValue();
    this.name = json.get("trackName").getTextValue();
    this.description = json.get("longDescription").getTextValue();
    this.artistName = json.get("artistName").getTextValue();
    this.trackViewUrl = json.get("trackViewUrl").getTextValue();
    this.country = json.get("country").getTextValue();
    this.artworkUrl30 = json.get("artworkUrl30").getTextValue();
    this.artworkUrl60 = json.get("artworkUrl60").getTextValue();
    this.artworkUrl100 = json.get("artworkUrl100").getTextValue();
    this.releaseDate = dateFromString(json.get("releaseDate").getTextValue());
    this.price = json.get("price").getDoubleValue();
    this.fileSizeBytes = json.get("fileSizeBytes").getLongValue();
    Iterator<JsonNode> it = json.get("genres").getElements();
    this.genres = new ArrayList<String>();
    while (it.hasNext()) {
      this.genres.add(it.next().getTextValue());
    }
  }

  /* Getters */
  public long getTrackId () { return trackId; }
  public String getName () { return name; }
  public String getDescription () { return description; }
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
