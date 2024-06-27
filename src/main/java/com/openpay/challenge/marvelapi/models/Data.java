
package com.openpay.challenge.marvelapi.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

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
