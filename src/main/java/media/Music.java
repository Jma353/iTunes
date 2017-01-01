package media;

/**
 * Music media request class
 */
public class Music extends Media <Music.Entity, Music.Attribute> {

  /* Type of music entity */
  public enum Entity {
    musicArtist,
    musicTrack,
    album,
    musicVideo,
    mix,
    song
  }

  /* Type of music attribute */
  public enum Attribute {
    mixTerm,
    genreIndex,
    artistTerm,
    composerTerm,
    albumTerm,
    ratingIndex,
    songTerm
  }

  /** Constructor 1 **/
  public Music (Music.Entity e, Music.Attribute a) {
    super ("music", e, a);
  }

  /** Constructor 2 **/
  public Music (Music.Entity e) {
    super ("music", e);
  }

  /** Constructor 3 **/
  public Music (Music.Attribute a) { super ("music", null, a); }

  /** Constructor 4 **/
  public Music () {
    super ("music");
  }


}
