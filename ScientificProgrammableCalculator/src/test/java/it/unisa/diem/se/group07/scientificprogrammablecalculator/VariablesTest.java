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
    private ComplexNumbers number1, number2;
    
    @Before
    public void setUp() {
        variables = new Variables();
        number1 = new ComplexNumbers(1.2, 7.6);
        number2 = new ComplexNumbers(-3.25, 0);
        
    }

    /**
     * Test of setVariableValue method, of class Variables.
     */
    @Test
    public void testSetVariableValue() {
        //check char is an alphabetic character
        assertEquals(false, variables.setVariableValue('1', number1));
        
        variables.setVariableValue('a', number1);
        assertEquals(number1, variables.getVariableValue('a'));
        
        variables.setVariableValue('b', number2);
        assertEquals(number2, variables.getVariableValue('b'));
    }
    
    /**
     * Test of getVariableValue method, of class Variables.
     */
    @Test
    public void testGetVariableValue() {
        //check with a key not in variables
        assertEquals(null, variables.getVariableValue('1'));
        assertEquals(null, variables.getVariableValue('c'));
        
        variables.setVariableValue('c', number1);
        variables.setVariableValue('z', number2);
        assertEquals(number1, variables.getVariableValue('c'));
        assertEquals(number2, variables.getVariableValue('z'));
        
        variables.setVariableValue('c', number2);
        assertEquals(number2, variables.getVariableValue('c'));
        
        
    }
    
}

