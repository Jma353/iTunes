package com.github.Jma353.itunes.utils;

import com.github.Jma353.itunes.result.Result;
import org.codehaus.jackson.JsonNode;
import com.github.Jma353.itunes.result.ResultMarshaller;

/**
 * A thread utilized to create a itunes.result derived
 * from an iTunes Search API response
 */
public class ResultThread extends Thread {

  /* Fields */
  private Result[] results;
  private JsonNode[] jsons;
  private int i;
  private IntHolder filled;

  /** Thread with necessary references **/
  public ResultThread (Result[] results,
                       JsonNode[] jsons,
                       int i,
                       IntHolder filled) {
    super();
    this.results = results;
    this.jsons = jsons;
    this.i = i;
    this.filled = filled;
  }

  /**
   * Run and create results until done.
   * A thread fills spots in results according to its initial i
   * value.  For example, if its i value is 3, it fills positions
   * 3, 13, 23, etc. until out of the bounds of the results array.
   * This decision was made to reduce the amount of overhead
   * that must be performed to maintain threads, while still
   * affording concurrency.
   */
  public void run () {
    while (i < results.length) {
      results[i] = ResultMarshaller.marshall(jsons[i]);
      /* If we're done */
      synchronized (filled) {
        filled.increment();
        if (filled.getI() == results.length) {
          filled.notify();
        }
      }
      i += 10;
    }
  }

}
