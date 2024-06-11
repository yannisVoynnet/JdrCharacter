package com.JdrCharacter.controller;

import com.JdrCharacter.model.Armor;
import com.JdrCharacter.service.ArmorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/armors")
public class ArmorController {

    @Autowired
    private ArmorService armorService;

    @GetMapping
    public String getAllArmors(Model model) {
        model.addAttribute("armors", armorService.getAllArmors());
        return "armors/list";
    }

    @GetMapping("/new")
    public String createArmorForm(Model model) {
        model.addAttribute("armor", new Armor());
        return "armors/armor_form";
    }

    @PostMapping
    public String saveArmor(@ModelAttribute Armor armor) {
        armorService.saveArmor(armor);
        return "redirect:/armors";
    }

    @GetMapping("/{id}")
    public String getArmorById(@PathVariable Long id, Model model) {
        model.addAttribute("armor", armorService.getArmorById(id));
        return "armors/detail";
    }

    @GetMapping("/delete/{id}")
    public String deleteArmor(@PathVariable Long id) {
        armorService.deleteArmor(id);
        return "redirect:/armors";
    }
}

