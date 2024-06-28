package com.openpay.challenge.marvelapi.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonSerializable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Represents the URL in Marvel API.
 */
@Getter
@Setter
@ToString
public class Url {
  public String type;

  @JsonProperty("url")
  public String uniformResourceLocator;
}
