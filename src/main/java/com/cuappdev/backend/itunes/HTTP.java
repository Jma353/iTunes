package com.cuappdev.backend.itunes;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;

/**
 * Abstract class defining itunes.HTTP methods
 */
public abstract class HTTP {

  /**
   * Send a simple GET request
   * @param uri - URI
   */
  protected JsonNode get (URI uri) throws IOException {

    /* Client & request setup */
    HttpClient client = HttpClientBuilder.create().build();
    HttpGet request = new HttpGet(uri.toString());

    /* Make the request */
    HttpResponse response = client.execute(request);

    /* Stream */
    BufferedReader rd = new BufferedReader(
      new InputStreamReader(response.getEntity().getContent()));

    /* Build itunes.result string */
    StringBuffer result = new StringBuffer();
    String line;
    while ((line = rd.readLine()) != null) {
      result.append(line);
    }

    /* Generate JSON response */
    ObjectMapper mapper = new ObjectMapper();
    return mapper.readTree(result.toString());
  }

}
