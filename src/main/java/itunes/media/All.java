package itunes.media;

/**
 * All itunes.media request class
 */
public class All extends Media <All.Entity, All.Attribute> {

  /* Type of all entity */
  public enum Entity {
    movie,
    album,
    allArtist,
    podcast,
    musicVideo,
    mix,
    audiobook,
    tvSeason,
    allTrack
  }

  /* Type of all attribute */
  public enum Attribute {
    actorTerm,
    languageTerm,
    allArtistTerm,
    tvEpisodeTerm,
    shortFilmTerm,
    directorTerm,
    releaseYearTerm,
    titleTerm,
    featureFilmTerm,
    ratingIndex,
    keywordsTerm,
    descriptionTerm,
    authorTerm,
    genreIndex,
    mixTerm,
    allTrackTerm,
    artistTerm,
    composerTerm,
    tvSeasonTerm,
    producerTerm,
    ratingTerm,
    songTerm,
    movieArtistTerm,
    showTerm,
    movieTerm,
    albumTerm
  }

  /** Constructor 1 **/
  public All (All.Entity e, All.Attribute a) {
    super ("all", e, a);
  }

  /** Constructor 2 **/
  public All (All.Entity e) {
    super ("all", e);
  }

  /** Constructor 3 **/
  public All (All.Attribute a) { super ("all", null, a); }

  /** Constructor 4 **/
  public All () {
    super ("all");
  }


}
