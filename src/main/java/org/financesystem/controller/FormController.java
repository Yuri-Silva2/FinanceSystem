package org.financesystem.controller;

import javafx.scene.control.Alert;
import org.financesystem.Main;
import org.financesystem.session.PropertiesSessionManager;

import java.io.File;
import java.util.UUID;

public class FormController {

    private static PropertiesSessionManager ppSM;

    protected static void successfulLogin(String uuid) {
        Main.initFinanceWindow();

        String filePath = System.getProperty("user.home") + "\\Documents\\session.properties";
        File file = new File(filePath);

        ppSM = new PropertiesSessionManager(file.getAbsolutePath());

        if (ppSM.getAttribute("session") == null) {
            ppSM.setAttribute("session", uuid);
        }
    }

    protected static void successfulSignUp(UUID uuid) {
        Main.initFinanceWindow();

        String filePath = System.getProperty("user.home") + "\\Documents\\session.properties";
        ppSM = new PropertiesSessionManager(filePath);

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
