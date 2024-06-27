package com.openpay.challenge.marvelapi.service;

import com.openpay.challenge.marvelapi.models.Characters;

public interface IMarvelApiService {
    Characters getCharacters();
    Characters getCharacterById(int characterId);
}