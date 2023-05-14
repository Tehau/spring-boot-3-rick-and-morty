package com.tehau.spring.api.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.tehau.spring.api.model.CharacterRM;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

@Service
public class CharacterService {
    private final File FILE_NAME = new File("src/main/resources/data/rickandmortycharacter.json");

    private List<CharacterRM> CharacterRMs;

    public CharacterService() {
        CharacterRMs = loadData();
    }

    public List<CharacterRM> findAll() {
        return CharacterRMs;
    }

    public CharacterRM findById(int id) {
        for (CharacterRM CharacterRM : CharacterRMs) {
            if (CharacterRM.getId() == id) {
                return CharacterRM;
            }
        }
        return null;
    }

    public CharacterRM save(CharacterRM CharacterRM) {
        if (CharacterRM.getId() == 0) {
            long maxId = 0;
            for (CharacterRM c : CharacterRMs) {
                if (c.getId() > maxId) {
                    maxId = c.getId();
                }
            }
            CharacterRM.setId(maxId + 1);
            CharacterRMs.add(CharacterRM);
        } else {
            int index = CharacterRMs.indexOf(CharacterRM);
            CharacterRMs.set(index, CharacterRM);
        }
        return CharacterRM;
    }

    public void deleteById(int id) {
        CharacterRM CharacterRMToDelete = null;
        for (CharacterRM CharacterRM : CharacterRMs) {
            if (CharacterRM.getId() == id) {
                CharacterRMToDelete = CharacterRM;
                break;
            }
        }
        if (CharacterRMToDelete != null) {
            CharacterRMs.remove(CharacterRMToDelete);
        }
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
