package com.JdrCharacter.model;

import java.util.Map;
import java.util.Set;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;

@Entity
public class Weapon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Integer attack;
    private Integer magicBonus; //1 = +1 pour touché et à l'attaque par exemple
    private Integer damage; // 6 = d6, 8 = d8 etc... 
    private Integer damageBonus;
    private DamageType damageType;
    private Integer range;

    @ElementCollection(targetClass = WeaponProperty.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "weapon_properties")
    @Column(name = "property")
    private Set<WeaponProperty> properties;

    @Transient
    private Character character;

    // Constructeur par défaut
    public Weapon() {}

    // Constructeur avec paramètres pour calculer le bonus d'attaque automatiquement
    public Weapon(String name, String description, Integer damage, DamageType damageType,
     Integer range, Integer magicBonus, Set<WeaponProperty> properties, Character character, boolean isMelee) {
        this.name = name;
        this.description = description;
        this.damage = damage;
        this.damageType = damageType;
        this.range = range;
        this.magicBonus = magicBonus;
        this.properties = properties;
        this.character = character;
        this.attack = calculateAttack(character);
    }

    // Getters and Setters
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
    public Integer getAttack() {
        return attack;
    }
    public void setAttack(Integer attack) {
        this.attack = attack;
    }
    public Integer getMagicBonus() {
        return magicBonus;
    }
    public void setMagicBonus(Integer magicBonus) {
        this.magicBonus = magicBonus;
    }
    public Integer getDamage() {
        return damage;
    }
    public void setDamage(Integer damage) {
        this.damage = damage;
    }
    public Integer getDamageBonus() {
        return damageBonus;
    }
    public void setDamageBonus(Integer damageBonus) {
        this.damageBonus = damageBonus;
    }
    public DamageType getDamageType() {
        return damageType;
    }
    public void setDamageType(DamageType damageType) {
        this.damageType = damageType;
    }
    public Integer getRange() {
        return range;
    }
    public void setRange(Integer range) {
        this.range = range;
    }
    public Set<WeaponProperty> getProperties() {
        return properties;
    }
    public void setProperties(Set<WeaponProperty> properties) {
        this.properties = properties;
    }
    public Character getCharacter() {
        return character;
    }
    public void setCharacter(Character character) {
        this.character = character;
    }

    private Integer calculateAttack(Character character) {
        //dague finesse + lancer         
        if(this.getProperties().contains(WeaponProperty.FINESSE) && (this.character.getMod(0) < this.character.getMod(1)) ){
        
        }

        if(this.getProperties().contains(WeaponProperty.THROW) && this.getProperties().contains(WeaponProperty.THROW)){
           // si propriété lancer et pas finesse  
        }
        boolean isMelee = true;
        Integer statBonus = isMelee ? character.getMod(0) : character.getMod(1); // 0 = force, 1 = dextérité
        Integer masteryBonus = character.getMasteryBonus();
        return statBonus + this.magicBonus + masteryBonus;
    }
}

