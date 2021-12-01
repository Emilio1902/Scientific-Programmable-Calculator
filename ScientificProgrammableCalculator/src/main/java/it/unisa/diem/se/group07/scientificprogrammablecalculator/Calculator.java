/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.se.group07.scientificprogrammablecalculator;

import java.math.BigDecimal;

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
     * Constructs the string to pass to the calculator and checks 
     * math operations.
     *
     * @param s String to pass to the calculator
     * @return "" if the string format is correct otherwise "Syntax Error" if
     * the string format is incorrect
     */
    public String checkMathOperations(String s) {

        if (s.compareTo("") == 0) {
            return "";
        } 
        
        if (s.compareTo("+") == 0) {
            return memory.sumLastTwoNumbers() == true ? "" : "Math Error";
        } 
        
        if (s.compareTo("-") == 0) {
            return memory.differenceLastTwoNumbers() == true ? "" : "Math Error";
        } 
        
        if (s.compareTo("*") == 0) {
            return memory.productLastTwoNumbers() == true ? "" : "Math Error";
        } 
        
        if (s.compareTo("/") == 0) {
            return memory.ratioLastTwoNumbers() == true ? "" : "Math Error";
        }
        
        if (s.compareTo("√") == 0) {
            return memory.squareRootLastNumber() == true ? "" : "Math Error";
        }
        
        if (s.compareTo("+-") == 0) {
            return memory.invertSignLastNumber() == true ? "" : "Math Error";
        }
     
        
        else {

            ComplexNumbers num = new ComplexNumbers(s);
            
            if (num.getReal()!=Double.NEGATIVE_INFINITY) {
                memory.push(num.getReal(), num.getImg());
                return "";
            } else {
                return "Syntax Error";
            }

        }
    }
    
    /**
     * Constructs the string to pass to the calculator and checks 
     * memory operations.
     *
     * @param s String to pass to the calculator
     * @return "" if the string format is correct otherwise "Syntax Error" if
     * the string format is incorrect
     */
     public String checkMemoryOperations(String s) {
 
        
        if (s.compareTo("clear") == 0) {
            memory.clear();
            return "";
        } 
        
        if (s.compareTo("drop") == 0) {
            return memory.dropLastNumber() == true ? "" : "Few Arguments";
        }
         
        if (s.compareTo("dup") == 0) {
            return memory.dupLastNumber() == true ? "" : "Few Arguments";
        }
          
        if (s.compareTo("swap") == 0) {
            return memory.swapLastTwoNumbers() == true ? "" : "Few Arguments";
        }
           
        if (s.compareTo("over") == 0) {
            return memory.dupSecondLastNumber() == true ? "" : "Few Arguments";
        }
        
        else {
                return "Syntax Error";
            }

    }

    /**
     * Returns the last twelve numbers in the stack memory.
     * 
     * @return the last twelve numbers in the stack memory
     */
    public String[] lastTwelveNumbers() {
        return memory.getLastTwelve();
    }

}
