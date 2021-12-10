/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.se.group07.scientificprogrammablecalculator;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;

/**
 * Calculator implements a calculator
 *
 * @author Diego Fileno
 */
public class Calculator {
    private final StackComplexNumbers memory;
    private final Variables variables;
    private final Functions functions;
    private boolean flagBackup = true;
    private Set<String> userFunctions;
    
    /**
     * Constructs the stack memory of the calculator.
     * @param memory
     */
    public Calculator(StackComplexNumbers memory) {
        this.memory = memory;
        variables = new Variables();
        functions = new Functions();
    }
    
    /**
     * Constructs the string to pass to the calculator and checks operations to do.
     *
     * @param input String to pass to the calculator.
     * @return "" if the string is empty otherwise the result of the operation.
     */
    public String checkOperations(String input) {
        if (input.compareTo("") == 0) {
            return "";
        }
        userFunctions = functions.getFunctions();
        if (userFunctions.contains(input)) {
            return executeFunctionOperations(input) == true ? "" : "Function Error";
        }
        if (input.matches("[+-/*]+") || input.matches(".*sqrt.*")) {
            return makeMathOperations(input) == true ? "" : "Math Error";
        }  
        if (input.matches(".*mod.*||.*arg.*||.*exp.*||.*log.*||.*sin.*||.*cos.*||.*tan.*")){
            return makeTrascendentalOperations(input) == true ? "" : "Math Error";
        }
        if (Character.toString(input.charAt(0)).matches("[<>+-]+") && input.substring(1).matches("[a-z]")) {
            return makeVariableOperations(Character.toString(input.charAt(0)), input.substring(1));
        }
        if (input.matches(".*save.*||.*restore.*")) {
            return makeCopyOperations(input) == true ? "Done" : "Syntax Error";
        }
        if (input.matches(".*clear.*||.*drop.*||.*dup.*||.*swap.*||.*over.*")) {
            return makeMemoryOperations(input) == true ? "" : "Few Arguments";
        }  
        else {
            return insertComplexNumbers(input) == true ? "" : "Syntax Error";
        }
    }
    
    /**
     * Makes math operations.
     *
     * @param input String that contains the operation to do.
     * @return true if the string format is correct false otherwise.
     */
    private boolean makeMathOperations(String input) {
        if (input.compareTo("+") == 0) {
            return memory.sumLastTwoNumbers();
        }
        if (input.compareTo("-") == 0) {
            return memory.differenceLastTwoNumbers();
        }
        if (input.compareTo("*") == 0) {
            return memory.productLastTwoNumbers();
        }
        if (input.compareTo("/") == 0) {
            return memory.ratioLastTwoNumbers();
        }
        if (input.compareTo("sqrt") == 0) {
            return memory.squareRootLastNumber();
        }
        if (input.compareTo("+-") == 0) {
            return memory.invertSignLastNumber();
        }
        else {
            return false;
        }
    }
    
    /**
     * Makes trascendental operations.
     *
     * @param input String that contains the operation to do.
     * @return true if the string format is correct false otherwise.
     */
    private boolean makeTrascendentalOperations(String input) {
        if (input.compareTo("mod") == 0) {
            return memory.modLastNumber();
        }
        if (input.compareTo("arg") == 0) {
            return memory.argLastNumber();
        }
        if (input.compareTo("exp") == 0) {
            return memory.expLastNumber();
        }
        if (input.compareTo("log") == 0) {
            return memory.logLastNumber();
        }
        if (input.compareTo("sin") == 0) {
            return memory.sinLastNumber();
        } 
        if (input.compareTo("cos") == 0) {
            return memory.cosLastNumber();
        } 
        if (input.compareTo("tan") == 0) {
            return memory.tanLastNumber();
        }
        else {
            return false;
        }
    }
    
