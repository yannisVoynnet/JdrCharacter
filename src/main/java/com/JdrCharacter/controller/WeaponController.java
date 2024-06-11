package com.JdrCharacter.controller;

import com.JdrCharacter.model.Weapon;
import com.JdrCharacter.model.WeaponProperty;
import com.JdrCharacter.service.WeaponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/weapons")
public class WeaponController {

    @Autowired
    private WeaponService weaponService;

    @GetMapping
    public String getAllWeapons(Model model) {
        model.addAttribute("weapons", weaponService.getAllWeapons());
        return "weapons/list";
    }

    @GetMapping("/new")
    public String createWeaponForm(Model model) {
        model.addAttribute("weapon", new Weapon());
        model.addAttribute("allProperties", WeaponProperty.values());
        return "weapons/weapon_form";
    }

    @PostMapping
    public String saveWeapon(@ModelAttribute Weapon weapon) {
        weaponService.saveWeapon(weapon);
        return "redirect:/weapons";
    }

    @GetMapping("/{id}")
    public String getWeaponById(@PathVariable Long id, Model model) {
        model.addAttribute("weapon", weaponService.getWeaponById(id));
        return "weapons/detail";
    }

    @GetMapping("/delete/{id}")
    public String deleteWeapon(@PathVariable Long id) {
        weaponService.deleteWeapon(id);
        return "redirect:/weapons";
    }
}

