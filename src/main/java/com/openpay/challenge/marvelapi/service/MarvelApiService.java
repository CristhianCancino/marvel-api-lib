package com.openpay.challenge.marvelapi.service;

import com.openpay.challenge.marvelapi.models.CharactersApiResponse;

/**
 * Service to interact with the Marvel API.
 */
public interface MarvelApiService {
  CharactersApiResponse getCharacters();

  CharactersApiResponse getCharacterById(int characterId);
}