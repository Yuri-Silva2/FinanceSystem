package org.financesystem.service;

import javafx.scene.control.Alert;

/**
 * The AlertService class provides methods for showing alert messages to the user.
 * It uses JavaFX's Alert class to display warning messages with a specified title and content.
 */
public class AlertService {

    /**
     * Displays an alert with the specified title and message.
     *
     * @param title   the title of the alert
     * @param message the message to be displayed in the alert
     */
    public void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setHeight(150.0);
        alert.setWidth(250.0);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
