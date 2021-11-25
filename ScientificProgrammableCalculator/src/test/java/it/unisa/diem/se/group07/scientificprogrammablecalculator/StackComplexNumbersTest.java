/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package it.unisa.diem.se.group07.scientificprogrammablecalculator;

import java.math.BigDecimal;
import static org.hamcrest.MatcherAssert.assertThat;
import org.hamcrest.Matchers;
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
        stack.push(BigDecimal.valueOf(2.6), BigDecimal.valueOf(7.1));
        stack.push(BigDecimal.valueOf(8.3), BigDecimal.valueOf(3.5));
        ComplexNumbers num = stack.pop();
        assertThat(BigDecimal.valueOf(8.3), Matchers.comparesEqualTo(num.getReal()));
        assertThat(BigDecimal.valueOf(3.5), Matchers.comparesEqualTo(num.getImg()));
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
        stack.push(BigDecimal.valueOf(2.6), BigDecimal.valueOf(7.1));
        stack.push(BigDecimal.valueOf(8.3), BigDecimal.valueOf(3.5));
        ComplexNumbers num = stack.top();
        assertThat(BigDecimal.valueOf(8.3), Matchers.comparesEqualTo(num.getReal()));
        assertThat(BigDecimal.valueOf(3.5), Matchers.comparesEqualTo(num.getImg()));

    }

    /**
     * Test of push method, of class StackComplexNumbers.
     */
    @Test
    public void testPush() {
        stack.push(BigDecimal.valueOf(14.8), BigDecimal.valueOf(37.1));
        ComplexNumbers num = stack.top();
        assertThat(BigDecimal.valueOf(14.8), Matchers.comparesEqualTo(num.getReal()));
        assertThat(BigDecimal.valueOf(37.1), Matchers.comparesEqualTo(num.getImg()));
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
            stack1.push(BigDecimal.valueOf(i), BigDecimal.valueOf(i));
        }
        
        String[] array1;
        array1 = stack1.getLastTwelve();
        assertEquals(12, array1.length);

        for (i = 0; i < 12; i++) {
            assertEquals(String.valueOf(dim1 - 1 - i)  + "+" + String.valueOf(dim1 - 1 - i)  + "i", array1[i]);
        }

        //test for a stacks with fewer than 12 numbers
        StackComplexNumbers stack2 = new StackComplexNumbers();
        for (i = 0; i < dim2; i++) {
            stack2.push(BigDecimal.valueOf(i), BigDecimal.valueOf(i));
        }
        String[] array2;
        array2 = stack2.getLastTwelve();
        assertEquals(5, array2.length);
        for (i = 0; i < 5; i++) {
            assertEquals(String.valueOf(dim1 - 1 - i) + "+" + String.valueOf(dim1 - 1 - i) + "i", array1[i]);
        }
    }

    /**
     * Test of sumLastTwoNumbers method, of class StackComplexNumbers.
     */
    @Test
    public void testSumLastTwoNumbers() {
        stack.push(BigDecimal.valueOf(21.5), BigDecimal.valueOf(13.1));
        stack.push(BigDecimal.valueOf(3.5), BigDecimal.valueOf(2.4));
        stack.sumLastTwoNumbers();
        ComplexNumbers num = stack.top();
        assertThat(BigDecimal.valueOf(25.0), Matchers.comparesEqualTo(num.getReal()));
        assertThat(BigDecimal.valueOf(15.5), Matchers.comparesEqualTo(num.getImg()));

        stack.push(BigDecimal.valueOf(14.2), BigDecimal.valueOf(-19.7));
        stack.push(BigDecimal.valueOf(0.0), BigDecimal.valueOf(6.6));
        stack.sumLastTwoNumbers();
        ComplexNumbers num1 = stack.top();
        assertThat(BigDecimal.valueOf(14.2), Matchers.comparesEqualTo(num1.getReal()));
        assertThat(BigDecimal.valueOf(-13.1), Matchers.comparesEqualTo(num1.getImg()));

        stack.push(BigDecimal.valueOf(0), BigDecimal.valueOf(-16));
        stack.push(BigDecimal.valueOf(-1.36), BigDecimal.valueOf(1));
        stack.sumLastTwoNumbers();
        ComplexNumbers num2 = stack.top();
        assertThat(BigDecimal.valueOf(-1.36), Matchers.comparesEqualTo(num2.getReal()));
        assertThat(BigDecimal.valueOf(-15.0), Matchers.comparesEqualTo(num2.getImg()));

        stack.push(BigDecimal.valueOf(17.1), BigDecimal.valueOf(2.345));
        stack.push(BigDecimal.valueOf(12.25), BigDecimal.valueOf(1.871));
        stack.sumLastTwoNumbers();
        ComplexNumbers num3 = stack.top();
        assertThat(BigDecimal.valueOf(29.35), Matchers.comparesEqualTo(num3.getReal()));
        assertThat(BigDecimal.valueOf(4.216), Matchers.comparesEqualTo(num3.getImg()));

    }

}
