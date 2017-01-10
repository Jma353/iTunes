package com.cuappdev.backend.itunes.utils;

import com.cuappdev.backend.itunes.result.Result;
import org.codehaus.jackson.JsonNode;
import com.cuappdev.backend.itunes.result.Result;
import com.cuappdev.backend.itunes.result.ResultMarshaller;

/**
 * A thread utilized to create a itunes.result derived
 * from an itunes.iTunes Search API response
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

  /** Run, create itunes.result & increment filled **/
  public void run () {
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
