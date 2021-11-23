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
    public void setUp(){
        stack = new StackComplexNumbers();
    }

    /**
     * Test of pop method, of class StackComplexNumbers.
     */
    @Test
    public void testPop() {
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
        stack.push(2.6, 7.1);
        stack.push(8.3, 3.5);
        ComplexNumbers num = stack.top();
        assertEquals(8.3, num.getReal());
        assertEquals(3.5, num.getImg());
        
    }
    
}
