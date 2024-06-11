package com.JdrCharacter.service;

import com.JdrCharacter.model.Armor;
import com.JdrCharacter.repository.ArmorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArmorService {

    @Autowired
    private ArmorRepository armorRepository;

    public List<Armor> getAllArmors() {
        return armorRepository.findAll();
    }

    public Armor getArmorById(Long id) {
        return armorRepository.findById(id).orElse(null);
    }

    public void saveArmor(Armor armor) {
        armorRepository.save(armor);
    }

    public void deleteArmor(Long id) {
        armorRepository.deleteById(id);
    }
}

