package com.JdrCharacter.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.JdrCharacter.model.ArmorCategory;
import com.JdrCharacter.model.LanguageExist;
import com.JdrCharacter.model.SkillExist;
import com.JdrCharacter.model.ToolExist;
import com.JdrCharacter.model.WeaponCategory;
import com.JdrCharacter.model.WeaponName;

@Service
public class TranslationService {

    @Value("${ArmorCategory.LIGHT_ARMOR}")
    private String lightArmorTranslation;
    @Value("${ArmorCategory.MEDIUM_ARMOR}")
    private String mediumArmorTranslation;
    @Value("${ArmorCategory.HEAVY_ARMOR}")
    private String heavyArmorTranslation;
    @Value("${ArmorCategory.SHIELD}")
    private String shieldTranslation;
    @Value("${ArmorCategory.BUCKLER}")
    private String bucklerTranslation;

    // Méthode pour récupérer la traduction d'un type d'armure
    public String getArmorCategoryTranslation(ArmorCategory armorCategory) {
        switch (armorCategory) {
            case LIGHT_ARMOR:
                return lightArmorTranslation;
            case MEDIUM_ARMOR:
                return mediumArmorTranslation;
            case HEAVY_ARMOR:
                return heavyArmorTranslation;
            case SHIELD:
                return shieldTranslation;
            case BUCKLER:
                return bucklerTranslation;
            default:
                return ""; // Gérer le cas par défaut si nécessaire
        }
    }

    //Weapon
    @Value("${WeaponName.STICK}")
    private String stickTranslation;
    @Value("${WeaponName.DAGGER}")
    private String daggerTranslation;
    @Value("${WeaponName.GOURDIN}")
    private String gourdinTranslation;
    @Value("${WeaponName.HATCHET}")
    private String hatchetTranslation;
    @Value("${WeaponName.JAVELINS}")
    private String javelinsTranslation;
    @Value("${WeaponName.SPEAR}")
    private String spearTranslation;
    @Value("${WeaponName.LIGHT_HAMMER}")
    private String lightHammerTranslation;
    @Value("${WeaponName.MACE}")
    private String maceTranslation;
    @Value("${WeaponName.CLUB}")
    private String clubTranslation;
    @Value("${WeaponName.BILL_HOOK}")
    private String billHookTranslation;
    @Value("${WeaponName.LIGHT_CROSSBOW}")
    private String lightCrossbowTranslation;
    @Value("${WeaponName.SHORT_BOW}")
    private String shortBowTranslation;
    @Value("${WeaponName.DARTS}")
    private String dartsTranslation;
    @Value("${WeaponName.SLING}")
    private String slingTranslation;
    @Value("${WeaponName.SCIMITAR}")
    private String scimitarTranslation;
    @Value("${WeaponName.TICKLE}")
    private String tickleTranslation;
    @Value("${WeaponName.TWO_HANDED_SWORD}")
    private String twoHandedSwordTranslation;
    @Value("${WeaponName.SHORT_SWORD}")
    private String shortSwordTranslation;
    @Value("${WeaponName.LONG_SWORD}")
    private String longSwordTranslation;
    @Value("${WeaponName.SCOURGE}")
    private String scourgeTranslation;
    @Value("${WeaponName.WHIP}")
    private String whipTranslation;
    @Value("${WeaponName.TWO_HAND_AX}")
    private String twoHandedAxTranslation;
    @Value("${WeaponName.BATTLE_AX}")
    private String battleAxTranslation;
    @Value("${WeaponName.HALBERD}")
    private String halberdTranslation;
    @Value("${WeaponName.WAR_HAMMER}")
    private String warHammerTranslation;
    @Value("${WeaponName.MERLIN}")
    private String merlinTranslation;
    @Value("${WeaponName.MORGENSTERN}")
    private String morgensternTranslation;
    @Value("${WeaponName.SPADES}")
    private String spadesTranslation;
    @Value("${WeaponName.RAPIER}")
    private String rapierTranslation;
    @Value("${WeaponName.TRIDENT}")
    private String tridentTranslation;
    @Value("${WeaponName.HAND_CROSSBOW}")
    private String handCrossbowTranslation;
    @Value("${WeaponName.HEAVY_CROSSBOW}")
    private String heavyCrossbowTranslation;
    @Value("${WeaponName.LONG_BOW}")
    private String longBowTranslation;
    @Value("${WeaponName.BLOW_GUN}")
    private String blowGunTranslation;

