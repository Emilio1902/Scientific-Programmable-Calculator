/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package it.unisa.diem.se.group07.scientificprogrammablecalculator;

import java.math.BigDecimal;
import org.junit.Test;
import org.junit.*;
import static org.hamcrest.MatcherAssert.assertThat;
import org.hamcrest.Matchers;
import static org.junit.Assert.*;

/**
 *
 * @author raffa
 */
public class ComplexNumbersTest {

    private ComplexNumbers num1, num2;

    @Before
    public void setUp() {
        num1 = new ComplexNumbers(BigDecimal.valueOf(7.15), BigDecimal.valueOf(6.70));
        num2 = new ComplexNumbers(BigDecimal.valueOf(-3.15), BigDecimal.valueOf(0));
    }

    /**
     * Test of getReal method, of class ComplexNumbers.
     */
    @Test
    public void testGetReal() {
        assertThat(BigDecimal.valueOf(7.15), Matchers.comparesEqualTo(num1.getReal()));
        assertThat(BigDecimal.valueOf(-3.15), Matchers.comparesEqualTo(num2.getReal()));
    }

    /**
     * Test of getImg method, of class ComplexNumbers.
     */
    @Test
    public void testGetImg() {
        assertThat(BigDecimal.valueOf(6.70), Matchers.comparesEqualTo(num1.getImg()));
        assertThat(BigDecimal.valueOf(0), Matchers.comparesEqualTo(num2.getImg()));
    }
    
    /**
     * Test of mod method, of class ComplexNumbers.
     */
    @Test
    public void testMod() {
        BigDecimal mod1 = num1.mod();
        assertThat(BigDecimal.valueOf(9.7986), Matchers.comparesEqualTo(mod1));
        
        BigDecimal mod2 = num2.mod();
        assertThat(BigDecimal.valueOf(3.15), Matchers.comparesEqualTo(mod2));
        
        ComplexNumbers num3 = new ComplexNumbers(BigDecimal.ZERO, BigDecimal.ZERO);
        BigDecimal mod3 = num3.mod();
        assertThat(BigDecimal.ZERO, Matchers.comparesEqualTo(mod3));  
    }
    
    /**
     * Test of arg method, of class ComplexNumbers.
     */
    @Test
    public void testArg() {
        BigDecimal arg1 = num1.arg();
        assertThat(BigDecimal.valueOf(0.753), Matchers.comparesEqualTo(arg1));
        
        BigDecimal arg2 = num2.arg();
        assertThat(BigDecimal.valueOf(3.1416), Matchers.comparesEqualTo(arg2));
        
        ComplexNumbers num3 = new ComplexNumbers(BigDecimal.ZERO, BigDecimal.ZERO);
        BigDecimal arg3 = num3.arg();
        assertThat(BigDecimal.ZERO, Matchers.comparesEqualTo(arg3));  
    }

    /*
    /**
     * Test of StringToComplex method, of class ComplexNumbers.
     */
    @Test
    public void testStringToComplex() {
        num1 = num1.stringToComplex("25+37i");
        assertThat(BigDecimal.valueOf(25.0), Matchers.comparesEqualTo(num1.getReal()));
        assertThat(BigDecimal.valueOf(37.0), Matchers.comparesEqualTo(num1.getImg()));

        num1 = num1.stringToComplex("25.56");
        assertThat(BigDecimal.valueOf(25.56), Matchers.comparesEqualTo(num1.getReal()));
        assertThat(BigDecimal.valueOf(0.0), Matchers.comparesEqualTo(num1.getImg()));

        num1 = num1.stringToComplex("37.43i");
        assertThat(BigDecimal.valueOf(0.0), Matchers.comparesEqualTo(num1.getReal()));
        assertThat(BigDecimal.valueOf(37.43), Matchers.comparesEqualTo(num1.getImg()));

        num1 = num1.stringToComplex("-14.56-18.21i");
        assertThat(BigDecimal.valueOf(-14.56), Matchers.comparesEqualTo(num1.getReal()));
        assertThat(BigDecimal.valueOf(-18.21), Matchers.comparesEqualTo(num1.getImg()));
    }

