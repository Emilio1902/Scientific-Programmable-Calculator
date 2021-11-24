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
}
