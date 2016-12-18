package media;

import org.apache.http.client.utils.URIBuilder;

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

  /**
   * @see Media#uriBuilder(URIBuilder builder)
   */
  public URIBuilder uriBuilder (URIBuilder builder) {
    // TODO - Add attributes
    return builder;
  }


}
