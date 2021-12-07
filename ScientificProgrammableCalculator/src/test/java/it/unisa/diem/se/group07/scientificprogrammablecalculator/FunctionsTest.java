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
 * @author raffa
 */
public class FunctionsTest {
    
    private final Functions function = new Functions();
    private String function1, function2, function3; 

    @Before
    public void setUp() {
        function1 = ">a + + - >a * /";
        function2 = "12+13i * sqrt +- dup drop save >a +a restore -3i 12 *";
        function3 = "+ -z +a * -13.3546-7.23654i swap dup arg mod log exp";
    }
    
    /**
     * Test of saveFunction method, of class Functions.
     */
    @Test
    public void testSaveFunction() {
        assertEquals(true,function.saveFunction("Example", function1));
        
        assertEquals(true,function.saveFunction("Example1", function2));
       
        //If a key already exists in function data structure, it will overwrite 
        assertEquals(true,function.saveFunction("Example", function3));
        
        String method4 =">a +- +* + - >a * /";
        assertEquals(false,function.saveFunction("Example2", method4));
        
        String method5 =">a +- +* + - >a * /";
        assertEquals(false,function.saveFunction("Example3", method5));
        
        String method6 =">a +- +* + - <ab * /";
        assertEquals(false,function.saveFunction("Example4", method6));
        
        String method7 ="save >c >b >a <b <b * 4 <a <c * * - sqrt >d <b +- <d - 2 <a * / <b +- <d + 2 <a * / restore";
        assertEquals(true,function.saveFunction("solve2degree", method7));
        
        String method8 ="save >b >a <a <a * <b <b * + sqrt restore";
        assertEquals(true,function.saveFunction("hypothenuse", method8));
        
        String method9 ="save restores 12.335 + + *";
        assertEquals(false,function.saveFunction("Example4", method9));
       
    }
    
    /**
     * Test of deleteFunction method, of class Functions.
     */
    @Test
    public void testDeleteFunction() {
        function.saveFunction("Example1", function1);
        function.saveFunction("Example2", function2);
        
        assertEquals(true,function.deleteFunction("Example1"));
     
        assertEquals(false,function.deleteFunction("Example"));
        assertEquals(false,function.deleteFunction("Example3"));
        
    }
    
}
