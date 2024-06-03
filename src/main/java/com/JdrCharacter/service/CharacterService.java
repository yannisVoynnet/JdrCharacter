package com.JdrCharacter.service;

import com.JdrCharacter.model.Character;
import com.JdrCharacter.repository.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterService {
    @Autowired
    private CharacterRepository characterRepository;

    public List<Character> getAllCharacters() {
        return characterRepository.findAll();
    }

    public Character getCharacterById(Long id) {
        return characterRepository.findById(id).orElse(null);
    }

    public Character saveCharacter(Character character) {
        return characterRepository.save(character);
    }

    public void deleteCharacter(Long id) {
        characterRepository.deleteById(id);
    }
}
