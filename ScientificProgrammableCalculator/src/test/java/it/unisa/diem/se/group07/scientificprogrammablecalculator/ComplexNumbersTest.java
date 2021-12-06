/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package it.unisa.diem.se.group07.scientificprogrammablecalculator;

import org.junit.Test;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author raffa
 */
public class ComplexNumbersTest {

    private final ComplexNumbers[] numbers =new ComplexNumbers[17];

    @Before
    public void setUp() {
        numbers[0] = new ComplexNumbers(-Double.MAX_VALUE-Double.MIN_VALUE,-Double.MAX_VALUE-Double.MIN_VALUE);
        numbers[1] = new ComplexNumbers(-Double.MAX_VALUE,-Double.MAX_VALUE);
        numbers[2] = new ComplexNumbers(-Double.MAX_VALUE+Double.MIN_VALUE,-Double.MAX_VALUE+Double.MIN_VALUE);
        numbers[3] = new ComplexNumbers(7.15, 6.70);
        numbers[4] = new ComplexNumbers(13.73, -41.13);
        numbers[5] = new ComplexNumbers(-1.137, 3.375);
        numbers[6] = new ComplexNumbers(-4.443, -11.73);
        numbers[7] = new ComplexNumbers(5.003, 0);
        numbers[8] = new ComplexNumbers(0, 7.777);
        numbers[9] = new ComplexNumbers(-3.15, 0);
        numbers[10] = new ComplexNumbers(0, -23.71);
        numbers[11] = new ComplexNumbers(0, 0);
        numbers[12] = new ComplexNumbers(Double.MAX_VALUE-Double.MIN_VALUE,Double.MAX_VALUE-Double.MIN_VALUE);
        numbers[13] = new ComplexNumbers(Double.MAX_VALUE,Double.MAX_VALUE);
        numbers[14] = new ComplexNumbers(Double.MAX_VALUE+Double.MIN_VALUE,Double.MAX_VALUE+Double.MIN_VALUE);
        //the complex number constructor approximates the number to the eighth decimal place
        numbers[15] = new ComplexNumbers(0.00000001,0.00000001);
        numbers[16] = new ComplexNumbers(0.000000001,0.000000001);
        
    }

    /**
     * Test of getReal method, of class ComplexNumbers.
     */
    @Test
    public void testGetReal() {
        assertEquals(-Double.MAX_VALUE, numbers[0].getReal());
        assertEquals(-Double.MAX_VALUE, numbers[1].getReal());
        assertEquals(-Double.MAX_VALUE+Double.MIN_VALUE, numbers[2].getReal());
        assertEquals(7.15, numbers[3].getReal());
        assertEquals(13.73, numbers[4].getReal());
        assertEquals(-1.137, numbers[5].getReal());
        assertEquals(-4.443, numbers[6].getReal());
        assertEquals(5.003, numbers[7].getReal());
        assertEquals(0.0, numbers[8].getReal());
        assertEquals(-3.15, numbers[9].getReal());
        assertEquals(0.0, numbers[10].getReal());
        assertEquals(0.0, numbers[11].getReal());
        assertEquals(Double.MAX_VALUE-Double.MIN_VALUE, numbers[12].getReal());
        assertEquals(Double.MAX_VALUE, numbers[13].getReal());
        assertEquals(Double.MAX_VALUE, numbers[14].getReal());
        assertEquals(0.00000001, numbers[15].getReal());
        assertEquals(0.0, numbers[16].getReal());
    }

    /**
     * Test of getImg method, of class ComplexNumbers.
     */
    @Test
    public void testGetImg() {
        assertEquals(-Double.MAX_VALUE, numbers[0].getImg());
        assertEquals(-Double.MAX_VALUE, numbers[1].getImg());
        assertEquals(-Double.MAX_VALUE+Double.MIN_VALUE, numbers[2].getImg());
        assertEquals(6.70, numbers[3].getImg());
        assertEquals(-41.13, numbers[4].getImg());
        assertEquals(3.375, numbers[5].getImg());
        assertEquals(-11.73, numbers[6].getImg());
        assertEquals(0.0, numbers[7].getImg());
        assertEquals(7.777, numbers[8].getImg());
        assertEquals(0.0, numbers[9].getImg());
        assertEquals(-23.71, numbers[10].getImg());
        assertEquals(0.0, numbers[11].getImg());
        assertEquals(Double.MAX_VALUE-Double.MIN_VALUE, numbers[12].getImg());
        assertEquals(Double.MAX_VALUE, numbers[13].getImg());
        assertEquals(Double.MAX_VALUE, numbers[14].getImg());
        assertEquals(0.00000001, numbers[15].getImg());
        assertEquals(0.0, numbers[16].getImg());
    }
    
