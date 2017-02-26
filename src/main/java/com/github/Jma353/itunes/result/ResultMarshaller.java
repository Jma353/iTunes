package com.github.Jma353.itunes.result;

import com.github.Jma353.itunes.utils.ResultThread;
import org.codehaus.jackson.JsonNode;
import com.github.Jma353.itunes.utils.IntHolder;

import java.util.Iterator;

/**
 * Class utilized to instantiate results based on
 * the search / lookup response from the itunes.iTunes
 * API
 */
public class ResultMarshaller {

  /**
   * Returns a single itunes.result, given a itunes.result JSON
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
        result = new PodcastResult (resultJSON);
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
        throw new IllegalArgumentException("Invalid itunes.result JSON");
    }
    return result;
  }

  /**
   * Returns a list of results, given the JSON response from itunes.iTunes
   * @param responseJSON - JsonNode
   * @return - Result[]
   */
  public static Result[] marshallAll (JsonNode responseJSON) throws InterruptedException {

    /* Setup for dispatching threads */
    int size = responseJSON.get("resultCount").getIntValue();
    Result[] results = new Result[size];
    Iterator<JsonNode> it = responseJSON.get("results").getElements();
    JsonNode[] jsons = new JsonNode[size];
    IntHolder filled = new IntHolder(0);

    /* Get elements */
    int i = 0;
    while (it.hasNext()) {
      jsons[i] = it.next();
      i++;
    }

    /* Dispatch 10 threads */
    for (i = 0; i < 10; i++) {
      new ResultThread(results, jsons, i, filled).start();
    }

    /* Wait on the filling of this data-structure + return */
    synchronized (filled) {
      while (filled.getI() < size) {
        filled.wait();
      }
      return results;
    }
  }

}
