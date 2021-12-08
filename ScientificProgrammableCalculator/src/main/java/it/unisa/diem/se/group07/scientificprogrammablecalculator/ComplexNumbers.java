/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unisa.diem.se.group07.scientificprogrammablecalculator;

import org.apache.commons.math3.util.Precision;

/**
 * ComplexNumbers implements a complex number
 *
 * @author raffa
 */
public class ComplexNumbers {

    private Double real, img;

    /**
     * Constructs the complex number z = real + i*img
     *
     * @param real Real part
     * @param img Imaginary part
     */
    public ComplexNumbers(double real, double img) {
        if(Double.compare(real,Double.NaN)!=0 && Double.compare(img,Double.NaN)!=0){
            this.real = Precision.round(real, 8);
            this.img = Precision.round(img, 8);
        }
        else{
            this.real = Double.NaN;
            this.img = Double.NaN;
        }
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
     * Modulus of this Complex number (the distance from the origin in polar
     * coordinates).
     *
     * @return |z| where z is this Complex number.
     */
    public double mod() {
        if (real != 0 || img != 0) {
            return Math.sqrt((real * real) + (img * img));
        } else {
            return 0;
        }
    }

    /**
     * Argument of this Complex number (the angle in radians with the x-axis in
     * polar coordinates).
     *
     * @return arg(z) where z is this Complex number.
     */
    public double arg() {
        if(Math.abs(real) != Double.POSITIVE_INFINITY && Math.abs(img) != Double.POSITIVE_INFINITY)
            return Math.atan2(img, real);
        else
            return 0.0;
    }

    /**
     * Constructs the complex number z from the string number; if the number 
     * format is incorrect, it constructs a ComplexNumbers z with 
     * NEGATIVE_INFINITY real and imaginary parts.
     *
     * @param number is the string that represents the complex number z.
     */
    public ComplexNumbers(String number) {
        String[] split = number.split("[+-]");
        if (number.equalsIgnoreCase("i")) {
            this.real = 0.0;
            this.img = 1.0;
        } else {
            if (this.checkFormat(number, split)) {
                Double[] res = this.getComplexNumber(split, number);
                this.real = res[0];
                this.img = res[1];
            } else {
                this.real = Double.NEGATIVE_INFINITY;
                this.img = Double.NEGATIVE_INFINITY;
            }
        }
    }
    
    /**
     * This method checks if the String could be a complex number
     * 
     * @param number is the string that contains the complex number
     * @param split is the string vector that contains the split of number on +
     * and -
     * 
     * @return true if the format is correct, false otherwise
    */
    private boolean checkFormat(String number, String[] split) {
        return ((number.endsWith("i") && ((number.length() - number.replace("i", "").length()) == 1)) 
                || (!number.contains("i")&& ((split.length==2 && Character.isDigit(number.charAt(number.length()-1))
                &&((number.startsWith("+"))||number.startsWith("-")))|| split.length==1)))
                && split.length <= 3;
    }

    /**
     * Obtains the Complex number and performs all checks relating it.
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
        try {
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
                    imgPart = Double.parseDouble((firstPositive ? "+" : "-") + (split[0].equalsIgnoreCase("i") ? "1" : split[0].substring(0, split[0].length() - 1)));
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
        } catch (Exception e) {
            realPart = Double.NEGATIVE_INFINITY;
            imgPart = Double.NEGATIVE_INFINITY;
        }
        finally {
            return new Double[]{realPart, imgPart};
        }
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
     * Subtraction of ComplexNumbers (doesn't change this Complex number).
     * <br>(x+i*y) - (s+i*t) = (x-s)+i*(y-t).
     *
     * @param w is the number to subtract.
     * @return z-w where z is this Complex number.
     */
    public ComplexNumbers difference(ComplexNumbers w) {
        return new ComplexNumbers(real - w.getReal(), img - w.getImg());
    }

    /**
     * Complex multiplication (doesn't change this Complex number).
     *
     * @param w is the number to multiply by.
     * @return z*w where z is this Complex number.
     */
    public ComplexNumbers product(ComplexNumbers w) {
        double realPart = (real * w.getReal()) - (img * w.getImg());
        double imgPart = (real * w.getImg()) + (img * w.getReal());
        return new ComplexNumbers(realPart, imgPart);
    }

    /**
     * Division of Complex numbers (doesn't change this Complex number).
     * <br>(x+i*y)/(s+i*t) = ((x*s + y*t)/(s^2+t^2))+ i*((y*s - x*t)/(s^2+t^2))
     *
     * @param w is the number to divide by
     * @return new Complex number z/w where z is this Complex number or -infinity if
     * the mod of w (s^2+t^2) is 0
     */
    public ComplexNumbers ratio(ComplexNumbers w) {
        double distance = w.mod();
        double squareDistance = Math.pow(distance, 2);
        if (distance != 0) {
            double realPart = ((real * w.getReal()) + (w.getImg() * img)) / squareDistance;
            double imgPart = ((img * w.getReal()) - (real * w.getImg())) / squareDistance;
            return new ComplexNumbers(realPart, imgPart);
        } else {
            return new ComplexNumbers(Double.NEGATIVE_INFINITY, 0.0);
        }
    }

    /**
     * Complex square root (doesn't change this complex number). Computes the
     * principal branch of the square root, which is the value with 0<= arg <pi.
     *
     * @return sqrt(z) where z is this Complex number.
     */
    public ComplexNumbers squareRoot() {
        double r = Math.sqrt(this.mod());
        double theta = this.arg() / 2;
        if (theta < 0) {
            theta = theta + Math.PI;
        }
        double realPart = r * Math.cos(theta);
        double imgPart = r * Math.sin(theta);
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
        double realPart = real;
        double imgPart = img;
        if (real != 0) {
            realPart = -real;
        }
        if (img != 0) {
            imgPart = -img;
        }
        return new ComplexNumbers(realPart, imgPart);
    }

    /**
     *  Complex exponential (doesn't change this Complex number).
     *  @return exp(z) where z is this Complex number.
    */
    public ComplexNumbers exp() {
        double realPart = Math.exp(real)*Math.cos(img);
        double imgPart = Math.exp(real)*Math.sin(img);
        if(Math.abs(realPart)==0)
            realPart =0.0;
        if(Math.abs(imgPart)==0)
            imgPart =0.0;
        return new ComplexNumbers(realPart, imgPart);
    }
    
    /**
     *  Principal branch of the Complex logarithm of this Complex number.
     *  (doesn't change this Complex number).
     *  The principal branch is the branch with -pi < arg <= pi.
     *  @return log(z) where z is this Complex number.
    */
    public ComplexNumbers log() {
        return new ComplexNumbers(Math.log(this.mod()),this.arg());
    }

    /**
     * Real cosh function (used to compute complex trig functions).
     * 
     * @param theta is the angle.
     * 
     * @return cosh(theta) where theta is the angle.
    */ 
    private double cosh(double theta) {
        return (Math.exp(theta)+Math.exp(-theta))/2;
    }
    
    /**
     * Real sinh function (used to compute complex trig functions)
     * 
     * @param theta is the angle
     * 
     * @return sinh(theta) where theta is the angle
     */ 
    private double sinh(double theta) {
        return (Math.exp(theta)-Math.exp(-theta))/2;
    }
    
    /**
     * Sine of this Complex number (doesn't change this Complex number).
     * <br>sin(z) = (exp(i*z)-exp(-i*z))/(2*i).
     * @return sin(z) where z is this Complex number.
    */
    public ComplexNumbers sin() {
        double realPart = cosh(img)*Math.sin(real);
        double imgPart = sinh(img)*Math.cos(real);
        if(Math.abs(Precision.round(realPart,8))==0)
            realPart = 0.0;
        if(Math.abs(Precision.round(imgPart,8))==0)
            imgPart = 0.0;
        return new ComplexNumbers(realPart,imgPart);
    }
    
     /**
     *  Cosine of this Complex number (doesn't change this Complex number).
     *  <br>cos(z) = (exp(i*z)+exp(-i*z))/ 2.
     *  @return cos(z) where z is this Complex number.
    */
    public ComplexNumbers cos() {
        double realPart = cosh(img)*Math.cos(real);
        double imgPart = -sinh(img)*Math.sin(real);
        if(Math.abs(Precision.round(realPart,8))==0)
            realPart = 0.0;
        if(Math.abs(Precision.round(imgPart,8))==0)
            imgPart = 0.0;
        return new ComplexNumbers(realPart,imgPart);
    }
    
    /**
     * Parse from ComplexNumbers to string
     *
     * @return Re[z]+Img[z]i string where z is this Complex number.
     */
    @Override
    public String toString() {
        return real + (img < 0 ? "" : "+") + img + "i";
    }

}
