/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unisa.diem.se.group07.scientificprogrammablecalculator;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author raffa
 */
public class Functions {
    private final HashMap<String, String> functions;
    private final HashMap<String, String> basicOperations;

    /**
     * Constructs the functions data structures and the basicOperations.
     *
     */
    public Functions() {
        this.functions = new HashMap<>();
        this.basicOperations = new HashMap<String, String>() {
            {
                put("+", null);
                put("-", null);
                put("*", null);
                put("/", null);
                put("+-", null);
                put("sqrt", null);
                put(">", null);
                put("<", null);
                put("save", null);
                put("restore", null);
                put("clear", null);
                put("drop", null);
                put("dup", null);
                put("swap", null);
                put("over", null);
                put("mod", null);
                put("arg", null);
                put("log", null);
                put("exp", null);
                put("sin", null);
                put("cos", null);
                put("tan", null);
            }
        };
    }

    /**
     * Check if the function to store is in the correct format and store it in
     * the datastructure.
     *
     * @param name is the name of the function to save.
     * @param operations is the sequence of the operations to do.
     * @return true if the format is correct, false otherwise
     */
    public boolean saveFunction(String name, String operations) {
        ComplexNumbers checkName = new ComplexNumbers(name);
        if(basicOperations.containsKey(name) || (Double.compare(checkName.getReal(), Double.NEGATIVE_INFINITY)!=0 
                && Double.compare(checkName.getImg(), Double.NEGATIVE_INFINITY)!=0)||
                (Character.toString(name.charAt(0)).matches("[<>+-]+") && name.substring(1).matches("[a-z]")))
            return false;
        String[] splitOp = operations.split(" ");
        for (int i = 0; i < splitOp.length; i++) {
            if(splitOp[i].compareTo(name)==0) {
                return false;
            }
            if (!basicOperations.containsKey(splitOp[i]) && !functions.containsKey(splitOp[i])) {
                String start = splitOp[i].substring(0, 1);
                if (!(start.matches("[<>+-]+") && splitOp[i].length() == 2 && Character.isAlphabetic(splitOp[i].charAt(1)))) {
                    ComplexNumbers num = new ComplexNumbers(splitOp[i]);
                    if (num.getReal() == Double.NEGATIVE_INFINITY && num.getImg() == Double.NEGATIVE_INFINITY) {
                        return false;
                    }
                }
            }
        }
        functions.put(name, operations);
        return true;
    }

    /**
     * Delete the specified function.
     *
     * @param name is the name of the function.
     * @return true if the remove is successfull, false otherwise.
     */
    public boolean deleteFunction(String name) {
        if (functions.containsKey(name)) {
            basicOperations.remove(name, null);
            return functions.remove(name, functions.get(name));
        } 
        else {
            return false;
        }
    }

    /**
     * Return the operations of specified function.
     *
     * @param name is the name of the function.
     * @return operations of specified function, null if the HashMap function
     * not cointains key name.
     */
    public String[] getOperation(String name) {
        String operations = functions.get(name);
        return operations != null ? operations.split(" ") : null;
    }

    /**
     * Return the specified function.
     *
     * @return set of stored function, null if the HashMap function not
     * cointains elements.
     */
    public Set<String> getFunctions() {
        return functions.keySet();
    }

    /**
     * This method writes to file stored functions.
     *
     * @param file is File to save on.
     * @return true if the writing is successfull, false otherwise.
     * @throws java.io.IOException
     */
    public boolean writeToFile(File file) throws IOException {
        if(functions.isEmpty()){
            return false;
        }
        Set entrySet = functions.entrySet();
        Iterator it = entrySet.iterator();
        try (PrintWriter o = new PrintWriter(new BufferedWriter(new FileWriter(file.getPath())))) {
            while (it.hasNext()) {
                HashMap.Entry pair = (HashMap.Entry) it.next();
                o.print(pair.getKey() + " : " + pair.getValue() + ";\n");
            }
        } catch (Exception e) {
            System.out.println("Error on written file");
            return false;
        }
        return true;
    }

    /**
     * This method reads the functions from file and store them.
     *
     * @param file is the File to read.
     * @return List of String of insert functions if the reading is successfull, 
     * null otherwise.
     * @throws java.io.IOException
     */
    public List<String> readFromFile(File file) throws IOException {
        List<String> functionsName = new ArrayList<>();
        try (Scanner i = new Scanner(new BufferedReader(new FileReader(file.getPath())))) {
            i.useLocale(Locale.US);
            i.useDelimiter(";\n*");
            String[] function;
            String name, operation;
            while (i.hasNext()) {
                function = i.next().split(" : ");
                name = function[0];
                operation = function[1];
                functions.put(name, operation);
                functionsName.add(name);    
            }
        } catch (Exception e) {
            System.out.println("Error on reading of file");
            functionsName = null;
        }
        if (functionsName.isEmpty()){
            return null;
        }
        return functionsName;
    }

}