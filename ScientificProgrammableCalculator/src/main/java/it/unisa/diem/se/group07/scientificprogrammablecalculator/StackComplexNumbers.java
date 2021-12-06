/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unisa.diem.se.group07.scientificprogrammablecalculator;

import java.util.Arrays;

/**
 * StackComplexNumbers implements a dynamic Stack data structures with LIFO(Last
 * In First Out) logic to do calculator operations.
 *
 * @author DELL
 */
public class StackComplexNumbers {

    private ComplexNumbers[] array;
    private static int capacity = 20;
    private int top;

    /**
     * Constructs the memory that contains the stored complex numbers in a stack
     * data structure
     */
    public StackComplexNumbers() {
        array = new ComplexNumbers[capacity];
        top = -1;
    }

    /**
     * This method check if the stack is empty
     *
     * @return boolean that specifies if the stack is empty
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
     *
     * @return boolean that specifies if the stack is full
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
     * This method puts the complex number on the stack; expands the stack if it
     * is full and then inserts the number
     *
     * @param real Real part
     * @param img Imaginary part
     */
    public void push(double real, double img) {
        if (isFull()) {
            expandArray();
        }
        array[++top] = createComplex(real, img);
    }

    /**
     * This method deletes the last element inserted on the stack
     *
     * @return last element in the stack that is deleted
     */
    public ComplexNumbers pop() {
        if (isEmpty()) {
            return null;
        } else {
            reduceSize();
            return array[top--];
        }
    }

    /**
     * This method returns the last item inserted on the stack
     *
     * @return last item inserted on the stack
     */
    public ComplexNumbers top() {
        if (isEmpty()) {
            return null;
        } else {
            return array[top];
        }
    }

    /**
     * This method creates a complex number
     *
     * @param real Real part
     * @param img Imaginary part
     * @return a complex number
     */
    private ComplexNumbers createComplex(double real, double img) {
        return new ComplexNumbers(real, img);
    }

