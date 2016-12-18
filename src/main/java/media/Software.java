package media;

/**
 * Software media request class
 */
public class Software extends Media <Software.Entity, Software.Attribute> {

  /* Type of software entity */
  public enum Entity {
    software,
    iPadSoftware,
    macSoftware
  }

  /* Type of software attribute */
  public enum Attribute {
    softwareDeveloper
  }

}