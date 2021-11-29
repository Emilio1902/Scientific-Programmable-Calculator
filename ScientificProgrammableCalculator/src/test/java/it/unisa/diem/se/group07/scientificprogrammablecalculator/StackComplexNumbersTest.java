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
        ComplexNumbers n = stack.pop();
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
        ComplexNumbers n = stack.top();
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
        assertEquals(0, array.length);

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
        //test for empty stack
        boolean n = stack.sumLastTwoNumbers();
        assertEquals(false, n);
        
        //test with 1 element in the stack
        StackComplexNumbers stackT1 = new StackComplexNumbers();
        stackT1.push(BigDecimal.valueOf(21.5), BigDecimal.valueOf(13.1));
        stackT1.sumLastTwoNumbers();
        boolean n1 = stackT1.sumLastTwoNumbers();
        assertEquals(false, n1);
        
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

        stack.push(BigDecimal.valueOf(0), BigDecimal.valueOf(-13.9));
        stack.push(BigDecimal.valueOf(-1.36), BigDecimal.valueOf(1));
        stack.sumLastTwoNumbers();
        ComplexNumbers num2 = stack.top();
        assertThat(BigDecimal.valueOf(-1.36), Matchers.comparesEqualTo(num2.getReal()));
        assertThat(BigDecimal.valueOf(-12.9), Matchers.comparesEqualTo(num2.getImg()));

        stack.push(BigDecimal.valueOf(-73.1), BigDecimal.valueOf(-62.28));
        stack.push(BigDecimal.valueOf(-36.0), BigDecimal.valueOf(1.8));
        stack.sumLastTwoNumbers();
        ComplexNumbers num3 = stack.top();
        assertThat(BigDecimal.valueOf(-109.1), Matchers.comparesEqualTo(num3.getReal()));
        assertThat(BigDecimal.valueOf(-60.48), Matchers.comparesEqualTo(num3.getImg()));

    }
    
    /**
     * Test of differenceLastTwoNumbers method, of class StackComplexNumbers.
     */
    @Test
    public void testDifferenceLastTwoNumbers() {
        //test for empty stack
        boolean n = stack.differenceLastTwoNumbers();
        assertEquals(false, n);
        
        //test with 1 element in the stack
        StackComplexNumbers stackT1 = new StackComplexNumbers();
        stackT1.push(BigDecimal.valueOf(21.5), BigDecimal.valueOf(13.1));
        stackT1.differenceLastTwoNumbers();
        boolean n1 = stackT1.differenceLastTwoNumbers();
        assertEquals(false, n1);
        
        stack.push(BigDecimal.valueOf(39.56), BigDecimal.valueOf(13.2));
        stack.push(BigDecimal.valueOf(47.3), BigDecimal.valueOf(2.4));
        stack.differenceLastTwoNumbers();
        ComplexNumbers num = stack.top();
        assertThat(BigDecimal.valueOf(-7.74), Matchers.comparesEqualTo(num.getReal()));
        assertThat(BigDecimal.valueOf(10.8), Matchers.comparesEqualTo(num.getImg()));

        stack.push(BigDecimal.valueOf(23.6), BigDecimal.valueOf(-11.1));
        stack.push(BigDecimal.valueOf(0.0), BigDecimal.valueOf(48.29));
        stack.differenceLastTwoNumbers();
        ComplexNumbers num1 = stack.top();
        assertThat(BigDecimal.valueOf(23.6), Matchers.comparesEqualTo(num1.getReal()));
        assertThat(BigDecimal.valueOf(-59.39), Matchers.comparesEqualTo(num1.getImg()));

        stack.push(BigDecimal.valueOf(0), BigDecimal.valueOf(-16));
        stack.push(BigDecimal.valueOf(-79.24), BigDecimal.valueOf(1));
        stack.differenceLastTwoNumbers();
        ComplexNumbers num2 = stack.top();
        assertThat(BigDecimal.valueOf(79.24), Matchers.comparesEqualTo(num2.getReal()));
        assertThat(BigDecimal.valueOf(-17.0), Matchers.comparesEqualTo(num2.getImg()));

        stack.push(BigDecimal.valueOf(-99.1), BigDecimal.valueOf(-2.345));
        stack.push(BigDecimal.valueOf(-12.25), BigDecimal.valueOf(-18.871));
        stack.differenceLastTwoNumbers();
        ComplexNumbers num3 = stack.top();
        assertThat(BigDecimal.valueOf(-86.85), Matchers.comparesEqualTo(num3.getReal()));
        assertThat(BigDecimal.valueOf(16.526), Matchers.comparesEqualTo(num3.getImg()));

    }
    
    /**
     * Test of productLastTwoNumbers method, of class StackComplexNumbers.
     * The result of the multiplication expects a maximum of 4 decimal digits rounded up, 
     * for the implementation of the method in ComplexNumbers class.
     */
    @Test
    public void testProductLastTwoNumbers() {
        //test for empty stack
        boolean n = stack.productLastTwoNumbers();
        assertEquals(false, n);
        
        //test with 1 element in the stack
        StackComplexNumbers stackT1 = new StackComplexNumbers();
        stackT1.push(BigDecimal.valueOf(21.5), BigDecimal.valueOf(13.1));
        stackT1.productLastTwoNumbers();
        boolean n1 = stackT1.productLastTwoNumbers();
        assertEquals(false, n1);
        
        stack.push(BigDecimal.valueOf(2.8), BigDecimal.valueOf(28.41));
        stack.push(BigDecimal.valueOf(4.6), BigDecimal.valueOf(10.0));
        stack.productLastTwoNumbers();
        ComplexNumbers num = stack.top();
        assertThat(BigDecimal.valueOf(-271.22), Matchers.comparesEqualTo(num.getReal()));
        assertThat(BigDecimal.valueOf(158.686), Matchers.comparesEqualTo(num.getImg()));

        stack.push(BigDecimal.valueOf(2.9), BigDecimal.valueOf(-22.89));
        stack.push(BigDecimal.valueOf(0.0), BigDecimal.valueOf(4.8));
        stack.productLastTwoNumbers();
        ComplexNumbers num1 = stack.top();
        assertThat(BigDecimal.valueOf(109.872), Matchers.comparesEqualTo(num1.getReal()));
        assertThat(BigDecimal.valueOf(13.92), Matchers.comparesEqualTo(num1.getImg()));

        stack.push(BigDecimal.valueOf(0.0), BigDecimal.valueOf(0.0));
        stack.push(BigDecimal.valueOf(-5.61), BigDecimal.valueOf(1));
        stack.productLastTwoNumbers();
        ComplexNumbers num2 = stack.top();
        assertThat(BigDecimal.valueOf(-0), Matchers.comparesEqualTo(num2.getReal()));
        assertThat(BigDecimal.valueOf(0), Matchers.comparesEqualTo(num2.getImg()));

        stack.push(BigDecimal.valueOf(-45.123), BigDecimal.valueOf(-1.1));
        stack.push(BigDecimal.valueOf(-2.0), BigDecimal.valueOf(-73.8));
        stack.productLastTwoNumbers();
        ComplexNumbers num3 = stack.top();
        assertThat(BigDecimal.valueOf(9.066), Matchers.comparesEqualTo(num3.getReal()));
        assertThat(BigDecimal.valueOf(3332.2774), Matchers.comparesEqualTo(num3.getImg()));
        
        stack.push(BigDecimal.valueOf(25.9), BigDecimal.valueOf(-3.871));
        stack.push(BigDecimal.valueOf(-5.274), BigDecimal.valueOf(-1.29));
        stack.productLastTwoNumbers();
        ComplexNumbers num4 = stack.top();
        assertThat(BigDecimal.valueOf(-141.5902), Matchers.comparesEqualTo(num4.getReal()));
        assertThat(BigDecimal.valueOf(-12.9954), Matchers.comparesEqualTo(num4.getImg()));

    }
   
    /**
     * Test of ratioLastTwoNumbers method, of class StackComplexNumbers.
     * The result of the division expects a maximum of 4 decimal digits rounded up, 
     * for the implementation of the method in ComplexNumbers class.
     */
    @Test
    public void testRatioLastTwoNumbers() {
        //test for empty stack
        boolean n = stack.ratioLastTwoNumbers();
        assertEquals(false, n);
        
        //test with 1 element in the stack
        StackComplexNumbers stackT1 = new StackComplexNumbers();
        stackT1.push(BigDecimal.valueOf(21.5), BigDecimal.valueOf(13.1));
        boolean n1 = stackT1.ratioLastTwoNumbers();
        assertEquals(false, n1);
        
        stack.push(BigDecimal.valueOf(5.9), BigDecimal.valueOf(66.8));
        stack.push(BigDecimal.valueOf(1.9), BigDecimal.valueOf(10.0));
        stack.ratioLastTwoNumbers();
        ComplexNumbers num = stack.top();
        assertThat(BigDecimal.valueOf(6.5554), Matchers.comparesEqualTo(num.getReal()));
        assertThat(BigDecimal.valueOf(0.6555), Matchers.comparesEqualTo(num.getImg()));

        stack.push(BigDecimal.valueOf(19.45), BigDecimal.valueOf(-57.156));
        stack.push(BigDecimal.valueOf(0.0), BigDecimal.valueOf(3.4));
        stack.ratioLastTwoNumbers();
        ComplexNumbers num1 = stack.top();
        assertThat(BigDecimal.valueOf(-16.8106), Matchers.comparesEqualTo(num1.getReal()));
        assertThat(BigDecimal.valueOf(-5.7206), Matchers.comparesEqualTo(num1.getImg()));

        stack.push(BigDecimal.valueOf(0.0), BigDecimal.valueOf(0.0));
        stack.push(BigDecimal.valueOf(-4.7), BigDecimal.valueOf(1));
        stack.ratioLastTwoNumbers();
        ComplexNumbers num2 = stack.top();
        assertThat(BigDecimal.valueOf(-0), Matchers.comparesEqualTo(num2.getReal()));
        assertThat(BigDecimal.valueOf(-0), Matchers.comparesEqualTo(num2.getImg()));

        stack.push(BigDecimal.valueOf(-23.897), BigDecimal.valueOf(-1.8));
        stack.push(BigDecimal.valueOf(-6.0), BigDecimal.valueOf(-1.0));
        stack.ratioLastTwoNumbers();
        ComplexNumbers num3 = stack.top();
        assertThat(BigDecimal.valueOf(3.9238), Matchers.comparesEqualTo(num3.getReal()));
        assertThat(BigDecimal.valueOf(-0.354), Matchers.comparesEqualTo(num3.getImg()));
        
        stack.push(BigDecimal.valueOf(42.9), BigDecimal.valueOf(-3.9));
        stack.push(BigDecimal.valueOf(-2.2), BigDecimal.valueOf(-3.8));
        stack.ratioLastTwoNumbers();
        ComplexNumbers num4 = stack.top();
        assertThat(BigDecimal.valueOf(-4.1266), Matchers.comparesEqualTo(num4.getReal()));
        assertThat(BigDecimal.valueOf(+8.9004), Matchers.comparesEqualTo(num4.getImg()));
        
        stack.push(BigDecimal.valueOf(73.8), BigDecimal.valueOf(2.6));
        stack.push(BigDecimal.valueOf(0.0), BigDecimal.valueOf(0.0));
        boolean n5 = stack.ratioLastTwoNumbers();
        assertEquals(false, n5);
        
        stack.push(BigDecimal.valueOf(23.6), BigDecimal.valueOf(2.5));
        stack.push(BigDecimal.valueOf(13.0), BigDecimal.valueOf(0.0));
        stack.ratioLastTwoNumbers();
        ComplexNumbers num6 = stack.top();
        assertThat(BigDecimal.valueOf(1.8154), Matchers.comparesEqualTo(num6.getReal()));
        assertThat(BigDecimal.valueOf(0.1923), Matchers.comparesEqualTo(num6.getImg()));
        
        stack.push(BigDecimal.valueOf(-6.2), BigDecimal.valueOf(6.2));
        stack.push(BigDecimal.valueOf(3.1), BigDecimal.valueOf(3.1));
        stack.ratioLastTwoNumbers();
        ComplexNumbers num7 = stack.top();
        assertThat(BigDecimal.valueOf(0), Matchers.comparesEqualTo(num7.getReal()));
        assertThat(BigDecimal.valueOf(2), Matchers.comparesEqualTo(num7.getImg()));

    }
    
    /**
     * Test of squareRootLastNumber method, of class StackComplexNumbers.
     * The result of the square root expects a maximum of 4 decimal digits rounded down, 
     * for the implementation of the method in ComplexNumbers class.
     */
    @Test
    public void testSquareRootLastNumber() {
        //test for empty stack
        boolean n = stack.squareRootLastNumber();
        assertEquals(false, n);
        
        stack.push(BigDecimal.valueOf(5.67), BigDecimal.valueOf(48.1));
        stack.push(BigDecimal.valueOf(6.31), BigDecimal.valueOf(39.443));
        stack.squareRootLastNumber();
        ComplexNumbers num = stack.top();
        assertThat(BigDecimal.valueOf(4.8090), Matchers.comparesEqualTo(num.getReal()));

        stack.push(BigDecimal.valueOf(0.0), BigDecimal.valueOf(15.39));
        stack.squareRootLastNumber();
        ComplexNumbers num1 = stack.top();
        assertThat(BigDecimal.valueOf(2.7739), Matchers.comparesEqualTo(num1.getReal()));

        stack.push(BigDecimal.valueOf(0.0), BigDecimal.valueOf(0.0));
        stack.squareRootLastNumber();
        ComplexNumbers num2 = stack.top();
        assertThat(BigDecimal.valueOf(0), Matchers.comparesEqualTo(num2.getReal()));

        stack.push(BigDecimal.valueOf(-36.41), BigDecimal.valueOf(-1.95));
        stack.squareRootLastNumber();
        ComplexNumbers num3 = stack.top();
        assertThat(BigDecimal.valueOf(-0.1614), Matchers.comparesEqualTo(num3.getReal()));
        
        stack.push(BigDecimal.valueOf(59.3), BigDecimal.valueOf(-22.56));
        stack.squareRootLastNumber();
        ComplexNumbers num4 = stack.top();
        assertThat(BigDecimal.valueOf( -7.8340), Matchers.comparesEqualTo(num4.getReal()));

    }
    
    /**
     * Test of invertSignLastNumber method, of class StackComplexNumbers.
     */
    @Test
    public void testInvertSignLastNumber() {
        //test for empty stack
        boolean n = stack.invertSignLastNumber();
        assertEquals(false, n);
        
        stack.push(BigDecimal.valueOf(4.65), BigDecimal.valueOf(1.5));
        stack.push(BigDecimal.valueOf(17.593), BigDecimal.valueOf(30.5));
        stack.invertSignLastNumber();
        ComplexNumbers num = stack.top();
        assertThat(BigDecimal.valueOf(-17.593), Matchers.comparesEqualTo(num.getReal()));
        assertThat(BigDecimal.valueOf(-30.5), Matchers.comparesEqualTo(num.getImg()));

        stack.push(BigDecimal.valueOf(0.0), BigDecimal.valueOf(15.39));
        stack.invertSignLastNumber();
        ComplexNumbers num1 = stack.top();
        assertThat(BigDecimal.valueOf(0.0), Matchers.comparesEqualTo(num1.getReal()));
        assertThat(BigDecimal.valueOf(-15.39), Matchers.comparesEqualTo(num1.getImg()));

        stack.push(BigDecimal.valueOf(0.0), BigDecimal.valueOf(0.0));
        stack.invertSignLastNumber();
        ComplexNumbers num2 = stack.top();
        assertThat(BigDecimal.valueOf(0.0), Matchers.comparesEqualTo(num2.getReal()));
        assertThat(BigDecimal.valueOf(0.0), Matchers.comparesEqualTo(num2.getImg()));

        stack.push(BigDecimal.valueOf(-34.921), BigDecimal.valueOf(-30.9));
        stack.invertSignLastNumber();
        ComplexNumbers num3 = stack.top();
        assertThat(BigDecimal.valueOf(34.921), Matchers.comparesEqualTo(num3.getReal()));
        assertThat(BigDecimal.valueOf(30.9), Matchers.comparesEqualTo(num3.getImg()));
        
        stack.push(BigDecimal.valueOf(25.3), BigDecimal.valueOf(-25.3));
        stack.invertSignLastNumber();
        ComplexNumbers num4 = stack.top();
        assertThat(BigDecimal.valueOf(-25.3), Matchers.comparesEqualTo(num4.getReal()));
        assertThat(BigDecimal.valueOf(25.3), Matchers.comparesEqualTo(num4.getImg()));

    }
    
}
