package it.unisa.diem.se.group07.scientificprogrammablecalculator;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class PrimaryController implements Initializable {

    @FXML
    private TextField display;

    private Calculator calculator = new Calculator();

    @FXML
    private ListView<String> numbersList;

    @FXML
    private ComboBox<String> variableOperations;

    @FXML
    private ComboBox<String> variables;

    @FXML
    private Button acButton;

    @FXML
    private Button equalButton;

    @FXML
    private TextField nameFunction;

    @FXML
    private TextArea operationsFunction;

    @FXML
    private ComboBox<String> functionsList;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        variableOperations.getItems().removeAll(variableOperations.getItems());
        variableOperations.getItems().addAll(">", "<", "+", "-");
        variableOperations.getSelectionModel().select("VarOp");

        variables.getItems().removeAll(variableOperations.getItems());
        variables.getItems().addAll("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z");
        variables.getSelectionModel().select("Vars");

        functionsList.getItems().removeAll(functionsList.getItems());
        functionsList.getSelectionModel().select("Functions");

        operationsFunction.setWrapText(true);

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                display.requestFocus();
            }

        });

    }

    /**
     * This method allows to visualize on display the key button pressed
     *
     * @param event represents the pressing of the button
     */
    @FXML
    private void pressedButton(ActionEvent event) {
        if (display.isEditable()) {
            String key = ((Button) event.getSource()).getText();
            display.setText(display.getText() + key);
            display.requestFocus();
            display.positionCaret(display.getText().length());
        }
    }

    /**
     * This method delete the last character of the string showed on display
     *
     * @param event represents the pressing of the DEL button
     */
    @FXML
    private void deleteNumber(ActionEvent event) {
        if (display.getText().length() > 0 && display.isEditable()) {
            display.setText(display.getText().substring(0, display.getText().length() - 1));
        }
        display.requestFocus();
        display.positionCaret(display.getText().length());
    }

    /**
     * This method delete the string showed on display
     *
     * @param event represents the pressing of the AC button
     */
    @FXML
    private void clearDisplay(ActionEvent event) {
        if (display.getText().length() > 0) {
            display.setText("");
            display.setEditable(true);
            acButton.setStyle("-fx-background-color: #ACACAC; -fx-background-radius: 30;");
            acButton.setDefaultButton(false);
            equalButton.setDefaultButton(true);
        }
        display.requestFocus();
    }

    /**
     * This method make operations on equals button written on display and shows
     * on the memory list the last twelve numbers
     *
     * @param event represents the pressing of the = button
     */
    @FXML
    private void makeEqualsButtonOperations(ActionEvent event) {
        String input = display.getText();
        String result = calculator.checkEqualsButtonOperations(input);
        updateInterface(result);
    }

    /**
     * This method make memory operations written on display and shows on 
     * the memory list the last twelve numbers
     *
     * @param event represents the pressing of clear, drop, dup, swap 
     * and over buttons
     */
    @FXML
    private void makeMemoryOperations(ActionEvent event) {
        String input = ((Button) event.getSource()).getText();
        String result = calculator.checkMemoryOperations(input);
        updateInterface(result);
    }

    /**
     * This method make variable operations written on display and shows on 
     * the memory list the last twelve numbers
     *
     * @param event represents the pressing of variable buttons
     */
    @FXML
    private void makeVariableOperations(ActionEvent event) {
        String varOp = variableOperations.getValue();
        String var = variables.getValue();
        String result = calculator.checkVariableOperations(varOp, var);
        updateInterface(result);
    }

    /**
     * This method make copy operations (save and restore) written on display 
     * and shows on the memory list the last twelve numbers
     *
     * @param event represents the pressing of save and restore buttons
     */
    @FXML
    private void makeCopyOperations(ActionEvent event) {
        String varOp = ((Button) event.getSource()).getText();
        String result = calculator.checkCopyOperations(varOp);
        updateInterface(result);
    }

     /**
     * This method make update the graphic interface 
     *
     * @param result is the string managed for the controls 
     */
    private void updateInterface(String result) {
        if (result.compareTo("") != 0) {
            display.setEditable(false);
            acButton.setStyle("-fx-background-color: #FF4D4D; -fx-background-radius: 30;");
            acButton.setDefaultButton(true);
            equalButton.setDefaultButton(false);
        }
        display.requestFocus();
        display.setText(result);
        numbersList.getItems().clear();
        numbersList.getItems().addAll(calculator.lastTwelveNumbers());
    }

     /**
     * This method takes the user-defined function and save it in the 
     * function list
     *
     * @param event represents the pressing of save function button
     */
    @FXML
    private void saveFunctionButton(ActionEvent event) {
        String name = nameFunction.getText();
        String funcOp = operationsFunction.getText();
        String result = calculator.saveFunctionOperations(name, funcOp);
        if (result.compareTo("Saved") == 0) {
            functionsList.getItems().add(name);
        }
        
        updateInterface(result);
    }

    @FXML
    private void useFunctionButton(ActionEvent event) {
    }

    @FXML
    private void modifyFunctionButton(ActionEvent event) {
    }

    @FXML
    private void deleteFunctionButton(ActionEvent event) {
    }

    @FXML
    private void loadFunctionButton(ActionEvent event) {
    }
}
