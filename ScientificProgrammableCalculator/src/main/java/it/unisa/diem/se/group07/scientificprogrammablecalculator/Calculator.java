/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.se.group07.scientificprogrammablecalculator;

/**
 * Calculator implements a calculator
 *
 * @author Diego Fileno
 */
public class Calculator {

    private final StackComplexNumbers memory;
    private final Variables variables;

    /**
     * Constructs the stack memory of the calculator
     */
    public Calculator() {
        memory = new StackComplexNumbers();
        variables = new Variables();

    }

    /**
     * Constructs the string to pass to the calculator and checks
     * operations to do.
     *
     * @param s String to pass to the calculator
     * @return "" if the string is empty otherwise the result of the operation
     */
    public String checkEqualsButtonOperations(String s) {
        if (s.compareTo("") == 0) {
            return "";
        }
        
        if(s.matches("[+-/√*]+"))
            return checkMathOperations(s);

        if (Character.toString(s.charAt(0)).matches("[<>+-]+") && s.substring(1).matches("[a-z]")) {
            return checkVariableOperations(Character.toString(s.charAt(0)), s.substring(1));
        } 
        
        else {
            return insertComplexNumbers(s);
        }
    }
    
    /**
     * Checks math operations.
     *
     * @param s String that contains the operation to do
     * @return "" if the string format is correct otherwise "Math Error" if
     * the string format is incorrect
     */
    
    private String checkMathOperations(String s) {
        if (s.compareTo("+") == 0) {
            return memory.sumLastTwoNumbers() == true ? "" : "Math Error";
        }

        if (s.compareTo("-") == 0) {
            return memory.differenceLastTwoNumbers() == true ? "" : "Math Error";
        }

        if (s.compareTo("*") == 0) {
            return memory.productLastTwoNumbers() == true ? "" : "Math Error";
        }

        if (s.compareTo("/") == 0) {
            return memory.ratioLastTwoNumbers() == true ? "" : "Math Error";
        }

        if (s.compareTo("√") == 0) {
            return memory.squareRootLastNumber() == true ? "" : "Math Error";
        }

        if (s.compareTo("+-") == 0) {
            return memory.invertSignLastNumber() == true ? "" : "Math Error";
        }
        
        else
            return "Syntax Error";
    }
    
    /**
     * Stores insert complex number in the memory .
     *
     * @param s String that contains the complex number
     * @return "" if the insert is successfull otherwise "Syntax Error"
     */
    private String insertComplexNumbers(String s) {
        ComplexNumbers num = new ComplexNumbers(s);

        if (num.getReal() != Double.NEGATIVE_INFINITY) {
            memory.push(num.getReal(), num.getImg());
            return "";
        } else {
            return "Syntax Error";
        }
    }

    /**
     * Constructs the string to pass to the calculator and checks memory
     * operations.
     *
     * @param s String to pass to the calculator
     * @return "" if the string format is correct otherwise "Syntax Error" if
     * the string format is incorrect
     */
    public String checkMemoryOperations(String s) {

        if (s.compareTo("clear") == 0) {
            memory.clear();
            return "";
        }

        if (s.compareTo("drop") == 0) {
            return memory.dropLastNumber() == true ? "" : "Few Arguments";
        }

        if (s.compareTo("dup") == 0) {
            return memory.dupLastNumber() == true ? "" : "Few Arguments";
        }

        if (s.compareTo("swap") == 0) {
            return memory.swapLastTwoNumbers() == true ? "" : "Few Arguments";
        }

        if (s.compareTo("over") == 0) {
            return memory.dupSecondLastNumber() == true ? "" : "Few Arguments";
        } else {
            return "Syntax Error";
        }

    }

    /**
     * Constructs the strings to pass to the calculator and checks variable
     * operations.
     *
     * @param operation is the operation to be performed
     * @param variable is the variable used for operation
     * @return "" if the string format is correct otherwise "Syntax Error" if
     * the string format is incorrect
     */
    public String checkVariableOperations(String operation, String variable) {

        ComplexNumbers num, complex;
        char op, var;

        if (operation.length() == 1 && variable.length() == 1) {
            op = operation.charAt(0);
            var = variable.charAt(0);
        } else {
            return "Syntax Error";
        }

        if (op == '>') {
            num = memory.pop();
            if (num == null) {
                return "Few Arguments";
            } else {
                return variables.setVariableValue(var, num) == true ? "" : "Variable Error";
            }
        }

        if (op == '<') {
            num = variables.getVariableValue(var);

            if (num == null) {
                return "No Value Stored";
            } else {
                memory.push(num.getReal(), num.getImg());
                return "";
            }

        }

        if (op == '+') {
            num = variables.getVariableValue(var);
            if (num == null) {
                return "No Value Stored";
            } else {
                complex = memory.pop();
                if (complex == null) {
                    return "Few Arguments";
                } else {
                    variables.setVariableValue(var, num.sum(complex));
                    return "";
                }
            }
        }

        if (op == '-') {
            num = variables.getVariableValue(var);
            if (num == null) {
                return "No Value Stored";
            } else {
                complex = memory.pop();
                if (complex == null) {
                    return "Few Arguments";
                } else {
                    variables.setVariableValue(var, num.difference(complex));
                    return "";
                }
            }
        } else {
            return "Syntax Error";
        }
    }

    /**
     * Constructs the string to pass to the calculator and checks copy
     * operations.
     *
     * @param operation is the operation to be performed
     * @return "" if the string format is correct otherwise "Syntax Error" if
     * the string format is incorrect
     */
    public String checkCopyOperations(String operation) {

        if (operation.compareTo("save") == 0) {
            variables.saveVariables();
            return "Saved";
        }

        if (operation.compareTo("restore") == 0) {
            variables.restoreVariables();
            return "Restored";
        } else {
            return "Syntax Error";
        }
    }

    /**
     * Returns the last twelve numbers in the stack memory.
     *
     * @return the last twelve numbers in the stack memory
     */
    public String[] lastTwelveNumbers() {
        return memory.getLastTwelve();
    }

}
