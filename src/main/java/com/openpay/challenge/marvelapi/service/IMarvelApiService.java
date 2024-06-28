package com.openpay.challenge.marvelapi.service;

import com.openpay.challenge.marvelapi.models.CharactersApiResponse;

public interface IMarvelApiService {
    CharactersApiResponse getCharacters();
    CharactersApiResponse getCharacterById(int characterId);
}