package com.github.Jma353.itunes.media;

/**
 * MusicVideo itunes.media request class
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

  /** Constructor 1 **/
  public MusicVideo (MusicVideo.Entity e, MusicVideo.Attribute a) {
    super ("musicVideo", e, a);
  }

  /** Constructor 2 **/
  public MusicVideo (MusicVideo.Entity e) {
    super ("musicVideo", e);
  }

  /** Constructor 3 **/
  public MusicVideo (MusicVideo.Attribute a) { super ("musicVideo", null, a); }

  /** Constructor 4 **/
  public MusicVideo () {
    super ("musicVideo");
  }

}