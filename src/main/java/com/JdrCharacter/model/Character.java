package com.JdrCharacter.model;

import java.util.EnumMap;
import java.util.Map;
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
    private Integer level = 1; 
    private Integer hitPoint; 
    private String description;
    private int[] stats = new int[6]; 
    // 0 : force, 1 : dextérité, 2 : constitution, 3 : intelligence, 4 : sagesse , 5 : charisme
    private Equipment equipment; 
    private Map<ProficiencyType,Map<?,Boolean>> proficiencies; 

    public Character(){
        this.proficiencies = new EnumMap<>(ProficiencyType.class);
        initProficiencies();
    }

    private void initProficiencies(){
        // Initialiser les maîtrises d'armures
        this.proficiencies.put(ProficiencyType.ARMOR, new EnumMap<>(ArmorCategory.class));

        // Initialiser les maîtrises des compétences (Skills)
        this.proficiencies.put(ProficiencyType.SKILL, new EnumMap<>(SkillExist.class));
 
        // Initialiser les maîtrises des langues (Languages)
        this.proficiencies.put(ProficiencyType.LANGUAGE, new EnumMap<>(LanguageExist.class));
 
        // Initialiser les maîtrises des catégories d'armes
        this.proficiencies.put(ProficiencyType.WEAPON_CATEGORY, new EnumMap<>(WeaponCategory.class));
 
        // Initialiser les maîtrises des armes spécifiques (si on a rien ici, mais qu'on a MELEEBASIC dans category, alors il faudra lui mettre toutes les armes melee )
        this.proficiencies.put(ProficiencyType.WEAPON_NAME, new EnumMap<>(WeaponName.class));
    
    }

    @SuppressWarnings("unchecked")
    public <E extends Enum<E>> void setProficiency(ProficiencyType type, E proficiency) {
        // on demande pas s'il maîtrise, car le personnage ne maitrise pas SI ce n'est pas dans proficiencies
        Map<Enum<?>, Boolean> proficiencyMap = (Map<Enum<?>, Boolean>) proficiencies.get(type); //on récupère la map, par exemple, SKILL et on veut ajouter deception
        if (proficiencyMap != null) {
            proficiencyMap.put(proficiency, true);
        }
    }

    @SuppressWarnings("unchecked")
    public <E extends Enum<E>> boolean getProficiency(ProficiencyType type, E proficiency) {
        Map<Enum<?>, Boolean> proficiencyMap = (Map<Enum<?>, Boolean>) proficiencies.get(type);
        return proficiencyMap != null && proficiencyMap.getOrDefault(proficiency, false);
    }

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
    public Integer getLevel() {
        return level;
    }
    public void setLevel(Integer level) {
        this.level = level;
    }
    public Integer getHitPoint() {
        return hitPoint;
    }
    public void setHitPoint(Integer hitPoint) {
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
    public void setOneStat(Integer id,Integer stat){
        this.stats[id] = stat;
    }
    
    // méthode semi aléatoire de création de stat
    // a appelé en arrivant sur la création d'un personnage, 
    // afin de pouvoir placer les stats comme on veut
    public int[] createStatsRandomLight(){
        int[] statsTmp = new int[6];
        Random rand = new Random();
        for(Integer i = 0; i < 3; i++){
            Integer dice1 = rand.nextInt(6)+1;
            Integer dice2 = rand.nextInt(6)+1;
            Integer res = dice1 + dice2;

            // on a jeté les 2d6, maintenant on ajouté 6 au résultat : 
            statsTmp[i] = res + 6;     
            //puis on fait 19 - res pour la seconde statistiques
            statsTmp[i+1] = 19 - res;
        }
        return statsTmp;
    }

    //fonction qui donne le bonus de maîtrise en fonction du niveau
    public Integer getMasteryBonus(){
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
    private Integer calculateMod(Integer x){
        return (x - 10) / 2 ;
    }

    public int[] getMods(){
        int[] mods = new int[this.getStats().length];
        for(Integer i = 0; i < this.getStats().length; i++){
            mods[i] = calculateMod(this.stats[i]);
        }
        return mods;
    }

    public Integer getMod(Integer statsIndex){
        //ici on ne veut récupèrer qu'un seul mod
        if(statsIndex < 0 || statsIndex >= this.getStats().length){
            throw new IllegalArgumentException("Indice de statistiques invalide");
        }
        return calculateMod(this.getStats()[statsIndex]);
    }

    //fonction qui calcule les différents score d'attaque
    public Integer getScoreAtt(String typeAtt, Integer statsIndex ){ 
        // magicStats = charisme pour un barde par exemple 
        Integer mb = this.getMasteryBonus();
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
    public Integer getDdSave(Integer idModStats){ 
        // idModStats doit être le modificateur de caractéristique de sort
        return 8 + this.getMasteryBonus() + this.getMod(idModStats);
    }
}
