
package com.openpay.challenge.marvelapi.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CharactersApiResponse {

    public String code;
    public String status;
    public String copyright;
    public String attributionText;
    public String attributionHTML;
    public Data data;
    public String etag;

}
