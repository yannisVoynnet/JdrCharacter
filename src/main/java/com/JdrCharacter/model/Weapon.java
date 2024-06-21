package com.JdrCharacter.model;

import java.util.Optional;
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
    private WeaponName name;
    private WeaponCategory category;
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
    public Weapon(WeaponName name, WeaponCategory category, Integer damage, DamageType damageType, Character character, boolean isMelee, 
    Optional<String> description, Optional<Integer> range, Optional<Integer> magicBonus, Optional<Set<WeaponProperty>> properties) 
    {
        this.name = name;
        this.category = category;
        this.description = description.orElse("une arme basique, non magique");
        this.damage = damage;
        this.damageType = damageType;
        this.range = range.orElse(0);
        this.magicBonus = magicBonus.orElse(0);
        this.properties = properties.orElse(null);
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
    public WeaponName getName() {
        return name;
    }
    public void setName(WeaponName name) {
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
    public WeaponCategory getCategory() {
        return category;
    }
    public void setCategory(WeaponCategory category) {
        this.category = category;
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

