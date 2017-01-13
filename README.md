# iTunes Search API

A multithreaded driver for interacting with the [`iTunes Search API`](https://affiliate.itunes.apple.com/resources/documentation/itunes-store-web-service-search-api/) in Java.

## Installation

Add the [`JitPack`](https://jitpack.io) repository to your build file

```
<repositories>
  <repository>
      <id>jitpack.io</id>
      <url>https://jitpack.io</url>
  </repository>
</repositories>
```

Add the dependency

```
<dependency>
    <groupId>com.github.Jma353</groupId>
    <artifactId>iTunes</artifactId>
    <version>CURRENT-VERSION</version>
</dependency>
```

To see the current version, check [`here`](https://jitpack.io/#Jma353/iTunes)


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
