package utils;

import com.gargoylesoftware.htmlunit.html.DomAttr;
import com.gargoylesoftware.htmlunit.html.DomElement;

/**
 * Extra XPathUtils (several static functions)
 */
public class XPathUtils {

  /** Get String content of a DomElement **/
  public static String firstByName (DomElement element, String name) {
    DomElement result = (DomElement) element.getFirstByXPath("./" + name);
    if (result == null) {
      return "";
    } else {
      return result.getTextContent();
    }
  }

  /** Get String content of DomAttr **/
  public static String firstByAttr (DomElement element, String attr) {
    DomAttr result = (DomAttr) element.getFirstByXPath("./" + attr);
    if (result == null) {
      return "";
    } else {
      return result.getTextContent();
    }
  }

}
