/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unisa.diem.se.group07.scientificprogrammablecalculator;

import java.math.BigDecimal;

/**
 * StackComplexNumbers implements a dynamic Stack data structures 
 * with LIFO(Last In First Out) logic to do calculator operations.
 * @author DELL
 */
public class StackComplexNumbers {

    private ComplexNumbers[] array;
    private int capacity;
    private int top;
    
    /**
    * Constructs the Stack
    */
    public StackComplexNumbers() {
        capacity = 20;
        array = new ComplexNumbers[capacity];
        top = -1;
    }
    
    /**
     * This method check if the stack is empty 
     *  @return boolean that specifies if the stack is empty
    */
    public boolean isEmpty() {
        if (top == -1) {
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * This method check if the stack is full 
     *  @return boolean that specifies if the stack is full
    */
    public boolean isFull() {
        if (capacity == top + 1) {
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * This method doubles the size of the array
    */
    public void expandArray() {
        int i = 0;
        int curr_size = top + 1;
        ComplexNumbers[] new_array = new ComplexNumbers[curr_size * 2];
        for (i = 0; i < curr_size; i++) {
            new_array[i] = array[i];
        }
        array = new_array;
        capacity = new_array.length;
    }
    
    /**
     * This method reduces the size of the array
    */
    public void reduceSize() {
        int curr_length = top + 1;
        if (curr_length < capacity / 2) {
            ComplexNumbers[] new_array = new ComplexNumbers[capacity / 2];
            System.arraycopy(array, 0, new_array, 0, new_array.length);
            array = new_array;
            capacity = new_array.length;
        }
    }
    
    /**
     * This method puts the complex number on the stack; 
     * expands the stack if it is full and then inserts the number 
     * @param real Real part 
     * @param img Imaginary part
    */
    public void push(BigDecimal real, BigDecimal img) {
        if (isFull()) {
            expandArray();
        }
        array[++top] = createComplex(real, img);
    }
    
    /** 
     * This method deletes the last element inserted on the stack 
     *  @return last element in the stack that is deleted
    */
    public ComplexNumbers pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return null;
        } else {
            reduceSize();
            return array[top--];
        }
    }
    
    /**
     * This method returns the last item inserted on the stack 
     *  @return last item inserted on the stack
    */
    public ComplexNumbers top() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return null;
        } else {
            return array[top];
        }
    }
    
    /**
     * This method creates a complex number 
     *  @param real Real part  
     *  @param img Imaginary part  
     *  @return a complex number
    */
    private ComplexNumbers createComplex(BigDecimal real, BigDecimal img) {
        return new ComplexNumbers(real, img);
    }

    /**
     * Last twelve numbers pushed in the stack
     *
     * @return An array that contains the last 12 ComplexNumbers.
     */
    public String[] getLastTwelve() {
        if (this.isEmpty()) {
            return null;

        } else {
            int n = 12;
            if (top + 1 < 12) {
                n = top + 1;
            }
            String[] lastTwelve = new String[n];
            int index = top;
            for (int i = 0; i < n; i++) {
                lastTwelve[i] = array[index].toString();
                index--;
            }
            return lastTwelve;
        }
    }
    
    /**
     * This method  sum the last two stored complex numbers 
     * and save the result in the stack
     *  @return an empty string otherwise Math Error if stack has almost one element
    */
    public String sumLastTwoNumbers(){
        if (top <= 0) {
            return "Math Error";
        } else {
            ComplexNumbers num1 = this.pop();
            ComplexNumbers num2 = this.pop();
            ComplexNumbers res = num2.sum(num1);
            this.push(res.getReal(), res.getImg());
            return "";
        }
    }
    
    /**
     * This method  makes the difference of the last two stored complex numbers 
     * and save the result in the stack
     *  @return an empty string otherwise Math Error if stack has almost one element
    */
    public String differenceLastTwoNumbers(){
        if (top <= 0) {
            return "Math Error";
        } else {
            ComplexNumbers num1 = this.pop();
            ComplexNumbers num2 = this.pop();
            ComplexNumbers res = num2.difference(num1);
            this.push(res.getReal(), res.getImg());
            return "";
        }
    }
    
    /**
     * This method  multiplies the last two stored complex numbers 
     * and save the result in the stack
     *  @return an empty string otherwise Math Error if stack has almost one element
    */
    public String productLastTwoNumbers(){
        if (top <= 0) {
            return "Math Error";
        } else {
            ComplexNumbers num1 = this.pop();
            ComplexNumbers num2 = this.pop();
            ComplexNumbers res = num2.product(num1);
            this.push(res.getReal(), res.getImg());
            return "";
        }
    }
    
}
