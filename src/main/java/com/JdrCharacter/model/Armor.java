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

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Integer getArmorClassBonus() {
        return armorClassBonus;
    }
    public void setArmorClassBonus(Integer armorClassBonus) {
        this.armorClassBonus = armorClassBonus;
    }
    public Integer getWeight() {
        return weight;
    }
    public void setWeight(Integer weight) {
        this.weight = weight;
    }
    public boolean isAddModDex() {
        return addModDex;
    }
    public void setAddModDex(boolean addModDex) {
        this.addModDex = addModDex;
    }
    public boolean isStealthDisadvantage() {
        return stealthDisadvantage;
    }
    public void setStealthDisadvantage(boolean stealthDisadvantage) {
        this.stealthDisadvantage = stealthDisadvantage;
    }
    
}

