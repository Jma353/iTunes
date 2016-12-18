package media;

/**
 * All media request class
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

}
