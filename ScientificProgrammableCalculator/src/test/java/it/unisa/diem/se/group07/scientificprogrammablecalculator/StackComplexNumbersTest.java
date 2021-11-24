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
     * Test of push method, of class StackComplexNumbers.
     */
    @Test
    public void testPush() {
        stack.push(14.8, 37.1);
        assertEquals(14.8, stack.top().getReal());
        assertEquals(37.1, stack.top().getImg());
    }

    /**
     * Test of getLastTwelve method, of class StackComplexNumbers.
     */
    @Test
    public void testGetLastTwelve() {
        int i, dim1 = 20, dim2 = 5;
        //test for empty stack
        String[] array;
        array = stack.getLastTwelve();
        assertEquals(null, array);

        //test for a stack with more than 12 numbers
        StackComplexNumbers stack1 = new StackComplexNumbers();
        for (i = 0; i < dim1; i++) {
            stack1.push(i, i);
        }
        
        String[] array1;
        array1 = stack1.getLastTwelve();
        assertEquals(12, array1.length);

        for (i = 0; i < 12; i++) {
            assertEquals(String.valueOf(dim1 - 1 - i) + ".0" + "+" + String.valueOf(dim1 - 1 - i) + ".0" + "i", array1[i]);
        }

        //test for a stacks with fewer than 12 numbers
        StackComplexNumbers stack2 = new StackComplexNumbers();
        for (i = 0; i < dim2; i++) {
            stack2.push(i, i);
        }
        String[] array2;
        array2 = stack2.getLastTwelve();
        assertEquals(5, array2.length);
        for (i = 0; i < 5; i++) {
            assertEquals(String.valueOf(dim1 - 1 - i) + ".0" + "+" + String.valueOf(dim1 - 1 - i) + ".0" + "i", array1[i]);
        }
    }

    /**
     * Test of sumLastTwoNumbers method, of class StackComplexNumbers.
     */
    @Test
    public void testSumLastTwoNumbers() {
        stack.push(21.5, 13.1);
        stack.push(3.5, 2.4);
        stack.sumLastTwoNumbers();
        assertEquals(25.0, stack.top().getReal());
        assertEquals(15.5, stack.top().getImg());

        stack.push(14.2, -19.7);
        stack.push(0.0, 6.6);
        stack.sumLastTwoNumbers();
        assertEquals(14.2, stack.top().getReal());
        assertEquals(-13.1, stack.top().getImg());

        stack.push(0, -16);
        stack.push(-1.36, 1);
        stack.sumLastTwoNumbers();
        assertEquals(-1.36, stack.top().getReal());
        assertEquals(-15.0, stack.top().getImg());

        stack.push(17.1, 2.345);
        stack.push(12.25, 1.871);
        stack.sumLastTwoNumbers();
        assertEquals(29.35, stack.top().getReal());
        assertEquals(4.216, stack.top().getImg());

    }

}
