import org.apache.http.client.utils.URIBuilder;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;

/**
 * Main class to handle making API Requests.
 * In the form of a singleton.
 */
public class iTunes extends HTTP {

  /* Exception specific to iTunes driver */
  public class iTunesException extends Exception {}

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
   * Search by term
   * @param term - String
   */
  public void search (String term) {
    try {
      URIBuilder uriBuilder = searchURIBuilderBase();
      uriBuilder.addParameter("term", term);
      get(uriBuilder.build());
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * Search by term & country ISO code
   * @param term - String
   * @param iso - String
   * @throws iTunesException
   */
  public void search (String term,
                      String iso) throws iTunesException {
    // TODO
  }

  /* Hand-tests */
  public static void main (String[] args) {
    iTunes.getInstance().search("lol");
  }

}


