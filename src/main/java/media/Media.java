package media;

import org.apache.http.client.utils.URIBuilder;

/**
 * Media parent (abstract)
 */
public abstract class Media {

  /**
   * Returns a URIBuilder with added parameters corresponding to
   * the meta-data stored in this instance of Media
   * @return - URIBuilder
   */
  public abstract URIBuilder uriBuilder (URIBuilder builder);


}