    /**
     * Test of mod method, of class ComplexNumbers.
     */
    @Test
    public void testMod() {
        assertEquals(Double.POSITIVE_INFINITY, numbers[0].mod());
        assertEquals(Double.POSITIVE_INFINITY, numbers[1].mod());
        assertEquals(Double.POSITIVE_INFINITY, numbers[2].mod());
        assertEquals(9.798596838323332, numbers[3].mod());
        assertEquals(43.36115542740991, numbers[4].mod());
        assertEquals(3.561375296146139, numbers[5].mod());
        assertEquals(12.54325113357777, numbers[6].mod());
        assertEquals(5.003, numbers[7].mod());
        assertEquals(7.777, numbers[8].mod());
        assertEquals(3.15, numbers[9].mod());
        assertEquals(23.71, numbers[10].mod());
        assertEquals(0.0, numbers[11].mod());
        assertEquals(Double.POSITIVE_INFINITY, numbers[12].mod());
        assertEquals(Double.POSITIVE_INFINITY, numbers[13].mod());
        assertEquals(Double.POSITIVE_INFINITY, numbers[14].mod());
        assertEquals(1.4142135623730952E-8, numbers[15].mod());
        assertEquals(0.0, numbers[16].mod());
    }
    
    /**
     * Test of arg method, of class ComplexNumbers.
     */
    @Test
    public void testArg() {
        assertEquals(-2.356194490192345, numbers[0].arg());
        assertEquals(-2.356194490192345, numbers[1].arg());
        assertEquals(-2.356194490192345, numbers[2].arg());
        assertEquals(0.7529186146099479, numbers[3].arg());
        assertEquals(-1.2486081994973603, numbers[4].arg());
        assertEquals(1.8957434606074932, numbers[5].arg());
        assertEquals(-1.93287017907239, numbers[6].arg());
        assertEquals(0.0, numbers[7].arg());
        assertEquals(1.5707963267948966, numbers[8].arg());
        assertEquals(3.141592653589793, numbers[9].arg());
        assertEquals(-1.5707963267948966, numbers[10].arg());
        assertEquals(0.0, numbers[11].arg());
        assertEquals(0.7853981633974483, numbers[12].arg());
        assertEquals(0.7853981633974483, numbers[13].arg());
        assertEquals(0.7853981633974483, numbers[14].arg());
        assertEquals(0.7853981633974483, numbers[15].arg());
        assertEquals(0.0, numbers[16].arg());
    }

    /*
    /**
     * Test of StringToComplex method, of class ComplexNumbers.
     */
    @Test
    public void testStringToComplex() {
        ComplexNumbers num1 = new ComplexNumbers("3.152");
        assertEquals(3.152, (num1.getReal()));
        assertEquals(0.0, (num1.getImg()));
        
        ComplexNumbers num2 = new ComplexNumbers("6.70i");
        assertEquals(0.0, (num2.getReal()));
        assertEquals(6.70, (num2.getImg()));

        ComplexNumbers num3 = new ComplexNumbers("7.15+6.70i");
        assertEquals(7.15, num3.getReal());
        assertEquals(6.70, num3.getImg());

        ComplexNumbers num4 = new ComplexNumbers("13.73-41.13i");
        assertEquals(13.73, num4.getReal());
        assertEquals(-41.13, num4.getImg());

        ComplexNumbers num5 = new ComplexNumbers("-1.137+3.375i");
        assertEquals(-1.137, num5.getReal());
        assertEquals(3.375, num5.getImg());
        
        ComplexNumbers num6 = new ComplexNumbers("-4.443-11.73i");
        assertEquals(-4.443, num6.getReal());
        assertEquals(-11.73, num6.getImg());
        
        ComplexNumbers num7 = new ComplexNumbers("-5.003");
        assertEquals(-5.003, num7.getReal());
        assertEquals(0.0, num7.getImg());
        
        ComplexNumbers num8 = new ComplexNumbers("-7.777i");
        assertEquals(0.0, num8.getReal());
        assertEquals(-7.777, num8.getImg());
        
        ComplexNumbers num9 = new ComplexNumbers("0");
        assertEquals(0.0, num9.getReal());
        assertEquals(0.0, num9.getImg());
        
        //Error cases
        ComplexNumbers num10 = new ComplexNumbers("175a6+36i");
        assertEquals(Double.NEGATIVE_INFINITY, num10.getReal());
        assertEquals(Double.NEGATIVE_INFINITY, num10.getImg());
        
        ComplexNumbers num11 = new ComplexNumbers("175+36");
        assertEquals(Double.NEGATIVE_INFINITY, num11.getReal());
        assertEquals(Double.NEGATIVE_INFINITY, num11.getImg());
        
        ComplexNumbers num12 = new ComplexNumbers("-175+");
        assertEquals(Double.NEGATIVE_INFINITY, num12.getReal());
        assertEquals(Double.NEGATIVE_INFINITY, num12.getImg());
    }

