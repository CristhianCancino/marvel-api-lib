
package com.openpay.challenge.marvelapi.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class Result {

    public String id;
    public String name;
    public String description;
    public String modified;
    public String resourceURI;
    public List<Url> urls;
    public Thumbnail thumbnail;
    public Comics comics;
    public Stories stories;
    public Events events;
    public Series series;

}
