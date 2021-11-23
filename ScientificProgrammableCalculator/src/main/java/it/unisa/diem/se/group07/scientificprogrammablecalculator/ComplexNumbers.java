/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unisa.diem.se.group07.scientificprogrammablecalculator;

/**
 * ComplexNumbers implements a complex number
 *
 * @author raffa
 */
public class ComplexNumbers {
    private double real, img;

    /**
    Constructs the complex number z = real + i*img
        @param real Real part
        @param img Imaginary part
    */            
    public ComplexNumbers(double real, double img) {
        this.real = real;
        this.img = img;
    }
    
    /**
        Real part of this Complex number 
        (the x-coordinate in rectangular coordinates).
        @return Re[z] where z is this Complex number.
    */
    public double getReal() {
        return real;
    }
    
    /**
        Imaginary part of this Complex number 
        (the y-coordinate in rectangular coordinates).
        @return Im[z] where z is this Complex number.
    */
    public double getImg() {
        return img;
    }
}