    /**
     * Test of sum method, of class ComplexNumbers.
     */
    @Test
    public void testSum() {
        //MinimumBoundary
        ComplexNumbers sum1 = numbers[11].sum(numbers[1]);
        assertEquals(-Double.MAX_VALUE, sum1.getReal());
        assertEquals(-Double.MAX_VALUE, sum1.getImg());

        //Above minimium
        ComplexNumbers sum2 = numbers[11].sum(numbers[2]);
        assertEquals(-Double.MAX_VALUE+Double.MIN_VALUE, sum2.getReal());
        assertEquals(-Double.MAX_VALUE+Double.MIN_VALUE, sum2.getImg());

        //Nominal
        ComplexNumbers sum3 = numbers[4].sum(numbers[5]);
        assertEquals(12.593, sum3.getReal());
        assertEquals(-37.755, sum3.getImg());
        
        ComplexNumbers sum4 = numbers[8].sum(numbers[9]);
        assertEquals(-3.15, sum4.getReal());
        assertEquals(7.777, sum4.getImg());
        
        ComplexNumbers sum5 = numbers[3].sum(numbers[6]);
        assertEquals(2.707, sum5.getReal());
        assertEquals(-5.03, sum5.getImg());
        
        ComplexNumbers sum6 = numbers[3].sum(numbers[4]);
        assertEquals(20.88, sum6.getReal());
        assertEquals(-34.43, sum6.getImg());
        
        ComplexNumbers sum7 = numbers[11].sum(numbers[6]);
        assertEquals(-4.443, sum7.getReal());
        assertEquals(-11.73, sum7.getImg());
        
        
        //Below Maximum
        ComplexNumbers sum8 = numbers[11].sum(numbers[12]);
        assertEquals(Double.MAX_VALUE-Double.MIN_VALUE, sum8.getReal());
        assertEquals(Double.MAX_VALUE-Double.MIN_VALUE, sum8.getImg());
        
        //Maximum Boundary
        ComplexNumbers sum9 = numbers[12].sum(new ComplexNumbers(Double.MIN_VALUE, Double.MIN_VALUE));
        assertEquals(Double.MAX_VALUE, sum9.getReal());
        assertEquals(Double.MAX_VALUE, sum9.getImg());
        
        //Outside
        ComplexNumbers sum10 = numbers[1].sum(numbers[2]);
        assertEquals(Double.NEGATIVE_INFINITY, sum10.getReal());
        assertEquals(Double.NEGATIVE_INFINITY, sum10.getImg());
        
        ComplexNumbers sum11 = numbers[1].sum(numbers[6]);
        assertEquals(-Double.MAX_VALUE, sum11.getReal());
        assertEquals(-Double.MAX_VALUE, sum11.getImg());
        
        ComplexNumbers sum12 = numbers[12].sum(numbers[13]);
        assertEquals(Double.POSITIVE_INFINITY, sum12.getReal());
        assertEquals(Double.POSITIVE_INFINITY, sum12.getImg());
        
        ComplexNumbers sum13 = numbers[13].sum(numbers[3]);
        assertEquals(Double.MAX_VALUE, sum13.getReal());
        assertEquals(Double.MAX_VALUE, sum13.getImg());
        
        
    }

