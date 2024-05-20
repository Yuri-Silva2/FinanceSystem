package org.financesystem.controller;

import javafx.scene.control.Alert;
import org.financesystem.Main;

public class FormController {

    protected static void successfulLogin() {
        Main.initFinanceWindow();
    }

    protected static void sendFormErrorMessage(String errorMessage) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setHeight(150.0);
        alert.setWidth(250.0);
        alert.setContentText(errorMessage);
        alert.showAndWait();
    }
}
