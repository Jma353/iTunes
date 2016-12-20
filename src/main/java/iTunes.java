import media.Media;
import media.Music;
import media.MusicVideo;
import media.Podcast;
import org.apache.http.client.utils.URIBuilder;
import org.codehaus.jackson.JsonNode;
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

  /**
   * Search by term
   * @param term - String
   */
  public void search (String term) {
    try {
      URIBuilder uriBuilder = searchURIBuilderBase();
      uriBuilder.addParameter("term", URLEncoder.encode(term, "UTF-8"));
      JsonNode result = get(uriBuilder.build());
      System.out.println(result);
      ResultMarshaller.marshallAll(result);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * Search by term & country ISO code
   * @param term - String
   * @param iso - String
   */
  public void search (String term, String iso) {
    try {
      URIBuilder uriBuilder = searchURIBuilderBase();
      uriBuilder.addParameter("term", URLEncoder.encode(term, "UTF-8"));
      uriBuilder.addParameter("country", soundISO(iso));
      JsonNode result = get(uriBuilder.build());
      System.out.println(result);
      ResultMarshaller.marshallAll(result);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * Search by term & media
   * @param term - String
   * @param m - Media
   */
  public void search (String term, Media m) {
    try {
      URIBuilder uriBuilder = searchURIBuilderBase();
      uriBuilder.addParameter("term", URLEncoder.encode(term, "UTF-8"));
      uriBuilder = m.uriBuilder(uriBuilder);
      JsonNode result = get(uriBuilder.build());
      System.out.println(result);
      ResultMarshaller.marshallAll(result);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /* Hand-tests */
  public static void main (String[] args) {
    iTunes.getInstance().search("hello", new MusicVideo());
  }

}


