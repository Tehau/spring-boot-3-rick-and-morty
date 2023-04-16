package com.tehau.spring.api.controller;

import com.tehau.spring.api.model.CharacterRM;
import com.tehau.spring.api.service.CharacterService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@Tag(name = "Character", description = "Character management APIs")
@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
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
    @GetMapping("/characters")
    public List<CharacterRM> getAllCharacters() {
        return characterService.findAll();
    }

    @Operation(
            summary = "Retrieve a Character by Id",
            description = "Get a Character object by specifying its id. The response is Character object.",
            tags = {"get"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = CharacterRM.class), mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema())})})
    @GetMapping("/characters/{id}")
    public Optional<CharacterRM> getCharacterById(@PathVariable int id) {
        return Optional.ofNullable(characterService.findById(id));
    }

    @Operation(summary = "Create a new Character", tags = {"post"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {
                    @Content(schema = @Schema(implementation = CharacterRM.class), mediaType = "application/json")}),
            @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema())})})
    @PostMapping("/characters")
    public CharacterRM createCharacter(@RequestBody CharacterRM character) {
        return characterService.save(character);
    }

    @Operation(summary = "Delete Character by ID", tags = {"delete"})
    @ApiResponses({@ApiResponse(responseCode = "204", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema())})})
    @DeleteMapping("/characters/{id}")
    public void deleteCharacter(@PathVariable int id) {
        characterService.deleteById(id);
    }
}