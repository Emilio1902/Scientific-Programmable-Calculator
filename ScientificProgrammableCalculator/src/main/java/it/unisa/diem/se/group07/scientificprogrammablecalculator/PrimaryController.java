package it.unisa.diem.se.group07.scientificprogrammablecalculator;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class PrimaryController implements Initializable{

    @FXML
    private TextField display;

    private Calculator calculator = new Calculator();

    @FXML
    private ListView<String> numbersList;
    
    @FXML
    private Button equals;
    
    @FXML
    private ComboBox<String> variableOperations;
    
    @FXML
    private ComboBox<String> variables;
    
    @FXML
    private Button acButton;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        variableOperations.getItems().removeAll(variableOperations.getItems());
        variableOperations.getItems().addAll(">", "<", "+", "-");
        variableOperations.getSelectionModel().select("VarOp");
        
        variables.getItems().removeAll(variableOperations.getItems());
        variables.getItems().addAll("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z");
        variables.getSelectionModel().select("Vars");
    }
    /**
     * This method allows to visualize on display the key button pressed
     *
     * @param event rappresents the pressing of the button
     */
    @FXML
    private void pressedButton(ActionEvent event) {
        if(display.isEditable()){
            String key = ((Button) event.getSource()).getText();
            display.setText(display.getText() + key);
            display.requestFocus();
            display.positionCaret(display.getText().length());
        }
    } 
    
    /**
     * This method delete the last character of the string showed on display
     *
     * @param event rappresents the pressing of the DEL button
     */
    @FXML
    private void deleteNumber(ActionEvent event) {
        if (display.getText().length() > 0 && display.isEditable()) {
            display.setText(display.getText().substring(0, display.getText().length() - 1));
            display.requestFocus();
            display.positionCaret(display.getText().length());
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
            display.setEditable(true);
            acButton.setStyle("-fx-background-color: #ACACAC; -fx-background-radius: 30;");
            acButton.setDefaultButton(false);
            equals.setDefaultButton(true);
            display.requestFocus();
        }
    }

    /**
     * This method make operation written on display and shows on the memory
     * list the last twelve numbers
     *
     * @param event rappresents the pressing of the = button
     */
    @FXML
    private void makeEqualsButtonOperations(ActionEvent event) {
        String s = display.getText();
        String s1 = calculator.checkEqualsButtonOperations(s);
        updateInterface(s1);
    }   

    @FXML
    private void makeMemoryOperations(ActionEvent event) {
        String s = ((Button)event.getSource()).getText();
        String s1 = calculator.checkMemoryOperations(s);
        updateInterface(s1);
    }

    @FXML
    private void makeVariableOperations(ActionEvent event) {
        String varOp = variableOperations.getValue();
        String var = variables.getValue();
        String s1 = calculator.checkVariableOperations(varOp, var);
        updateInterface(s1);
    }

    @FXML
    private void makeCopyOperations(ActionEvent event) {
        String varOp = ((Button)event.getSource()).getText();
        String s1 = calculator.checkCopyOperations(varOp);
        updateInterface(s1);
    }
    
    private void updateInterface(String s1) {
        if(s1.compareTo("")!=0){
            display.setEditable(false);
            acButton.setStyle("-fx-background-color: #FF4D4D; -fx-background-radius: 30;");
            acButton.setDefaultButton(true);
            equals.setDefaultButton(false);
        }
        display.requestFocus();
        display.setText(s1);
        numbersList.getItems().clear();
        numbersList.getItems().addAll(calculator.lastTwelveNumbers());
    }
  }
  