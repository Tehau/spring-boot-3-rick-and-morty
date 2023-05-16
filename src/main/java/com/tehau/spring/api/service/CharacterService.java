package com.tehau.spring.api.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.tehau.spring.api.model.CharacterRM;
import com.tehau.spring.api.model.Episode;
import com.tehau.spring.api.repository.CharacterRepository;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class CharacterService {
    private final File FILE_NAME = new File("src/main/resources/data/rickandmortycharacter.json");

    private List<CharacterRM> characterRMS;

    private final CharacterRepository characterRepository;

    public CharacterService(CharacterRepository characterRepository) {
        characterRMS = loadData();
        this.characterRepository = characterRepository;
    }

    public List<CharacterRM> findAll() {
        return characterRepository.findAll();
    }

    public Optional<CharacterRM> findById(Long id) {
        return characterRepository.findById(id);
    }

    public CharacterRM save(CharacterRM characterRM) {
        return characterRepository.save(characterRM);
    }

    public CharacterRM update(long id , CharacterRM newCharacterRM) {
        return findById(id)
                .map(character_db -> {
                    character_db.setName(newCharacterRM.getName());
                    character_db.setStatus(newCharacterRM.getStatus());
                    character_db.setSpecies(newCharacterRM.getSpecies());
                    character_db.setType(newCharacterRM.getType());
                    character_db.setGender(newCharacterRM.getGender());
                    character_db.setOrigin(newCharacterRM.getOrigin());
                    character_db.setLocation(newCharacterRM.getLocation());
                    character_db.setImage(newCharacterRM.getImage());
                    character_db.setUrl(newCharacterRM.getUrl());
                    return characterRepository.save(character_db);
                }).orElseGet(() -> {
                    return characterRepository.save(newCharacterRM);
                });
    }

    public void deleteById(Long id) {
        characterRepository.deleteById(id);
    }

    private List<CharacterRM> loadData() {
        List<CharacterRM> CharacterRMs;
        try(JsonReader reader =new JsonReader(new FileReader(FILE_NAME))) {
            Gson gson = new Gson();
            CharacterRMs = gson.fromJson(reader, new TypeToken<List<CharacterRM>>() {}.getType());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return CharacterRMs;
    }

}
