package com.github.Jma353.itunes;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;

/**
 * Abstract class defining itunes.HTTP methods
 */
public class HTTP {

  private static String userAgentValue = "Mozilla/5.0 " +
    "(Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2";

  /**
   * Send a simple GET request
   * @param uri - URI
   * @throws IOException - Networking I/O issue
   */
  public static JsonNode get(URI uri) throws IOException {

    /* Client & request setup */
    HttpClient client = HttpClientBuilder.create().build();
    HttpGet request = new HttpGet(uri.toString());
    request.addHeader("User-Agent", userAgentValue);

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

  /**
   * Stream RSS feed
   * @param httpClient - CloseableHttpClient
   * @param dataSource - URL in String form
   * @return - BufferedReader
   * @throws IOException - Networking I/O issue
   */
  public static BufferedReader getResponseRSS(CloseableHttpClient httpClient,
                                              String dataSource) throws IOException {

    URL src = new URL(dataSource);
    URLConnection srcConn = src.openConnection();
    srcConn.setRequestProperty("User-Agent", userAgentValue);
    BufferedReader reader;
    BufferedReader in =
      new BufferedReader(new InputStreamReader(srcConn.getInputStream(), "UTF-8"));
    return in;
  }


}
