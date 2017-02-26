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
    Result[] results = itunes.search("serial", new Podcast(Podcast.Entity.podcast), 40);
    for(Result r : results) {
      System.out.println(r);
    }
  }



}
