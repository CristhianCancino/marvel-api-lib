package com.openpay.challenge.marvelapi;

import com.openpay.challenge.marvelapi.models.CharactersApiResponse;
import com.openpay.challenge.marvelapi.service.impl.MarvelApiServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestClientException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

public class MarvilApiServiceTest {

    @Mock
    private MarvelApiClient marvelApiClient;

    @InjectMocks
    private MarvelApiServiceImpl marvelApiService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void getCharactersReturnsValidResponse() {
        when(marvelApiClient.getCharacters()).thenReturn(new CharactersApiResponse());
        CharactersApiResponse response = marvelApiService.getCharacters();
        assertNotNull(response);
    }

    @Test
    public void getCharacterByIdReturnsValidResponse() {
        when(marvelApiClient.getCharacterById(anyInt())).thenReturn(new CharactersApiResponse());
        CharactersApiResponse response = marvelApiService.getCharacterById(100);
        assertNotNull(response);
    }


    @Test
    public void getCharactersThrowsExceptionWhenApiClientFails() {
        when(marvelApiClient.getCharacters()).thenThrow(RestClientException.class);
        assertThrows(RestClientException.class, () -> marvelApiService.getCharacters());
    }

    @Test
    public void getCharactersReturnsNullWhenApiClientReturnsNull() {
        when(marvelApiClient.getCharacters()).thenReturn(null);
        CharactersApiResponse response = marvelApiService.getCharacters();
        assertNull(response);
    }

    @Test
    public void getCharacterByIdThrowsExceptionWhenApiClientFails() {
        when(marvelApiClient.getCharacterById(anyInt())).thenThrow(RestClientException.class);
        assertThrows(RestClientException.class, () -> marvelApiService.getCharacterById(100));
    }

    @Test
    public void getCharacterByIdReturnsNullWhenApiClientReturnsNull() {
        when(marvelApiClient.getCharacterById(anyInt())).thenReturn(null);
        CharactersApiResponse response = marvelApiService.getCharacterById(100);
        assertNull(response);
    }
}