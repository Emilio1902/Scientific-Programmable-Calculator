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
        ComplexNumbers num = stack.top();
        assertEquals(14.8, num.getReal());
        assertEquals(37.1, num.getImg());
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
        
        stack.push(21.5, 13.1);
        stack.push(3.5, 2.4);
        stack.sumLastTwoNumbers();
        ComplexNumbers num = stack.top();
        assertEquals(25.0, num.getReal());
        assertEquals(15.5, num.getImg());

        stack.push(14.2, -19.7);
        stack.push(0.0, 6.6);
        stack.sumLastTwoNumbers();
        ComplexNumbers num1 = stack.top();
        assertEquals(14.2, num1.getReal());
        assertEquals(-13.1, num1.getImg());

        stack.push(0, -13.9);
        stack.push(-1.36, 1);
        stack.sumLastTwoNumbers();
        ComplexNumbers num2 = stack.top();
        assertEquals(-1.36, num2.getReal());
        assertEquals(-12.9, num2.getImg());

        stack.push(-73.1, -62.28);
        stack.push(-36.0, 1.8);
        stack.sumLastTwoNumbers();
        ComplexNumbers num3 = stack.top();
        assertEquals(-109.1, num3.getReal());
        assertEquals(-60.48, num3.getImg());

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
        
        stack.push(39.56, 13.2);
        stack.push(47.3, 2.4);
        stack.differenceLastTwoNumbers();
        ComplexNumbers num = stack.top();
        assertEquals(-7.74, num.getReal());
        assertEquals(10.8, num.getImg());

        stack.push(23.6, -11.1);
        stack.push(0.0, 48.29);
        stack.differenceLastTwoNumbers();
        ComplexNumbers num1 = stack.top();
        assertEquals(23.6, num1.getReal());
        assertEquals(-59.39, num1.getImg());

        stack.push(0, -16);
        stack.push(-79.24, 1);
        stack.differenceLastTwoNumbers();
        ComplexNumbers num2 = stack.top();
        assertEquals(79.24, num2.getReal());
        assertEquals(-17.0, num2.getImg());

        stack.push(-99.1, -2.345);
        stack.push(-12.25, -18.871);
        stack.differenceLastTwoNumbers();
        ComplexNumbers num3 = stack.top();
        assertEquals(-86.85, num3.getReal());
        assertEquals(16.526, num3.getImg());

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
        
        stack.push(2.8, 28.41);
        stack.push(4.6, 10.0);
        stack.productLastTwoNumbers();
        ComplexNumbers num = stack.top();
        assertEquals(-271.22, num.getReal());
        assertEquals(158.686, num.getImg());

        stack.push(2.9, -22.89);
        stack.push(0.0, 4.8);
        stack.productLastTwoNumbers();
        ComplexNumbers num1 = stack.top();
        assertEquals(109.872, num1.getReal());
        assertEquals(13.92, num1.getImg());

        stack.push(0.0, 0.0);
        stack.push(-5.61, 1);
        stack.productLastTwoNumbers();
        ComplexNumbers num2 = stack.top();
        assertEquals(-0.0, num2.getReal());
        assertEquals(0.0, num2.getImg());

        stack.push(-45.123, -1.1);
        stack.push(-2.0, -73.8);
        stack.productLastTwoNumbers();
        ComplexNumbers num3 = stack.top();
        assertEquals(9.066, num3.getReal());
        assertEquals(3332.2774, num3.getImg());
        
        stack.push(25.9, -3.871);
        stack.push(-5.274, -1.29);
        stack.productLastTwoNumbers();
        ComplexNumbers num4 = stack.top();
        assertEquals(-141.59019, num4.getReal());
        assertEquals(-12.995346, num4.getImg());

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
        
        stack.push(5.9, 66.8);
        stack.push(1.9, 10.0);
        stack.ratioLastTwoNumbers();
        ComplexNumbers num = stack.top();
        assertEquals(6.55544832, num.getReal());
        assertEquals(0.65553518, num.getImg());

        stack.push(19.45, -57.156);
        stack.push(0.0, 3.4);
        stack.ratioLastTwoNumbers();
        ComplexNumbers num1 = stack.top();
        assertEquals(-16.81058824, num1.getReal());
        assertEquals(-5.72058824, num1.getImg());

        stack.push(0.0, 0.0);
        stack.push(-4.7, 1);
        stack.ratioLastTwoNumbers();
        ComplexNumbers num2 = stack.top();
        assertEquals(0.0, num2.getReal());
        assertEquals(-0.0, num2.getImg());

        stack.push(-23.897, -1.8);
        stack.push(-6.0, -1.0);
        stack.ratioLastTwoNumbers();
        ComplexNumbers num3 = stack.top();
        assertEquals(3.92383784, num3.getReal());
        assertEquals(-0.35397297, num3.getImg());
        
        stack.push(42.9, -3.9);
        stack.push(-2.2, -3.8);
        stack.ratioLastTwoNumbers();
        ComplexNumbers num4 = stack.top();
        assertEquals(-4.12655602, num4.getReal());
        assertEquals(8.90041494, num4.getImg());
        
        stack.push(73.8, 2.6);
        stack.push(0.0, 0.0);
        boolean n5 = stack.ratioLastTwoNumbers();
        assertEquals(false, n5);
        
        stack.push(23.6, 2.5);
        stack.push(13.0, 0.0);
        stack.ratioLastTwoNumbers();
        ComplexNumbers num6 = stack.top();
        assertEquals(1.81538462, num6.getReal());
        assertEquals(0.19230769, num6.getImg());
        
        stack.push(-6.2, 6.2);
        stack.push(3.1, 3.1);
        stack.ratioLastTwoNumbers();
        ComplexNumbers num7 = stack.top();
        assertEquals(0.0, num7.getReal());
        assertEquals(2.0, num7.getImg());

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
        
        stack.push(5.67, 48.1);
        stack.push(6.31, 39.443);
        stack.squareRootLastNumber();
        ComplexNumbers num = stack.top();
        assertEquals(4.80908208, num.getReal());

        stack.push(0.0, 15.39);
        stack.squareRootLastNumber();
        ComplexNumbers num1 = stack.top();
        assertEquals(2.7739863, num1.getReal());

        stack.push(0.0, 0.0);
        stack.squareRootLastNumber();
        ComplexNumbers num2 = stack.top();
        assertEquals(0.0, num2.getReal());

        stack.push(-36.41, -1.95);
        stack.squareRootLastNumber();
        ComplexNumbers num3 = stack.top();
        assertEquals(-0.16152461, num3.getReal());
        
        stack.push(59.3, -22.56);
        stack.squareRootLastNumber();
        ComplexNumbers num4 = stack.top();
        assertEquals( -7.8341044, num4.getReal());

    }
    
    /**
     * Test of invertSignLastNumber method, of class StackComplexNumbers.
     */
    @Test
    public void testInvertSignLastNumber() {
        //test for empty stack
        boolean n = stack.invertSignLastNumber();
        assertEquals(false, n);
        
        stack.push(4.65, 1.5);
        stack.push(17.593, 30.5);
        stack.invertSignLastNumber();
        ComplexNumbers num = stack.top();
        assertEquals(-17.593, num.getReal());
        assertEquals(-30.5, num.getImg());

        stack.push(0.0, 15.39);
        stack.invertSignLastNumber();
        ComplexNumbers num1 = stack.top();
        assertEquals(0.0, num1.getReal());
        assertEquals(-15.39, num1.getImg());

        stack.push(0.0, 0.0);
        stack.invertSignLastNumber();
        ComplexNumbers num2 = stack.top();
        assertEquals(0.0, num2.getReal());
        assertEquals(0.0, num2.getImg());

        stack.push(-34.921, -30.9);
        stack.invertSignLastNumber();
        ComplexNumbers num3 = stack.top();
        assertEquals(34.921, num3.getReal());
        assertEquals(30.9, num3.getImg());
        
        stack.push(25.3, -25.3);
        stack.invertSignLastNumber();
        ComplexNumbers num4 = stack.top();
        assertEquals(-25.3, num4.getReal());
        assertEquals(25.3, num4.getImg());

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
     * The result of the modulus expects a maximum of 8 decimal digits rounded up, 
     * for the implementation of the method in ComplexNumbers class.
     */
    @Test
    public void testModLastNumber() {
        //test for empty stack
        boolean n = stack.modLastNumber();
        assertEquals(false, n);
        
        stack.push(5.63, 10.5);
        stack.push(13.6, 16.0);
        stack.modLastNumber();
        ComplexNumbers num = stack.top();
        assertEquals(20.9990476, num.getReal());

        stack.push(0.0, 23.286);
        stack.modLastNumber();
        ComplexNumbers num1 = stack.top();
        assertEquals(23.286, num1.getReal());
        
        stack.push(99.3, 0.0);
        stack.modLastNumber();
        ComplexNumbers num2 = stack.top();
        assertEquals(99.3, num2.getReal());

        stack.push(0.0, 0.0);
        stack.modLastNumber();
        ComplexNumbers num3 = stack.top();
        assertEquals(0.0, num3.getReal());

        stack.push(-50.32, -1.4);
        stack.modLastNumber();
        ComplexNumbers num4 = stack.top();
        assertEquals(50.33947159, num4.getReal());
        
        stack.push(32.09, -47.6);
        stack.modLastNumber();
        ComplexNumbers num5 = stack.top();
        assertEquals(57.40669038, num5.getReal());

    }
    
    /**
     * Test of argLastNumber method, of class StackComplexNumbers.
     * The result of the arguments expects a maximum of 8 decimal digits rounded up, 
     * for the implementation of the method in ComplexNumbers class.
     */
    @Test
    public void testArgLastNumber() {
        //test for empty stack
        boolean n = stack.argLastNumber();
        assertEquals(false, n);
        
        stack.push(40.32, 3.7);
        stack.push(10.3, 55.93);
        stack.argLastNumber();
        ComplexNumbers num = stack.top();
        assertEquals(1.38867807, num.getReal());

        
        stack.push(8.21, -3.78);
        stack.argLastNumber();
        ComplexNumbers num1 = stack.top();
        assertEquals(-0.43148049, num1.getReal());

        stack.push(0.0, 21.854);
        stack.argLastNumber();
        ComplexNumbers num2 = stack.top();
        assertEquals(1.57079633, num2.getReal());
        
        stack.push(0.0, -5.1);
        stack.argLastNumber();
        ComplexNumbers num3 = stack.top();
        assertEquals(-1.57079633, num3.getReal());
        
        stack.push(0.0, 0.0);
        stack.argLastNumber();
        ComplexNumbers num4 = stack.top();
        assertEquals(0.0, num4.getReal());
        
        stack.push(37.492, 0.0);
        stack.argLastNumber();
        ComplexNumbers num5 = stack.top();
        assertEquals(0.0, num5.getReal());

        stack.push(-19.4, -53.28);
        stack.argLastNumber();
        ComplexNumbers num6 = stack.top();
        assertEquals(-1.91998922, num6.getReal());
        
        stack.push(-65.4, 2.345);
        stack.argLastNumber();
        ComplexNumbers num7 = stack.top();
        assertEquals(3.10575174, num7.getReal());

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

        stack.push(0.0, 20.462);
        stack.logLastNumber();
        ComplexNumbers num2 = stack.top();
        assertEquals(3.01856951, num2.getReal());
        assertEquals(1.57079633, num2.getImg());
        
        stack.push(0.0, -92.83);
        stack.logLastNumber();
        ComplexNumbers num3 = stack.top();
        assertEquals(4.53076986, num3.getReal());
        assertEquals(-1.57079633, num3.getImg());
        
        stack.push(0.0, 0.0);
        stack.logLastNumber();
        ComplexNumbers num4 = stack.top();
        assertEquals(Double.NEGATIVE_INFINITY, num4.getReal());
        assertEquals(0.0, num4.getImg());
        
        stack.push(28.43, 0.0);
        stack.logLastNumber();
        ComplexNumbers num5 = stack.top();
        assertEquals(3.34744493, num5.getReal());
        assertEquals(0.0, num5.getImg());

        stack.push(-47.27, -50.1);
        stack.logLastNumber();
        ComplexNumbers num6 = stack.top();
        assertEquals(4.23236676, num6.getReal());
        assertEquals(-2.32713828, num6.getImg());
        
        stack.push(-36.91, 1.3);
        stack.logLastNumber();
        ComplexNumbers num7 = stack.top();
        assertEquals(3.60910239, num7.getReal());
        assertEquals(3.1063864, num7.getImg());
        
        stack.push(Math.E, 0.0);
        stack.logLastNumber();
        ComplexNumbers num8 = stack.top();
        assertEquals(1.0, num8.getReal());
        assertEquals(0.0, num8.getImg());

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

        stack.push(0.0, 25.291);
        stack.expLastNumber();
        ComplexNumbers num2 = stack.top();
        assertEquals(0.9875032, num2.getReal());
        assertEquals(0.15759898, num2.getImg());
        
        stack.push(0.0, -19.38);
        stack.expLastNumber();
        ComplexNumbers num3 = stack.top();
        assertEquals(0.86258249, num3.getReal());
        assertEquals(-0.50591645, num3.getImg());
        
        stack.push(0.0, 0.0);
        stack.expLastNumber();
        ComplexNumbers num4 = stack.top();
        assertEquals(1.0, num4.getReal());
        assertEquals(0.0, num4.getImg());
        
        stack.push(30.2, 0.0);
        stack.expLastNumber();
        ComplexNumbers num5 = stack.top();
        assertEquals(13052489528882.516, num5.getReal());
        assertEquals(0.0, num5.getImg());

        stack.push(-2.3817, -3.1);
        stack.expLastNumber();
        ComplexNumbers num6 = stack.top();
        assertEquals(-0.09231347, num6.getReal());
        assertEquals(-0.00384178, num6.getImg());
        
        stack.push(-6.63, 2.93);
        stack.expLastNumber();
        ComplexNumbers num7 = stack.top();
        assertEquals(-0.00129072, num7.getReal());
        assertEquals(0.00027726, num7.getImg());
        
        stack.push(Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY);
        stack.expLastNumber();
        ComplexNumbers num8 = stack.top();
        assertEquals(Double.NaN, num8.getReal());
        assertEquals(Double.NaN, num8.getImg());
        
        

    }
    
}
