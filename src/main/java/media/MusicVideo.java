package media;

/**
 * MusicVideo media request class
 */
public class MusicVideo extends Media <MusicVideo.Entity, MusicVideo.Attribute> {

  /* Type of musicVideo entity */
  public enum Entity {
    musicArtist,
    musicVideo
  }

  /* Type of musicVideo attribute */
  public enum Attribute {
    genreIndex,
    artistTerm,
    albumTerm,
    ratingIndex,
    songTerm
  }

}