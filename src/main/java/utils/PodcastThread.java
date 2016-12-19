package utils;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomAttr;
import com.gargoylesoftware.htmlunit.xml.XmlPage;
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
      XmlPage page = client.getPage(getRssFeed());
      List<DomAttr> links = (List<DomAttr>) page.getByXPath("//enclosure/@url");
      for (DomAttr e : links) {
        System.out.println(e);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /* Hand-testing */
  public static void main (String[] args) {
    PodcastThread lol = new PodcastThread("http://feeds.feedburner.com/ProgrammingThrowdown");
    lol.run();
  }



}
