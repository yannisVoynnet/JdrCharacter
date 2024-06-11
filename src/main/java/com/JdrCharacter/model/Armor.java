package com.JdrCharacter.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Armor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Integer armorClassBonus;
    private Integer weight;
    private boolean addModDex;
    private boolean stealthDisadvantage;

    // Getters and Setters
}

