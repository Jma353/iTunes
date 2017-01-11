# iTunes Search API

A multithreaded driver for interacting with the [`iTunes Search API`](https://affiliate.itunes.apple.com/resources/documentation/itunes-store-web-service-search-api/) in Java.

## Usage

```java
iTunes itunes = iTunes.getInstance();
Result[] results = itunes.search ("Programming Throwdown",
                                  new Podcast(Podcast.Entity.podcast,
                                              Podcast.Attribute.titleTerm);
for (Result r : results) {
  if (r instanceof PodcastResult) {
    PodcastResult podcast = (PodcastResult) r;
    // Do things
  }
}

```

`NOTE`: When searching, one can search for various entities and by attributes associated with the media specified, so various classes exist to specify these options accordingly.  
