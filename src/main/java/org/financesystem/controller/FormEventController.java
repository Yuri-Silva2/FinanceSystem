package org.financesystem.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import org.controlsfx.control.textfield.CustomPasswordField;
import org.controlsfx.control.textfield.CustomTextField;
import org.financesystem.model.People;

/**
 * Controller for handling events in the FinanceForm.
 */
public class FormEventController {

    private final Button signInButton;
    private final Button signUpButton;

    private final Button confirmSignInButton;
    private final Button confirmSignUpButton;

    private final CustomTextField emailField;
    private final CustomPasswordField confirmPasswordField;
    private final CustomPasswordField passwordField;

    private final CheckBox checkBox;

    private final ImageView closeIcon;

    public FormEventController(Button signInButton, Button signUpButton, Button confirmSignInButton, Button confirmSignUpButton, CustomTextField emailField,
                               CustomPasswordField confirmPasswordField, CustomPasswordField passwordField, CheckBox checkBox, ImageView closeIcon) {
        this.signInButton = signInButton;
        this.signUpButton = signUpButton;
        this.confirmSignInButton = confirmSignInButton;
        this.confirmSignUpButton = confirmSignUpButton;
        this.emailField = emailField;
        this.confirmPasswordField = confirmPasswordField;
        this.passwordField = passwordField;
        this.checkBox = checkBox;
        this.closeIcon = closeIcon;
        initialize();
    }

    public void initialize() {
        signInButton.setOnAction(this::handleSignInButtonClick);
        signUpButton.setOnAction(this::handleSignUpButtonClick);
        confirmSignInButton.setOnAction(this::handleConfirmSignInButtonClick);
        confirmSignUpButton.setOnAction(this::handleConfirmSignUpButtonClick);
        closeIcon.setOnMouseClicked(this::handleCloseIconClick);
    }

    private void handleSignInButtonClick(ActionEvent event) {
        signInButton.setStyle("-fx-background-color: linear-gradient(to right, #3366FF, #678ff6);");
        signUpButton.setStyle("-fx-background-color: #ffffff;");

        checkBox.setText("Remember Password");

        confirmPasswordField.setVisible(false);
        confirmSignInButton.setVisible(true);
        confirmSignUpButton.setVisible(false);
    }

    private void handleSignUpButtonClick(ActionEvent event) {
        signUpButton.setStyle("-fx-background-color: linear-gradient(to left, #3366FF, #678ff6);");
        signInButton.setStyle("-fx-background-color: #ffffff;");

        checkBox.setText("Terms");

        confirmPasswordField.setVisible(true);
        confirmSignInButton.setVisible(false);
        confirmSignUpButton.setVisible(true);
    }

    private void handleConfirmSignInButtonClick(ActionEvent event) {
        String email = emailField.getText();
        String password = passwordField.getText();

        if (email.isEmpty() || email.isBlank() || password.isEmpty() || password.isBlank()) {
            FormController.sendFormErrorMessage("Please enter a valid email address and password");
            return;
        }

        String databasePassword = MysqlController.containsPeople(email);

        if (databasePassword == null || !email.contains("@")) {
            FormController.sendFormErrorMessage("Please enter a valid email address");
            return;
        }

        if (!password.equalsIgnoreCase(databasePassword)) {
            FormController.sendFormErrorMessage("Password does not match");
            return;
        }

        FormController.successfulLogin();
    }

    private void handleConfirmSignUpButtonClick(ActionEvent event) {
        String email = emailField.getText();
        String confirmPassword = confirmPasswordField.getText();
        String password = passwordField.getText();

        if (email.isEmpty() || email.isBlank() || confirmPassword.isEmpty() ||
                confirmPassword.isBlank() || password.isEmpty() || password.isBlank()) {
            FormController.sendFormErrorMessage("Please enter a valid email address and password");
            return;
        }

        if (!email.contains("@")) {
            FormController.sendFormErrorMessage("Please enter a valid email address");
            return;
        }

        String databasePassword = MysqlController.containsPeople(email);

        if (databasePassword != null) {
            FormController.sendFormErrorMessage("User already exists");
            return;
        }

        if (!password.equalsIgnoreCase(confirmPassword)) {
            System.out.println(password + " " + confirmPassword);
            FormController.sendFormErrorMessage("Password does not match");
            return;
        }

        if (!checkBox.isSelected()) {
            FormController.sendFormErrorMessage("Please accept the terms");
            return;
        }

        MysqlController.createPeople(new People("", email, null, password));

        FormController.successfulLogin();
    }

    private void handleCloseIconClick(MouseEvent event) {
        Platform.exit();
    }
}
