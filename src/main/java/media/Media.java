package media;

import org.apache.http.client.utils.URIBuilder;

/**
 * Media parent (abstract)
 * E - Entity specific to the media type
 * A - Attribute specific to the media type
 */
public abstract class Media <E extends Enum, A extends Enum> {

  /* Fields */
  protected E entity;
  protected A attribute;

  /**
   * Constructor specifying both entity & attribute
   * @param entity - E
   * @param attribute - A
   */
  public Media (E entity, A attribute) {
    this.entity = entity;
    this.attribute = attribute;
  }

  /**
   * Blank constructor
   */
  public Media () {
    this (null, null);
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
   * Entity getter
   * @return - E
   */
  protected E getEntity() {
    return entity;
  }

  /**
   * Attribute getter
   * @return - A
   */
  protected A getAttribute() {
    return attribute;
  }

  /**
   * Returns a URIBuilder with added parameters corresponding to
   * the meta-data stored in this instance of Media
   * @return - URIBuilder
   */
  public URIBuilder uriBuilder (URIBuilder builder) {
    if (hasEntity()) { builder.addParameter("entity", getEntity().name()); }
    if (hasAttribute()) { builder.addParameter("attribute", getAttribute().name()); }
    return builder;
  }

}
