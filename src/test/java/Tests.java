import com.github.Jma353.itunes.iTunes;
import com.github.Jma353.itunes.media.Podcast;
import com.github.Jma353.itunes.result.Result;
import org.junit.Test;
import java.util.Arrays;

/**
 * Overarching tests for iTunes driver
 */
public class Tests {

  @Test
  public void test1() {
    iTunes itunes = iTunes.getInstance();
    Result[] results = itunes.lookup(Arrays.asList(new String[] {"394775318", "206527655", "1076599250"}));
    for(Result r : results) {
      System.out.println(r);
    }
  }

  @Test
  public void test2() {
    iTunes itunes = iTunes.getInstance();
    Result[] results = itunes.search("serial", new Podcast(Podcast.Entity.podcast), 20);
    for(Result r : results) {
      System.out.println(r);
    }
  }

  @Test
  public void test3() { // Ensure CDATA extracted
    iTunes itunes = iTunes.getInstance();
    Result[] results = itunes.lookup(Arrays.asList(new String[] { "313417425" }));
    for(Result r : results) {
      System.out.println(r);
    }
  }

  @Test
  public void test4() { // Test incomplete series data
    iTunes itunes = iTunes.getInstance();
    Result[] results = itunes.lookup(Arrays.asList(new String[] { "1033688462" }));
    for(Result r : results) {
      System.out.println(r);
    }
  }

  @Test
  public void test5() {
    iTunes itunes = iTunes.getInstance();
    Result[] results = itunes.lookup(Arrays.asList(new String[] { "811377230" }));
    for (Result r : results) {
      System.out.println(r);
    }
  }

  @Test
  public void test6() {
    iTunes itunes = iTunes.getInstance();
    Result[] results = itunes.lookup(Arrays.asList(new String[] { "124921198" }));
    for (Result r : results) {
      System.out.println(r);
    }
  }

  @Test
  public void test7() {
    iTunes itunes = iTunes.getInstance();
    Result[] results = itunes.lookup(Arrays.asList(new String[] { "117488860" }));
    for (Result r : results) {
      System.out.println(r);
    }
  }

}