    /**
     * Last twelve numbers pushed in the stack
     *
     * @return An array that contains the last 12 ComplexNumbers.
     */
    public String[] getLastTwelve() {
        if (this.isEmpty()) {
            String[] s = {};
            return s;

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
     * This method sum the last two stored complex numbers and save the result
     * in the stack
     *
     * @return false if stack has at most one element, true otherwise
     */
    public boolean sumLastTwoNumbers() {
        if (top <= 0) {
            return false;
        } else {
            ComplexNumbers num1 = this.pop();
            ComplexNumbers num2 = this.pop();
            ComplexNumbers res = num2.sum(num1);
            this.push(res.getReal(), res.getImg());
            return true;
        }
    }

    /**
     * This method makes the difference of the last two stored complex numbers
     * and save the result in the stack
     *
     * @return false if stack has at most one element, true otherwise
     */
    public boolean differenceLastTwoNumbers() {
        if (top <= 0) {
            return false;
        } else {
            ComplexNumbers num1 = this.pop();
            ComplexNumbers num2 = this.pop();
            ComplexNumbers res = num2.difference(num1);
            this.push(res.getReal(), res.getImg());
            return true;
        }
    }

    /**
     * This method multiplies the last two stored complex numbers and save the
     * result in the stack
     *
     * @return false if stack has at most one element, true otherwise
     */
    public boolean productLastTwoNumbers() {
        if (top <= 0) {
            return false;
        } else {
            ComplexNumbers num1 = this.pop();
            ComplexNumbers num2 = this.pop();
            ComplexNumbers res = num2.product(num1);
            this.push(res.getReal(), res.getImg());
            return true;
        }
    }

    /**
     * This method divides the last two stored complex numbers and save the
     * result in the stack
     *
     * @return false if stack has at most one element, true otherwise
     */
    public boolean ratioLastTwoNumbers() {
        if (top <= 0) {
            return false;
        } else {
            ComplexNumbers num1 = this.pop();
            ComplexNumbers num2 = this.pop();
            ComplexNumbers res = num2.ratio(num1);

            this.push(res.getReal(), res.getImg());
            return true;
        }
    }


/**
 * This method takes the square root of the last stored complex number and save
 * the result in the stack
 *
 * @return false if stack has zero element, true otherwise
 */
public boolean squareRootLastNumber(){
        if (top == -1) {
            return false;
        } else {
            ComplexNumbers num1 = this.pop();
            ComplexNumbers res = num1.squareRoot();
            this.push(res.getReal(), res.getImg());
            return true;
        }
    }
    
    
    /**
     * This method inverted the sign (real and imaginary part) 
     * of the last stored complex number and save the result in the stack
     *  @return false if stack has zero element, true otherwise
    */
    
    public boolean invertSignLastNumber(){
        if (top == -1) {
            return false;
        } else {
            ComplexNumbers num1 = this.pop();
            ComplexNumbers res = num1.invertSign();
            this.push(res.getReal(), res.getImg());
            return true;
        }
    }
    
    
    /**
     * This method drop the last stored complex number 
     * 
     * @return false if stack is empty, true otherwise
    */
    public boolean dropLastNumber(){
        if(top < 0){
            return false;
        } else{
            this.pop();
            return true;
        }
    }
    
    /**
     * This method swap the last two stored complex numbers 
     * 
     * @return false if stack has at most one element, true otherwise
    */
    
    public boolean swapLastTwoNumbers(){
        if(top <= 0){
            return false;
        } else{
            ComplexNumbers n1 = this.pop();
            ComplexNumbers n2 = this.pop();
            this.push(n1.getReal(), n1.getImg());
            this.push(n2.getReal(), n2.getImg());
            return true;
        }
    }
    
    /**
     * This method deletes all stored complex numbers
     */
    public void clear(){
        Arrays.fill(array, null);
        top = -1;
    }
    
    /**
     * This method copies the last stored complex number and places it in memory
     *  @return false if stack has zero element, true otherwise
     */
    public boolean dupLastNumber(){
        if (top == -1) {
            return false;
        } else {
            ComplexNumbers n = this.top();
            this.push(n.getReal(), n.getImg());
            return true;
        }
    }
    
    /**
     * This method copies the second last stored complex number 
     * and places it in memory
     *  @return false if stack has at most one element, true otherwise
     */
    public boolean dupSecondLastNumber(){
        if (top <= 0) {
            return false;
        } else {
            ComplexNumbers n = this.pop();
            ComplexNumbers n1 = this.top();
            this.push(n.getReal(), n.getImg());
            this.push(n1.getReal(), n1.getImg());
            return true;
        }
    }
    
    /**
     * This method makes the modulus of the last stored complex number 
     * and save the result in the stack
     *  @return false if stack has zero element, true otherwise
    */
    public boolean modLastNumber(){
        if (top == -1) {
            return false;
        } else {
            ComplexNumbers num1 = this.pop();
            double res = num1.mod();
            this.push(res, 0.0);
            return true;
        }
    }
    
    /**
     * This method makes the arguments of the last stored complex number 
     * and save the result in the stack
     *  @return false if stack has zero element, true otherwise
    */
    public boolean argLastNumber(){
        if (top == -1) {
            return false;
        } else {
            ComplexNumbers num1 = this.pop();
            double res = num1.arg();
            this.push(res, 0.0);
            return true;
        }
    }
    
    /**
     * This method takes the logarithm of the last stored complex number 
     * and save the result in the stack
     *  @return false if stack has zero element, true otherwise
    */
    public boolean logLastNumber(){
        if (top == -1) {
            return false;
        } else {
            ComplexNumbers num1 = this.pop();
            ComplexNumbers res = num1.log();
            this.push(res.getReal(), res.getImg());
            return true;
        }
    }
    
    /**
     * This method makes the exponent of the last stored complex number 
     * and save the result in the stack
     *  @return false if stack has zero element, true otherwise
    */
    public boolean expLastNumber(){
        if (top == -1) {
            return false;
        } else {
            ComplexNumbers num1 = this.pop();
            ComplexNumbers res = num1.exp();
            this.push(res.getReal(), res.getImg());
            return true;
        }
    }
    
}
