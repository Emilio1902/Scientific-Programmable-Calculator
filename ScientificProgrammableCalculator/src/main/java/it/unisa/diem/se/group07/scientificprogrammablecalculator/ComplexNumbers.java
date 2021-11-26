/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unisa.diem.se.group07.scientificprogrammablecalculator;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * ComplexNumbers implements a complex number
 *
 * @author raffa
 */
public class ComplexNumbers {

    private BigDecimal real, img;

    /**
     * Constructs the complex number z = real + i*img
     *
     * @param real Real part
     * @param img Imaginary part
     */
    public ComplexNumbers(BigDecimal real, BigDecimal img) {
        this.real = real;
        this.img = img;
    }

    /**
     * Real part of this Complex number (the x-coordinate in rectangular
     * coordinates).
     *
     * @return Re[z] where z is this Complex number.
     */
    public BigDecimal getReal() {
        return real;
    }

    /**
     * Imaginary part of this Complex number (the y-coordinate in rectangular
     * coordinates).
     *
     * @return Im[z] where z is this Complex number.
     */
    public BigDecimal getImg() {
        return img;
    }

    /**
        This method checks and parses a string into a ComplexNumbers.
        * @param number is the string that represents the complex number z.
        * @return ComplexNumbers z 
        * @return null if the string format is incorrect
    */
    public ComplexNumbers stringToComplex(String number) {
        String[] split = number.split("[+-]");
        if (((number.endsWith("i") 
           && ((number.length() - number.replace("i", "").length()) == 1)) 
           || !number.contains("i")) && split.length <= 3 && !number.isEmpty() 
           && !number.matches(".*[/*].*")) {
           Double[] res = this.getComplexNumber(split, number);
           return new ComplexNumbers(BigDecimal.valueOf(res[0]), BigDecimal.valueOf(res[1]));
        } else {
            return null;
        }
        
    }

    /**
     * This method obtains the Complex number and performs all checks relating
     * it.
     *
     * @param split is the string vector that contains real and imaginary part of 
     * the number.
     * @param number is the string that represents the complex number z.
     * @return Complex number with Re[z] and Im[z] where z is this Complex
     * number.
     */
    private Double[] getComplexNumber(String[] split, String number) {
        boolean firstPositive = true;
        boolean secondPositive = true;
        if (number.charAt(0) == '-') {
            firstPositive = false;
        }
        if (number.substring(1).contains("-")) {
            secondPositive = false;
        }
        if (split[0].equals("")) {
            split[0] = split[1];
            if (split.length > 2) {
                split[1] = split[2];
            }
        }
        double realPart = 0;
        double imgPart = 0;
        if (split.length == 1) {
            if (number.contains("i")) {
                imgPart = Double.parseDouble(number.substring(0, number.length() - 1));
            } else {
                realPart = Double.parseDouble(number);
            }
        }
        if (split.length == 2) {
            if (split[1].contains("i") && !split[0].contains("i")) {
                imgPart = Double.parseDouble((secondPositive ? "+" : "-") + split[1].substring(0, split[1].length() - 1));
            }
            if (split[0].contains("i")) {
                imgPart = Double.parseDouble((firstPositive ? "+" : "-") + split[0].substring(0, split[0].length() - 1));
            } else {
                realPart = Double.parseDouble((firstPositive ? "+" : "-") + split[0]);
            }
        }
        if (split.length > 2) {
            imgPart = Double.parseDouble((secondPositive ? "+" : "-") + split[1].substring(0, split[1].length() - 1));
            realPart = Double.parseDouble((firstPositive ? "+" : "-") + split[0]);
        }

        return new Double[]{realPart, imgPart};
    }
    
    /**
     * Addition of ComplexNumbers (doesn't change this Complex number).
     * <br>(x+i*y) + (s+i*t) = (x+s)+i*(y+t).
     *
     * @param w is the number to add.
     * @return z+w where z is this Complex number.
     */
    public ComplexNumbers sum(ComplexNumbers w) {
        return new ComplexNumbers(real.add(w.getReal()),img.add(w.getImg()));
    }
    
    /**
        Subtraction of ComplexNumbers (doesn't change this Complex number).
        <br>(x+i*y) - (s+i*t) = (x-s)+i*(y-t).
        @param w is the number to subtract.
        @return z-w where z is this Complex number.
    */
    public ComplexNumbers difference(ComplexNumbers w) {
        return new ComplexNumbers(real.subtract(w.getReal()),img.subtract(w.getImg()));
    }
    
    /**
        Complex multiplication (doesn't change this Complex number).
        @param w is the number to multiply by.
        @return z*w where z is this Complex number.
    */
    public ComplexNumbers product(ComplexNumbers w) {
        BigDecimal realPart = ((real.multiply(w.getReal())).subtract(img.multiply(w.getImg()))).stripTrailingZeros();
        BigDecimal imgPart = ((real.multiply(w.getImg())).add(img.multiply(w.getReal()))).stripTrailingZeros();
                
        return new ComplexNumbers(realPart, imgPart); 
    }
    
    /**
        Division of Complex numbers (doesn't change this Complex number).
        <br>(x+i*y)/(s+i*t) = ((x*s + y*t)/(s^2+t^2))+ i*((y*s - x*t)/(s^2+t^2))  
        @param w is the number to divide by
        @return new Complex number z/w where z is this Complex number or null if the distance (s^2+t^2) is 0
    */
    public ComplexNumbers ratio(ComplexNumbers w) {
        BigDecimal distance = ((w.getReal().multiply(w.getReal())).add(w.getImg().multiply(w.getImg()))).stripTrailingZeros();
        if(!distance.equals(BigDecimal.ZERO)){
            BigDecimal realPart = (((real.multiply(w.getReal())).add(w.getImg().multiply(img))).divide(distance,4,RoundingMode.HALF_UP));
            BigDecimal imgPart = ((img.multiply(w.getReal())).subtract(real.multiply(w.getImg()))).divide(distance, 4,RoundingMode.HALF_UP);
            return new ComplexNumbers(realPart, imgPart);
        }
        else{
            return null;
        } 
    }
    
    /**
     * Parse from ComplexNumbers to string
     * 
     * @return Re[z]+Img[z]i string where z is this Complex number.
     */
    @Override
    public String toString() {
        return real + (img.compareTo(BigDecimal.ZERO)<0?"":"+")+ img + 'i';
    }
    
    

}
