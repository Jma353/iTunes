package com.cuappdev.backend.itunes.media;

/**
 * Software itunes.media request class
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

  /** Constructor 1 **/
  public Software (Software.Entity e, Software.Attribute a) {
    super ("software", e, a);
  }

  /** Constructor 2 **/
  public Software (Software.Entity e) {
    super ("software", e);
  }

  /** Constructor 3 **/
  public Software (Software.Attribute a) { super ("software", null, a); }

  /** Constructor 4 **/
  public Software () {
    super ("software");
  }


}