    /**
     * Test of difference method, of class ComplexNumbers.
     */
    @Test
    public void testDifference() {
        //Minimum Boundary
        ComplexNumbers difference1 = numbers[11].difference(numbers[13]);
        assertEquals(-Double.MAX_VALUE, difference1.getReal());
        assertEquals(-Double.MAX_VALUE, difference1.getImg());

        //Above minimium
        ComplexNumbers difference2 =numbers[11].difference(numbers[12]);
        assertEquals(-Double.MAX_VALUE+Double.MIN_VALUE, difference2.getReal());
        assertEquals(-Double.MAX_VALUE+Double.MIN_VALUE, difference2.getImg());

        //Nominal
        ComplexNumbers difference3 = numbers[4].difference(numbers[5]);
        assertEquals(14.867, difference3.getReal());
        assertEquals(-44.505, difference3.getImg());
        
        ComplexNumbers difference4 = numbers[7].difference(numbers[10]);
        assertEquals(5.003, difference4.getReal());
        assertEquals(23.71, difference4.getImg());
        
        ComplexNumbers difference5 = numbers[3].difference(numbers[6]);
        assertEquals(11.593, difference5.getReal());
        assertEquals(18.43, difference5.getImg());
        
        ComplexNumbers difference6 = numbers[8].difference(numbers[9]);
        assertEquals(3.15, difference6.getReal());
        assertEquals(7.777, difference6.getImg());
        
        ComplexNumbers difference7 = numbers[11].difference(numbers[5]);
        assertEquals(1.137, difference7.getReal());
        assertEquals(-3.375, difference7.getImg());
        
        //Below Maximum
        ComplexNumbers difference8 = numbers[13].difference(new ComplexNumbers(Double.MIN_VALUE, Double.MIN_VALUE));
        assertEquals(Double.MAX_VALUE-Double.MIN_VALUE, difference8.getReal());
        assertEquals(Double.MAX_VALUE-Double.MIN_VALUE, difference8.getImg());
        
        //Maximum Boundary
        ComplexNumbers difference9 = numbers[11].difference(numbers[1]);
        assertEquals(Double.MAX_VALUE,difference9.getReal());
        assertEquals(Double.MAX_VALUE, difference9.getImg());
        
        //Outside
        ComplexNumbers difference10 = numbers[1].difference(numbers[13]);
        assertEquals(Double.NEGATIVE_INFINITY,difference10.getReal());
        assertEquals(Double.NEGATIVE_INFINITY, difference10.getImg());
        
        ComplexNumbers difference11 = numbers[1].difference(numbers[3]);
        assertEquals(-Double.MAX_VALUE,difference11.getReal());
        assertEquals(-Double.MAX_VALUE, difference11.getImg());
        
        ComplexNumbers difference12 = numbers[13].difference(numbers[1]);
        assertEquals(Double.POSITIVE_INFINITY,difference12.getReal());
        assertEquals(Double.POSITIVE_INFINITY, difference12.getImg());
        
        ComplexNumbers difference13 = numbers[13].difference(numbers[6]);
        assertEquals(Double.MAX_VALUE,difference13.getReal());
        assertEquals(Double.MAX_VALUE, difference13.getImg());
        
    }
    
    
    /**
     * Test of product method, of class ComplexNumbers.
     */
    @Test
    public void testProduct() {
        //Minimum Boundary
        ComplexNumbers num1 = new ComplexNumbers(-1.7976931348623157E30,0);
        ComplexNumbers num2 = new ComplexNumbers(1E278,0);
        
        ComplexNumbers product1 = num1.product(num2);
        assertEquals(-Double.MAX_VALUE, product1.getReal());
        assertEquals(0.0, product1.getImg());
        
        //Above minimium
        ComplexNumbers product2 = num1.product(num2);
        assertEquals(-Double.MAX_VALUE+Double.MIN_VALUE, product2.getReal());
        assertEquals(0.0, product2.getImg());
        
        //Nominal
        ComplexNumbers product3 = numbers[4].product(numbers[5]);
        assertEquals(123.20274, product3.getReal());
        assertEquals(93.10356, product3.getImg());
        
        ComplexNumbers product4 = numbers[3].product(numbers[11]);
        assertEquals(0.0, product4.getReal());
        assertEquals(0.0, product4.getImg());
        
        ComplexNumbers product5 = numbers[7].product(numbers[9]);
        assertEquals(-15.75945, product5.getReal());
        assertEquals(0.0, product5.getImg());
        
        ComplexNumbers product6 = numbers[3].product(numbers[6]);
        assertEquals(46.82355, product6.getReal());
        assertEquals(-113.6376, product6.getImg());
        
        ComplexNumbers product7 = numbers[5].product(numbers[7]);
        assertEquals(-5.688411, product7.getReal());
        assertEquals(16.885125, product7.getImg());
        //Below Maximum
        
        ComplexNumbers num4 = new ComplexNumbers(1,1.7976931348623157E307);
        ComplexNumbers num5 = new ComplexNumbers(1,1.6179238213760842E308-Double.MIN_VALUE);
        ComplexNumbers product8 = num4.product(num5);
        assertEquals(Double.NEGATIVE_INFINITY, product8.getReal());
        assertEquals(Double.MAX_VALUE-Double.MIN_VALUE, product8.getImg());
        
        //Maximum Boundary
        ComplexNumbers product9 = num1.invertSign().product(num2);
        assertEquals(Double.MAX_VALUE,product9.getReal());
        assertEquals(0.0, product9.getImg());
        
        //Outside
        ComplexNumbers product10 = numbers[2].product(numbers[3]);
        assertEquals(Double.NaN, product10.getReal());
        assertEquals(Double.NaN, product10.getImg());
        
        ComplexNumbers product11 = numbers[13].product(numbers[3]);
        assertEquals(Double.NaN, product11.getReal());
        assertEquals(Double.NaN, product11.getImg());
        
        ComplexNumbers product12 = numbers[10].product(new ComplexNumbers(Double.POSITIVE_INFINITY, 12324));
        assertEquals(Double.NaN, product12.getReal());
        assertEquals(Double.NaN, product12.getImg());
        
        ComplexNumbers num6 = new ComplexNumbers(Double.MAX_VALUE, 745.32);
        ComplexNumbers product13 = num6.product(num6);
        assertEquals(Double.POSITIVE_INFINITY, product13.getReal());
        assertEquals(Double.POSITIVE_INFINITY, product13.getImg());
        
        ComplexNumbers num7 = new ComplexNumbers(-Double.MAX_VALUE, 1);
        ComplexNumbers product14 = num6.product(num7);
        assertEquals(Double.NEGATIVE_INFINITY, product14.getReal());
        assertEquals(Double.NEGATIVE_INFINITY, product14.getImg());
    }
    
