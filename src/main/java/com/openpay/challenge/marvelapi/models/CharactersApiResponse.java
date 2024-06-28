
package com.openpay.challenge.marvelapi.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Represents the response from the Marvel API when requesting characters.
 */
@Getter
@Setter
@ToString
public class CharactersApiResponse {

  public String code;
  public String status;
  public String copyright;
  public String attributionText;
  @JsonProperty("attributionHTML")
  public String attributionHtml;
  public Data data;
  public String etag;

}