    public String getWeaponNameTranslation(WeaponName weaponName) {
        switch (weaponName) {
            case STICK:
                return stickTranslation;
            case DAGGER:
                return daggerTranslation;
            case GOURDIN:
                return gourdinTranslation;
            case HATCHET:
                return hatchetTranslation;
            case JAVELINS:
                return javelinsTranslation;
            case SPEAR:
                return spearTranslation;
            case LIGHT_HAMMER:
                return lightHammerTranslation;
            case MACE:
                return maceTranslation;
            case CLUB:
                return clubTranslation;
            case BILL_HOOK:
                return billHookTranslation;
            case LIGHT_CROSSBOW:
                return lightCrossbowTranslation;
            case SHORT_BOW:
                return shortBowTranslation;
            case DARTS:
                return dartsTranslation;
            case SLING:
                return slingTranslation;
            case SCIMITAR:
                return scimitarTranslation;
            case TICKLE:
                return tickleTranslation;
            case TWO_HANDED_SWORD:
                return twoHandedSwordTranslation;
            case SHORT_SWORD:
                return shortSwordTranslation;
            case LONG_SWORD:
                return longSwordTranslation;
            case SCOURGE:
                return scourgeTranslation;
            case WHIP:
                return whipTranslation;
            case TWO_HAND_AX:
                return twoHandedAxTranslation;
            case BATTLE_AX:
                return battleAxTranslation;
            case HALBERD:
                return halberdTranslation;
            case WAR_HAMMER:
                return warHammerTranslation;
            case MERLIN:
                return merlinTranslation;
            case MORGENSTERN:
                return morgensternTranslation;
            case SPADES:
                return spadesTranslation;
            case RAPIER:
                return rapierTranslation;
            case TRIDENT:
                return tridentTranslation;
            case HAND_CROSSBOW:
                return handCrossbowTranslation;
            case HEAVY_CROSSBOW:
                return heavyCrossbowTranslation;
            case LONG_BOW:
                return longBowTranslation;
            case BLOW_GUN:
                return blowGunTranslation;
            default:
                return "";
        }
    }

    //Categorie d'armes
    @Value("${WeaponCategory.MELEEBASIC}")
    private String meleeBasicTranslation;
    @Value("${WeaponCategory.MELEEYWAR}")
    private String meleeWarTranslation;
    @Value("${WeaponCategory.RANGEBASIC}")
    private String rangeBasicTranslation;
    @Value("${WeaponCategory.RANGEWAR}")
    private String rangeWarTranslation;


    public String getWeaponCategoryTranslation(WeaponCategory weaponCategory ) {
        // Switch pour WeaponCategory
        switch (weaponCategory) {
            case MELEEBASIC:
                return meleeBasicTranslation;
            case MELEEYWAR:
                return meleeWarTranslation;
            case RANGEBASIC:
                return rangeBasicTranslation;
            case RANGEWAR:
                return rangeWarTranslation;
            default:
                return "";
        }
    }

    @Value("${LanguageExist.COMMON}")
    private String commonTranslation;
    @Value("${LanguageExist.ELF}")
    private String elfTranslation;
    @Value("${LanguageExist.GIANTS}")
    private String giantsTranslation;
    @Value("${LanguageExist.GNOME}")
    private String gnomeTranslation;
    @Value("${LanguageExist.GOBLIN}")
    private String goblinTranslation;
    @Value("${LanguageExist.HALFING}")
    private String halfingTranslation;
    @Value("${LanguageExist.DWARF}")
    private String dwarfTranslation;
    @Value("${LanguageExist.ORC}")
    private String orcTranslation;
    @Value("${LanguageExist.ABYSSAL}")
    private String abyssalTranslation;
    @Value("${LanguageExist.CELESTIAL}")
    private String celestialTranslation;
    @Value("${LanguageExist.COMMON_DEEP}")
    private String commonDeepTranslation;
    @Value("${LanguageExist.DRACONIC}")
    private String draconicTranslation;
    @Value("${LanguageExist.INFERNAL}")
    private String infernalTranslation;
    @Value("${LanguageExist.PRIMORDIAL}")
    private String primordialTranslation;
    @Value("${LanguageExist.BLACK_TALK}")
    private String blackTalkTranslation;
    @Value("${LanguageExist.SSELISH}")
    private String ssedishTranslation;
    @Value("${LanguageExist.SYLVESTER}")
    private String sylvesterTranslation;

    public String getLanguageExistTranslation(LanguageExist languageExist ) {
        switch (languageExist) {
            case COMMON:
                return commonTranslation;
            case ELF:
                return elfTranslation;
            case GIANTS:
                return giantsTranslation;
            case GNOME:
                return gnomeTranslation;
            case GOBLIN:
                return goblinTranslation;
            case HALFING:
                return halfingTranslation;
            case DWARF:
                return dwarfTranslation;
            case ORC:
                return orcTranslation;
            case ABYSSAL:
                return abyssalTranslation;
            case CELESTIAL:
                return celestialTranslation;
            case COMMON_DEEP:
                return commonDeepTranslation;
            case DRACONIC:
                return draconicTranslation;
            case INFERNAL:
                return infernalTranslation;
            case PRIMORDIAL:
                return primordialTranslation;
            case BLACK_TALK:
                return blackTalkTranslation;
            case SSELISH:
                return ssedishTranslation;
            case SYLVESTER:
                return sylvesterTranslation;
            default:
                return "";
        }
    }

