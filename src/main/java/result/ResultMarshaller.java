package result;

import org.codehaus.jackson.JsonNode;
import java.util.Iterator;

/**
 * Class utilized to instantiate results based on
 * the search / lookup response from the iTunes
 * API
 */
public class ResultMarshaller {

  /**
   * Returns a single result, given a result JSON
   * @param resultJSON - JsonNode
   * @return - Result
   */
  public static Result marshall (JsonNode resultJSON) {
    Result result;
    String switchString = resultJSON.get("kind") != null ?
      resultJSON.get("kind").getTextValue() :
      resultJSON.get("wrapperType").getTextValue();
    switch (switchString) {
      case "feature-movie":
        result = new MovieResult (resultJSON);
        break;
      case "podcast":
        result = PodcastResult.fromJson (resultJSON);
        break;
      case "song":
        result = new MusicResult (resultJSON);
        break;
      case "music-video":
        result = new MusicVideoResult (resultJSON);
        break;
      case "audiobook":
        result = new AudioBookResult (resultJSON);
        break;
      case "tv-episode":
        result = new TVShowResult (resultJSON);
        break;
      case "software":
        result = new SoftwareResult (resultJSON);
        break;
      case "ebook":
        result = new EBookResult (resultJSON);
        break;
      default:
        throw new IllegalArgumentException("Invalid result JSON");
    }
    return result;
  }

  /**
   * Returns a list of results, given the JSON response from iTunes
   * @param responseJSON - JsonNode
   * @return - Result[]
   */
  public static Result[] marshallAll (JsonNode responseJSON) {
    Result[] results = new Result[responseJSON.get("resultCount").getIntValue()];
    Iterator<JsonNode> it = responseJSON.get("results").getElements();
    int i = 0;
    while (it.hasNext()) {
      results[i] = marshall(it.next());
      i++;
    }
    return results;
  }

}
