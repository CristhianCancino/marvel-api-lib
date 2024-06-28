package com.openpay.challenge.marvelapi;

import com.openpay.challenge.marvelapi.models.CharactersApiResponse;
import com.openpay.challenge.marvelapi.util.HashUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * Client to interact with the Marvel API.
 */
@Component
@RequiredArgsConstructor
public class MarvelApiClient {

  private final RestTemplate restTemplate;

  @Value("${public.api.key}")
  private String publicKey;

  @Value("${private.api.key}")
  private String privateKey;

  private static final String BASE_URL = "https://gateway.marvel.com:443/v1/public/";

  /**
   * Get all characters from the Marvel API.
   *
   * @return CharactersApiResponse
   */
  public CharactersApiResponse getCharacters() {
    String hash = HashUtil.generateHash("1", privateKey, publicKey);
    String url = BASE_URL + "characters?ts=1" + "&apikey=" + publicKey + "&hash=" + hash;
    return restTemplate.getForObject(url, CharactersApiResponse.class);
  }


  /**
   * Get a character by id from the Marvel API.
   *
   * @param characterId The character id.
   * @return CharactersApiResponse
   */
  public CharactersApiResponse getCharacterById(int characterId) {
    String hash = HashUtil.generateHash("1", privateKey, publicKey);
    String url = BASE_URL + "characters/" + characterId + "?ts=1" + "&apikey=" + publicKey
            + "&hash=" + hash;
    return restTemplate.getForObject(url, CharactersApiResponse.class);
  }
}