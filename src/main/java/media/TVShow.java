package media;

/**
 * TVShow media request class
 */
public class TVShow extends Media <TVShow.Entity, TVShow.Attribute> {

  /* Type of tvShow entity */
  public enum Entity {
    tvEpisode,
    tvSeason
  }

  /* Type of tvShow attribute */
  public enum Attribute {
    genreIndex,
    tvEpisodeTerm,
    showTerm,
    tvSeasonTerm,
    ratingIndex,
    descriptionTerm
  }

}