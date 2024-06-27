package com.openpay.challenge.marvelapi;

import com.openpay.challenge.marvelapi.models.Characters;
import com.openpay.challenge.marvelapi.service.MarvelApiService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class MarvelApiServiceTest {

    @Mock
    private MarvelApiServiceClient marvelApiServiceClient;

    @InjectMocks
    private MarvelApiService marvelApiService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

//    @Test
//    void getCharacters_returnsListOfCharacters() {
//        Characters character1 = new Characters();
//        Characters character2 = new Characters();
//        Characters expectedCharacters = Arrays.asList(character1, character2);
//
//        when(marvelApiServiceClient.getCharacters()).thenReturn(expectedCharacters);
//
//        Characters actualCharacters = marvelApiService.getCharacters();
//
//        assertEquals(expectedCharacters, actualCharacters);
//        verify(marvelApiServiceClient, times(1)).getCharacters();
//    }

    @Test
    void getCharacterById_returnsCharacter() {
        int characterId = 1;
        Characters expectedCharacter = new Characters();

        when(marvelApiServiceClient.getCharacterById(characterId)).thenReturn(expectedCharacter);

        Characters actualCharacter = marvelApiService.getCharacterById(characterId);

        assertEquals(expectedCharacter, actualCharacter);
        verify(marvelApiServiceClient, times(1)).getCharacterById(characterId);
    }
}