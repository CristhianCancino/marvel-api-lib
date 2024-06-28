package com.openpay.challenge.marvelapi.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Represents comics in Marvel API.
 */
@Getter
@Setter
@ToString
public class Comics {

  public String available;
  public String returned;
  @JsonProperty("collectionURI")
  public String collectionUri;
  public List<Item> items;

}
