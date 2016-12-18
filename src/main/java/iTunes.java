import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;

/**
 * Main class to handle making API Requests.
 * In the form of a singleton.
 */
public class iTunes {

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
    /* Base URL */
    this.baseURL = "https://itunes.apple.com/";
    /* Set of valid country ISO codes */
    this.countryISOs =
      new HashSet<String> (Arrays.asList(Locale.getISOCountries()));
  }

  /* Hand-tests */
  public static void main (String[] args) {
    // TODO
  }



}
