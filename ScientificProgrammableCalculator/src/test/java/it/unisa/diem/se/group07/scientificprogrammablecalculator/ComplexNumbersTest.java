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

    private ComplexNumbers num1, num2;

    @Before
    public void setUp() {
        num1 = new ComplexNumbers(7.15, 6.70);
        num2 = new ComplexNumbers(-3.15, 0);
    }

    /**
     * Test of getReal method, of class ComplexNumbers.
     */
    @Test
    public void testGetReal() {
        assertEquals(7.15, num1.getReal());
        assertEquals(-3.15, num2.getReal());
    }

    /**
     * Test of getImg method, of class ComplexNumbers.
     */
    @Test
    public void testGetImg() {
        assertEquals(6.70, num1.getImg());
        assertEquals(0.0, num2.getImg());
    }
    
    /**
     * Test of mod method, of class ComplexNumbers.
     */
    @Test
    public void testMod() {
        double mod1 = num1.mod();
        assertEquals(9.79859684, mod1);
        
        double mod2 = num2.mod();
        assertEquals(3.15, mod2);
        
        ComplexNumbers num3 = new ComplexNumbers(0, 0);
        double mod3 = num3.mod();
        assertEquals(0.0, mod3); 
        
        ComplexNumbers num4 = new ComplexNumbers(Double.MAX_VALUE, Double.MIN_VALUE);
        double mod4 = num4.mod();
        assertEquals(Double.POSITIVE_INFINITY, mod4); 
    }
    
    /**
     * Test of arg method, of class ComplexNumbers.
     */
    @Test
    public void testArg() {
        double arg1 = num1.arg();
        assertEquals(0.75291861, arg1);
        
        double arg2 = num2.arg();
        assertEquals(3.14159265, arg2);
        
        ComplexNumbers num3 = new ComplexNumbers(0, 0);
        double arg3 = num3.arg();
        assertEquals(0.0, arg3);  
    }

    /*
    /**
     * Test of StringToComplex method, of class ComplexNumbers.
     */
    @Test
    public void testStringToComplex() {
        num1 = new ComplexNumbers("25+37i");
        assertEquals(25.0, (num1.getReal()));
        assertEquals(37.0, (num1.getImg()));

        num1 = new ComplexNumbers("25.56");
        assertEquals(25.56, num1.getReal());
        assertEquals(0.0, num1.getImg());

        num1 = new ComplexNumbers("37.43i");
        assertEquals(0.0, num1.getReal());
        assertEquals(37.43, num1.getImg());

        num1 = new ComplexNumbers("-14.56-18.21i");
        assertEquals(-14.56, num1.getReal());
        assertEquals(-18.21, num1.getImg());
    }

    /**
     * Test of sum method, of class ComplexNumbers.
     */
    @Test
    public void testSum() {
        ComplexNumbers sum1 = num1.sum(num2);
        assertEquals(4.0, sum1.getReal());
        assertEquals(6.70, sum1.getImg());

        num1 = new ComplexNumbers(0, -16);
        num2 = new ComplexNumbers(-1.36, 0);
        ComplexNumbers sum2 = num1.sum(num2);
        assertEquals(-1.36, sum2.getReal());
        assertEquals(-16.0, sum2.getImg());

        num1 = new ComplexNumbers(17.11, 2.345);
        num2 = new ComplexNumbers(1.25, 1.87);

        ComplexNumbers sum3 = num1.sum(num2);
        assertEquals(18.36, sum3.getReal());
        assertEquals(4.215, sum3.getImg());
    }

    /**
     * Test of difference method, of class ComplexNumbers.
     */
    @Test
    public void testDifference() {
        ComplexNumbers difference1 = num1.difference(num2);
        assertEquals(10.3, difference1.getReal());
        assertEquals(6.7, difference1.getImg());

        num1 = new ComplexNumbers(0, -16);
        num2 = new ComplexNumbers(-1.36, 0);
        ComplexNumbers difference2 = num1.difference(num2);
        assertEquals(1.36, difference2.getReal());
        assertEquals(-16.0, difference2.getImg());

        num1 = new ComplexNumbers(17.11, 2.345);
        num2 = new ComplexNumbers(1.25, 1.87);
        ComplexNumbers difference3 = num1.difference(num2);
        assertEquals(15.86, difference3.getReal());
        assertEquals(0.475, difference3.getImg());
    }
    
    
    /**
     * Test of product method, of class ComplexNumbers.
     */
    @Test
    public void testProduct() {
        ComplexNumbers product1 = num1.product(num2);
        assertEquals(-22.5225, product1.getReal());
        assertEquals(-21.105, product1.getImg());
        
        num1 = new ComplexNumbers(15.36, -16.32);
        num2 = new ComplexNumbers(0, 0);
        
        ComplexNumbers product2 = num1.product(num2);
        assertEquals(0.0, product2.getReal());
        assertEquals(0.0, product2.getImg());
        
        num1 = new ComplexNumbers(17.11, -2.345);
        num2 = new ComplexNumbers(-1.25, -1.87);
        ComplexNumbers product3 = num1.product(num2);
        assertEquals(-25.77265, product3.getReal());
        assertEquals(-29.06445, product3.getImg());
        
        
    }
    
    /**
     * Test of ratio method, of class ComplexNumbers.
     */
    @Test
    public void testRatio() {
        
        ComplexNumbers ratio1 = num1.ratio(num2);
        assertEquals(-2.26984127, ratio1.getReal());
        assertEquals(-2.12698413, ratio1.getImg());
        
        num1 = new ComplexNumbers(15.36, -16.32);
        num2 = new ComplexNumbers(0, 0);
        ComplexNumbers ratio2 = num1.ratio(num2);
        System.out.println(ratio2);
        assertEquals(null, ratio2);
        
        num1 = new ComplexNumbers(17.11, -2.345);
        num2 = new ComplexNumbers(-1.25, -1.87);
        ComplexNumbers ratio3 = num1.ratio(num2);
        assertEquals(-3.36054669, ratio3.getReal());
        assertEquals(6.90337784, ratio3.getImg());
        
        num1 = new ComplexNumbers(0, 0);
        num2 = new ComplexNumbers(3.24, 12.25);
        ComplexNumbers ratio4 = num1.ratio(num2);
        assertEquals(0.0, ratio4.getReal());
        assertEquals(0.0, ratio4.getImg());
        
    }
    
    /**
     * Test of squareRoot method, of class ComplexNumbers.
     */
    @Test
    public void testSquareRoot() {
        ComplexNumbers sqrt1 =num1.squareRoot();
        assertEquals(2.91106483, sqrt1.getReal());
        assertEquals(1.15078165, sqrt1.getImg());
        
        ComplexNumbers sqrt2 =num2.squareRoot();
        assertEquals(0.0, sqrt2.getReal());
        assertEquals(1.77482393, sqrt2.getImg());
        
        ComplexNumbers num3 = new ComplexNumbers(-12.2546, -0.3657);
        ComplexNumbers sqrt3 =num3.squareRoot();
        assertEquals(-0.05222724, sqrt3.getReal());
        assertEquals(3.50104666, sqrt3.getImg());
        
        ComplexNumbers num4 = new ComplexNumbers(0, -17.52);
        ComplexNumbers sqrt4 =num4.squareRoot();
        assertEquals(-2.95972971, sqrt4.getReal());
        assertEquals(2.95972972, sqrt4.getImg());
        
        ComplexNumbers num5 = new ComplexNumbers(0, 0);
        ComplexNumbers sqrt5 =num5.squareRoot();
        assertEquals(0.0, sqrt5.getReal());
        assertEquals(0.0, sqrt5.getImg());
        
        ComplexNumbers num6 = new ComplexNumbers(-150.57, 41236.21);
        ComplexNumbers sqrt6 =num6.squareRoot();
        assertEquals(143.32814626, sqrt6.getReal());
        assertEquals(143.85245005, sqrt6.getImg());
    }
    
    /**
     * Test of invertSign method, of class ComplexNumbers.
     */
    @Test
    public void testInvertSign() {
        ComplexNumbers inverted1 =num1.invertSign();
        assertEquals(-7.15, inverted1.getReal());
        assertEquals(-6.70, inverted1.getImg());
        
        ComplexNumbers inverted2 =num2.invertSign();
        assertEquals(3.15, inverted2.getReal());
        assertEquals(0.0, inverted2.getImg());
    }
    
    /**
     * Test of exp method, of class ComplexNumbers.
     */
    @Test
    public void testExp() {
        ComplexNumbers exp1 =num1.exp();
        assertEquals(1165.02101448, exp1.getReal());
        assertEquals(515.82169481, exp1.getImg());
        
        ComplexNumbers exp2 =num2.exp();
        assertEquals(0.04285213, exp2.getReal());
        assertEquals(0.0, exp2.getImg());
        
        ComplexNumbers num3 = new ComplexNumbers(0, 0);
        ComplexNumbers exp3 = num3.exp();
        assertEquals(1.0, exp3.getReal());
        assertEquals(0.0, exp3.getImg());
        
        ComplexNumbers num4 = new ComplexNumbers(0, -3.20548);
        ComplexNumbers exp4 = num4.exp();
        assertEquals(-0.9979599, exp4.getReal());
        assertEquals(0.06384389, exp4.getImg());
        
        ComplexNumbers num5 = new ComplexNumbers(Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY);
        ComplexNumbers exp5 = num5.exp();
        assertEquals(Double.NaN, exp5.getReal());
        assertEquals(Double.NaN, exp5.getImg());
        
        ComplexNumbers num6 = new ComplexNumbers(15.32, 166.10);
        ComplexNumbers exp6 = num6.exp();
        assertEquals(-4138710.03802039, exp6.getReal());
        assertEquals(1771376.2819426, exp6.getImg());


    }
    
    /**
     * Test of log method, of class ComplexNumbers.
     */
    @Test
    public void testLog() {
        ComplexNumbers log1 =num1.log();
        assertEquals(2.2822392, log1.getReal());
        assertEquals(0.75291861, log1.getImg());
        
        ComplexNumbers log2 =num2.log();
        assertEquals(1.14740245, log2.getReal());
        assertEquals(3.14159265, log2.getImg());
        
        ComplexNumbers num3 = new ComplexNumbers(0, 0);
        ComplexNumbers log3 = num3.log();
        assertEquals(Double.NEGATIVE_INFINITY, log3.getReal());
        assertEquals(0.0, log3.getImg());
        
        ComplexNumbers num4 = new ComplexNumbers(0, -3.20548);
        ComplexNumbers log4 = num4.log();
        assertEquals(1.16486185, log4.getReal());
        assertEquals(-1.57079633, log4.getImg());
        
        ComplexNumbers num5 = new ComplexNumbers(Math.E, 0);
        ComplexNumbers log5 = num5.log();
        assertEquals(1.0, log5.getReal());
        assertEquals(0.0, log5.getImg());
        
    }
}
