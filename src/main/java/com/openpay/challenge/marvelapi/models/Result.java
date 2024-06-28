
package com.openpay.challenge.marvelapi.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Represents the result in Marvel API.
 */
@Getter
@Setter
@ToString
public class Result {

  public String id;
  public String name;
  public String description;
  public String modified;
  @JsonProperty("resourceURI")
  public String resourceUri;
  public List<Url> urls;
  public Thumbnail thumbnail;
  public Comics comics;
  public Stories stories;
  public Events events;
  public Series series;

}
