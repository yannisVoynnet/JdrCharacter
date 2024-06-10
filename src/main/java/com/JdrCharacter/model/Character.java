package com.JdrCharacter.model;

import java.util.Random;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Character {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Origin origin; 
    private CharacterClass characterClass;
    private Background background; 
    private int level = 1; 
    private int hitPoint; 
    private String description;
    private int[] stats = new int[6]; 
    // 0 : force, 1 : dextérité, 2 : constitution, 3 : intelligence, 4 : sagesse , 5 : charisme
    private Equipment equipment; 
    private Mastery mastery;

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
    public Origin getOrigin() {
        return origin;
    }
    public void setOrigin(Origin origin) {
        this.origin = origin;
    }
    public CharacterClass getCharacterClass() {
        return characterClass;
    }
    public void setCharacterClass(CharacterClass characterClass) {
        this.characterClass = characterClass;
    }
    public Background getBackground() {
        return background;
    }
    public void setBackground(Background background) {
        this.background = background;
    }
    public int getLevel() {
        return level;
    }
    public void setLevel(int level) {
        this.level = level;
    }
    public int getHitPoint() {
        return hitPoint;
    }
    public void setHitPoint(int hitPoint) {
        this.hitPoint = hitPoint;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public int[] getStats() {
        return stats;
    }
    public void setStats(int[] stats) {
        this.stats = stats;
    }
    public Equipment getEquipment() {
        return equipment;
    }
    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }
    public Mastery getMastery() {
        return mastery;
    }
    public void setMastery(Mastery mastery) {
        this.mastery = mastery;
    } 
    
    public void setOneStat(int id,int stat){
        this.stats[id] = stat;
    }
    
    // méthode semi aléatoire de création de stat
    // a appelé en arrivant sur la création d'un personnage, 
    // afin de pouvoir placer les stats comme on veut
    public int[] createStatsRandomLight(){
        int[] statsTmp = new int[6];
        Random rand = new Random();
        for(int i = 0; i < 3; i++){
            int dice1 = rand.nextInt(6)+1;
            int dice2 = rand.nextInt(6)+1;
            int res = dice1 + dice2;

            // on a jeté les 2d6, maintenant on ajouté 6 au résultat : 
            statsTmp[i] = res + 6;     
            //puis on fait 19 - res pour la seconde statistiques
            statsTmp[i+1] = 19 - res;
        }
        return statsTmp;
    }

    //fonction qui donne le bonus de maîtrise en fonction du niveau
    public int getMasteryBonus(){
        if(this.level < 5 ){
            return 2;
        }else if(this.level < 9){
            return 3;
        }else if(this.level < 13){
            return 4;
        }else if(this.level < 17){
            return 5;
        }else{
            return 6;
        }
    }

    //fonction qui récupère le modificateur en fonction d'une valeur de stats
    private int calculateMod(int x){
        return (x - 10) / 2 ;
    }

    public int[] getMods(){
        int[] mods = new int[this.getStats().length];
        for(int i = 0; i < this.getStats().length; i++){
            mods[i] = calculateMod(this.stats[i]);
        }
        return mods;
    }

    public int getMod(int statsIndex){
        //ici on ne veut récupèrer qu'un seul mod
        if(statsIndex < 0 || statsIndex >= this.getStats().length){
            throw new IllegalArgumentException("Indice de statistiques invalide");
        }
        return calculateMod(this.getStats()[statsIndex]);
    }

    //fonction qui calcule les différents score d'attaque
    public int getScoreAtt(String typeAtt, int statsIndex ){ 
        // magicStats = charisme pour un barde par exemple 
        int mb = this.getMasteryBonus();
        if(typeAtt.equals("C")){
            return mb + this.getStats()[0]; // 0 = force
        }else if (typeAtt.equals("D")){
            return mb + this.getStats()[1]; // 1 = dextérité
        }else if (typeAtt.equals("M")){
            return mb + this.getMod(this.getStats()[statsIndex]);
        }else{
            throw new IllegalArgumentException("Veuillez mettre C pour corps à corps, D pour distance et M pour magique");
        }
    }

    //fonction qui calcule le dd de sauvegarde des sorts
    public int getDdSave(int magicStats){ 
        //x doit être le modificateur de caractéristique de sort
        return 8 + this.getMasteryBonus() + magicStats;
    }
}
