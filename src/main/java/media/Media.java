package media;

import org.apache.http.client.utils.URIBuilder;

/**
 * Media parent (abstract)
 * E - Entity specific to the media type
 * A - Attribute specific to the media type
 */
public abstract class Media <E extends Enum, A extends Enum> {

  /* Fields */
  protected String name;
  protected E entity;
  protected A attribute;

  /**
   * Constructor specifying both entity & attribute
   * @param entity - E
   * @param attribute - A
   */
  public Media (String name, E entity, A attribute) {
    this.name = name;
    this.entity = entity;
    this.attribute = attribute;
  }

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
   * Name getter
   * @return - String
   */
  protected String getName () { return name; }

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
    builder.addParameter("media", getName());
    if (hasEntity()) { builder.addParameter("entity", getEntity().name()); }
    if (hasAttribute()) { builder.addParameter("attribute", getAttribute().name()); }
    return builder;
  }

}
