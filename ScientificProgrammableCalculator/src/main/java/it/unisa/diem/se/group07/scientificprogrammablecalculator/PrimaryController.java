package it.unisa.diem.se.group07.scientificprogrammablecalculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class PrimaryController {

    @FXML
    private Label display;
    
    private Calculator calculator = new Calculator();
    
    @FXML
    private ListView<String> numbersList;
    
    /**
     * This method allows to visualize on display the key button pressed
     *  @param event rappresents the pressing of the button
    */
    @FXML
    private void pressedKey(ActionEvent event) {
        String number = ((Button) event.getSource()).getText();
        if (display.getText().contains("Syntax Error")) {
            this.clearDisplay(event);
        }
        display.setText(display.getText() + number);
    }
    
    /**
     * This method delete the last character of the string showed on display
     *  @param event rappresents the pressing of the DEL button 
    */
    @FXML
    private void deleteNumber(ActionEvent event) {
        if (display.getText().length() > 0) {
            display.setText(display.getText().substring(0, display.getText().length() - 1));
        }
    }

    /**
     * This method delete the string showed on display
     *  @param event rappresents the pressing of the AC button
    */
    @FXML
    private void clearDisplay(ActionEvent event) {
        if (display.getText().length()> 0) {
            display.setText("");
        }
    }
    
    /**
     * This method make operation written on display and shows on the memory list 
     * the last twelve numbers 
     *  @param event rappresents the pressing of the = button
    */
    @FXML
    private void makeOperations(ActionEvent event) {
        
        String s = display.getText();
        String s1 = calculator.checkOperations(s);
        display.setText(s1);
        numbersList.getItems().clear();
        numbersList.getItems().addAll(calculator.lastTwelveNumbers());
     
      }
    }
    
        
    

   

