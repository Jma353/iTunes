package media;

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

}
