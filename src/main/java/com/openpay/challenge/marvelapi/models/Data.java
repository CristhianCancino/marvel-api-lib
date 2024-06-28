package com.openpay.challenge.marvelapi.models;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Represents the data in the response from the Marvel API when requesting characters.
 */
@Getter
@Setter
@ToString
public class Data {

  public String offset;
  public String limit;
  public String total;
  public String count;
  public List<Result> results;

}
