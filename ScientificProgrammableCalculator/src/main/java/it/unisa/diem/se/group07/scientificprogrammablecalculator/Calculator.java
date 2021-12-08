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

    private StackComplexNumbers memory;
    private Variables variables;
    private Functions functions;
    private boolean flagBackup = true;
    private Set<String> userFunctions;

    /**
     * Constructs the stack memory of the calculator
     */
    public Calculator() {
        memory = new StackComplexNumbers();
        variables = new Variables();
        functions = new Functions();
    }

    /**
     * Constructs the string to pass to the calculator and checks
     * operations to do.
     *
     * @param s String to pass to the calculator
     * @return "" if the string is empty otherwise the result of the operation
     */
    public String checkOperations(String s) {
        if (s.compareTo("") == 0) {
            return "";
        }
        
        userFunctions = functions.getFunctions();
        if(userFunctions.contains(s)){
            return executeFunctionOperations(s);
        }
        
        if(s.matches("[+-/*]+") || s.matches(".*sqrt.*||.*mod.*||.*arg.*||.*exp.*||.*log.*") ) {
            return checkMathOperations(s);
        }
        
        if (Character.toString(s.charAt(0)).matches("[<>+-]+") && s.substring(1).matches("[a-z]")) {
            return checkVariableOperations(Character.toString(s.charAt(0)), s.substring(1));
        } 
        
        if(s.matches(".*save.*||.*restore.*")){
            return checkCopyOperations(s) == "" ? "Done" : "Syntax Error";
        }
        
        if(s.matches(".*clear.*||.*drop.*||.*dup.*||.*swap.*||.*over.*")){
            return checkMemoryOperations(s);
        }
 
        else {
            return insertComplexNumbers(s) == true ? "" : "Syntax Error";
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

        if (s.compareTo("sqrt") == 0) {
            return memory.squareRootLastNumber() == true ? "" : "Math Error";
        }

        if (s.compareTo("+-") == 0) {
            return memory.invertSignLastNumber() == true ? "" : "Math Error";
        }
        
        if (s.compareTo("mod") == 0) {
            return memory.modLastNumber() == true ? "" : "Math Error";
        }
        
        if (s.compareTo("arg") == 0) {
            return memory.argLastNumber() == true ? "" : "Math Error";
        }
        
        if (s.compareTo("exp") == 0) {
            return memory.expLastNumber() == true ? "" : "Math Error";
        }
        
        if (s.compareTo("log") == 0) {
            return memory.logLastNumber() == true ? "" : "Math Error";
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
    private boolean insertComplexNumbers(String s) {
        ComplexNumbers num = new ComplexNumbers(s);

        if (num.getReal() != Double.NEGATIVE_INFINITY) {
            memory.push(num.getReal(), num.getImg());
            return true;
        } else {
            return false;
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
            return "";
        }

        if (operation.compareTo("restore") == 0) {
            variables.restoreVariables();
            return "";
        } else {
            return "Syntax Error";
        }
    }
    
    /**
     * Save a function with relatives name and operations.
     *
     * @param name is the name of the function to save.
     * @param operations is the sequence of the operations to do.
     * @return true if the format is correct, false otherwise
     */
    public String saveFunctionOperations(String name, String operations) {
        
        return functions.saveFunction(name, operations) == true ? "Saved" : "Format Error";
    }

    /**
     * Returns the last twelve numbers in the stack memory.
     *
     * @return the last twelve numbers in the stack memory
     */
    public String[] lastTwelveNumbers() {
        return memory.getLastTwelve();
    }
    
    /**
     * Execution of stored function specified by user.
     *
     * @return "" if operation is successfull, "Function Error" otherwise
     */
    public String executeFunctionOperations(String name){
        userFunctions = functions.getFunctions();
        String[] operations = functions.getOperation(name);
        if(flagBackup == true){
            memory.createBackup();
            flagBackup = false;
        }
       
        if(operations == null){
            flagBackup = true;
            return "Function Error";        
        }
   
        for (int i=0; i<operations.length; i++){
            if(userFunctions.contains(operations[i])){
                if(executeFunctionOperations(operations[i]).compareTo("")!= 0){
                    memory.restoreBackup();
                    flagBackup = true;
                    return "Function Error";
                }           
            }
            else{
                String result = checkOperations(operations[i]);
                if(result.compareTo("")!=0 && result.compareTo("Done")!=0){
                    memory.restoreBackup();
                    flagBackup = true;
                    return "Function Error";
                }
            }     
        }
        flagBackup = true;
        return "";
    }

    /**
     * Delete user-defined functions.
     *
     * @param name is the name of the function to delete.
     * @return true if the deleting is successfull, false otherwise
     */
    public String deleteFunctionOperations(String name) {
        return functions.deleteFunction(name) == true ? "Done" : "Syntax Error";
    }
    
    /**
     * This method separates the operations with white space.
     *
     * @param name is the name of the function to separate
     * @return a string of operations separated with white space
     */
    public String getFunctionOperations(String name) {
        return String.join(" ", functions.getOperation(name));
    }
    
    /**
     * This method writes the stored functions to file.
     *
     * @param file is the File to write on
     * @return "Saved" if the operation is successfull, "Saved Error" otherwise
     */
    public String writeFunctionsToFile(File file) throws IOException {
        return functions.writeToFile(file) == true ? "Saved" : "Saved Error";
    }
    
    /**
     * This method reads the stored functions from file.
     *
     * @param file is the File to read
     * @return List<String> of the operatations loaded if the read is successfull, null otherwise
     */
    public List<String> readFunctionsFromFile(File file) throws IOException {
        return functions.readFromFile(file);
    }
}