    @Value("${SkillExist.ATHLETICS}")
    private String athleticsTranslation;
    @Value("${SkillExist.ACROBATICS}")
    private String acrobaticsTranslation;
    @Value("${SkillExist.DISCRETION}")
    private String discretionTranslation;
    @Value("${SkillExist.SLEIGHTOFHAND}")
    private String sleightOfHandTranslation;
    @Value("${SkillExist.ARCANA}")
    private String arcanaTranslation;
    @Value("${SkillExist.HISTORY}")
    private String historyTranslation;
    @Value("${SkillExist.INVESTIGATION}")
    private String investigationTranslation;
    @Value("${SkillExist.NATURE}")
    private String natureTranslation;
    @Value("${SkillExist.RELIGION}")
    private String religionTranslation;
    @Value("${SkillExist.DRESSAGE}")
    private String dressageTranslation;
    @Value("${SkillExist.MEDICINE}")
    private String medicineTranslation;
    @Value("${SkillExist.PERCEPTION}")
    private String perceptionTranslation;
    @Value("${SkillExist.INSIGHT}")
    private String insightTranslation;
    @Value("${SkillExist.SURVIVAL}")
    private String survivalTranslation;
    @Value("${SkillExist.INTIMIDATION}")
    private String intimidationTranslation;
    @Value("${SkillExist.PERSUASION}")
    private String persuasionTranslation;
    @Value("${SkillExist.REPRESENTATION}")
    private String representationTranslation;
    @Value("${SkillExist.DECEPTION}")
    private String deceptionTranslation;

    public String getSkillExistTranslation(SkillExist skillExist) {
        switch (skillExist) {
            case ATHLETICS:
                return athleticsTranslation;
            case ACROBATICS:
                return acrobaticsTranslation;
            case DISCRETION:
                return discretionTranslation;
            case SLEIGHTOFHAND:
                return sleightOfHandTranslation;
            case ARCANA:
                return arcanaTranslation;
            case HISTORY:
                return historyTranslation;
            case INVESTIGATION:
                return investigationTranslation;
            case NATURE:
                return natureTranslation;
            case RELIGION:
                return religionTranslation;
            case DRESSAGE:
                return dressageTranslation;
            case MEDICINE:
                return medicineTranslation;
            case PERCEPTION:
                return perceptionTranslation;
            case INSIGHT:
                return insightTranslation;
            case SURVIVAL:
                return survivalTranslation;
            case INTIMIDATION:
                return intimidationTranslation;
            case PERSUASION:
                return persuasionTranslation;
            case REPRESENTATION:
                return representationTranslation;
            case DECEPTION:
                return deceptionTranslation;
            default:
                return "";
        }
    }

