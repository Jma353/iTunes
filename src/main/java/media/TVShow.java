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

  /** Constructor 1 **/
  public TVShow (TVShow.Entity e, TVShow.Attribute a) {
    super ("tvShow", e, a);
  }

  /** Constructor 2 **/
  public TVShow (TVShow.Entity e) {
    super ("tvShow", e);
  }

  /** Constructor 3 **/
  public TVShow () {
    super ("tvShow");
  }


}