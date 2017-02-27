package com.github.Jma353.itunes.utils;

import com.gargoylesoftware.htmlunit.html.*;
import org.w3c.dom.CharacterData;
import java.util.ArrayList;
import java.util.List;

/**
 * Extra XPathUtils (several static functions)
 */
public class XPathUtils {

  /** Helper function to process a Dom Node **/
  private static String processDomNode(DomNamespaceNode node) {
    if (node == null) { // Avoids null exceptions
      return "";
    }
    DomNodeList<DomNode> children = node.getChildNodes();
    for (DomNode item : children) {
      if (item instanceof CharacterData) {
        CharacterData child = (CharacterData) item;
        String data = child.getData();
        if (data != null && data.trim().length() > 0) {
          return child.getData().trim()
            .replaceAll("(<!)*(\\[)*CDATA\\[*", "").replaceAll("(\\])+>*", "");
        }
      }
    }
    return node.getTextContent().trim();
  }

  /** Get String content of a DomElement **/
  public static String firstByName(DomElement element, String name) {
    DomElement result = (DomElement) element.getFirstByXPath("./" + name);
    return processDomNode(result);
  }


  /** Gets String contents of all DomElements satisfying the name credential **/
  public static String[] getAllByName(DomElement element, String name) {
    List<DomElement> elements = (ArrayList<DomElement>) element.getByXPath("./" + name);
    String[] results = new String[elements.size()];
    for (int i = 0; i < elements.size(); i++) {
      results[i] = processDomNode(elements.get(i));
    }
    return results;
  }


  /** Get String content of DomAttr **/
  public static String firstByAttr(DomElement element, String attr) {
    DomAttr result = (DomAttr) element.getFirstByXPath("./" + attr);
    return processDomNode(result);
  }

}