    /**
     * Stores insert complex number in the memory.
     *
     * @param input String that contains the complex number.
     * @return true if the insert is successfull false otherwise.
     */
    private boolean insertComplexNumbers(String input) {
        ComplexNumbers num = new ComplexNumbers(input);
        if (num.getReal() != Double.NEGATIVE_INFINITY) {
            memory.push(num.getReal(), num.getImg());
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * Constructs the string to pass to the calculator and makes memory operations.
     *
     * @param input String to pass to the calculator.
     * @return true if the string format is correct false otherwise.
     */
    private boolean makeMemoryOperations(String input) {
        if (input.compareTo("clear") == 0) {
            memory.clear();
            return true;
        }
        if (input.compareTo("drop") == 0) {
            return memory.dropLastNumber();
        }
        if (input.compareTo("dup") == 0) {
            return memory.dupLastNumber();
        }
        if (input.compareTo("swap") == 0) {
            return memory.swapLastTwoNumbers();
        }
        if (input.compareTo("over") == 0) {
            return memory.dupSecondLastNumber();
        } 
        else {
            return false;
        }
    }
    
    /**
     * Constructs the strings to pass to the calculator and makes variable
     * operations.
     *
     * @param operation is the operation to be performed.
     * @param variable is the variable used for operation.
     * @return "" if the string format is correct otherwise "Syntax Error" if
     * the string format is incorrect or "Few Arguments" if there are no stored
     * complex numbers in memory or "No Value Stored" if in the specified variable
     * there are no value saved.
     */
    private String makeVariableOperations(String operation, String variable) {
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
        } 
        else {
            return "Syntax Error";
        }
    }
    
    /**
     * Constructs the string to pass to the calculator and makes copy
     * operations.
     *
     * @param operation is the operation to be performed.
     * @return true if the string format is correct false otherwise.
     */
    private boolean makeCopyOperations(String operation) {
        if (operation.compareTo("save") == 0) {
            variables.saveVariables();
            return true;
        }
        if (operation.compareTo("restore") == 0) {
            variables.restoreVariables();
            return true;
        }      
        else {
            return false;
        }
    }
    
    /**
     * Save a function with relatives name and operations.
     *
     * @param name is the name of the function to save.
     * @param operations is the sequence of the operations to do.
     * @return "Saved" if the operation is succesfull, otherwise "Format Error".
     */
    public String saveFunctionOperations(String name, String operations) {
        return functions.saveFunction(name, operations) == true ? "Saved" : "Format Error";
    }
    
    /**
     * Execution of stored function specified by user.
     *
     * @return true if operation is successfull, false otherwise.
     */
    private boolean executeFunctionOperations(String name) {
        userFunctions = functions.getFunctions();
        String[] operations = functions.getOperation(name);
        if (flagBackup == true) {
            memory.createBackup();
            flagBackup = false;
        }
        if (operations == null) {
            flagBackup = true;
            return false;
        }
        for (int i = 0; i < operations.length; i++) {
            if (userFunctions.contains(operations[i])) {
                if (!executeFunctionOperations(operations[i])) {
                    memory.restoreBackup();
                    flagBackup = true;
                    return false;
                }
            }   
            else {
                String result = checkOperations(operations[i]);
                if (result.compareTo("") != 0 && result.compareTo("Done") != 0) {
                    memory.restoreBackup();
                    flagBackup = true;
                    return false;
                }
            }
        }    
        flagBackup = true;
        return true;
    }
    
    /**
     * Delete user-defined functions.
     *
     * @param name is the name of the function to delete.
     * @return "Done" if the deleting is successfull, otherwise "Syntax Error".
     */
    public String deleteFunctionOperations(String name) {
        return functions.deleteFunction(name) == true ? "Done" : "Syntax Error";
    }
    
    /**
     * This method separates the operations with white space.
     *
     * @param name is the name of the function to separate.
     * @return a string of operations separated with white space, while null if 
     * the function isn't saved.
     */
    public String getFunctionOperations(String name) {
        return String.join(" ", functions.getOperation(name));
    }
    
    /**
     * This method writes the stored functions to file.
     *
     * @param file is the File to write on.
     * @return "Saved" if the operation is successfull, otherwise "Saved Error".
     * @throws java.io.IOException
     */
    public String writeFunctionsToFile(File file) throws IOException {
        return functions.writeToFile(file) == true ? "Saved" : "Saved Error";
    }
    
    /**
     * This method reads the stored functions from file.
     *
     * @param file is the File to read.
     * @return List of String of the functions loaded if the read is successfull, 
     * null otherwise.
     * @throws java.io.IOException
     */
    public List<String> readFunctionsFromFile(File file) throws IOException {
        return functions.readFromFile(file);
    }
}
