package com.openpay.challenge.marvelapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MarvelResponse {

    @JsonProperty("data")
    private MarvelData data;

    public MarvelData getData() {
        return data;
    }

    public void setData(MarvelData data) {
        this.data = data;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class MarvelData {

        @JsonProperty("results")
        private List<Characters> results;

        public List<Characters> getResults() {
            return results;
        }

        public void setResults(List<Characters> results) {
            this.results = results;
        }
    }
}