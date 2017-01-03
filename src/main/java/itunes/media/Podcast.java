package itunes.media;

/**
 * Podcast itunes.media request class
 */
public class Podcast extends Media <Podcast.Entity, Podcast.Attribute> {

  /* Type of podcast entity */
  public enum Entity {
    podcastAuthor,
    podcast
  }

  /* Type of podcast attribute */
  public enum Attribute {
    titleTerm,
    languageTerm,
    authorTerm,
    genreIndex,
    artistTerm,
    ratingIndex,
    keywordsTerm,
    descriptionTerm
  }

  /** Constructor 1 **/
  public Podcast (Podcast.Entity e, Podcast.Attribute a) {
    super ("podcast", e, a);
  }

  /** Constructor 2 **/
  public Podcast (Podcast.Entity e) {
    super ("podcast", e);
  }

  /** Constructor 3 **/
  public Podcast (Podcast.Attribute a) { super ("podcast", null, a); }

  /** Constructor 4 **/
  public Podcast () {
    super ("podcast");
  }

}
