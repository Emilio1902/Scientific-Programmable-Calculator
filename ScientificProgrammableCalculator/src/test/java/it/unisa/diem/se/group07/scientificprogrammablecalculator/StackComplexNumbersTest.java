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
        ComplexNumbers n = stack.pop();
        assertEquals(null, n);

        //test for stack with inserted numbers
        stack.push(2.6, 7.1);
        stack.push(8.3, 3.5);
        ComplexNumbers num = stack.pop();
        assertEquals(8.3, num.getReal());
        assertEquals(3.5, num.getImg());
        
        stack.push(39.491, -16.382);
        ComplexNumbers num1 = stack.pop();
        assertEquals(39.491, num1.getReal());
        assertEquals(-16.382, num1.getImg());
        
        stack.push(-172.49, 43.9);
        ComplexNumbers num2 = stack.pop();
        assertEquals(-172.49, num2.getReal());
        assertEquals(43.9, num2.getImg());
        
        stack.push(-22.4932, -1.30);
        ComplexNumbers num3 = stack.pop();
        assertEquals(-22.4932, num3.getReal());
        assertEquals(-1.30, num3.getImg());
        
        stack.push(0.0, 0.0);
        ComplexNumbers num4 = stack.pop();
        assertEquals(0.0, num4.getReal());
        assertEquals(0.0, num4.getImg());
        
        stack.push(0.0, 25.39);
        ComplexNumbers num5 = stack.pop();
        assertEquals(0.0, num5.getReal());
        assertEquals(25.39, num5.getImg());
        
        stack.push(0.0, -2.30);
        ComplexNumbers num6 = stack.pop();
        assertEquals(0.0, num6.getReal());
        assertEquals(-2.30, num6.getImg());
        
        stack.push(184.403, 0.0);
        ComplexNumbers num7 = stack.pop();
        assertEquals(184.403, num7.getReal());
        assertEquals(0.0, num7.getImg());
        
        stack.push(-10347.59, 0.0);
        ComplexNumbers num8 = stack.pop();
        assertEquals(-10347.59, num8.getReal());
        assertEquals(0.0, num8.getImg());
        
        //test for stack with inserted boundary limits
        stack.push(-Double.MAX_VALUE-Double.MIN_VALUE, -Double.MAX_VALUE-Double.MIN_VALUE);
        ComplexNumbers num9 = stack.pop();
        assertEquals(-Double.MAX_VALUE, num9.getReal());
        assertEquals(-Double.MAX_VALUE, num9.getImg());
        
        stack.push(-Double.MAX_VALUE, -Double.MAX_VALUE);
        ComplexNumbers num10 = stack.pop();
        assertEquals(-Double.MAX_VALUE, num10.getReal());
        assertEquals(-Double.MAX_VALUE, num10.getImg());
        
        stack.push(-Double.MAX_VALUE+Double.MIN_VALUE, -Double.MAX_VALUE+Double.MIN_VALUE);
        ComplexNumbers num11 = stack.pop();
        assertEquals(-Double.MAX_VALUE+Double.MIN_VALUE, num11.getReal());
        assertEquals(-Double.MAX_VALUE+Double.MIN_VALUE, num11.getImg());
        
        stack.push(Double.MAX_VALUE-Double.MIN_VALUE, Double.MAX_VALUE-Double.MIN_VALUE);
        ComplexNumbers num12 = stack.pop();
        assertEquals(Double.MAX_VALUE-Double.MIN_VALUE, num12.getReal());
        assertEquals(Double.MAX_VALUE-Double.MIN_VALUE, num12.getImg());
        
        stack.push(Double.MAX_VALUE+Double.MAX_VALUE, Double.MAX_VALUE+Double.MAX_VALUE);
        ComplexNumbers num13 = stack.pop();
        assertEquals(Double.POSITIVE_INFINITY, num13.getReal());
        assertEquals(Double.POSITIVE_INFINITY, num13.getImg());
        
        stack.push(Double.MAX_VALUE+Double.MIN_VALUE, Double.MAX_VALUE+Double.MIN_VALUE);
        ComplexNumbers num14 = stack.pop();
        assertEquals(Double.MAX_VALUE, num14.getReal());
        assertEquals(Double.MAX_VALUE, num14.getImg());
        
        //the complex number constructor approximates the number to the eighth decimal place
        stack.push(0.000000001, 0.000000001);
        ComplexNumbers num15 = stack.pop();
        assertEquals(0.0, num15.getReal());
        assertEquals(0.0, num15.getImg());
        
        stack.push(0.00000001, 0.00000001);
        ComplexNumbers num16 = stack.pop();
        assertEquals(0.00000001, num16.getReal());
        assertEquals(0.00000001, num16.getImg());
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
        stack.push(203.10, 1.23);
        stack.push(293.45, 29.123);
        ComplexNumbers num = stack.top();
        assertEquals(293.45, num.getReal());
        assertEquals(29.123, num.getImg());

        stack.push(45.673, -392.5);
        ComplexNumbers num1 = stack.top();
        assertEquals(45.673, num1.getReal());
        assertEquals(-392.5, num1.getImg());
        
        stack.push(-8.3203, 3.5);
        ComplexNumbers num2 = stack.top();
        assertEquals(-8.3203, num2.getReal());
        assertEquals(3.5, num2.getImg());
        
        stack.push(-67.0, -82.392);
        ComplexNumbers num3 = stack.top();
        assertEquals(-67.0, num3.getReal());
        assertEquals(-82.392, num3.getImg());
        
        stack.push(0.0, 0.0);
        ComplexNumbers num4 = stack.top();
        assertEquals(0.0, num4.getReal());
        assertEquals(0.0, num4.getImg());
        
        stack.push(0.0, 19.37);
        ComplexNumbers num5 = stack.top();
        assertEquals(0.0, num5.getReal());
        assertEquals(19.37, num5.getImg());
        
        stack.push(0.0, -23.2);
        ComplexNumbers num6 = stack.top();
        assertEquals(0.0, num6.getReal());
        assertEquals(-23.2, num6.getImg());
        
        stack.push(30.21, 0.0);
        ComplexNumbers num7 = stack.top();
        assertEquals(30.21, num7.getReal());
        assertEquals(0.0, num7.getImg());
        
        stack.push(-45.37, 0.0);
        ComplexNumbers num8 = stack.top();
        assertEquals(-45.37, num8.getReal());
        assertEquals(0.0, num8.getImg());
        
        //test for stack with inserted boundary limits
        stack.push(-Double.MAX_VALUE-Double.MIN_VALUE, -Double.MAX_VALUE-Double.MIN_VALUE);
        ComplexNumbers num9 = stack.pop();
        assertEquals(-Double.MAX_VALUE, num9.getReal());
        assertEquals(-Double.MAX_VALUE, num9.getImg());
        
        stack.push(-Double.MAX_VALUE, -Double.MAX_VALUE);
        ComplexNumbers num10 = stack.pop();
        assertEquals(-Double.MAX_VALUE, num10.getReal());
        assertEquals(-Double.MAX_VALUE, num10.getImg());
        
        stack.push(-Double.MAX_VALUE+Double.MIN_VALUE, -Double.MAX_VALUE+Double.MIN_VALUE);
        ComplexNumbers num11 = stack.pop();
        assertEquals(-Double.MAX_VALUE+Double.MIN_VALUE, num11.getReal());
        assertEquals(-Double.MAX_VALUE+Double.MIN_VALUE, num11.getImg());
        
        stack.push(Double.MAX_VALUE-Double.MIN_VALUE, Double.MAX_VALUE-Double.MIN_VALUE);
        ComplexNumbers num12 = stack.pop();
        assertEquals(Double.MAX_VALUE-Double.MIN_VALUE, num12.getReal());
        assertEquals(Double.MAX_VALUE-Double.MIN_VALUE, num12.getImg());
        
        stack.push(Double.MAX_VALUE+Double.MAX_VALUE, Double.MAX_VALUE+Double.MAX_VALUE);
        ComplexNumbers num13 = stack.pop();
        assertEquals(Double.POSITIVE_INFINITY, num13.getReal());
        assertEquals(Double.POSITIVE_INFINITY, num13.getImg());
        
        stack.push(Double.MAX_VALUE+Double.MIN_VALUE, Double.MAX_VALUE+Double.MIN_VALUE);
        ComplexNumbers num14 = stack.pop();
        assertEquals(Double.MAX_VALUE, num14.getReal());
        assertEquals(Double.MAX_VALUE, num14.getImg());
        
        //the complex number constructor approximates the number to the eighth decimal place
        stack.push(0.000000001, 0.000000001);
        ComplexNumbers num15 = stack.pop();
        assertEquals(0.0, num15.getReal());
        assertEquals(0.0, num15.getImg());
        
        stack.push(0.00000001, 0.00000001);
        ComplexNumbers num16 = stack.pop();
        assertEquals(0.00000001, num16.getReal());
        assertEquals(0.00000001, num16.getImg());

    }

    /**
     * Test of push method, of class StackComplexNumbers.
     */
    @Test
    public void testPush() {
        //test for stack with inserted numbers
        stack.push(14.8, 37.1);
        ComplexNumbers num = stack.top();
        assertEquals(14.8, num.getReal());
        assertEquals(37.1, num.getImg());
        
        stack.push(30.281, -27.19);
        ComplexNumbers num1 = stack.top();
        assertEquals(30.281, num1.getReal());
        assertEquals(-27.19, num1.getImg());
        
        stack.push(-3.238, 16.72);
        ComplexNumbers num2 = stack.top();
        assertEquals(-3.238, num2.getReal());
        assertEquals(16.72, num2.getImg());
        
        stack.push(-54.6, -1.22);
        ComplexNumbers num3 = stack.top();
        assertEquals(-54.6, num3.getReal());
        assertEquals(-1.22, num3.getImg());
        
        stack.push(0.0, 0.0);
        ComplexNumbers num4 = stack.top();
        assertEquals(0.0, num4.getReal());
        assertEquals(0.0, num4.getImg());
        
        stack.push(0.0, 674.8201);
        ComplexNumbers num5 = stack.top();
        assertEquals(0.0, num5.getReal());
        assertEquals(674.8201, num5.getImg());
        
        stack.push(0.0, -4.7839201);
        ComplexNumbers num6 = stack.top();
        assertEquals(0.0, num6.getReal());
        assertEquals(-4.7839201, num6.getImg());
        
        stack.push(9382.453, 0.0);
        ComplexNumbers num7 = stack.top();
        assertEquals(9382.453, num7.getReal());
        assertEquals(0.0, num7.getImg());
        
        stack.push(-4502.37, 0.0);
        ComplexNumbers num8 = stack.top();
        assertEquals(-4502.37, num8.getReal());
        assertEquals(0.0, num8.getImg());
        
        //test for stack with inserted boundary limits
        stack.push(-Double.MAX_VALUE-Double.MIN_VALUE, -Double.MAX_VALUE-Double.MIN_VALUE);
        ComplexNumbers num9 = stack.top();
        assertEquals(-Double.MAX_VALUE, num9.getReal());
        assertEquals(-Double.MAX_VALUE, num9.getImg());
        
        stack.push(-Double.MAX_VALUE, -Double.MAX_VALUE);
        ComplexNumbers num10 = stack.top();
        assertEquals(-Double.MAX_VALUE, num10.getReal());
        assertEquals(-Double.MAX_VALUE, num10.getImg());
        
        stack.push(-Double.MAX_VALUE+Double.MIN_VALUE, -Double.MAX_VALUE+Double.MIN_VALUE);
        ComplexNumbers num11 = stack.top();
        assertEquals(-Double.MAX_VALUE+Double.MIN_VALUE, num11.getReal());
        assertEquals(-Double.MAX_VALUE+Double.MIN_VALUE, num11.getImg());
        
        stack.push(Double.MAX_VALUE-Double.MIN_VALUE, Double.MAX_VALUE-Double.MIN_VALUE);
        ComplexNumbers num12 = stack.top();
        assertEquals(Double.MAX_VALUE-Double.MIN_VALUE, num12.getReal());
        assertEquals(Double.MAX_VALUE-Double.MIN_VALUE, num12.getImg());
        
        stack.push(Double.MAX_VALUE+Double.MIN_VALUE, Double.MAX_VALUE+Double.MIN_VALUE);
        ComplexNumbers num13 = stack.top();
        assertEquals(Double.MAX_VALUE, num13.getReal());
        assertEquals(Double.MAX_VALUE, num13.getImg());
        
        //the complex number constructor approximates the number to the eighth decimal place
        stack.push(0.000000001, 0.000000001);
        ComplexNumbers num14 = stack.top();
        assertEquals(0.0, num14.getReal());
        assertEquals(0.0, num14.getImg());
        
        stack.push(0.00000001, 0.00000001);
        ComplexNumbers num15 = stack.top();
        assertEquals(0.00000001, num15.getReal());
        assertEquals(0.00000001, num15.getImg());
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
            stack1.push(i, i);
        }
        
        String[] array1;
        array1 = stack1.getLastTwelve();
        assertEquals(12, array1.length);

        for (i = 0; i < 12; i++) {
            assertEquals(String.valueOf(dim1 - 1 - i) + ".0"  + "+" + String.valueOf(dim1 - 1 - i) + ".0" + "i", array1[i]);
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
        //test for empty stack
        boolean n = stack.sumLastTwoNumbers();
        assertEquals(false, n);
        
        //test with 1 element in the stack
        StackComplexNumbers stackT1 = new StackComplexNumbers();
        stackT1.push(21.5, 13.1);
        stackT1.sumLastTwoNumbers();
        boolean n1 = stackT1.sumLastTwoNumbers();
        assertEquals(false, n1);
        
        //test for stack with inserted numbers
        stack.push(21.5, 13.1);
        stack.push(3.5, 2.4);
        stack.sumLastTwoNumbers();
        ComplexNumbers num = stack.top();
        assertEquals(25.0, num.getReal());
        assertEquals(15.5, num.getImg());

        stack.push(14.2, 19.7);
        stack.push(-29.73, -6.6);
        stack.sumLastTwoNumbers();
        ComplexNumbers num1 = stack.top();
        assertEquals(-15.53, num1.getReal());
        assertEquals(13.1, num1.getImg());

        stack.push(563.9, 13.9);
        stack.push(1.3601, -1);
        stack.sumLastTwoNumbers();
        ComplexNumbers num2 = stack.top();
        assertEquals(565.2601, num2.getReal());
        assertEquals(12.9, num2.getImg());

        stack.push(73.10281, 62.28);
        stack.push(-36.0, 1.8);
        stack.sumLastTwoNumbers();
        ComplexNumbers num3 = stack.top();
        assertEquals(37.10281, num3.getReal());
        assertEquals(64.08, num3.getImg());
        
        stack.push(493.218, 194.3);
        stack.push(0.0, 0.0);
        stack.sumLastTwoNumbers();
        ComplexNumbers num4 = stack.top();
        assertEquals(493.218, num4.getReal());
        assertEquals(194.3, num4.getImg());
        
        stack.push(39.219234, 1.67);
        stack.push(0.0, 1.8);
        stack.sumLastTwoNumbers();
        ComplexNumbers num5 = stack.top();
        assertEquals(39.219234, num5.getReal());
        assertEquals(3.47, num5.getImg());
        
        stack.push(89.392,45.39712);
        stack.push(0.0, -1.8);
        stack.sumLastTwoNumbers();
        ComplexNumbers num6 = stack.top();
        assertEquals(89.392, num6.getReal());
        assertEquals(43.59712, num6.getImg());
        
        stack.push(0.0,0.0);
        stack.push(0.0, 0.0);
        stack.sumLastTwoNumbers();
        ComplexNumbers num7 = stack.top();
        assertEquals(0.0, num7.getReal());
        assertEquals(0.0, num7.getImg());
        
        stack.push(0.0,0.0);
        stack.push(0.0, 392.934);
        stack.sumLastTwoNumbers();
        ComplexNumbers num8 = stack.top();
        assertEquals(0.0, num8.getReal());
        assertEquals(392.934, num8.getImg());
        
        stack.push(0.0,0.0);
        stack.push(0.0, -340.2912);
        stack.sumLastTwoNumbers();
        ComplexNumbers num9 = stack.top();
        assertEquals(0.0, num9.getReal());
        assertEquals(-340.2912, num9.getImg());
        
        stack.push(0.0,0.0);
        stack.push(23.9487, 0.0);
        stack.sumLastTwoNumbers();
        ComplexNumbers num10 = stack.top();
        assertEquals(23.9487, num10.getReal());
        assertEquals(0.0, num10.getImg());
        
        stack.push(0.0,0.0);
        stack.push(-30291.63, 0.0);
        stack.sumLastTwoNumbers();
        ComplexNumbers num11 = stack.top();
        assertEquals(-30291.63, num11.getReal());
        assertEquals(0.0, num11.getImg());
        
        //test for stack with inserted boundary limits
        //Minimum Boundary
        stack.push(-Double.MAX_VALUE, -Double.MAX_VALUE);
        stack.push(0.0, 0.0);
        stack.sumLastTwoNumbers();
        ComplexNumbers num12 = stack.top();
        assertEquals(-Double.MAX_VALUE, num12.getReal());
        assertEquals(-Double.MAX_VALUE, num12.getImg());
        
        stack.push(-Double.MAX_VALUE+Double.MIN_VALUE, -Double.MAX_VALUE+Double.MIN_VALUE);
        stack.push(0.0, 0.0);
        stack.sumLastTwoNumbers();
        ComplexNumbers num13 = stack.top();
        assertEquals(-Double.MAX_VALUE+Double.MIN_VALUE, num13.getReal());
        assertEquals(-Double.MAX_VALUE+Double.MIN_VALUE, num13.getImg());
        
        //Below Maximum
        stack.push(Double.MAX_VALUE-Double.MIN_VALUE, Double.MAX_VALUE-Double.MIN_VALUE);
        stack.push(0.0, 0.0);
        stack.sumLastTwoNumbers();
        ComplexNumbers num14 = stack.top();
        assertEquals(Double.MAX_VALUE-Double.MIN_VALUE, num14.getReal());
        assertEquals(Double.MAX_VALUE-Double.MIN_VALUE, num14.getImg());
              
         //Maximum Boundary
        stack.push(Double.MAX_VALUE-Double.MIN_VALUE, Double.MAX_VALUE-Double.MIN_VALUE);
        stack.push(Double.MIN_VALUE, Double.MIN_VALUE);
        stack.sumLastTwoNumbers();
        ComplexNumbers num15 = stack.top();
        assertEquals(Double.MAX_VALUE, num15.getReal());
        assertEquals(Double.MAX_VALUE, num15.getImg());
          
        //Outside
        stack.push(-Double.MAX_VALUE, -Double.MAX_VALUE);
        stack.push(-Double.MAX_VALUE+Double.MIN_VALUE, -Double.MAX_VALUE+Double.MIN_VALUE);
        stack.sumLastTwoNumbers();
        ComplexNumbers num16 = stack.top();
        assertEquals(Double.NEGATIVE_INFINITY, num16.getReal());
        assertEquals(Double.NEGATIVE_INFINITY, num16.getImg());  
        
        stack.push(-Double.MAX_VALUE, -Double.MAX_VALUE);
        stack.push(-4.443, -11.73);
        stack.sumLastTwoNumbers();
        ComplexNumbers num17 = stack.top();
        assertEquals(-Double.MAX_VALUE, num17.getReal());
        assertEquals(-Double.MAX_VALUE, num17.getImg());
        
        stack.push(Double.MAX_VALUE-Double.MIN_VALUE, Double.MAX_VALUE-Double.MIN_VALUE);
        stack.push(Double.MAX_VALUE, Double.MAX_VALUE);
        stack.sumLastTwoNumbers();
        ComplexNumbers num18 = stack.top();
        assertEquals(Double.POSITIVE_INFINITY, num18.getReal());
        assertEquals(Double.POSITIVE_INFINITY, num18.getImg());
       
        stack.push(Double.MAX_VALUE, Double.MAX_VALUE);
        stack.push(7.15, 6.70);
        stack.sumLastTwoNumbers();
        ComplexNumbers num19 = stack.top();
        assertEquals(Double.MAX_VALUE, num19.getReal());
        assertEquals(Double.MAX_VALUE, num19.getImg());

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
        stackT1.push(21.5, 13.1);
        stackT1.differenceLastTwoNumbers();
        boolean n1 = stackT1.differenceLastTwoNumbers();
        assertEquals(false, n1);
        
        //test for stack with inserted numbers
        stack.push(39.283, 167.1);
        stack.push(46.302, 473.2910);
        stack.differenceLastTwoNumbers();
        ComplexNumbers num = stack.top();
        assertEquals(-7.019, num.getReal());
        assertEquals(-306.191, num.getImg());

        stack.push(39.4839, 69.382);
        stack.push(-18.29382, -46.302);
        stack.differenceLastTwoNumbers();
        ComplexNumbers num1 = stack.top();
        assertEquals(57.77772, num1.getReal());
        assertEquals(115.684, num1.getImg());

        stack.push(47.39221, 100.7);
        stack.push(304.2719, -15.55);
        stack.differenceLastTwoNumbers();
        ComplexNumbers num2 = stack.top();
        assertEquals(-256.87969, num2.getReal());
        assertEquals(116.25, num2.getImg());

        stack.push(73.10281, 62.28);
        stack.push(-36.0, 1.8);
        stack.differenceLastTwoNumbers();
        ComplexNumbers num3 = stack.top();
        assertEquals(109.10281, num3.getReal());
        assertEquals(60.48, num3.getImg());
        
        stack.push(57.3821, 143.1112);
        stack.push(0.0, 0.0);
        stack.differenceLastTwoNumbers();
        ComplexNumbers num4 = stack.top();
        assertEquals(57.3821, num4.getReal());
        assertEquals(143.1112, num4.getImg());
        
        stack.push(48.3721, 13.999);
        stack.push(0.0, 57.23);
        stack.differenceLastTwoNumbers();
        ComplexNumbers num5 = stack.top();
        assertEquals(48.3721, num5.getReal());
        assertEquals(-43.231, num5.getImg());
        
        stack.push(5401.38,2.6123);
        stack.push(0.0, -5.37854);
        stack.differenceLastTwoNumbers();
        ComplexNumbers num6 = stack.top();
        assertEquals(5401.38, num6.getReal());
        assertEquals(7.99084, num6.getImg());
        
        stack.push(0.0,0.0);
        stack.push(0.0, 0.0);
        stack.differenceLastTwoNumbers();
        ComplexNumbers num7 = stack.top();
        assertEquals(0.0, num7.getReal());
        assertEquals(0.0, num7.getImg());
        
        stack.push(0.0,0.0);
        stack.push(0.0, 392.934);
        stack.differenceLastTwoNumbers();
        ComplexNumbers num8 = stack.top();
        assertEquals(0.0, num8.getReal());
        assertEquals(-392.934, num8.getImg());
        
        stack.push(0.0,0.0);
        stack.push(0.0, -340.2912);
        stack.differenceLastTwoNumbers();
        ComplexNumbers num9 = stack.top();
        assertEquals(0.0, num9.getReal());
        assertEquals(340.2912, num9.getImg());
        
        stack.push(0.0,0.0);
        stack.push(23.9487, 0.0);
        stack.differenceLastTwoNumbers();
        ComplexNumbers num10 = stack.top();
        assertEquals(-23.9487, num10.getReal());
        assertEquals(0.0, num10.getImg());
        
        stack.push(0.0,0.0);
        stack.push(-30291.63, 0.0);
        stack.differenceLastTwoNumbers();
        ComplexNumbers num11 = stack.top();
        assertEquals(30291.63, num11.getReal());
        assertEquals(0.0, num11.getImg());
        
        //test for stack with inserted boundary limits
        //Minimum Boundary
        stack.push(0.0, 0.0);
        stack.push(Double.MAX_VALUE, Double.MAX_VALUE);
        stack.differenceLastTwoNumbers();
        ComplexNumbers num12 = stack.top();
        assertEquals(-Double.MAX_VALUE, num12.getReal());
        assertEquals(-Double.MAX_VALUE, num12.getImg());
        
        //Above
        stack.push(0.0, 0.0);
        stack.push(Double.MAX_VALUE-Double.MIN_VALUE, Double.MAX_VALUE-Double.MIN_VALUE);
        stack.differenceLastTwoNumbers();
        ComplexNumbers num13 = stack.top();
        assertEquals(-Double.MAX_VALUE+Double.MIN_VALUE, num13.getReal());
        assertEquals(-Double.MAX_VALUE+Double.MIN_VALUE, num13.getImg());
        
        //Below Maximum
        stack.push(Double.MAX_VALUE, Double.MAX_VALUE);
        stack.push(Double.MIN_VALUE, Double.MIN_VALUE);
        stack.differenceLastTwoNumbers();
        ComplexNumbers num14 = stack.top();
        assertEquals(Double.MAX_VALUE-Double.MIN_VALUE, num14.getReal());
        assertEquals(Double.MAX_VALUE-Double.MIN_VALUE, num14.getImg());
              
         //Maximum Boundary
        stack.push(0.0, 0.0);
        stack.push(-Double.MAX_VALUE, -Double.MAX_VALUE);
        stack.differenceLastTwoNumbers();
        ComplexNumbers num15 = stack.top();
        assertEquals(Double.MAX_VALUE, num15.getReal());
        assertEquals(Double.MAX_VALUE, num15.getImg());
          
        //Outside
        stack.push(-Double.MAX_VALUE, -Double.MAX_VALUE);
        stack.push(Double.MAX_VALUE, Double.MAX_VALUE);
        stack.differenceLastTwoNumbers();
        ComplexNumbers num16 = stack.top();
        assertEquals(Double.NEGATIVE_INFINITY, num16.getReal());
        assertEquals(Double.NEGATIVE_INFINITY, num16.getImg());  
        
        stack.push(-Double.MAX_VALUE, -Double.MAX_VALUE);
        stack.push(7.15, 6.70);
        stack.differenceLastTwoNumbers();
        ComplexNumbers num17 = stack.top();
        assertEquals(-Double.MAX_VALUE, num17.getReal());
        assertEquals(-Double.MAX_VALUE, num17.getImg());
        
        stack.push(Double.MAX_VALUE, Double.MAX_VALUE);
        stack.push(-Double.MAX_VALUE, -Double.MAX_VALUE);
        stack.differenceLastTwoNumbers();
        ComplexNumbers num18 = stack.top();
        assertEquals(Double.POSITIVE_INFINITY, num18.getReal());
        assertEquals(Double.POSITIVE_INFINITY, num18.getImg());
       
        stack.push(Double.MAX_VALUE, Double.MAX_VALUE);
        stack.push(-4.443, -11.73);
        stack.differenceLastTwoNumbers();
        ComplexNumbers num19 = stack.top();
        assertEquals(Double.MAX_VALUE, num19.getReal());
        assertEquals(Double.MAX_VALUE, num19.getImg());

    }
    
    /**
     * Test of productLastTwoNumbers method, of class StackComplexNumbers.
     * The result of the multiplication expects a maximum of 8 decimal digits rounded up, 
     * for the implementation of the method in ComplexNumbers class.
     */
    @Test
    public void testProductLastTwoNumbers() {
        //test for empty stack
        boolean n = stack.productLastTwoNumbers();
        assertEquals(false, n);
        
        //test with 1 element in the stack
        StackComplexNumbers stackT1 = new StackComplexNumbers();
        stackT1.push(21.5, 13.1);
        stackT1.productLastTwoNumbers();
        boolean n1 = stackT1.productLastTwoNumbers();
        assertEquals(false, n1);
        
        //test for stack with inserted numbers
        stack.push(28.573, 10.5231);
        stack.push(9.1115, 2.8732);
        stack.productLastTwoNumbers();
        ComplexNumbers num = stack.top();
        assertEquals(230.10791858, num.getReal());
        assertEquals(177.97716925, num.getImg());

        stack.push(13.8, 37.52);
        stack.push(-8.342, -75.11);
        stack.productLastTwoNumbers();
        ComplexNumbers num1 = stack.top();
        assertEquals(2703.0076, num1.getReal());
        assertEquals(-1349.50984, num1.getImg());

        stack.push(2.54, 64.99);
        stack.push(4.53, -1.641);
        stack.productLastTwoNumbers();
        ComplexNumbers num2 = stack.top();
        assertEquals(118.15479, num2.getReal());
        assertEquals(290.23656, num2.getImg());

        stack.push(32.6643, 3.33);
        stack.push(-10, 1.43);
        stack.productLastTwoNumbers();
        ComplexNumbers num3 = stack.top();
        assertEquals(-331.4049, num3.getReal());
        assertEquals(13.409949, num3.getImg());
        
        stack.push(36.291, 49.2);
        stack.push(0.0, 0.0);
        stack.productLastTwoNumbers();
        ComplexNumbers num4 = stack.top();
        assertEquals(0.0, num4.getReal());
        assertEquals(0.0, num4.getImg());
        
        stack.push(38.42, 7.1234);
        stack.push(0.0, 47.99);
        stack.productLastTwoNumbers();
        ComplexNumbers num5 = stack.top();
        assertEquals(-341.851966, num5.getReal());
        assertEquals(1843.7758, num5.getImg());
        
        stack.push(5.5, 2.61);
        stack.push(0.0, -21.66);
        stack.productLastTwoNumbers();
        ComplexNumbers num6 = stack.top();
        assertEquals(56.5326, num6.getReal());
        assertEquals(-119.13, num6.getImg());
        
        stack.push(0.0,0.0);
        stack.push(0.0, 0.0);
        stack.productLastTwoNumbers();
        ComplexNumbers num7 = stack.top();
        assertEquals(0.0, num7.getReal());
        assertEquals(0.0, num7.getImg());
        
        stack.push(0.0,0.0);
        stack.push(0.0, 39.21);
        stack.productLastTwoNumbers();
        ComplexNumbers num8 = stack.top();
        assertEquals(0.0, num8.getReal());
        assertEquals(0.0, num8.getImg());
        
        stack.push(0.0,0.0);
        stack.push(0.0, -276.826);
        stack.productLastTwoNumbers();
        ComplexNumbers num9 = stack.top();
        assertEquals(0.0, num9.getReal());
        assertEquals(0.0, num9.getImg());
        
        stack.push(0.0,0.0);
        stack.push(1.87, 0.0);
        stack.productLastTwoNumbers();
        ComplexNumbers num10 = stack.top();
        assertEquals(0.0, num10.getReal());
        assertEquals(0.0, num10.getImg());
        
        stack.push(0.0,0.0);
        stack.push(-45.93, 0.0);
        stack.productLastTwoNumbers();
        ComplexNumbers num11 = stack.top();
        assertEquals(-0.0, num11.getReal());
        assertEquals(0.0, num11.getImg());
        
        //test for stack with inserted boundary limits
        //Minimum Boundary
        stack.push(-1.7976931348623157E30, 0.0);
        stack.push(1E278, 0.0);
        stack.productLastTwoNumbers();
        ComplexNumbers num12 = stack.top();
        assertEquals(-Double.MAX_VALUE, num12.getReal());
        assertEquals(0.0, num12.getImg());
        
        //Above
        stack.push(-1.797693134862315699E30, 0.0);
        stack.push(1E278, 0.0);
        stack.productLastTwoNumbers();
        ComplexNumbers num13 = stack.top();
        assertEquals(-Double.MAX_VALUE+Double.MIN_VALUE, num13.getReal());
        assertEquals(0.0, num13.getImg());
        
        //Below Maximum
        stack.push(1, 1.7976931348623157E307);
        stack.push(1, 1.6179238213760842E308-Double.MIN_VALUE);
        stack.productLastTwoNumbers();
        ComplexNumbers num14 = stack.top();
        assertEquals(Double.NEGATIVE_INFINITY, num14.getReal());
        assertEquals(Double.MAX_VALUE-Double.MIN_VALUE, num14.getImg());
              
        //Maximum Boundary
        stack.push(1.7976931348623157E30, -0.0);
        stack.push(1E278, 0.0);
        stack.productLastTwoNumbers();
        ComplexNumbers num15 = stack.top();
        assertEquals(Double.MAX_VALUE, num15.getReal());
        assertEquals(0.0, num15.getImg());
          
        //Outside
        stack.push(-Double.MAX_VALUE+Double.MIN_VALUE, -Double.MAX_VALUE+Double.MIN_VALUE);
        stack.push(7.15, 6.70);
        stack.productLastTwoNumbers();
        ComplexNumbers num16 = stack.top();
        assertEquals(Double.NaN, num16.getReal());
        assertEquals(Double.NaN, num16.getImg());  
        
        stack.push(Double.MAX_VALUE, Double.MAX_VALUE);
        stack.push(7.15, 6.70);
        stack.productLastTwoNumbers();
        ComplexNumbers num17 = stack.top();
        assertEquals(Double.NaN, num17.getReal());
        assertEquals(Double.NaN, num17.getImg());  
        
        stack.push(0.0, -23.71);
        stack.push(Double.POSITIVE_INFINITY, 12324);
        stack.productLastTwoNumbers();
        ComplexNumbers num18 = stack.top();
        assertEquals(Double.NaN, num18.getReal());
        assertEquals(Double.NaN, num18.getImg());  
       
        stack.push(Double.MAX_VALUE, 745.32);
        stack.push(Double.MAX_VALUE, 745.32);
        stack.productLastTwoNumbers();
        ComplexNumbers num19 = stack.top();
        assertEquals(Double.POSITIVE_INFINITY, num19.getReal());
        assertEquals(Double.POSITIVE_INFINITY, num19.getImg());
        
        stack.push(Double.MAX_VALUE, 745.32);
        stack.push(-Double.MAX_VALUE, 1);
        stack.productLastTwoNumbers();
        ComplexNumbers num20 = stack.top();
        assertEquals(Double.NEGATIVE_INFINITY, num20.getReal());
        assertEquals(Double.NEGATIVE_INFINITY, num20.getImg());

    }
   
    /**
     * Test of ratioLastTwoNumbers method, of class StackComplexNumbers.
     * The result of the division expects a maximum of 8 decimal digits rounded up, 
     * for the implementation of the method in ComplexNumbers class.
     */
    @Test
    public void testRatioLastTwoNumbers() {
        //test for empty stack
        boolean n = stack.ratioLastTwoNumbers();
        assertEquals(false, n);
        
        //test with 1 element in the stack
        StackComplexNumbers stackT1 = new StackComplexNumbers();
        stackT1.push(21.5, 13.1);
        boolean n1 = stackT1.ratioLastTwoNumbers();
        assertEquals(false, n1);
        
        //test for stack with inserted numbers
        stack.push(46.583, 4.321);
        stack.push(39.7218, 6.99);
        stack.ratioLastTwoNumbers();
        ComplexNumbers num = stack.top();
        assertEquals(1.15607413, num.getReal());
        assertEquals(-0.0946573, num.getImg());

        stack.push(73.921, 1.43);
        stack.push(-5.194, -35.2);
        stack.ratioLastTwoNumbers();
        ComplexNumbers num1 = stack.top();
        assertEquals(-0.34302972, num1.getReal());
        assertEquals(2.04941204, num1.getImg());

        stack.push(23.1, 5.22);
        stack.push(0.0, 0.0);
        stack.ratioLastTwoNumbers();
        ComplexNumbers num2 = stack.top();
        assertEquals(Double.NEGATIVE_INFINITY, num2.getReal());
        assertEquals(0.0, num2.getImg());

        stack.push(23.33, 8.33);
        stack.push(0.0, 62.95412);
        stack.ratioLastTwoNumbers();
        ComplexNumbers num3 = stack.top();
        assertEquals(0.13231858, num3.getReal());
        assertEquals(-0.37058734, num3.getImg());
        
        stack.push(0.0, 0.0);
        stack.push(3.6, 59.26);
        stack.ratioLastTwoNumbers();
        ComplexNumbers num4 = stack.top();
        assertEquals(0.0, num4.getReal());
        assertEquals(0.0, num4.getImg());
        
        stack.push(0.0, 4.6);
        stack.push(-25.50, 10);
        stack.ratioLastTwoNumbers();
        ComplexNumbers num5 = stack.top();
        assertEquals(0.0613129, num5.getReal());
        assertEquals(-0.15634788, num5.getImg());
        
        stack.push(-51.5, -2.61);
        stack.push(16, -21.66);
        stack.ratioLastTwoNumbers();
        ComplexNumbers num6 = stack.top();
        assertEquals(-1.05834858, num6.getReal());
        assertEquals(-1.59586439, num6.getImg());
        
        stack.push(-59.992, -4.932);
        stack.push(0.0,0.0);
        stack.ratioLastTwoNumbers();
        ComplexNumbers num7 = stack.top();
        assertEquals(Double.NEGATIVE_INFINITY, num7.getReal());
        assertEquals(0.0, num7.getImg());
        
        stack.push(-4.888, -9.43);
        stack.push(5.367,0.0);
        stack.ratioLastTwoNumbers();
        ComplexNumbers num8 = stack.top();
        assertEquals(-0.91075089, num8.getReal());
        assertEquals(-1.75703372, num8.getImg());
        
        //test for stack with inserted boundary limits
        //Minimum Boundary
        stack.push(-5.6177910464447365625E304, 1665.05654);
        stack.push(0.0003125, 0.0);
        stack.ratioLastTwoNumbers();
        ComplexNumbers num9 = stack.top();
        assertEquals(-Double.MAX_VALUE, num9.getReal());
        assertEquals(5328180.928, num9.getImg());
        
        //Above
        stack.push(-5.6177910464447365625E304, 1665.05654);
        stack.push(Double.MIN_VALUE, Double.MIN_VALUE);
        stack.sumLastTwoNumbers();
        ComplexNumbers numSum = stack.top();
        stack.push(0.0003125, 0.0);
        stack.ratioLastTwoNumbers();
        ComplexNumbers num10 = stack.top();
        assertEquals(-Double.MAX_VALUE+Double.MIN_VALUE, num10.getReal());
        assertEquals(5328180.928, num10.getImg());
        
        //Below Maximum
        stack.push(5.6177910464447365625E304, 7.2365);
        stack.push(0.0003125, 0.0);
        stack.ratioLastTwoNumbers();
        ComplexNumbers num11 = stack.top();
        assertEquals(Double.MAX_VALUE, num11.getReal());
        assertEquals(23156.8, num11.getImg());
              
        //Maximum Boundary
        stack.push(5.6177910464447365625E304, 7.2365);
        stack.push(Double.MIN_VALUE, Double.MIN_VALUE);
        stack.differenceLastTwoNumbers();
        ComplexNumbers numDif = stack.top();
        stack.push(0.0003125, 0.0);
        stack.ratioLastTwoNumbers();
        ComplexNumbers num12 = stack.top();
        assertEquals(Double.MAX_VALUE-Double.MIN_VALUE, num12.getReal());
        assertEquals(23156.8, num12.getImg());
          
        //Outside
        stack.push(13.73, -41.13);
        stack.push(0.0, 0.0);
        stack.ratioLastTwoNumbers();
        ComplexNumbers num13 = stack.top();
        assertEquals(Double.NEGATIVE_INFINITY, num13.getReal());
        assertEquals(0.0, num13.getImg());  
        
        stack.push(Double.MAX_VALUE, Double.MAX_VALUE);
        stack.push(-Double.MAX_VALUE+Double.MIN_VALUE, -Double.MAX_VALUE+Double.MIN_VALUE);
        stack.ratioLastTwoNumbers();
        ComplexNumbers num14 = stack.top();
        assertEquals(Double.NaN, num14.getReal());
        assertEquals(Double.NaN, num14.getImg());  
        
        stack.push(Double.MAX_VALUE, Double.MAX_VALUE);
        stack.push(7.15, 6.70);
        stack.ratioLastTwoNumbers();
        ComplexNumbers num15 = stack.top();
        assertEquals(Double.NaN, num15.getReal());
        assertEquals(Double.NaN, num15.getImg());  

    }
    
    /**
     * Test of squareRootLastNumber method, of class StackComplexNumbers.
     * The result of the square root expects a maximum of 8 decimal digits rounded up, 
     * for the implementation of the method in ComplexNumbers class.
     */
    @Test
    public void testSquareRootLastNumber() {
        //test for empty stack
        boolean n = stack.squareRootLastNumber();
        assertEquals(false, n);
        
        //test for stack with inserted numbers
        stack.push(5.67, 48.1);
        stack.push(6.31, 39.443);
        stack.squareRootLastNumber();
        ComplexNumbers num = stack.top();
        assertEquals(4.80908208, num.getReal());
        assertEquals(4.10088655, num.getImg());
        
        stack.push(59.3, -22.56);
        stack.squareRootLastNumber();
        ComplexNumbers num1 = stack.top();
        assertEquals(-7.83410441, num1.getReal());
        assertEquals(1.43985827, num1.getImg());
        
        stack.push(-39.271, 1.4892);
        stack.squareRootLastNumber();
        ComplexNumbers num2 = stack.top();
        assertEquals(0.11879797, num2.getReal());
        assertEquals(6.26778374, num2.getImg());
        
        stack.push(-36.41, -1.95);
        stack.squareRootLastNumber();
        ComplexNumbers num3 = stack.top();
        assertEquals(-0.16152462, num3.getReal());
        assertEquals(6.03623146, num3.getImg());
        
        stack.push(0.0, 0.0);
        stack.squareRootLastNumber();
        ComplexNumbers num4 = stack.top();
        assertEquals(0.0, num4.getReal());
        assertEquals(0.0, num4.getImg());

        stack.push(0.0, 15.39);
        stack.squareRootLastNumber();
        ComplexNumbers num5 = stack.top();
        assertEquals(2.7739863, num5.getReal());
        assertEquals(2.7739863, num5.getImg());
        
        stack.push(0.0, -4.2781);
        stack.squareRootLastNumber();
        ComplexNumbers num6 = stack.top();
        assertEquals(-1.46254914, num6.getReal());
        assertEquals(1.46254914, num6.getImg());
        
        stack.push(65.8245, 0.0);
        stack.squareRootLastNumber();
        ComplexNumbers num7 = stack.top();
        assertEquals(8.11322994, num7.getReal());
        assertEquals(0.0, num7.getImg());

        //test for stack with inserted boundary limits
        stack.push(-Double.MAX_VALUE-Double.MIN_VALUE, -Double.MAX_VALUE-Double.MIN_VALUE);
        stack.squareRootLastNumber();
        ComplexNumbers num8 = stack.top();
        assertEquals(Double.NEGATIVE_INFINITY, num8.getReal());
        assertEquals(Double.POSITIVE_INFINITY, num8.getImg());
  
        stack.push(-Double.MAX_VALUE, -Double.MAX_VALUE);
        stack.squareRootLastNumber();
        ComplexNumbers num9 = stack.top();
        assertEquals(Double.NEGATIVE_INFINITY, num9.getReal());
        assertEquals(Double.POSITIVE_INFINITY, num9.getImg());
        
        stack.push(-Double.MAX_VALUE+Double.MIN_VALUE, -Double.MAX_VALUE+Double.MIN_VALUE);
        stack.squareRootLastNumber();
        ComplexNumbers num10 = stack.top();
        assertEquals(Double.NEGATIVE_INFINITY, num10.getReal());
        assertEquals(Double.POSITIVE_INFINITY, num10.getImg());
              
        stack.push(Double.MAX_VALUE-Double.MIN_VALUE, Double.MAX_VALUE-Double.MIN_VALUE);
        stack.squareRootLastNumber();
        ComplexNumbers num11 = stack.top();
        assertEquals(Double.POSITIVE_INFINITY, num11.getReal());
        assertEquals(Double.POSITIVE_INFINITY, num11.getImg());
          
        stack.push(Double.MAX_VALUE, Double.MAX_VALUE);
        stack.squareRootLastNumber();
        ComplexNumbers num12 = stack.top();
        assertEquals(Double.POSITIVE_INFINITY, num12.getReal());
        assertEquals(Double.POSITIVE_INFINITY, num12.getImg()); 
        
        stack.push(Double.MAX_VALUE+Double.MIN_VALUE, Double.MAX_VALUE+Double.MIN_VALUE);
        stack.squareRootLastNumber();
        ComplexNumbers num13 = stack.top();
        assertEquals(Double.POSITIVE_INFINITY, num13.getReal());
        assertEquals(Double.POSITIVE_INFINITY, num13.getImg());
        
        //the complex number constructor approximates the number to the eighth decimal place
        stack.push(0.00000001, 0.00000001);
        stack.squareRootLastNumber();
        ComplexNumbers num14 = stack.top();
        assertEquals(0.00010987, num14.getReal()); 
        assertEquals(0.00004551, num14.getImg()); 
       
        stack.push(0.000000001, 0.000000001);
        stack.squareRootLastNumber();
        ComplexNumbers num15 = stack.top();
        assertEquals(0.0, num15.getReal());
        assertEquals(0.0, num15.getImg());
    }
    
    /**
     * Test of invertSignLastNumber method, of class StackComplexNumbers.
     */
    @Test
    public void testInvertSignLastNumber() {
        //test for empty stack
        boolean n = stack.invertSignLastNumber();
        assertEquals(false, n);
        
        //test for stack with inserted numbers
        stack.push(392.1837, 3.26);
        stack.push(39.73619, 1.111);
        stack.invertSignLastNumber();
        ComplexNumbers num = stack.top();
        assertEquals(-39.73619, num.getReal());
        assertEquals(-1.111, num.getImg());
        
        stack.push(2.8491, -547.3928);
        stack.invertSignLastNumber();
        ComplexNumbers num1 = stack.top();
        assertEquals(-2.8491, num1.getReal());
        assertEquals(547.3928, num1.getImg());
        
        stack.push(-16.27930, 2.739);
        stack.invertSignLastNumber();
        ComplexNumbers num2 = stack.top();
        assertEquals(16.27930, num2.getReal());
        assertEquals(-2.739, num2.getImg());
        
        stack.push(-3.849, -2.6392);
        stack.invertSignLastNumber();
        ComplexNumbers num3 = stack.top();
        assertEquals(3.849, num3.getReal());
        assertEquals(2.6392, num3.getImg());
        
        stack.push(0.0, 0.0);
        stack.invertSignLastNumber();
        ComplexNumbers num4 = stack.top();
        assertEquals(0.0, num4.getReal());
        assertEquals(0.0, num4.getImg());

        stack.push(0.0, 4.8392);
        stack.invertSignLastNumber();
        ComplexNumbers num5 = stack.top();
        assertEquals(0.0, num5.getReal());
        assertEquals(-4.8392, num5.getImg());
        
        stack.push(0.0, -392.45291);
        stack.invertSignLastNumber();
        ComplexNumbers num6 = stack.top();
        assertEquals(0.0, num6.getReal());
        assertEquals(392.45291, num6.getImg());
        
        stack.push(30.2618, 0.0);
        stack.invertSignLastNumber();
        ComplexNumbers num7 = stack.top();
        assertEquals(-30.2618, num7.getReal());
        assertEquals(0.0, num7.getImg());
        
        stack.push(-6.47, 0.0);
        stack.invertSignLastNumber();
        ComplexNumbers num8 = stack.top();
        assertEquals(6.47, num8.getReal());
        assertEquals(0.0, num8.getImg());
        
        //test for stack with inserted boundary limits
        stack.push(-Double.MAX_VALUE-Double.MIN_VALUE, -Double.MAX_VALUE-Double.MIN_VALUE);
        stack.invertSignLastNumber();
        ComplexNumbers num9 = stack.top();
        assertEquals(Double.MAX_VALUE, num9.getReal());
        assertEquals(Double.MAX_VALUE, num9.getImg());
  
        stack.push(Double.MAX_VALUE, Double.MAX_VALUE);
        stack.invertSignLastNumber();
        ComplexNumbers num10 = stack.top();
        assertEquals(-Double.MAX_VALUE, num10.getReal());
        assertEquals(-Double.MAX_VALUE, num10.getImg());

    }
    
    /**
     * Test of dropLastNumber method, of class StackComplexNumbers.
     */
    @Test
    public void testDropLastNumber() {
        //test for empty stack
        assertEquals(false, stack.dropLastNumber());
        
        //test with 1 element in the stack
        stack.push(15.56, -3.256);
        stack.dropLastNumber();
        assertEquals(true, stack.isEmpty());
        
        stack.push(1.25, 0.7544);
        stack.push(12.03, -1.456);
        stack.dropLastNumber();
        assertEquals(1.25, stack.top().getReal());
        assertEquals(0.7544, stack.top().getImg());
        
    }
    
    /**
     * Test of swapLastTwoNumbers method, of class StackComplexNumbers.
     */
    @Test
    public void testSwapLastTwoNumbers() {
        //test for empty stack
        assertEquals(false, stack.swapLastTwoNumbers());
        
        //test with 1 element in the stack
        stack.push(15.56, -3.256);
        assertEquals(false, stack.swapLastTwoNumbers());
        
        stack.push(1.25, 0.7544);
        stack.push(12.03, -1.456);
        stack.swapLastTwoNumbers();
        assertEquals(1.25, stack.top().getReal());
        assertEquals(0.7544, stack.top().getImg());
        
    }
    
    /**
     * Test of clear method, of class StackComplexNumbers.
     */
    @Test
    public void testClear() {
        //test for empty stack
        stack.clear();
        assertEquals(true, stack.isEmpty());
        
        stack.push(0.0, 72.54);
        stack.clear();
        assertEquals(true, stack.isEmpty());
        
        stack.push(5.93, 10.5);
        stack.push(78.38, 99.32);
        stack.clear();
        assertEquals(true, stack.isEmpty());

    }
    
    /**
     * Test of dupLastNumber method, of class StackComplexNumbers.
     */
    @Test
    public void testDupLastNumber() {
        //test for empty stack
        boolean n = stack.dupLastNumber();
        assertEquals(false, n);
        
        stack.push(0.0, 56.1);
        boolean n1 = stack.dupLastNumber();
        assertEquals(0.0, stack.top().getReal());
        assertEquals(56.1, stack.top().getImg());
        
        stack.push(13.784, 10.5);
        stack.push(89.2, 1.1);
        boolean n2 = stack.dupLastNumber();
        assertEquals(89.2, stack.top().getReal());
        assertEquals(1.1, stack.top().getImg());

    }
    
    /**
     * Test of dupSecondLastNumber method, of class StackComplexNumbers.
     */
    @Test
    public void testDupSecondLastNumber() {
        //test for empty stack
        boolean n = stack.dupSecondLastNumber();
        assertEquals(false, n);
        
        //test with 1 element in the stack
        stack.push(13.65, 22.8);
        boolean n1 = stack.dupSecondLastNumber();
        assertEquals(false, n1);
        stack.push(29.647, 2.0);
        stack.push(8.0, 56.29);
        boolean n2 = stack.dupSecondLastNumber();
        assertEquals(29.647, stack.top().getReal());
        assertEquals(2.0, stack.top().getImg());
        
        stack.push(27.4, 2.0);
        stack.push(11.3, 37.9);
        stack.push(25.684, 66.1);
        boolean n3 = stack.dupSecondLastNumber();
        assertEquals(11.3, stack.top().getReal());
        assertEquals(37.9, stack.top().getImg());

    }
    
    /**
     * Test of modLastNumber method, of class StackComplexNumbers.
     * The result of the modul expects a maximum of 8 decimal digits rounded up, 
     * for the implementation of the method in ComplexNumbers class.
     */
    @Test
    public void testModLastNumber() {
        //test for empty stack
        boolean n = stack.modLastNumber();
        assertEquals(false, n); 
        
        //test for stack with inserted numbers
        stack.push(5.63, 10.5);
        stack.push(13.6, 16.0);
        stack.modLastNumber();
        ComplexNumbers num = stack.top();
        assertEquals(20.9990476, num.getReal());
        
        stack.push(32.09, -47.6);
        stack.modLastNumber();
        ComplexNumbers num1 = stack.top();
        assertEquals(57.40669038, num1.getReal());
        
        stack.push(-54.8621, 3.88);
        stack.modLastNumber();
        ComplexNumbers num2 = stack.top();
        assertEquals(54.99913105, num2.getReal());
        
        stack.push(-50.32, -1.4);
        stack.modLastNumber();
        ComplexNumbers num3 = stack.top();
        assertEquals(50.33947159, num3.getReal());
        
        stack.push(0.0, 0.0);
        stack.modLastNumber();
        ComplexNumbers num4 = stack.top();
        assertEquals(0.0, num4.getReal());

        stack.push(0.0, 23.286);
        stack.modLastNumber();
        ComplexNumbers num5 = stack.top();
        assertEquals(23.286, num5.getReal());
        
        stack.push(0.0, -392.45291);
        stack.modLastNumber();
        ComplexNumbers num6 = stack.top();
        assertEquals(392.45291, num6.getReal());
        
        stack.push(99.3, 0.0);
        stack.modLastNumber();
        ComplexNumbers num7 = stack.top();
        assertEquals(99.3, num7.getReal());
        
        stack.push(-5.321, 0.0);
        stack.modLastNumber();
        ComplexNumbers num8 = stack.top();
        assertEquals(5.321, num8.getReal());
 
        //test for stack with inserted boundary limits
        stack.push(-Double.MAX_VALUE-Double.MIN_VALUE, -Double.MAX_VALUE-Double.MIN_VALUE);
        stack.modLastNumber();
        ComplexNumbers num9 = stack.top();
        assertEquals(Double.POSITIVE_INFINITY, num9.getReal());
  
        stack.push(-Double.MAX_VALUE, -Double.MAX_VALUE);
        stack.modLastNumber();
        ComplexNumbers num10 = stack.top();
        assertEquals(Double.POSITIVE_INFINITY, num10.getReal());
        
        stack.push(-Double.MAX_VALUE+Double.MIN_VALUE, -Double.MAX_VALUE+Double.MIN_VALUE);
        stack.modLastNumber();
        ComplexNumbers num11 = stack.top();
        assertEquals(Double.POSITIVE_INFINITY, num11.getReal());
              
        stack.push(Double.MAX_VALUE-Double.MIN_VALUE, Double.MAX_VALUE-Double.MIN_VALUE);
        stack.modLastNumber();
        ComplexNumbers num12 = stack.top();
        assertEquals(Double.POSITIVE_INFINITY, num12.getReal());
          
        stack.push(Double.MAX_VALUE, Double.MAX_VALUE);
        stack.modLastNumber();
        ComplexNumbers num13 = stack.top();
        assertEquals(Double.POSITIVE_INFINITY, num13.getReal());
        
        stack.push(Double.MAX_VALUE+Double.MIN_VALUE, Double.MAX_VALUE+Double.MIN_VALUE);
        stack.modLastNumber();
        ComplexNumbers num14 = stack.top();
        assertEquals(Double.POSITIVE_INFINITY, num14.getReal());
        
        //the complex number constructor approximates the number to the eighth decimal place
        stack.push(0.00000001, 0.00000001);
        stack.modLastNumber();
        ComplexNumbers num15 = stack.top();
        assertEquals(1.0E-8, num15.getReal()); 
       
        stack.push(0.000000001, 0.000000001);
        stack.modLastNumber();
        ComplexNumbers num16 = stack.top();
        assertEquals(0.0, num16.getReal());

    }
    
    /**
     * Test of argLastNumber method, of class StackComplexNumbers.
     * The result of the argument expects a maximum of 8 decimal digits rounded up, 
     * for the implementation of the method in ComplexNumbers class.
     */
    @Test
    public void testArgLastNumber() {
        //test for empty stack
        boolean n = stack.argLastNumber();
        assertEquals(false, n);
        
        //test for stack with inserted numbers
        stack.push(40.32, 3.7);
        stack.push(10.3, 55.93);
        stack.argLastNumber();
        ComplexNumbers num = stack.top();
        assertEquals(1.38867807, num.getReal());
        
        stack.push(4.31, -65.92);
        stack.argLastNumber();
        ComplexNumbers num1 = stack.top();
        assertEquals(-1.50550697, num1.getReal());
        
        stack.push(-65.4, 2.345);
        stack.argLastNumber();
        ComplexNumbers num2 = stack.top();
        assertEquals(3.10575174, num2.getReal());
        
        stack.push(-19.4, -53.28);
        stack.argLastNumber();
        ComplexNumbers num3 = stack.top();
        assertEquals(-1.91998922, num3.getReal());
        
        stack.push(0.0, 0.0);
        stack.argLastNumber();
        ComplexNumbers num4 = stack.top();
        assertEquals(0.0, num4.getReal());

        stack.push(0.0, 21.854);
        stack.argLastNumber();
        ComplexNumbers num5 = stack.top();
        assertEquals(1.57079633, num5.getReal());
        
        stack.push(0.0, -5.1);
        stack.argLastNumber();
        ComplexNumbers num6 = stack.top();
        assertEquals(-1.57079633, num6.getReal());
        
        stack.push(37.492, 0.0);
        stack.argLastNumber();
        ComplexNumbers num7 = stack.top();
        assertEquals(0.0, num7.getReal());
        
        stack.push(-43.7774, 0.0);
        stack.argLastNumber();
        ComplexNumbers num8 = stack.top();
        assertEquals(3.14159265, num8.getReal());
        
        //test for stack with inserted boundary limits
        stack.push(-Double.MAX_VALUE-Double.MIN_VALUE, -Double.MAX_VALUE-Double.MIN_VALUE);
        stack.argLastNumber();
        ComplexNumbers num9 = stack.top();
        assertEquals(-2.35619449, num9.getReal()); 
  
        stack.push(-Double.MAX_VALUE, -Double.MAX_VALUE);
        stack.argLastNumber();
        ComplexNumbers num10 = stack.top();
        assertEquals(-2.35619449, num10.getReal()); 
        
        stack.push(-Double.MAX_VALUE+Double.MIN_VALUE, -Double.MAX_VALUE+Double.MIN_VALUE);
        stack.argLastNumber();
        ComplexNumbers num11 = stack.top();
        assertEquals(-2.35619449, num11.getReal()); 
              
        stack.push(Double.MAX_VALUE-Double.MIN_VALUE, Double.MAX_VALUE-Double.MIN_VALUE);
        stack.argLastNumber();
        ComplexNumbers num12 = stack.top();
        assertEquals(0.78539816, num12.getReal()); 
          
        stack.push(Double.MAX_VALUE, Double.MAX_VALUE);
        stack.argLastNumber();
        ComplexNumbers num13 = stack.top();
        assertEquals(0.78539816, num13.getReal());
        
        stack.push(Double.MAX_VALUE+Double.MIN_VALUE, Double.MAX_VALUE+Double.MIN_VALUE);
        stack.argLastNumber();
        ComplexNumbers num14 = stack.top();
        assertEquals(0.78539816, num14.getReal()); 
        
        //the complex number constructor approximates the number to the eighth decimal place
        stack.push(0.00000001, 0.00000001);
        stack.argLastNumber();
        ComplexNumbers num15 = stack.top();
        assertEquals(0.78539816, num15.getReal()); 
       
        stack.push(0.000000001, 0.000000001);
        stack.argLastNumber();
        ComplexNumbers num16 = stack.top();
        assertEquals(0.0, num16.getReal());

    }
    
    /**
     * Test of logLastNumber method, of class StackComplexNumbers.
     * The result of the arguments expects a maximum of 8 decimal digits rounded up, 
     * for the implementation of the method in ComplexNumbers class.
     */
    @Test
    public void testLogLastNumber() {
        //test for empty stack
        boolean n = stack.argLastNumber();
        assertEquals(false, n);
        
        //test for stack with inserted numbers
        stack.push(39.459, 10);
        stack.push(184.392, 3.92);
        stack.logLastNumber();
        ComplexNumbers num = stack.top();
        assertEquals(5.21728985, num.getReal());
        assertEquals(0.02125586, num.getImg());
        
        stack.push(23.5302, -19.3);
        stack.logLastNumber();
        ComplexNumbers num1 = stack.top();
        assertEquals(3.41552367, num1.getReal());
        assertEquals(-0.68695069, num1.getImg());
        
        stack.push(-36.91, 1.3);
        stack.logLastNumber();
        ComplexNumbers num2 = stack.top();
        assertEquals(3.60910239, num2.getReal());
        assertEquals(3.1063864, num2.getImg());
        
        stack.push(-47.27, -50.1);
        stack.logLastNumber();
        ComplexNumbers num3 = stack.top();
        assertEquals(4.23236676, num3.getReal());
        assertEquals(-2.32713828, num3.getImg());
        
        stack.push(0.0, 0.0);
        stack.logLastNumber();
        ComplexNumbers num4 = stack.top();
        assertEquals(Double.NEGATIVE_INFINITY, num4.getReal());
        assertEquals(0.0, num4.getImg());

        stack.push(0.0, 20.462);
        stack.logLastNumber();
        ComplexNumbers num5 = stack.top();
        assertEquals(3.01856951, num5.getReal());
        assertEquals(1.57079633, num5.getImg());
        
        stack.push(0.0, -92.83);
        stack.logLastNumber();
        ComplexNumbers num6 = stack.top();
        assertEquals(4.53076986, num6.getReal());
        assertEquals(-1.57079633, num6.getImg());
        
        stack.push(28.43, 0.0);
        stack.logLastNumber();
        ComplexNumbers num7 = stack.top();
        assertEquals(3.34744493, num7.getReal());
        assertEquals(0.0, num7.getImg());
        
        stack.push(-561.3376, 0.0);
        stack.logLastNumber();
        ComplexNumbers num8 = stack.top();
        assertEquals(6.33032251, num8.getReal());
        assertEquals(3.14159265, num8.getImg());
        
        stack.push(Math.E, 0.0);
        stack.logLastNumber();
        ComplexNumbers num9 = stack.top();
        assertEquals(1.0, num9.getReal());
        assertEquals(0.0, num9.getImg());
        
        //test for stack with inserted boundary limits
        stack.push(-Double.MAX_VALUE-Double.MIN_VALUE, -Double.MAX_VALUE-Double.MIN_VALUE);
        stack.logLastNumber();
        ComplexNumbers num10 = stack.top();
        assertEquals(Double.POSITIVE_INFINITY, num10.getReal());
        assertEquals(-2.35619449, num10.getImg());
  
        stack.push(-Double.MAX_VALUE, -Double.MAX_VALUE);
        stack.logLastNumber();
        ComplexNumbers num11 = stack.top();
        assertEquals(Double.POSITIVE_INFINITY, num11.getReal());
        assertEquals(-2.35619449, num11.getImg());
        
        stack.push(-Double.MAX_VALUE+Double.MIN_VALUE, -Double.MAX_VALUE+Double.MIN_VALUE);
        stack.logLastNumber();
        ComplexNumbers num12 = stack.top();
        assertEquals(Double.POSITIVE_INFINITY, num12.getReal());
        assertEquals(-2.35619449, num12.getImg());
              
        stack.push(Double.MAX_VALUE-Double.MIN_VALUE, Double.MAX_VALUE-Double.MIN_VALUE);
        stack.logLastNumber();
        ComplexNumbers num13 = stack.top();
        assertEquals(Double.POSITIVE_INFINITY, num13.getReal());
        assertEquals(0.78539816, num13.getImg());
          
        stack.push(Double.MAX_VALUE, Double.MAX_VALUE);
        stack.logLastNumber();
        ComplexNumbers num14 = stack.top();
        assertEquals(Double.POSITIVE_INFINITY, num14.getReal());
        assertEquals(0.78539816, num14.getImg()); 
        
        stack.push(Double.MAX_VALUE+Double.MIN_VALUE, Double.MAX_VALUE+Double.MIN_VALUE);
        stack.logLastNumber();
        ComplexNumbers num15 = stack.top();
        assertEquals(Double.POSITIVE_INFINITY, num15.getReal());
        assertEquals(0.78539816, num15.getImg());
        
        //the complex number constructor approximates the number to the eighth decimal place
        stack.push(0.00000001, 0.00000001);
        stack.logLastNumber();
        ComplexNumbers num16 = stack.top();
        assertEquals(-18.07410715, num16.getReal()); 
        assertEquals(0.78539816, num16.getImg()); 
       
        stack.push(0.000000001, 0.000000001);
        stack.logLastNumber();
        ComplexNumbers num17 = stack.top();
        assertEquals(Double.NEGATIVE_INFINITY, num17.getReal());
        assertEquals(0.0, num17.getImg());
    }
    
    /**
     * Test of expLastNumber method, of class StackComplexNumbers.
     * The result of the arguments expects a maximum of 8 decimal digits rounded up, 
     * for the implementation of the method in ComplexNumbers class.
     */
    @Test
    public void testExpLastNumber() {
        //test for empty stack
        boolean n = stack.argLastNumber();
        assertEquals(false, n);
        
        //test for stack with inserted numbers
        stack.push(6.27, 1);
        stack.push(29.4, 19.382);
        stack.expLastNumber();
        ComplexNumbers num = stack.top();
        assertEquals(5052982541961.771, num.getReal());
        assertEquals(2977241845731.3906, num.getImg());
        
        stack.push(16.37, -0.281);
        stack.expLastNumber();
        ComplexNumbers num1 = stack.top();
        assertEquals(12360157.10532003, num1.getReal());
        assertEquals(-3567602.68363675, num1.getImg());
        
        stack.push(-6.63, 2.93);
        stack.expLastNumber();
        ComplexNumbers num2 = stack.top();
        assertEquals(-0.00129072, num2.getReal());
        assertEquals(0.00027726, num2.getImg());
        
        stack.push(-2.3817, -3.1);
        stack.expLastNumber();
        ComplexNumbers num3 = stack.top();
        assertEquals(-0.09231347, num3.getReal());
        assertEquals(-0.00384178, num3.getImg());
        
        stack.push(0.0, 0.0);
        stack.expLastNumber();
        ComplexNumbers num4 = stack.top();
        assertEquals(1.0, num4.getReal());
        assertEquals(0.0, num4.getImg());

        stack.push(0.0, 25.291);
        stack.expLastNumber();
        ComplexNumbers num5 = stack.top();
        assertEquals(0.9875032, num5.getReal());
        assertEquals(0.15759898, num5.getImg());
        
        stack.push(0.0, -19.38);
        stack.expLastNumber();
        ComplexNumbers num6 = stack.top();
        assertEquals(0.86258249, num6.getReal());
        assertEquals(-0.50591645, num6.getImg());
        
        stack.push(30.2, 0.0);
        stack.expLastNumber();
        ComplexNumbers num7 = stack.top();
        assertEquals(13052489528882.516, num7.getReal());
        assertEquals(0.0, num7.getImg());
        
        stack.push(-24.543, 0.0);
        stack.expLastNumber();
        ComplexNumbers num8 = stack.top();
        assertEquals(0.0, num8.getReal());
        assertEquals(0.0, num8.getImg());
        
        //test for stack with inserted boundary limits
        stack.push(-Double.MAX_VALUE-Double.MIN_VALUE, -Double.MAX_VALUE-Double.MIN_VALUE);
        stack.expLastNumber();
        ComplexNumbers num9 = stack.top();
        assertEquals(0.0, num9.getReal()); 
        assertEquals(0.0, num9.getImg());  
  
        stack.push(-Double.MAX_VALUE, -Double.MAX_VALUE);
        stack.expLastNumber();
        ComplexNumbers num10 = stack.top();
        assertEquals(0.0, num10.getReal());  
        assertEquals(0.0, num10.getImg());  
        
        stack.push(-Double.MAX_VALUE+Double.MIN_VALUE, -Double.MAX_VALUE+Double.MIN_VALUE);
        stack.expLastNumber();
        ComplexNumbers num11 = stack.top();
        assertEquals(0.0, num11.getReal());  
        assertEquals(0.0, num11.getImg());  
              
        stack.push(Double.MAX_VALUE-Double.MIN_VALUE, Double.MAX_VALUE-Double.MIN_VALUE);
        stack.expLastNumber();
        ComplexNumbers num12 = stack.top();
        assertEquals(Double.NEGATIVE_INFINITY, num12.getReal());  
        assertEquals(Double.POSITIVE_INFINITY, num12.getImg());
          
        stack.push(Double.MAX_VALUE, Double.MAX_VALUE);
        stack.expLastNumber();
        ComplexNumbers num13 = stack.top();
        assertEquals(Double.NEGATIVE_INFINITY, num13.getReal());
        assertEquals(Double.POSITIVE_INFINITY, num13.getImg()); 
        
        stack.push(Double.MAX_VALUE+Double.MIN_VALUE, Double.MAX_VALUE+Double.MIN_VALUE);
        stack.expLastNumber();
        ComplexNumbers num14 = stack.top();
        assertEquals(Double.NEGATIVE_INFINITY, num14.getReal());
        assertEquals(Double.POSITIVE_INFINITY, num14.getImg());
        
        //the complex number constructor approximates the number to the eighth decimal place
        stack.push(0.00000001, 0.00000001);
        stack.expLastNumber();
        ComplexNumbers num15 = stack.top();
        assertEquals(1.00000001, num15.getReal());
        assertEquals(0.00000001, num15.getImg());
       
        stack.push(0.000000001, 0.000000001);
        stack.expLastNumber();
        ComplexNumbers num16 = stack.top();
        assertEquals(1.0, num16.getReal());
        assertEquals(0.0, num16.getImg());
    }
    
    /**
     * Test of sinLastNumber method, of class StackComplexNumbers.
     * The result of the arguments expects a maximum of 8 decimal digits rounded up, 
     * for the implementation of the method in ComplexNumbers class.
     */
    @Test
    public void testSinLastNumber() {
        //test for empty stack
        boolean n = stack.sinLastNumber();
        assertEquals(false, n); 
        
        //test for stack with inserted numbers
        stack.push(32.87, 12.34);
        stack.push(13.81, 160.452);
        stack.sinLastNumber();
        ComplexNumbers num = stack.top();
        assertEquals(2.2841166532129237E69, num.getReal());
        assertEquals(7.751435039379318E68, num.getImg());
        
        stack.push(89.271, -23.481);
        stack.sinLastNumber();
        ComplexNumbers num1 = stack.top();
        assertEquals(7608156000.9525795, num1.getReal());
        assertEquals(-2059743980.639147, num1.getImg());
        
        stack.push(-5.28, 91.2);
        stack.sinLastNumber();
        ComplexNumbers num2 = stack.top();
        assertEquals(1.7082484609464478E39, num2.getReal());
        assertEquals(1.089184732547192E39, num2.getImg());
        
        stack.push(-283.481, -1.1);
        stack.sinLastNumber();
        ComplexNumbers num3 = stack.top();
        assertEquals(-1.12217704, num3.getReal());
        assertEquals(-0.98843733, num3.getImg());
        
        stack.push(0.0, 0.0);
        stack.sinLastNumber();
        ComplexNumbers num4 = stack.top();
        assertEquals(0.0, num4.getReal());
        assertEquals(0.0, num4.getImg());

        stack.push(0.0, 11.678);
        stack.sinLastNumber();
        ComplexNumbers num5 = stack.top();
        assertEquals(0.0, num5.getReal());
        assertEquals(58974.0514002, num5.getImg());
        
        stack.push(0.0, -66.401);
        stack.sinLastNumber();
        ComplexNumbers num6 = stack.top();
        assertEquals(0.0, num6.getReal());
        assertEquals(-3.4399956801245515E28, num6.getImg());
        
        stack.push(31.32, 0.0);
        stack.sinLastNumber();
        ComplexNumbers num7 = stack.top();
        assertEquals(-0.09577949, num7.getReal());
        assertEquals(0.0, num7.getImg());
        
        stack.push(-3.562, 0.0);
        stack.sinLastNumber();
        ComplexNumbers num8 = stack.top();
        assertEquals(0.40813236, num8.getReal());
        assertEquals(0.0, num8.getImg());
        
        //test for stack with inserted boundary limits
        stack.push(-Double.MAX_VALUE-Double.MIN_VALUE, -Double.MAX_VALUE-Double.MIN_VALUE);
        stack.sinLastNumber();
        ComplexNumbers num9 = stack.top();
        assertEquals(Double.NEGATIVE_INFINITY, num9.getReal()); 
        assertEquals(Double.POSITIVE_INFINITY, num9.getImg());  
  
        stack.push(-Double.MAX_VALUE, -Double.MAX_VALUE);
        stack.sinLastNumber();
        ComplexNumbers num10 = stack.top();
        assertEquals(Double.NEGATIVE_INFINITY, num10.getReal());  
        assertEquals(Double.POSITIVE_INFINITY, num10.getImg());  
        
        stack.push(-Double.MAX_VALUE+Double.MIN_VALUE, -Double.MAX_VALUE+Double.MIN_VALUE);
        stack.sinLastNumber();
        ComplexNumbers num11 = stack.top();
        assertEquals(Double.NEGATIVE_INFINITY, num11.getReal());  
        assertEquals(Double.POSITIVE_INFINITY, num11.getImg());  
              
        stack.push(Double.MAX_VALUE-Double.MIN_VALUE, Double.MAX_VALUE-Double.MIN_VALUE);
        stack.sinLastNumber();
        ComplexNumbers num12 = stack.top();
        assertEquals(Double.POSITIVE_INFINITY, num12.getReal());  
        assertEquals(Double.NEGATIVE_INFINITY, num12.getImg());
          
        stack.push(Double.MAX_VALUE, Double.MAX_VALUE);
        stack.sinLastNumber();
        ComplexNumbers num13 = stack.top();
        assertEquals(Double.POSITIVE_INFINITY, num13.getReal());
        assertEquals(Double.NEGATIVE_INFINITY, num13.getImg()); 
        
        stack.push(Double.MAX_VALUE+Double.MIN_VALUE, Double.MAX_VALUE+Double.MIN_VALUE);
        stack.sinLastNumber();
        ComplexNumbers num14 = stack.top();
        assertEquals(Double.POSITIVE_INFINITY, num14.getReal());
        assertEquals(Double.NEGATIVE_INFINITY, num14.getImg());
        
        //the complex number constructor approximates the number to the eighth decimal place
        stack.push(0.00000001, 0.00000001);
        stack.sinLastNumber();
        ComplexNumbers num15 = stack.top();
        assertEquals(1E-8, num15.getReal());
        assertEquals(1E-8, num15.getImg());
       
        stack.push(0.000000001, 0.000000001);
        stack.sinLastNumber();
        ComplexNumbers num16 = stack.top();
        assertEquals(0.0, num16.getReal());
        assertEquals(0.0, num16.getImg());
    }  
}
