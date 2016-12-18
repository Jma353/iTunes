package media;

/**
 * AudioBook media request class
 */
public class AudioBook extends Media <AudioBook.Entity, AudioBook.Attribute> {

  /* Type of audiobook entity */
  public enum Entity {
    audiobookAuthor,
    audiobook
  }

  /* Type of audiobook attribute */
  public enum Attribute {
    titleTerm,
    authorTerm,
    genreIndex,
    ratingIndex
  }

  /** Constructor 1 **/
  public AudioBook (AudioBook.Entity e, AudioBook.Attribute a) {
    super ("audiobook", e, a);
  }

  /** Constructor 2 **/
  public AudioBook (AudioBook.Entity e) {
    super ("audiobook", e);
  }

  /** Constructor 3 **/
  public AudioBook () {
    super ("audiobook");
  }


}
