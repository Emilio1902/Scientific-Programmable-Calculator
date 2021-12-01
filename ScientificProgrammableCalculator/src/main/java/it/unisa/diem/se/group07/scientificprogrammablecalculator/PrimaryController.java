package it.unisa.diem.se.group07.scientificprogrammablecalculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class PrimaryController{

    @FXML
    private TextField display;

    private Calculator calculator = new Calculator();

    @FXML
    private ListView<String> numbersList;
    
    @FXML
    private Button equals;
    /**
     * This method allows to visualize on display the key button pressed
     *
     * @param event rappresents the pressing of the button
     */
    @FXML
    private void pressedKey(ActionEvent event) {
        String key = ((Button) event.getSource()).getText();
        if (display.getText().contains("Syntax Error") || display.getText().contains("Math Error")) {
            this.clearDisplay(event);
        }
        display.setText(display.getText() + key);
        equals.requestFocus();
    } 
    
    /**
     * This method delete the last character of the string showed on display
     *
     * @param event rappresents the pressing of the DEL button
     */
    @FXML
    private void deleteNumber(ActionEvent event) {
        if (display.getText().length() > 0) {
            display.setText(display.getText().substring(0, display.getText().length() - 1));
        }
    }

    /**
     * This method delete the string showed on display
     *
     * @param event rappresents the pressing of the AC button
     */
    @FXML
    private void clearDisplay(ActionEvent event) {
        if (display.getText().length() > 0) {
            display.setText("");
        }
    }

    /**
     * This method make operation written on display and shows on the memory
     * list the last twelve numbers
     *
     * @param event rappresents the pressing of the = button
     */
    @FXML
    private void makeMathOperations(ActionEvent event) {
        String s = display.getText();
        String s1 = calculator.checkMathOperations(s);
        display.setText(s1);
        numbersList.getItems().clear();
        numbersList.getItems().addAll(calculator.lastTwelveNumbers());
        
    }   

    @FXML
    private void makeMemoryOperations(ActionEvent event) {
        String s = ((Button)event.getSource()).getText();
        String s1 = calculator.checkMemoryOperations(s);
        display.setText(s1);
        numbersList.getItems().clear();
        numbersList.getItems().addAll(calculator.lastTwelveNumbers());
    }
}  