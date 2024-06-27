
package com.openpay.challenge.marvelapi.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class Events {

    public String available;
    public String returned;
    public String collectionURI;
    public List<Item> items;

}