    /**
     * Test of ratio method, of class ComplexNumbers.
     */
    @Test
    public void testRatio() {
        //Minimum Boundary
        
        ComplexNumbers num1 = new ComplexNumbers(-5.6177910464447365625E304,1665.05654);
        ComplexNumbers num2 = new ComplexNumbers(0.0003125,0);
        ComplexNumbers ratio1 = num1.ratio(num2);
        assertEquals(-Double.MAX_VALUE, ratio1.getReal());
        assertEquals(5328180.928, ratio1.getImg());
        
        //Above minimium
        ComplexNumbers num3 = num1.sum(new ComplexNumbers(Double.MIN_VALUE, Double.MIN_VALUE));
        ComplexNumbers ratio2 = num3.ratio(num2);
        assertEquals(-Double.MAX_VALUE+Double.MIN_VALUE, ratio2.getReal());
        assertEquals(5328180.928, ratio2.getImg());
        
        //Nominal
        ComplexNumbers ratio3 = numbers[3].ratio(numbers[6]);
        assertEquals(-0.70143165, ratio3.getReal());
        assertEquals(0.34386523, ratio3.getImg());
        
        ComplexNumbers ratio4 = numbers[4].ratio(numbers[5]);
        assertEquals(-12.17534991, ratio4.getReal());
        assertEquals(0.03359195, ratio4.getImg());
        
        ComplexNumbers ratio5 = numbers[7].ratio(numbers[3]);
        assertEquals(0.37257076, ratio5.getReal());
        assertEquals(-0.34912225, ratio5.getImg());
        
        ComplexNumbers ratio6 = numbers[8].ratio(numbers[10]);
        assertEquals(-0.32800506, ratio6.getReal());
        assertEquals(0.0, ratio6.getImg());
        
        ComplexNumbers ratio7 = numbers[11].ratio(numbers[4]);
        assertEquals(0.0, ratio7.getReal());
        assertEquals(0.0, ratio7.getImg());
        
        //Below Maximum
        ComplexNumbers num4 = new ComplexNumbers(5.6177910464447365625E304,7.2365);
        ComplexNumbers ratio8 = num4.ratio(num2);
        assertEquals(Double.MAX_VALUE, ratio8.getReal());
        assertEquals(23156.8, ratio8.getImg());

        //Maximum Boundary
        ComplexNumbers num5 = num4.difference(new ComplexNumbers(Double.MIN_VALUE, Double.MIN_VALUE));
        ComplexNumbers ratio9 = num5.ratio(num2);
        assertEquals(Double.MAX_VALUE-Double.MIN_VALUE, ratio9.getReal());
        assertEquals(23156.8, ratio9.getImg());
        
        //Outside
        ComplexNumbers ratio10 = numbers[4].ratio(numbers[11]);
        assertEquals(Double.NEGATIVE_INFINITY, ratio10.getReal());
        assertEquals(0.0, ratio10.getImg());
        
        ComplexNumbers ratio11 = numbers[13].ratio(numbers[2]);
        assertEquals(Double.NaN, ratio11.getReal());
        assertEquals(Double.NaN, ratio11.getImg());
        
        ComplexNumbers ratio12 = numbers[13].ratio(numbers[3]);
        assertEquals(Double.NaN, ratio12.getReal());
        assertEquals(Double.NaN, ratio12.getImg());
    }
    
