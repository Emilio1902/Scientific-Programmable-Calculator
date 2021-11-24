/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.se.group07.scientificprogrammablecalculator;

/**
 * Calculator implements a calculator
 *
 * @author Diego Fileno
 */
public class Calculator {

    private StackComplexNumbers memory;

    /**
     * Constructs the stack memory of the calculator
     */
    public Calculator() {
        memory = new StackComplexNumbers();
    }

    /**
     * Constructs the string to pass to the calculator
     *
     * @param s String to pass to the calculator
     * @return "" if the string format is correct
     * @return "Syntax Error" if the string format is incorrect
     */
    public String checkOperations(String s) {
        ComplexNumbers num = null;
        num = num.StringToComplex(s);

        if (num != null) {
            memory.push(num.getReal(), num.getImg());
            return "";
        } else {
            return "Syntax Error";
        }
    }

}