    @Value("${ToolExist.CHALEMIE}")
    private String chalemieTranslation;
    @Value("${ToolExist.HORN}")
    private String hornTranslation;
    @Value("${ToolExist.BAGPIPES}")
    private String bagpipesTranslation;
    @Value("${ToolExist.FLUTE}")
    private String fluteTranslation;
    @Value("${ToolExist.PANFLUTE}")
    private String panfluteTranslation;
    @Value("${ToolExist.LUTE}")
    private String luteTranslation;
    @Value("${ToolExist.LYRE}")
    private String lyreTranslation;
    @Value("${ToolExist.DRUM}")
    private String drumTranslation;
    @Value("${ToolExist.TYMPANION}")
    private String tympanionTranslation;
    @Value("${ToolExist.VIOLE}")
    private String violeTranslation;
    @Value("${ToolExist.NAVIGATIONAL_INSTRUMENTS}")
    private String navigationalInstrumentsTranslation;
    @Value("${ToolExist.CARDGAME}")
    private String cardgameTranslation;
    @Value("${ToolExist.DICE}")
    private String diceTranslation;
    @Value("${ToolExist.POISONERS_EQUIPMENT}")
    private String poisonersEquipmentTranslation;
    @Value("${ToolExist.HERBALIST_EQUIPMENT}")
    private String herbalistEquipmentTranslation;
    @Value("${ToolExist.ALCHEMIST_EQUIPMENT}")
    private String alchemistEquipmentTranslation;
    @Value("${ToolExist.BREWER_SEQUIPMENT}")
    private String brewerEquipmentTranslation;
    @Value("${ToolExist.HANDY_MAN_TOOLS}")
    private String handyManToolsTranslation;
    @Value("${ToolExist.CALLIGRAPHY_MATERIALS}")
    private String calligraphyMaterialsTranslation;
    @Value("${ToolExist.MAPPING_TOOLS}")
    private String mappingToolsTranslation;
    @Value("${ToolExist.CARPENTER_TOOLS}")
    private String carpenterToolsTranslation;
    @Value("${ToolExist.COBLER_TOOLS}")
    private String cobblerToolsTranslation;
    @Value("${ToolExist.COOKING_UTENSILS}")
    private String cookingUtensilsTranslation;
    @Value("${ToolExist.COSTUME_ACCESSORIES}")
    private String costumeAccessoriesTranslation;
    @Value("${ToolExist.COUNTERFEITERS_ACCESSORIES}")
    private String counterfeitersAccessoriesTranslation;
    @Value("${ToolExist.BLACKSMITH_TOOLS}")
    private String blacksmithToolsTranslation;
    @Value("${ToolExist.JEWELERS_TOOLS}")
    private String jewelersToolsTranslation;
    @Value("${ToolExist.MASON_TOOLS}")
    private String masonToolsTranslation;
    @Value("${ToolExist.JOINER_TOOLS}")
    private String joinerToolsTranslation;
    @Value("${ToolExist.PAINTERS_EQUIPMENT}")
    private String paintersEquipmentTranslation;
    @Value("${ToolExist.POTTERS_TOOLS}")
    private String pottersToolsTranslation;
    @Value("${ToolExist.GLASSBLOWER_TOOLS}")
    private String glassblowerToolsTranslation;
    @Value("${ToolExist.TANNERS_TOOLS}")
    private String tannersToolsTranslation;
    @Value("${ToolExist.WEAVERS_TOOLS}")
    private String weaversToolsTranslation;
    @Value("${ToolExist.THIEFS_TOOLS}")
    private String thiefsToolsTranslation;
    
    public String getToolExistTranslation(ToolExist toolExist) {
        switch (toolExist) {
            case CHALEMIE:
                return chalemieTranslation;
            case HORN:
                return hornTranslation;
            case BAGPIPES:
                return bagpipesTranslation;
            case FLUTE:
                return fluteTranslation;
            case PANFLUTE:
                return panfluteTranslation;
            case LUTE:
                return luteTranslation;
            case LYRE:
                return lyreTranslation;
            case DRUM:
                return drumTranslation;
            case TYMPANION:
                return tympanionTranslation;
            case VIOLE:
                return violeTranslation;
            case NAVIGATIONAL_INSTRUMENTS:
                return navigationalInstrumentsTranslation;
            case CARDGAME:
                return cardgameTranslation;
            case DICE:
                return diceTranslation;
            case POISONERS_EQUIPMENT:
                return poisonersEquipmentTranslation;
            case HERBALIST_EQUIPMENT:
                return herbalistEquipmentTranslation;
            case ALCHEMIST_EQUIPMENT:
                return alchemistEquipmentTranslation;
            case BREWER_SEQUIPMENT:
                return brewerEquipmentTranslation;
            case HANDY_MAN_TOOLS:
                return handyManToolsTranslation;
            case CALLIGRAPHY_MATERIALS:
                return calligraphyMaterialsTranslation;
            case MAPPING_TOOLS:
                return mappingToolsTranslation;
            case CARPENTER_TOOLS:
                return carpenterToolsTranslation;
            case COBBLER_TOOLS:
                return cobblerToolsTranslation;
            case COOKING_UTENSILS:
                return cookingUtensilsTranslation;
            case COSTUME_ACCESSORIES:
                return costumeAccessoriesTranslation;
            case COUNTERFEITERS_ACCESSORIES:
                return counterfeitersAccessoriesTranslation;
            case BLACKSMITH_TOOLS:
                return blacksmithToolsTranslation;
            case JEWELERS_TOOLS:
                return jewelersToolsTranslation;
            case MASON_TOOLS:
                return masonToolsTranslation;
            case JOINER_TOOLS:
                return joinerToolsTranslation;
            case PAINTERS_EQUIPMENT:
                return paintersEquipmentTranslation;
            case POTTERS_TOOLS:
                return pottersToolsTranslation;
            case GLASSBLOWER_TOOLS:
                return glassblowerToolsTranslation;
            case TANNERS_TOOLS:
                return tannersToolsTranslation;
            case WEAVERS_TOOLS:
                return weaversToolsTranslation;
            case THIEFS_TOOLS:
                return thiefsToolsTranslation;
            default:
                return "";
        }
    }

}