    /**
     * Test of squareRoot method, of class ComplexNumbers.
     */
    @Test
    public void testSquareRoot() {
        ComplexNumbers sqrt0 =numbers[0].squareRoot();
        assertEquals(Double.NEGATIVE_INFINITY, sqrt0.getReal());
        assertEquals(Double.POSITIVE_INFINITY, sqrt0.getImg());
        
        ComplexNumbers sqrt1 =numbers[1].squareRoot();
        assertEquals(Double.NEGATIVE_INFINITY, sqrt1.getReal());
        assertEquals(Double.POSITIVE_INFINITY, sqrt1.getImg());
        
        ComplexNumbers sqrt2 = numbers[2].squareRoot();
        assertEquals(Double.NEGATIVE_INFINITY, sqrt2.getReal());
        assertEquals(Double.POSITIVE_INFINITY, sqrt2.getImg());
       
        ComplexNumbers sqrt3 =numbers[3].squareRoot();
        assertEquals(2.91106483, sqrt3.getReal());
        assertEquals(1.15078166, sqrt3.getImg());
        
        ComplexNumbers sqrt4 =numbers[4].squareRoot();
        assertEquals(-5.34280616, sqrt4.getReal());
        assertEquals(3.8491009, sqrt4.getImg());
        
        ComplexNumbers sqrt5 =numbers[5].squareRoot();
        assertEquals(1.10099394, sqrt5.getReal());
        assertEquals(1.53270599, sqrt5.getImg());
        
        ComplexNumbers sqrt6 =numbers[6].squareRoot();
        assertEquals(-2.01249238, sqrt6.getReal());
        assertEquals(2.91429675, sqrt6.getImg());
        
        ComplexNumbers sqrt7 =numbers[7].squareRoot();
        assertEquals(2.2367387, sqrt7.getReal());
        assertEquals(0.0, sqrt7.getImg());
        
        ComplexNumbers sqrt8 =numbers[8].squareRoot();
        assertEquals(1.97192799, sqrt8.getReal());
        assertEquals(1.97192799, sqrt8.getImg());
        
        ComplexNumbers sqrt9 =numbers[9].squareRoot();
        assertEquals(0.0, sqrt9.getReal());
        assertEquals(1.77482393, sqrt9.getImg());
        
        ComplexNumbers sqrt10 =numbers[10].squareRoot();
        assertEquals(-3.44310906, sqrt10.getReal());
        assertEquals(3.44310906, sqrt10.getImg());
        
        ComplexNumbers sqrt11 =numbers[11].squareRoot();
        assertEquals(0.0, sqrt11.getReal());
        assertEquals(0.0, sqrt11.getImg());
        
        ComplexNumbers sqrt12 =numbers[12].squareRoot();
        assertEquals(Double.POSITIVE_INFINITY, sqrt12.getReal());
        assertEquals(Double.POSITIVE_INFINITY, sqrt12.getImg());
        
        ComplexNumbers sqrt13 =numbers[13].squareRoot();
        assertEquals(Double.POSITIVE_INFINITY, sqrt13.getReal());
        assertEquals(Double.POSITIVE_INFINITY, sqrt13.getImg());
        
        ComplexNumbers sqrt14 =numbers[14].squareRoot();
        assertEquals(Double.POSITIVE_INFINITY, sqrt14.getReal());
        assertEquals(Double.POSITIVE_INFINITY, sqrt14.getImg());
        
        ComplexNumbers sqrt15 =numbers[15].squareRoot();
        assertEquals(0.00010987, sqrt15.getReal());
        assertEquals(0.00004551, sqrt15.getImg());
        
        ComplexNumbers sqrt16 =numbers[16].squareRoot();
        assertEquals(0.0, sqrt16.getReal());
        assertEquals(0.0, sqrt16.getImg());
        
        
    }
    
