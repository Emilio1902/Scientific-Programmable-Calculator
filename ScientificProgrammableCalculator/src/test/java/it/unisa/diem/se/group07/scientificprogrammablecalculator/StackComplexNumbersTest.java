/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package it.unisa.diem.se.group07.scientificprogrammablecalculator;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.*;

/**
 *
 * @author DELL
 */
public class StackComplexNumbersTest {

    private StackComplexNumbers stack;

    @Before
    public void setUp() {
        stack = new StackComplexNumbers();
    }

    /**
     * Test of pop method, of class StackComplexNumbers.
     */
    @Test
    public void testPop() {
        //test for empty stack
        StackComplexNumbers stackP = new StackComplexNumbers();
        ComplexNumbers n = stackP.pop();
        assertEquals(null, n);
        
        
        //test for stack with inserted numbers
        stack.push(2.6, 7.1);
        stack.push(8.3, 3.5);
        ComplexNumbers num = stack.pop();
        assertEquals(8.3, num.getReal());
        assertEquals(3.5, num.getImg());
    }
    

    /**
     * Test of top method, of class StackComplexNumbers.
     */
    @Test
    public void testTop() {
        //test for empty stack
        StackComplexNumbers stackT = new StackComplexNumbers();
        ComplexNumbers n = stackT.top();
        assertEquals(null, n);
        
        //test for stack with inserted numbers
        stack.push(2.6, 7.1);
        stack.push(8.3, 3.5);
        ComplexNumbers num = stack.top();
        assertEquals(8.3, num.getReal());
        assertEquals(3.5, num.getImg());

    }
   

    /**
     * Test of getLastTwelve method, of class StackComplexNumbers.
     */
    @Test
    public void testGetLastTwelve() {
        int i, dim1=20, dim2 = 5;
        //test for empty stack
        ComplexNumbers[] array;
        array = stack.getLastTwelve();
        assertEquals(null, array);

        //test for a stack with more than 12 numbers
        StackComplexNumbers stack1 = new StackComplexNumbers();
        for (i = 0; i < dim1; i++) {
            stack1.push(i, i);
        }
        ComplexNumbers[] array1;
        array1 = stack1.getLastTwelve();
        assertEquals(12, array1.length);
        for (i = 0; i < 12; i++) {
            assertEquals(Double.valueOf(dim1-1- i), array1[i].getReal());
            assertEquals(Double.valueOf(dim1-1-i), array1[i].getImg());
        }

        //test for a stacks with fewer than 12 numbers
        StackComplexNumbers stack2 = new StackComplexNumbers();
        for (i = 0; i < dim2; i++) {
            stack2.push(i, i);
        }
        ComplexNumbers[] array2;
        array2 = stack2.getLastTwelve();
        assertEquals(5, array2.length);
        for (i = 0; i < 5; i++) {
            assertEquals(Double.valueOf(dim2-1-i), array2[i].getReal());
            assertEquals(Double.valueOf(dim2-1-i), array2[i].getImg());
        }

    }

}
