package utils;

import org.codehaus.jackson.JsonNode;
import result.Result;
import result.ResultMarshaller;

/**
 * A thread utilized to create a result derived
 * from an iTunes Search API response
 */
public class ResultThread extends Thread {

  /* Fields */
  private Result[] results;
  private JsonNode json;
  private int i;
  private IntHolder filled;
  private int size;

  /** Thread with necessary references **/
  public ResultThread (Result[] results, JsonNode json, int i, IntHolder filled, int size) {
    super ();
    this.results = results;
    this.json = json;
    this.i = i;
    this.filled = filled;
    this.size = size;
  }

  /** Run, create result & increment filled **/
  public void run () {
    System.out.println("Starting...");
    results[i] = ResultMarshaller.marshall(json);
    System.out.println(results[i]);
    /* If we're done */
    synchronized (results) {
      filled.increment();
      if (filled.getI() == size) {
        results.notify();
      }
    }
  }

}
