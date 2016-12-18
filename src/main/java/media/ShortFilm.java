package media;

/**
 * ShortFilm media request class
 */
public class ShortFilm extends Media <ShortFilm.Entity, ShortFilm.Attribute> {

  /* Type of shortFilm entity */
  public enum Entity {
    shortFilmArtist,
    shortFilm
  }

  /* Type of shortFilm attribute */
  public enum Attribute {
    genreIndex,
    artistTerm,
    shortFilmTerm,
    ratingIndex,
    descriptionTerm
  }

}