    /**
     * Test of sum method, of class ComplexNumbers.
     */
    @Test
    public void testSum() {
        ComplexNumbers sum1 = num1.sum(num2);
        assertThat(BigDecimal.valueOf(4.0), Matchers.comparesEqualTo(sum1.getReal()));
        assertThat(BigDecimal.valueOf(6.70), Matchers.comparesEqualTo(sum1.getImg()));

        num1 = new ComplexNumbers(BigDecimal.valueOf(0), BigDecimal.valueOf(-16));
        num2 = new ComplexNumbers(BigDecimal.valueOf(-1.36), BigDecimal.valueOf(0));
        ComplexNumbers sum2 = num1.sum(num2);
        assertThat(BigDecimal.valueOf(-1.36), Matchers.comparesEqualTo(sum2.getReal()));
        assertThat(BigDecimal.valueOf(-16.0), Matchers.comparesEqualTo(sum2.getImg()));

        num1 = new ComplexNumbers(BigDecimal.valueOf(17.11), BigDecimal.valueOf(2.345));
        num2 = new ComplexNumbers(BigDecimal.valueOf(1.25), BigDecimal.valueOf(1.87));

        ComplexNumbers sum3 = num1.sum(num2);
        assertThat(BigDecimal.valueOf(18.36), Matchers.comparesEqualTo(sum3.getReal()));
        assertThat(BigDecimal.valueOf(4.215), Matchers.comparesEqualTo(sum3.getImg()));
    }

    /**
     * Test of difference method, of class ComplexNumbers.
     */
    @Test
    public void testDifference() {
        ComplexNumbers difference1 = num1.difference(num2);
        assertThat(BigDecimal.valueOf(10.3), Matchers.comparesEqualTo(difference1.getReal()));
        assertThat(BigDecimal.valueOf(6.7), Matchers.comparesEqualTo(difference1.getImg()));

        num1 = new ComplexNumbers(BigDecimal.valueOf(0), BigDecimal.valueOf(-16));
        num2 = new ComplexNumbers(BigDecimal.valueOf(-1.36), BigDecimal.valueOf(0));
        ComplexNumbers difference2 = num1.difference(num2);
        assertThat(BigDecimal.valueOf(1.36), Matchers.comparesEqualTo(difference2.getReal()));
        assertThat(BigDecimal.valueOf(-16.0), Matchers.comparesEqualTo(difference2.getImg()));

        num1 = new ComplexNumbers(BigDecimal.valueOf(17.11), BigDecimal.valueOf(2.345));
        num2 = new ComplexNumbers(BigDecimal.valueOf(1.25), BigDecimal.valueOf(1.87));
        ComplexNumbers difference3 = num1.difference(num2);
        assertThat(BigDecimal.valueOf(15.86), Matchers.comparesEqualTo(difference3.getReal()));
        assertThat(BigDecimal.valueOf(0.475), Matchers.comparesEqualTo(difference3.getImg()));
    }
    
    
    /**
     * Test of product method, of class ComplexNumbers.
     */
    @Test
    public void testProduct() {
        ComplexNumbers product1 = num1.product(num2);
        assertThat(BigDecimal.valueOf(-22.5225), Matchers.comparesEqualTo(product1.getReal()));
        assertThat(BigDecimal.valueOf(-21.105), Matchers.comparesEqualTo(product1.getImg()));
        
        num1 = new ComplexNumbers(BigDecimal.valueOf(15.36), BigDecimal.valueOf(-16.32));
        num2 = new ComplexNumbers(BigDecimal.valueOf(0), BigDecimal.valueOf(0));
        
        ComplexNumbers product2 = num1.product(num2);
        assertThat(BigDecimal.valueOf(0.0), Matchers.comparesEqualTo(product2.getReal()));
        assertThat(BigDecimal.valueOf(0.0), Matchers.comparesEqualTo(product2.getImg()));
        
        num1 = new ComplexNumbers(BigDecimal.valueOf(17.11), BigDecimal.valueOf(-2.345));
        num2 = new ComplexNumbers(BigDecimal.valueOf(-1.25), BigDecimal.valueOf(-1.87));
        ComplexNumbers product3 = num1.product(num2);
        assertThat(BigDecimal.valueOf(-25.7727), Matchers.comparesEqualTo(product3.getReal()));
        assertThat(BigDecimal.valueOf(-29.0645), Matchers.comparesEqualTo(product3.getImg()));
        
        
    }
    
