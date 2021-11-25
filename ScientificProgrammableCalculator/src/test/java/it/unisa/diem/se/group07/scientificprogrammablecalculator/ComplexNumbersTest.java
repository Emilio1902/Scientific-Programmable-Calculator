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
}
