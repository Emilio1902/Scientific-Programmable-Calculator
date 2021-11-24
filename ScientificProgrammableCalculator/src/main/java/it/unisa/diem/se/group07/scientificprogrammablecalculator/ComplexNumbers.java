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
     * Constructs the complex number z = real + i*img
     *
     * @param real Real part
     * @param img Imaginary part
     */
    public ComplexNumbers(double real, double img) {
        this.real = real;
        this.img = img;
    }

    /**
     * Real part of this Complex number (the x-coordinate in rectangular
     * coordinates).
     *
     * @return Re[z] where z is this Complex number.
     */
    public double getReal() {
        return real;
    }

    /**
     * Imaginary part of this Complex number (the y-coordinate in rectangular
     * coordinates).
     *
     * @return Im[z] where z is this Complex number.
     */
    public double getImg() {
        return img;
    }

    /**
        This method checks and parses a string into a ComplexNumbers.
        * @param number is the string that represents the complex number z.
        * @return ComplexNumbers z 
        * @return null if the string format is incorrect
    */
    public ComplexNumbers StringToComplex(String number) {
        String[] split = number.split("[+-]");
        if (((number.endsWith("i") 
           && ((number.length() - number.replace("i", "").length()) == 1)) 
           || !number.contains("i")) && split.length <= 3 && !number.isEmpty() 
           && !number.matches(".*[/*].*")) {
           Double[] res = this.getComplexNumber(split, number);
           return new ComplexNumbers(res[0], res[1]);
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
        return new ComplexNumbers(real + w.getReal(), img + w.getImg());
    }

    
    /**
     * Parse from ComplexNumbers to string
     * 
     * @return Re[z]+Img[z]i string where z is this Complex number.
     */
    @Override
    public String toString() {
        return real + (img<0?"":"+")+ img + 'i';
    }
    
    

}
