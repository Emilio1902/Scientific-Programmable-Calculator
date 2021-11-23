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
    private ComplexNumbers num;
    
    @Before
    public void setUp() {
        num = new ComplexNumbers(7.15,6.70);
    }

    /**
     * Test of getReal method, of class ComplexNumbers.
     */
    @Test
    public void testGetReal() {
        assertEquals(7.15, num.getReal());
    }

    /**
     * Test of getImg method, of class ComplexNumbers.
     */
    @Test
    public void testGetImg() {
        assertEquals(6.70,num.getImg());
    }
    
}
