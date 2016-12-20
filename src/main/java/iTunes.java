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
  private String baseURL;
  private HashSet<String> countryISOs;

  /**
   * Protected constructor (only used in singleton logic)
   */
  protected iTunes () {
    this.baseURL = "https://itunes.apple.com";
    this.countryISOs =
      new HashSet<String> (Arrays.asList(Locale.getISOCountries()));
  }

  /**
   * Base URL getter
   * @return - String
   */
  private String getBaseURL() {
    return baseURL;
  }

  /**
   * Country ISO set getter
   * @return - HashSet of String
   */
  private HashSet<String> getCountryISOs() {
    return countryISOs;
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
   * @throws iTunesException
   */
  public String soundISO (String iso) throws iTunesException {
    if (getCountryISOs().contains(iso)) {
      return iso;
    } else {
      throw new iTunesException("ISO not found");
    }
  }

  /** Search by term **/
  public Result[] search (String term) {
    try {
      URIBuilder uriBuilder = searchURIBuilderBase();
      uriBuilder.addParameter("term", URLEncoder.encode(term, "UTF-8"));
      JsonNode result = get(uriBuilder.build());
      return ResultMarshaller.marshallAll(result);
    } catch (Exception e) {
      e.printStackTrace();
      return new Result[0];
    }
  }

  /** Search by term & country ISO **/
  public Result[] search (String term, String iso) {
    try {
      URIBuilder uriBuilder = searchURIBuilderBase();
      uriBuilder.addParameter("term", URLEncoder.encode(term, "UTF-8"));
      uriBuilder.addParameter("country", soundISO(iso));
      JsonNode result = get(uriBuilder.build());
      return ResultMarshaller.marshallAll(result);
    } catch (Exception e) {
      e.printStackTrace();
      return new Result[0];
    }
  }

  /** Search by term & media type (w/entity & attribute as optional values too) **/
  public Result[] search (String term, Media m) {
    try {
      URIBuilder uriBuilder = searchURIBuilderBase();
      uriBuilder.addParameter("term", URLEncoder.encode(term, "UTF-8"));
      uriBuilder = m.uriBuilder(uriBuilder);
      JsonNode result = get(uriBuilder.build());
      return ResultMarshaller.marshallAll(result);
    } catch (Exception e) {
      e.printStackTrace();
      return new Result[0];
    }
  }

  /** Search by term & media type (w/entity & attribute as optional values too) **/
  public Result[] search (String term, Media m, Integer limit) {
    try {
      URIBuilder uriBuilder = searchURIBuilderBase();
      uriBuilder.addParameter("term", URLEncoder.encode(term, "UTF-8"));
      uriBuilder = m.uriBuilder(uriBuilder);
      uriBuilder = addLimit(uriBuilder, limit);
      JsonNode result = get(uriBuilder.build());
      return ResultMarshaller.marshallAll(result);
    } catch (Exception e) {
      e.printStackTrace();
      return new Result[0];
    }
  }

  /* Hand-tests */
  public static void main (String[] args) {
    Result[] results = iTunes.getInstance().search("hello", new Podcast(), 25);
  }

}


