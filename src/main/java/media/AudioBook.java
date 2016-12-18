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

}
