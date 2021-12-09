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
    private HashMap<Character, ComplexNumbers> variablesCopy;
    
    /**
     * Constructs the variables data structures and its eventual copy.
     *
     */
    public Variables() {
        this.variables = new HashMap<>();
        this.variablesCopy = new HashMap<>();
    }
    
    /**
     * This method saves a ComplexNumbers into a specified variable.
     *
     * @param key is the variable that will contain the ComplexNumbers.
     * @param number is the ComplexNumbers to store.
     * 
     * @return true if the specified variable is an Alphabetic character, false otherwise.
     */
    public boolean setVariableValue(char key, ComplexNumbers number){
        if(!Character.isAlphabetic(key)){
            return false;
        }
        else{
            variables.put(Character.toLowerCase(key), number);
            return true;
        }
    }
    
    /**
     * This method saves a ComplexNumbers into a specified variable.
     *
     * @param key is the variable that contains the ComplexNumbers to return.
     * @return the ComplexNumbers contained into variable key if this exists, null otherwise.
     */
    public ComplexNumbers getVariableValue(char key){
        return variables.get(key);
    }
    
    /**
     * This method saves a copy of the stored variables into another data structure.
     */
    public void saveVariables(){
        variablesCopy = (HashMap<Character, ComplexNumbers>)variables.clone();
    }
    
    /**
     * This method restores the copy of the stored variables into original data structure.
     */
    public void restoreVariables(){
        variables = (HashMap<Character, ComplexNumbers>)variablesCopy.clone();
    }
    
}
