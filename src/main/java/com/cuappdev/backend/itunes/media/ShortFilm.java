package com.cuappdev.backend.itunes.media;

/**
 * ShortFilm itunes.media request class
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

  /** Constructor 1 **/
  public ShortFilm (ShortFilm.Entity e, ShortFilm.Attribute a) {
    super ("shortFilm", e, a);
  }

  /** Constructor 2 **/
  public ShortFilm (ShortFilm.Entity e) {
    super ("shortFilm", e);
  }

  /** Constructor 3 **/
  public ShortFilm (ShortFilm.Attribute a) { super ("shortFilm", null, a); }

  /** Constructor 4 **/
  public ShortFilm () {
    super ("shortFilm");
  }


}