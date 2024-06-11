package com.JdrCharacter.service;

import com.JdrCharacter.model.Weapon;
import com.JdrCharacter.repository.WeaponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeaponService {

    @Autowired
    private WeaponRepository weaponRepository;

    public List<Weapon> getAllWeapons() {
        return weaponRepository.findAll();
    }

    public Weapon getWeaponById(Long id) {
        return weaponRepository.findById(id).orElse(null);
    }

    public void saveWeapon(Weapon weapon) {
        weaponRepository.save(weapon);
    }

    public void deleteWeapon(Long id) {
        weaponRepository.deleteById(id);
    }
}

