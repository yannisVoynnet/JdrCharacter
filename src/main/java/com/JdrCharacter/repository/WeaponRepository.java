package com.JdrCharacter.repository;

import com.JdrCharacter.model.Weapon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeaponRepository extends JpaRepository<Weapon, Long> {
}

