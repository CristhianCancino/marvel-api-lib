package com.openpay.challenge.marvelapi;

import com.openpay.challenge.marvelapi.models.Characters;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class MarvelApiClientTest {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private MarvelApiServiceClient marvelApiServiceClient;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getCharacters_returnsListOfCharacters() {
        Characters character1 = new Characters();
        Characters character2 = new Characters();
        List<Characters> expectedCharacters = Arrays.asList(character1, character2);

        when(restTemplate.getForObject(anyString(), eq(List.class))).thenReturn(expectedCharacters);

        Characters actualCharacters = marvelApiServiceClient.getCharacters();

        assertEquals(expectedCharacters, actualCharacters);
        verify(restTemplate, times(1)).getForObject(anyString(), eq(List.class));
    }


    @Test
    void getCharacters_returnsEmptyListWhenNoCharacters() {
        when(restTemplate.getForObject(anyString(), eq(Characters.class))).thenReturn(new Characters());

        Characters actualCharacters = marvelApiServiceClient.getCharacters();

        assertTrue(actualCharacters.getData().getResults().isEmpty());
        verify(restTemplate, times(1)).getForObject(anyString(), eq(Characters.class));
    }


    @Test
    void getCharacterById_returnsNullWhenCharacterNotFound() {
        int characterId = 999;

        when(restTemplate.getForObject(anyString(), eq(Characters.class))).thenReturn(null);

        Characters actualCharacter = marvelApiServiceClient.getCharacterById(characterId);

        assertNull(actualCharacter);
        verify(restTemplate, times(1)).getForObject(anyString(), eq(Characters.class));
    }
}