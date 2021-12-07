/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unisa.diem.se.group07.scientificprogrammablecalculator;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

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
        put("sqrt", null);put(">", null);put("<", null);put("save", null);put("restore", null);
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
        String[] splitOp = operations.split(" ");
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
        allowedOperations.put(name, null);
        return true;
    }
    
    /**
     * Return the operations of specified function.
     *
     * @param name is the name of the function.
     * @return operations of specified function, null if the HashMap function not cointains key name
     */
    public String[] getOperation (String name){
        String operations = functions.get(name);
        return operations != null ? operations.split(" ") : null;   
    }
  
    /**
     * Return the specified function.
     *
     * @return set of stored function, null if the HashMap function not cointains elements
     */
    public Set<String> getFunctions (){
       return functions.keySet();
    }
    
    
}
