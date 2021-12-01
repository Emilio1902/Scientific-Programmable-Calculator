/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package it.unisa.diem.se.group07.scientificprogrammablecalculator;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author DELL
 */
public class VariablesTest {
    
    private Variables variables;
    private ComplexNumbers number;
    
    @Before
    public void setUp() {
        variables = new Variables();
        number = new ComplexNumbers(1.2, 7.6);
        
    }

    /**
     * Test of setVariableValue method, of class Variables.
     */
    @Test
    public void testSetVariableValue() {
        //check char is an alphabetic character
        assertEquals(false, variables.setVariableValue('1', number));
        
        assertEquals(true, variables.setVariableValue('a', number));
    }
    
}
