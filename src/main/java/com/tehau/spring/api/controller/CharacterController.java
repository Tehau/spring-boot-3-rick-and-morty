package com.tehau.spring.api.controller;

import com.tehau.spring.api.exception.ResourceNotFoundException;
import com.tehau.spring.api.model.CharacterRM;
import com.tehau.spring.api.model.Episode;
import com.tehau.spring.api.service.CharacterService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "Character", description = "Character management APIs")
@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api/characters")
public class CharacterController {

    private final CharacterService characterService;

    public CharacterController(CharacterService characterService) {
        this.characterService = characterService;
    }

    @Operation(summary = "Retrieve all Characters Rick and Morty.", tags = {"get", "filter"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {
                    @Content(schema = @Schema(implementation = CharacterRM.class), mediaType = "application/json")}),
            @ApiResponse(responseCode = "204", description = "There are no Character", content = {
                    @Content(schema = @Schema())}),
            @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema())})})
    @GetMapping
    public ResponseEntity<List<CharacterRM>> getAllCharacters() {
        List<CharacterRM> characterRMS = characterService.findAll();
        if (characterRMS.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(characterRMS, HttpStatus.OK);
    }

    @Operation(
            summary = "Retrieve a Character by Id",
            description = "Get a Character object by specifying its id. The response is Character object.",
            tags = {"get"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = CharacterRM.class), mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema())})})
    @GetMapping("/{id}")
    public ResponseEntity<CharacterRM> getCharacterById(@PathVariable Long id) {
        CharacterRM characterRM = characterService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found Character with id = " + id));

        return new ResponseEntity<>(characterRM, HttpStatus.OK);
    }

    @Operation(summary = "Create a new Character", tags = {"post"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {
                    @Content(schema = @Schema(implementation = CharacterRM.class), mediaType = "application/json")}),
            @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema())})})
    @PostMapping
    public ResponseEntity<CharacterRM> createCharacter(@RequestBody CharacterRM character) {
        character = characterService.save(character);
        return new ResponseEntity<>(character, HttpStatus.CREATED);
    }

    @Operation(summary = "Update a Character by ID", tags = {"put"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {
                    @Content(schema = @Schema(implementation = Episode.class), mediaType = "application/json")}),
            @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema())})})
    @PutMapping("/{id}")
    public ResponseEntity<CharacterRM> updateEpisode(@PathVariable("id") long id, @RequestBody CharacterRM character) {
        character = characterService.update(id, character);
        return new ResponseEntity<>(character, HttpStatus.CREATED);
    }

    @Operation(summary = "Delete Character by ID", tags = {"delete"})
    @ApiResponses({@ApiResponse(responseCode = "204", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema())})})
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus>  deleteCharacter(@PathVariable Long id) {
        characterService.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}