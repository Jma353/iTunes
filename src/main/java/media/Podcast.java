package media;

import org.apache.http.client.utils.URIBuilder;

/**
 * Podcast media request class
 */
public class Podcast extends Media <Podcast.Entity, Podcast.Attribute> {

  /* Type of podcast entity */
  public enum Entity {
    movieArtist,
    movie
  }

  /* Type of podcast attribute */
  public enum Attribute {
    titleTerm,
    languageTerm,
    authorTerm,
    genreIndex,
    artistTerm,
    ratingIndex,
    keywordsTerm,
    descriptionTerm
  }

  /**
   * @see Media#uriBuilder(URIBuilder builder)
   */
  public URIBuilder uriBuilder (URIBuilder builder) {
    // TODO -  Add attributes
    return builder;
  }

}
