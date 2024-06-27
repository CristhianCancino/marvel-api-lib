package com.openpay.challenge.marvelapi;

import com.openpay.challenge.marvelapi.models.Characters;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Value;
import com.openpay.challenge.marvelapi.util.HashUtil;


@Component
@RequiredArgsConstructor
public class MarvelApiServiceClient {

    private final RestTemplate restTemplate;

    @Value("${public.api.key}")
    private String publicKey;

    @Value("${private.api.key}")
    private String privateKey;

    private static final String BASE_URL = "https://gateway.marvel.com:443/v1/public/";


    public Characters getCharacters() {
        String hash = HashUtil.generateHash("1", privateKey, publicKey);
        String url = BASE_URL + "characters?ts=1" + "&apikey=" + publicKey + "&hash=" + hash;
        return restTemplate.getForObject(url, Characters.class);
    }

    public Characters getCharacterById(int characterId) {
        String hash = HashUtil.generateHash("1", privateKey, publicKey);
        String url = BASE_URL + "characters/" + characterId + "?ts=1" + "&apikey=" + publicKey + "&hash=" + hash;
        return restTemplate.getForObject(url, Characters.class);
    }
}