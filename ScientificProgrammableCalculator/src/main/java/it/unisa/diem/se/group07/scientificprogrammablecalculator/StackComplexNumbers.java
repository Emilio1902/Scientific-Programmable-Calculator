/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unisa.diem.se.group07.scientificprogrammablecalculator;

/**
 *
 * @author DELL
 */
public class StackComplexNumbers {

    private ComplexNumbers[] array;
    private int capacity;
    private int top;

    public StackComplexNumbers() {
        capacity = 20;
        array = new ComplexNumbers[capacity];
        top = -1;
    }

    public boolean isEmpty() {
        if (top == -1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isFull() {
        if (capacity == top + 1) {
            return true;
        } else {
            return false;
        }
    }

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

    public void reduceSize() {
        int curr_length = top + 1;
        if (curr_length < capacity / 2) {
            ComplexNumbers[] new_array = new ComplexNumbers[capacity / 2];
            System.arraycopy(array, 0, new_array, 0, new_array.length);
            array = new_array;
            capacity = new_array.length;
        }
    }

    public void push(double a, double b) {
        if (isFull()) {
            expandArray();
        }
        array[++top] = createComplex(a, b);
    }

    public ComplexNumbers pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return null;
        } else {
            reduceSize();
            return array[top--];
        }
    }

    public ComplexNumbers top() {
        return array[top];
    }

    private ComplexNumbers createComplex(double a, double b) {
        return new ComplexNumbers(a, b);
    }

    /**
     * Last twelve numbers pushed in the stack
     *
     * @return An array that contains the last 12 ComplexNumbers.
     */
    public ComplexNumbers[] getLastTwelve() {
        if (this.isEmpty()) {
            return null;

        } else {
            int n = 12;
            if (top + 1 < 12) {
                n = top + 1;
            }
            ComplexNumbers[] lastTwelve = new ComplexNumbers[n];
            int index = top;
            for (int i = 0; i < n; i++) {
                lastTwelve[i] = array[index];
                index--;
            }
            return lastTwelve;
        }
    }

}
