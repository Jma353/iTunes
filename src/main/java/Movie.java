/**
 * Movie media request meta-data class
 */
public class Movie {

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

  /* Fields */
  private Entity entity;
  private Attribute attribute;

  /**
   * Constructor specifying both entity & attribute
   * @param entity - Entity
   * @param attribute - Attribute
   */
  public Movie (Entity entity, Attribute attribute) {
    this.entity = entity;
    this.attribute = attribute;
  }

  /**
   * Constructor specifying entity
   * @param entity - Entity
   */
  public Movie (Entity entity) {
    this (entity, null);
  }

  /**
   * Constructor specifying attribute
   * @param attribute - Attribute
   */
  public Movie (Attribute attribute) {
    this (null, attribute);
  }

  /**
   * Blank constructor
   */
  public Movie () {
    this (null, null);
  }

  /**
   * Checks to see if this Movie instance specifies an entity
   * @return - boolean
   */
  public boolean hasEntity () {
    return this.entity != null;
  }

  /**
   * Checks to see if this Movie instance specifies an attribute
   * @return - boolean
   */
  public boolean hasAttribute () {
    return this.attribute != null;
  }


}
