package com.JdrCharacter.model;

import java.util.Map;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Mastery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Map<String,Boolean> languages; 
    private Map<String,Boolean> tools;
    private Map<String,Boolean> skills; 
    private Map<String,Boolean> weapons;
    private Map<String,Boolean> armor;
    
}
