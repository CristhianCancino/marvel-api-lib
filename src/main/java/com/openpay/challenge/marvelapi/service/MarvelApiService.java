package com.openpay.challenge.marvelapi.service;

import com.openpay.challenge.marvelapi.MarvelApiServiceClient;
import com.openpay.challenge.marvelapi.models.Characters;
import com.openpay.challenge.marvelapi.service.IMarvelApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MarvelApiService implements IMarvelApiService {

    private final MarvelApiServiceClient marvelApiServiceClient;

    @Autowired
    public MarvelApiService(MarvelApiServiceClient marvelApiServiceClient) {
        this.marvelApiServiceClient = marvelApiServiceClient;
    }

    public Characters getCharacters() {
        return marvelApiServiceClient.getCharacters();
    }

    public Characters getCharacterById(int characterId) {
        return marvelApiServiceClient.getCharacterById(characterId);
    }
}
