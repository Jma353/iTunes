package media;

/**
 * EBook media request class
 */
public class EBook extends Media <EBook.Entity, EBook.Attribute> {

  /* Type of ebook entity */
  public enum Entity {
    ebook
  }

  /* Type of ebook attribute (NONE) */
  public enum Attribute {
  }

  /** Constructor 1 **/
  public EBook (EBook.Entity e) {
    super ("ebook", e);
  }

  /** Constructor 2 **/
  public EBook () {
    super ("ebook");
  }


}