    /**
     * Test of invertSign method, of class ComplexNumbers.
     */
    @Test
    public void testInvertSign() {
        ComplexNumbers inverted1 =numbers[4].invertSign();
        assertEquals(-13.73, inverted1.getReal());
        assertEquals(41.13, inverted1.getImg());
        
        ComplexNumbers inverted2 =numbers[5].invertSign();
        assertEquals(1.137, inverted2.getReal());
        assertEquals(-3.375, inverted2.getImg());
        
        ComplexNumbers inverted3 =numbers[11].invertSign();
        assertEquals(0.0, inverted3.getReal());
        assertEquals(0.0, inverted3.getImg());
        
        ComplexNumbers inverted4 =numbers[1].invertSign();
        assertEquals(Double.MAX_VALUE, inverted4.getReal());
        assertEquals(Double.MAX_VALUE, inverted4.getImg());
        
        ComplexNumbers inverted5 =numbers[13].invertSign();
        assertEquals(-Double.MAX_VALUE, inverted5.getReal());
        assertEquals(-Double.MAX_VALUE, inverted5.getImg());
        
        
    }
    
    /**
     * Test of exp method, of class ComplexNumbers.
     */
    @Test
    public void testExp() {
        ComplexNumbers exp0 =numbers[0].exp();
        assertEquals(0.0, exp0.getReal());
        assertEquals(0.0, exp0.getImg());
        
        ComplexNumbers exp1 =numbers[1].exp();
        assertEquals(0.0, exp1.getReal());
        assertEquals(0.0, exp1.getImg());
        
        ComplexNumbers exp2 =numbers[2].exp();
        assertEquals(0.0, exp2.getReal());
        assertEquals(0.0, exp2.getImg());
        
        ComplexNumbers exp3 = numbers[3].exp();
        assertEquals(1165.02101448, exp3.getReal());
        assertEquals(515.82169481, exp3.getImg());
        
        ComplexNumbers exp4 = numbers[4].exp();
        assertEquals(-879894.23746096, exp4.getReal());
        assertEquals(261896.74985077, exp4.getImg());
        
        ComplexNumbers exp5 = numbers[5].exp();
        assertEquals(-0.31208163, exp5.getReal());
        assertEquals(-0.07419441, exp5.getImg());
        
        ComplexNumbers exp6 = numbers[6].exp();
        assertEquals(0.0078815, exp6.getReal());
        assertEquals(0.00872891, exp6.getImg());
        
        ComplexNumbers exp7 = numbers[7].exp();
        assertEquals(148.85906711, exp7.getReal());
        assertEquals(0.0, exp7.getImg());
        
        ComplexNumbers exp8 = numbers[8].exp();
        assertEquals(0.07690562, exp8.getReal());
        assertEquals(0.99703838, exp8.getImg());
        
        ComplexNumbers exp9 = numbers[9].exp();
        assertEquals(0.04285213, exp9.getReal());
        assertEquals(0.0, exp9.getImg());
        
        ComplexNumbers exp10 = numbers[10].exp();
        assertEquals(0.14751479, exp10.getReal());
        assertEquals(0.98905985, exp10.getImg());
        
        ComplexNumbers exp11 = numbers[11].exp();
        assertEquals(1.0, exp11.getReal());
        assertEquals(0.0, exp11.getImg());

        ComplexNumbers exp12 = numbers[12].exp();
        assertEquals(Double.NEGATIVE_INFINITY, exp12.getReal());
        assertEquals(Double.POSITIVE_INFINITY, exp12.getImg());
        
        ComplexNumbers exp13 = numbers[13].exp();
        assertEquals(Double.NEGATIVE_INFINITY, exp13.getReal());
        assertEquals(Double.POSITIVE_INFINITY, exp13.getImg());
        
        ComplexNumbers exp14 = numbers[14].exp();
        assertEquals(Double.NEGATIVE_INFINITY, exp14.getReal());
        assertEquals(Double.POSITIVE_INFINITY, exp14.getImg());
        
        ComplexNumbers exp15 = numbers[15].exp();
        assertEquals(1.00000001, exp15.getReal());
        assertEquals(0.00000001, exp15.getImg());
        
        ComplexNumbers exp16 = numbers[16].exp();
        assertEquals(1.0, exp16.getReal());
        assertEquals(0.0, exp16.getImg());
    }
    
