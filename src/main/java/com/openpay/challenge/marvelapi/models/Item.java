package com.openpay.challenge.marvelapi.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Represents items in Marvel API.
 */
@Getter
@Setter
@ToString
public class Item {
  @JsonProperty("resourceURI")
  public String resourceUri;
  public String name;
  public String type;

}
