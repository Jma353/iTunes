package com.github.Jma353.itunes.media;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.http.client.utils.URIBuilder;

/**
 * Media parent (abstract)
 * E - Entity specific to the itunes.media type
 * A - Attribute specific to the itunes.media type
 */
@AllArgsConstructor
public abstract class Media <E extends Enum, A extends Enum> {

  /* Fields */
  @Getter protected String name;
  @Getter protected E entity;
  @Getter protected A attribute;

  /**
   * Constructor specifying only entity
   * @param entity - E
   */
  public Media (String name, E entity) {
    this (name, entity, null);
  }

  /**
   * Blank constructor
   */
  public Media (String name) {
    this (name, null, null);
  }

  /**
   * Checks to see if this Media instance specifies an entity
   * @return - boolean
   */
  protected boolean hasEntity () {
    return this.entity != null;
  }

  /**
   * Checks to see if this Media instance specifies an attribute
   * @return - boolean
   */
  protected boolean hasAttribute () {
    return this.attribute != null;
  }

  /**
   * Returns a URIBuilder with added parameters corresponding to
   * the meta-data stored in this instance of Media
   * @return - URIBuilder
   */
  public URIBuilder uriBuilder (URIBuilder builder) {
    builder.addParameter("itunes/media", getName());
    if (hasEntity()) { builder.addParameter("entity", getEntity().name()); }
    if (hasAttribute()) { builder.addParameter("attribute", getAttribute().name()); }
    return builder;
  }

}
