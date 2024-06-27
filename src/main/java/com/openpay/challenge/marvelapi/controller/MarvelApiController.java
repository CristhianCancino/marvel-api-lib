package com.openpay.challenge.marvelapi.controller;

import com.openpay.challenge.marvelapi.models.Characters;
import com.openpay.challenge.marvelapi.service.IMarvelApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/marvel")
public class MarvelApiController {

    private final IMarvelApiService marvelApiService;


    @Autowired
    public MarvelApiController(IMarvelApiService marvelApiService) {
        this.marvelApiService = marvelApiService;
    }

    @GetMapping("/characters")
    public ResponseEntity<Characters> getCharacters() {
        Characters characters = marvelApiService.getCharacters();
        return ResponseEntity.ok(characters);
    }

    @GetMapping("/characters/{id}")
    public ResponseEntity<Characters> getCharacterById(@PathVariable int id) {
        Characters character = marvelApiService.getCharacterById(id);
        if (character != null) {
            return ResponseEntity.ok(character);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}