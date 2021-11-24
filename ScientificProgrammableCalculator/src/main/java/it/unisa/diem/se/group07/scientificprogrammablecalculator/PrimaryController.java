package it.unisa.diem.se.group07.scientificprogrammablecalculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class PrimaryController {

    @FXML
    private Label display;

    @FXML
    private void pressedKey(ActionEvent event) {
        String number = ((Button) event.getSource()).getText();
        if (display.getText().contains("Syntax Error")) {
            this.clearDisplay(event);
        }
        display.setText(display.getText() + number);
    }

    @FXML
    private void deleteNumber(ActionEvent event) {
        if (display.getText().length() > 0) {
            display.setText(display.getText().substring(0, display.getText().length() - 1));
        }
    }

    @FXML
    private void clearDisplay(ActionEvent event) {
        if (display.getText().length()> 0) {
            display.setText("");
        }
    }

}
