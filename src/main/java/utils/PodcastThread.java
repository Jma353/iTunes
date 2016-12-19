package utils;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomAttr;
import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.xml.XmlPage;
import result.PodcastResult;

import java.util.List;

/**
 * This class involves parsing the RSS feed of a given podcast
 * to extract useful information about the podcast (series) & all
 * its available episodes
 */
public class PodcastThread extends Thread {

  /* Fields */
  private String rssFeed;

  /**
   * Constructor
   * @param rssFeed - String (URL pointing to XML)
   */
  public PodcastThread (String rssFeed) {
    super ();
    this.rssFeed = rssFeed;
  }

  /**
   * RSS Feed getter
   * @return - String (URL)
   */
  private String getRssFeed () {
    return this.rssFeed;
  }

  /**
   * Fetch RSS feed data
   */
  public void run () {
    WebClient client = new WebClient();
    client.getOptions().setCssEnabled(false);
    client.getOptions().setJavaScriptEnabled(false);
    try {

      /* Get the page */
      XmlPage page = client.getPage(getRssFeed());

      /* Get the links (to the podcast episodes) */
      List<DomAttr> links = (List<DomAttr>) page.getByXPath("//enclosure/@url");
      for (DomAttr e : links) {
        System.out.println(e);
      }

      /* Print series info */
      DomElement channel = (DomElement) page.getFirstByXPath("//channel");
      PodcastResult result = new PodcastResult(channel);
      System.out.println(result);

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /* Hand-testing */
  public static void main (String[] args) {
    PodcastThread lol = new PodcastThread("https://www.npr.org/rss/podcast.php?id=381444908");
    lol.run();
  }



}
