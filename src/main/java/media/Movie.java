package media;

import org.apache.http.client.utils.URIBuilder;

/**
 * Movie media request class
 */
public class Movie extends Media <Movie.Entity, Movie.Attribute> {

  /* Type of movie entity */
  public enum Entity {
    movieArtist,
    movie
  }

  /* Type of movie attribute */
  public enum Attribute {
    actorTerm,
    genreIndex,
    artistTerm,
    shortFilmTerm,
    producerTerm,
    ratingTerm,
    directorTerm,
    releaseYearTerm,
    featureFilmTerm,
    movieArtistTerm,
    movieTerm,
    ratingIndex,
    descriptionTerm
  }

  /**
   * @see Media#uriBuilder(URIBuilder builder)
   */
  public URIBuilder uriBuilder (URIBuilder builder) {
    if (hasEntity()) { builder.addParameter("entity", getEntity().name()); }
    if (hasAttribute()) { builder.addParameter("attribute", getAttribute().name()); }
    return builder;
  }

}