    /**
     * Test of log method, of class ComplexNumbers.
     */
    @Test
    public void testLog() {
        ComplexNumbers log0 =numbers[0].log();
        assertEquals(Double.POSITIVE_INFINITY, log0.getReal());
        assertEquals(-2.35619449, log0.getImg());
        
        ComplexNumbers log1 =numbers[1].log();
        assertEquals(Double.POSITIVE_INFINITY, log1.getReal());
        assertEquals(-2.35619449, log1.getImg());
        
        ComplexNumbers log2 =numbers[2].log();
        assertEquals(Double.POSITIVE_INFINITY, log2.getReal());
        assertEquals(-2.35619449, log2.getImg());
        
        ComplexNumbers log3 = numbers[3].log();
        assertEquals(2.2822392, log3.getReal());
        assertEquals(0.75291861, log3.getImg());
        
        ComplexNumbers log4 = numbers[4].log();
        assertEquals(3.769564, log4.getReal());
        assertEquals(-1.2486082, log4.getImg());
        
        ComplexNumbers log5 = numbers[5].log();
        assertEquals(1.27014679, log5.getReal());
        assertEquals(1.89574346, log5.getImg());
        
        ComplexNumbers log6 = numbers[6].log();
        assertEquals(2.52918276, log6.getReal());
        assertEquals(-1.93287018, log6.getImg());
        
        ComplexNumbers log7 = numbers[7].log();
        assertEquals(1.61003773, log7.getReal());
        assertEquals(0.0, log7.getImg());
        
        ComplexNumbers log8 = numbers[8].log();
        assertEquals(2.05117066, log8.getReal());
        assertEquals(1.57079633, log8.getImg());
        
        ComplexNumbers log9 = numbers[9].log();
        assertEquals(1.14740245, log9.getReal());
        assertEquals(3.14159265, log9.getImg());
        
        ComplexNumbers log10 = numbers[10].log();
        assertEquals(3.16589690, log10.getReal());
        assertEquals(-1.57079633, log10.getImg());
        
        ComplexNumbers log11 = numbers[11].log();
        assertEquals(Double.NEGATIVE_INFINITY, log11.getReal());
        assertEquals(0.0, log11.getImg());
        
        ComplexNumbers log12 = numbers[12].log();
        assertEquals(Double.POSITIVE_INFINITY, log12.getReal());
        assertEquals(0.78539816, log12.getImg());
        
        ComplexNumbers log13 = numbers[13].log();
        assertEquals(Double.POSITIVE_INFINITY, log13.getReal());
        assertEquals(0.78539816, log13.getImg());
        
        ComplexNumbers log14 = numbers[14].log();
        assertEquals(Double.POSITIVE_INFINITY, log14.getReal());
        assertEquals(0.78539816, log14.getImg());
        
        ComplexNumbers log15 = numbers[15].log();
        assertEquals(-18.07410715, log15.getReal());
        assertEquals(0.78539816, log15.getImg());
        
        ComplexNumbers log16 = numbers[16].log();
        assertEquals(Double.NEGATIVE_INFINITY, log16.getReal());
        assertEquals(0.0, log16.getImg());
     
    }
}

