package com.openpay.challenge.marvelapi.service.impl;

import com.openpay.challenge.marvelapi.MarvelApiClient;
import com.openpay.challenge.marvelapi.models.CharactersApiResponse;
import com.openpay.challenge.marvelapi.service.IMarvelApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MarvelApiServiceImpl implements IMarvelApiService {

    private final MarvelApiClient marvelApiServiceClient;

    @Autowired
    public MarvelApiServiceImpl(MarvelApiClient marvelApiServiceClient) {
        this.marvelApiServiceClient = marvelApiServiceClient;
    }

    public CharactersApiResponse getCharacters() {
        return marvelApiServiceClient.getCharacters();
    }

    public CharactersApiResponse getCharacterById(int characterId) {
        return marvelApiServiceClient.getCharacterById(characterId);
    }
}
