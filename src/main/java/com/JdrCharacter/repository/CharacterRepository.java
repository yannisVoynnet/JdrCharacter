package com.JdrCharacter.repository;

import com.JdrCharacter.model.Character;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacterRepository extends JpaRepository<Character, Long> {
}
