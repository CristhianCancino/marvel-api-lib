package com.openpay.challenge.marvelapi;

import com.openpay.challenge.marvelapi.models.CharactersApiResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;



public class MarvelApiClientTest {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private MarvelApiClient marvelApiClient;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        ReflectionTestUtils.setField(marvelApiClient, "publicKey", "mockPublicKey");
        ReflectionTestUtils.setField(marvelApiClient, "privateKey", "mockPrivateKey");
    }

    @Test
    public void getCharactersReturnsValidResponse() {
        when(restTemplate.getForObject(anyString(), any())).thenReturn(new CharactersApiResponse());
        CharactersApiResponse response = marvelApiClient.getCharacters();
        assertNotNull(response);
    }

    @Test
    public void getCharacterByIdReturnsValidResponse() {
        when(restTemplate.getForObject(anyString(), any())).thenReturn(new CharactersApiResponse());
        CharactersApiResponse response = marvelApiClient.getCharacterById(100);
        assertNotNull(response);
    }

    @Test
    public void getCharactersThrowsExceptionWhenRestTemplateFails() {
        when(restTemplate.getForObject(anyString(), any())).thenThrow(RestClientException.class);
        assertThrows(RestClientException.class, () -> marvelApiClient.getCharacters());
    }

    @Test
    public void getCharactersReturnsNullWhenRestTemplateReturnsNull() {
        when(restTemplate.getForObject(anyString(), any())).thenReturn(null);
        CharactersApiResponse response = marvelApiClient.getCharacters();
        assertNull(response);
    }

    @Test
    public void getCharacterByIdThrowsExceptionWhenRestTemplateFails() {
        when(restTemplate.getForObject(anyString(), any())).thenThrow(RestClientException.class);
        assertThrows(RestClientException.class, () -> marvelApiClient.getCharacterById(100));
    }

    @Test
    public void getCharacterByIdReturnsNullWhenRestTemplateReturnsNull() {
        when(restTemplate.getForObject(anyString(), any())).thenReturn(null);
        CharactersApiResponse response = marvelApiClient.getCharacterById(100);
        assertNull(response);
    }
}