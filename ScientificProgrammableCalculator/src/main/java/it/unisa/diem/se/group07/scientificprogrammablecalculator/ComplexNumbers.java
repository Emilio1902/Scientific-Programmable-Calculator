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
import java.math.MathContext;
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
     * Modulus of this Complex number (the distance from the origin in polar
     * coordinates).
     *
     * @return |z| where z is this Complex number.
     */
    public BigDecimal mod() {
        if (real.compareTo(BigDecimal.ZERO) != 0 || img.compareTo(BigDecimal.ZERO) != 0) {
            BigDecimal quadraticDistance = (real.multiply(real)).add(img.multiply(img));
            return quadraticDistance.sqrt(MathContext.DECIMAL128).setScale(4, RoundingMode.UP).stripTrailingZeros();
        } else {
            return BigDecimal.ZERO;
        }
    }

    /**
     * Argument of this Complex number (the angle in radians with the x-axis in
     * polar coordinates).
     *
     * @return arg(z) where z is this Complex number.
     */
    public BigDecimal arg() {
        return BigDecimal.valueOf(Math.atan2(img.doubleValue(), real.doubleValue())).setScale(4, RoundingMode.UP).stripTrailingZeros();
    }

    /**
     * This method checks and parses a string into a ComplexNumbers.
     *
     * @param number is the string that represents the complex number z.
     * @return ComplexNumbers z or null if the string format is incorrect
     */
    public ComplexNumbers stringToComplex(String number) {
        String[] split = number.split("[+-]");
        if (this.checkFormat(number, split)) {
            Double[] res = this.getComplexNumber(split, number);
            return new ComplexNumbers(BigDecimal.valueOf(res[0]).setScale(4,RoundingMode.UP).stripTrailingZeros(), BigDecimal.valueOf(res[1]).setScale(4,RoundingMode.UP).stripTrailingZeros());
        } else {
            if (number.equalsIgnoreCase("i")) {
                return new ComplexNumbers(BigDecimal.valueOf(0), BigDecimal.valueOf(1.0));
            }
            return null;
        }

    }
    
    private boolean checkFormat(String number, String[] split){
        if (number.matches(".*[0-9].*")
                && ((number.endsWith("i") && ((number.length() - number.replace("i", "").length()) == 1)) || !number.contains("i")) 
                && split.length <= 3 
                && !number.isEmpty()
                && !number.matches(".*[/*√].*")
                && (!number.endsWith("+") && !number.endsWith("-"))
                && ((split.length==1)
                || (split.length==2 && (number.charAt(0)!='-' || number.charAt(0)!='+') && number.endsWith("i"))
                || (split.length==3 && number.endsWith("i"))
                || (split.length==2 && number.charAt(0)=='-' && !number.endsWith("i"))))
            return true;
        else
            return false;    
    }

    /**
     * This method obtains the Complex number and performs all checks relating
     * it.
     *
     * @param split is the string vector that contains real and imaginary part
     * of the number.
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
        double realPart = 0.0;
        double imgPart = 0.0;
        if (split.length == 1) {
            if (number.contains("i")) {
                imgPart = Double.parseDouble(number.substring(0, number.length() - 1));
            } else {
                realPart = Double.parseDouble(number);
            }
        }
        if (split.length == 2) {
            if (split[1].contains("i") && !split[0].contains("i")) {
                if (split[1].equalsIgnoreCase("i")) {
                    imgPart = Double.parseDouble((secondPositive ? "+" : "-") + "1");
                } else {
                    imgPart = Double.parseDouble((secondPositive ? "+" : "-") + split[1].substring(0, split[1].length() - 1));
                }
            }
            if (split[0].contains("i")) {
                imgPart = Double.parseDouble((firstPositive ? "+" : "-") + split[0].substring(0, split[0].length() - 1));
            } else {
                realPart = Double.parseDouble((firstPositive ? "+" : "-") + split[0]);
            }
        }
        if (split.length > 2) {
            if (split[1].equalsIgnoreCase("i")) {
                imgPart = Double.parseDouble((secondPositive ? "+" : "-") + "1");
            } else {
                imgPart = Double.parseDouble((secondPositive ? "+" : "-") + split[1].substring(0, split[1].length() - 1));
            }
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
        return new ComplexNumbers(real.add(w.getReal()), img.add(w.getImg()));
    }

    /**
     * Subtraction of ComplexNumbers (doesn't change this Complex number).
     * <br>(x+i*y) - (s+i*t) = (x-s)+i*(y-t).
     *
     * @param w is the number to subtract.
     * @return z-w where z is this Complex number.
     */
    public ComplexNumbers difference(ComplexNumbers w) {
        return new ComplexNumbers(real.subtract(w.getReal()), img.subtract(w.getImg()));
    }

    /**
     * Complex multiplication (doesn't change this Complex number).
     *
     * @param w is the number to multiply by.
     * @return z*w where z is this Complex number.
     */
    public ComplexNumbers product(ComplexNumbers w) {
        BigDecimal realPart = (real.multiply(w.getReal())).subtract(img.multiply(w.getImg())).setScale(4, RoundingMode.UP).stripTrailingZeros();
        BigDecimal imgPart = (real.multiply(w.getImg())).add(img.multiply(w.getReal())).setScale(4, RoundingMode.UP).stripTrailingZeros();

        return new ComplexNumbers(realPart, imgPart);
    }

    /**
     * Division of Complex numbers (doesn't change this Complex number).
     * <br>(x+i*y)/(s+i*t) = ((x*s + y*t)/(s^2+t^2))+ i*((y*s - x*t)/(s^2+t^2))
     *
     * @param w is the number to divide by
     * @return new Complex number z/w where z is this Complex number or null if
     * the distance (s^2+t^2) is 0
     */
    public ComplexNumbers ratio(ComplexNumbers w) {
        BigDecimal distance = ((w.getReal().multiply(w.getReal())).add(w.getImg().multiply(w.getImg()))).stripTrailingZeros();
        if (!distance.equals(BigDecimal.ZERO)) {
            BigDecimal realPart = ((real.multiply(w.getReal())).add(w.getImg().multiply(img))).divide(distance, 4, RoundingMode.HALF_UP).stripTrailingZeros();
            BigDecimal imgPart = ((img.multiply(w.getReal())).subtract(real.multiply(w.getImg()))).divide(distance, 4, RoundingMode.HALF_UP).stripTrailingZeros();
            return new ComplexNumbers(realPart, imgPart);
        } else {
            return null;
        }
    }

    /**
     * Complex square root (doesn't change this complex number). Computes the
     * principal branch of the square root, which is the value with 0<= arg <pi.
     *
     * @return sqrt(z) where z is this Complex number.
     */
    public ComplexNumbers squareRoot() {
        BigDecimal r = this.mod().sqrt(MathContext.DECIMAL128);
        BigDecimal theta = this.arg().divide(BigDecimal.valueOf(2));
        if(theta.compareTo(BigDecimal.ZERO)<0){
            theta = theta.add(BigDecimal.valueOf(Math.PI));
        }
        BigDecimal realPart = r.multiply(BigDecimal.valueOf(Math.cos(theta.doubleValue()))).setScale(4, RoundingMode.DOWN).stripTrailingZeros();
        BigDecimal imgPart = r.multiply(BigDecimal.valueOf(Math.sin(theta.doubleValue()))).setScale(4, RoundingMode.DOWN).stripTrailingZeros();
        return new ComplexNumbers(realPart, imgPart);
    }

    /**
     * Invert sign of this complex number. This produces a new Complex number
     * and doesn't change this Complex number.
     * <br>-(x+i*y) = -x-i*y.
     *
     * @return -z where z is this Complex number.
     */
    public ComplexNumbers invertSign() {

        return new ComplexNumbers(real.negate(), img.negate());
    }
    

    /**
     * Parse from ComplexNumbers to string
     *
     * @return Re[z]+Img[z]i string where z is this Complex number.
     */
    @Override
    public String toString() {
        return real + (img.compareTo(BigDecimal.ZERO) < 0 ? "" : "+") + img + "i";
    }

    

}
