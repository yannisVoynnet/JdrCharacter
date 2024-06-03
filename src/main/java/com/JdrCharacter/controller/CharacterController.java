package com.JdrCharacter.controller;

import com.JdrCharacter.model.Character;
import com.JdrCharacter.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/characters")
public class CharacterController {
    @Autowired
    private CharacterService characterService;

    @GetMapping
    public String getAllCharacters(Model model) {
        model.addAttribute("characters", characterService.getAllCharacters());
        return "characters/list";
    }

    @GetMapping("/{id}")
    public String getCharacterById(@PathVariable Long id, Model model) {
        model.addAttribute("character", characterService.getCharacterById(id));
        return "characters/detail";
    }

    @GetMapping("/new")
    public String createCharacterForm(Model model) {
        model.addAttribute("character", new Character());
        return "characters/form";
    }

    @PostMapping
    public String saveCharacter(@ModelAttribute Character character) {
        characterService.saveCharacter(character);
        return "redirect:/characters";
    }

    @GetMapping("/delete/{id}")
    public String deleteCharacter(@PathVariable Long id) {
        characterService.deleteCharacter(id);
        return "redirect:/characters";
    }
}