    /**
     * Test of ratio method, of class ComplexNumbers.
     */
    @Test
    public void testRatio() {
        
        ComplexNumbers ratio1 = num1.ratio(num2);
        assertThat(BigDecimal.valueOf(-2.2698), Matchers.comparesEqualTo(ratio1.getReal()));
        assertThat(BigDecimal.valueOf(-2.127), Matchers.comparesEqualTo(ratio1.getImg()));
        
        num1 = new ComplexNumbers(BigDecimal.valueOf(15.36), BigDecimal.valueOf(-16.32));
        num2 = new ComplexNumbers(BigDecimal.valueOf(0), BigDecimal.valueOf(0));
        ComplexNumbers ratio2 = num1.ratio(num2);
        System.out.println(ratio2);
        assertEquals(null, ratio2);
        
        num1 = new ComplexNumbers(BigDecimal.valueOf(17.11), BigDecimal.valueOf(-2.345));
        num2 = new ComplexNumbers(BigDecimal.valueOf(-1.25), BigDecimal.valueOf(-1.87));
        ComplexNumbers ratio3 = num1.ratio(num2);
        assertThat(BigDecimal.valueOf(-3.3605), Matchers.comparesEqualTo(ratio3.getReal()));
        assertThat(BigDecimal.valueOf(6.9034), Matchers.comparesEqualTo(ratio3.getImg()));
        
        num1 = new ComplexNumbers(BigDecimal.valueOf(0), BigDecimal.valueOf(0));
        num2 = new ComplexNumbers(BigDecimal.valueOf(3.24), BigDecimal.valueOf(12.25));
        ComplexNumbers ratio4 = num1.ratio(num2);
        assertThat(BigDecimal.valueOf(0), Matchers.comparesEqualTo(ratio4.getReal()));
        assertThat(BigDecimal.valueOf(0), Matchers.comparesEqualTo(ratio4.getImg()));
        
    }
    
    /**
     * Test of squareRoot method, of class ComplexNumbers.
     */
    @Test
    public void testSquareRoot() {
        ComplexNumbers sqrt1 =num1.squareRoot();
        assertThat(BigDecimal.valueOf(2.911), Matchers.comparesEqualTo(sqrt1.getReal()));
        assertThat(BigDecimal.valueOf(1.1509), Matchers.comparesEqualTo(sqrt1.getImg()));
        
        ComplexNumbers sqrt2 =num2.squareRoot();
        assertThat(BigDecimal.valueOf(0), Matchers.comparesEqualTo(sqrt2.getReal()));
        assertThat(BigDecimal.valueOf(1.7748), Matchers.comparesEqualTo(sqrt2.getImg()));
        
        ComplexNumbers num3 = new ComplexNumbers(BigDecimal.valueOf(-12.2546), BigDecimal.valueOf(-0.3657));
        ComplexNumbers sqrt3 =num3.squareRoot();
        assertThat(BigDecimal.valueOf(-0.0521), Matchers.comparesEqualTo(sqrt3.getReal()));
        assertThat(BigDecimal.valueOf(3.501), Matchers.comparesEqualTo(sqrt3.getImg()));
        
        ComplexNumbers num4 = new ComplexNumbers(BigDecimal.valueOf(0), BigDecimal.valueOf(-17.52));
        ComplexNumbers sqrt4 =num4.squareRoot();
        assertThat(BigDecimal.valueOf(-2.9597), Matchers.comparesEqualTo(sqrt4.getReal()));
        assertThat(BigDecimal.valueOf(2.9597), Matchers.comparesEqualTo(sqrt4.getImg()));
        
        ComplexNumbers num5 = new ComplexNumbers(BigDecimal.valueOf(0), BigDecimal.valueOf(0));
        ComplexNumbers sqrt5 =num5.squareRoot();
        assertThat(BigDecimal.valueOf(0), Matchers.comparesEqualTo(sqrt5.getReal()));
        assertThat(BigDecimal.valueOf(0), Matchers.comparesEqualTo(sqrt5.getImg()));
        
        ComplexNumbers num6 = new ComplexNumbers(BigDecimal.valueOf(-150.57), BigDecimal.valueOf(41236.21));
        ComplexNumbers sqrt6 =num6.squareRoot();
        assertThat(BigDecimal.valueOf(143.3243), Matchers.comparesEqualTo(sqrt6.getReal()));
        assertThat(BigDecimal.valueOf(143.8561), Matchers.comparesEqualTo(sqrt6.getImg()));
    }
    
    /**
     * Test of invertSign method, of class ComplexNumbers.
     */
    @Test
    public void testInvertSign() {
        ComplexNumbers inverted1 =num1.invertSign();
        assertThat(BigDecimal.valueOf(-7.15), Matchers.comparesEqualTo(inverted1.getReal()));
        assertThat(BigDecimal.valueOf(-6.70), Matchers.comparesEqualTo(inverted1.getImg()));
        
        ComplexNumbers inverted2 =num2.invertSign();
        assertThat(BigDecimal.valueOf(3.15), Matchers.comparesEqualTo(inverted2.getReal()));
        assertThat(BigDecimal.valueOf(0), Matchers.comparesEqualTo(inverted2.getImg()));
    }
}
