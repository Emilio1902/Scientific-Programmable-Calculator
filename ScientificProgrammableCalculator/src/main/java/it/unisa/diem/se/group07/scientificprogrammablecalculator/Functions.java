/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unisa.diem.se.group07.scientificprogrammablecalculator;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author raffa
 */
public class Functions {
    
    private HashMap<String, String> functions;
    private Map<String, String> allowedOperations;
    
    /**
     * Constructs the functions data structures and the allowedOperations
     *
     */
    public Functions() {
        this.functions = new HashMap<>();
        this.allowedOperations = new HashMap<String, String>() {
        { put("+", null);put("-", null); put("*", null);put("/", null);put("+-", null);
        put("√", null);put(">", null);put("<", null);put("save", null);put("restore", null);
        put("clear", null);put("drop", null);put("dup", null);put("swap", null);put("over", null);
        put("mod", null); put("arg", null);put("log", null);put("exp", null);}};   
    }
    
    /**
     * Check if the function to store is in the correct format and store it in the datastructure.
     *
     * @param name is the name of the function to save.
     * @param operations is the sequence of the operations to do.
     * @return true if the format is correct, false otherwise
     */
    public boolean saveFunction(String name,String operations){
        String newOperations = operations.replaceAll("sqrt", "√");
        String[] splitOp = newOperations.split(" ");
        for(int i=0; i< splitOp.length; i++){
            if(!allowedOperations.containsKey(splitOp[i])){
                String start = splitOp[i].substring(0,1);
                if(!(start.matches("[<>+-]+")&& splitOp[i].length()==2 && Character.isAlphabetic(splitOp[i].charAt(1)))){
                    ComplexNumbers num = new ComplexNumbers(splitOp[i]);
                    if(num.getReal()== Double.NEGATIVE_INFINITY && num.getImg() == Double.NEGATIVE_INFINITY)
                        return false;   
                }
            }
        }
        functions.put(name, operations);
        return true;
    }
    
    
}
