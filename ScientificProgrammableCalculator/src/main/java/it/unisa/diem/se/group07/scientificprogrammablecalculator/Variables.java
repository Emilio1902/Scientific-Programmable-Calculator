/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unisa.diem.se.group07.scientificprogrammablecalculator;

import java.util.HashMap;

/**
 *
 * @author raffa
 */
public class Variables {
    private HashMap<Character, ComplexNumbers> variables;

    public Variables() {
        this.variables = new HashMap<Character, ComplexNumbers>();
    }
    
    public boolean setVariableValue(char key, ComplexNumbers number){
        if(!Character.isAlphabetic(key)){
            return false;
        }else{
            variables.put(Character.toLowerCase(key), number);
            return true;
        }
    }
    
    public ComplexNumbers getVariableValue(char key){
        return variables.get(key);
    }
 
}
