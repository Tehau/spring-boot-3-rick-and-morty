package com.tehau.spring.api.controller;

import com.tehau.spring.api.exception.ResourceNotFoundException;
import com.tehau.spring.api.model.CharacterRM;
import com.tehau.spring.api.model.Episode;
import com.tehau.spring.api.service.EpisodeService;
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

@Tag(name = "Episode", description = "Episode management APIs")
@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api/episodes")
public class EpisodeController {

    private final EpisodeService episodeService;

    public EpisodeController(EpisodeService episodeService) {
        this.episodeService = episodeService;
    }

    @Operation(summary = "Retrieve all Episodes Rick and Morty.", tags = {"get", "filter"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {
                    @Content(schema = @Schema(implementation = Episode.class), mediaType = "application/json")}),
            @ApiResponse(responseCode = "204", description = "There are no Episodes", content = {
                    @Content(schema = @Schema())}),
            @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema())})})
    @GetMapping
    public ResponseEntity<List<Episode>> getAllEpisodes() {
        List<Episode> episodes = episodeService.findAll();
        if (episodes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(episodes, HttpStatus.OK);
    }

    @Operation(summary = "Create a new Episode", tags = {"post"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {
                    @Content(schema = @Schema(implementation = Episode.class), mediaType = "application/json")}),
            @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema())})})
    @PostMapping
    public ResponseEntity<Episode> createEpisode(@RequestBody Episode episode) {
        episode = episodeService.save(episode);
        return new ResponseEntity<>(episode, HttpStatus.CREATED);
    }

    @Operation(
            summary = "Retrieve a Episode by Id",
            description = "Get a Episode object by specifying its id. The response is Episode object.",
            tags = {"get"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = CharacterRM.class), mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema())})})
    @GetMapping("/{id}")
    public ResponseEntity<Episode> getEpisodeById(@PathVariable("id") long id) {
        Episode tutorial = episodeService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found Tutorial with id = " + id));

        return new ResponseEntity<>(tutorial, HttpStatus.OK);
    }

    @Operation(summary = "Update a Episode by ID", tags = {"put"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {
                    @Content(schema = @Schema(implementation = Episode.class), mediaType = "application/json")}),
            @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema())})})
    @PutMapping("{id}")
    public ResponseEntity<Episode> updateEpisode(@PathVariable("id") long id, @RequestBody Episode episode) {
        episode = episodeService.update(id, episode);
        return new ResponseEntity<>(episode, HttpStatus.CREATED);
    }


    @Operation(summary = "Delete Episode by ID", tags = {"delete"})
    @ApiResponses({@ApiResponse(responseCode = "204", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema())})})
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus>  deleteEpisode(@PathVariable Long id) {
        episodeService.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
