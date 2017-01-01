import media.Media;
import media.MusicVideo;
import media.Podcast;
import org.apache.http.client.utils.URIBuilder;
import org.codehaus.jackson.JsonNode;
import result.Result;
import result.ResultMarshaller;

import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;

import lombok.Getter;

/**
 * Main class to handle making API Requests.
 * In the form of a singleton.
 */
public class iTunes extends HTTP {

  /* Exception specific to iTunes driver */
  public class iTunesException extends Exception {
    public iTunesException (String s) {
      super (s);
    }
  }

  /* Singleton logic */
  private static iTunes instance = null;
  public static iTunes getInstance () {
    if (instance == null) {
      instance = new iTunes ();
    }
    return instance;
  }

  /* Fields */
  @Getter private String baseURL;
  @Getter private HashSet<String> countryISOs;

  /**
   * Protected constructor (only used in singleton logic)
   */
  protected iTunes () {
    this.baseURL = "https://itunes.apple.com";
    this.countryISOs =
      new HashSet<String> (Arrays.asList(Locale.getISOCountries()));
  }

  /**
   * Search URI builder
   * @return - URIBuilder
   * @throws URISyntaxException
   */
  public URIBuilder searchURIBuilderBase () throws URISyntaxException {
    return new URIBuilder(getBaseURL() + "/search");
  }

  /**
   * Lookup URI builder
   * @return - URIBuilder
   * @throws URISyntaxException
   */
  public URIBuilder lookupURIBuilderBase () throws URISyntaxException {
    return new URIBuilder(getBaseURL() + "/lookup");
  }

  /**
   * Add limit info to URI builder
   * @param builder - URIBuilder
   * @return - URIBuilder
   */
  public URIBuilder addLimit (URIBuilder builder, Integer limit) {
    builder.addParameter("limit", limit.toString());
    return builder;
  }

  /**
   * Returns ISO country code if it's correct, else throws an iTunesException
   * @param iso - String
   * @return - ISO String
   * @throws iTunesException - Custom exception
   */
  public String soundISO (String iso) throws iTunesException {
    if (getCountryISOs().contains(iso)) {
      return iso;
    } else {
      throw new iTunesException("ISO not found");
    }
  }

  /** The God search function **/
  public Result[] search (String term, String iso, Media m, Integer limit) {
    try {
      URIBuilder uriBuilder = searchURIBuilderBase();
      uriBuilder.addParameter("term", URLEncoder.encode(term, "UTF-8"));
      if (iso != null) { uriBuilder.addParameter("country", soundISO(iso)); }
      if (m != null) { uriBuilder = m.uriBuilder(uriBuilder); }
      if (limit != null) { uriBuilder = addLimit(uriBuilder, limit); }
      JsonNode result = get(uriBuilder.build());
      return ResultMarshaller.marshallAll(result);
    } catch (Exception e) {
      e.printStackTrace();
      return new Result[0];
    }
  }

  /** Search by term **/
  public Result[] search (String term) {
    return search (term, null, null, null);
  }

  /** Search by term & country ISO **/
  public Result[] search (String term, String iso) {
    return search (term, iso, null, null);
  }

  /** Search by term, country ISO, & media type **/
  public Result[] search (String term, String iso, Media m) {
    return search (term, iso, m, null);
  }

  /** Search by term & media type **/
  public Result[] search (String term, Media m) {
    return search (term, null, m, null);
  }

  /** Search by term, with a specified limit **/
  public Result[] search (String term, Integer limit) {
    return search (term, null, null, limit);
  }

  /** Search by term & media, with a specified limit **/
  public Result[] search (String term, Media m, Integer limit) {
    return search (term, null, m, limit);
  }

  public static void main (String[] args) {
  }


}


