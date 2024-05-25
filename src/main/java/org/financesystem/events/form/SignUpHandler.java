package org.financesystem.events.form;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import org.controlsfx.control.textfield.CustomPasswordField;
import org.controlsfx.control.textfield.CustomTextField;
import org.financesystem.controller.FormController;
import org.financesystem.controller.MysqlController;
import org.financesystem.model.People;

import java.util.UUID;

/**
 * The SignUpHandler class handles the sign-up related events for the form.
 * It manages the sign-up button click actions, validates user input, and interacts
 * with the MysqlController to create new user accounts.
 */
public class SignUpHandler {

    private final FormController formController;
    private final MysqlController mysqlController;

    private final Button signInButton;
    private final Button signUpButton;
    private final Button confirmSignInButton;
    private final Button confirmSignUpButton;
    private final CustomTextField emailField;
    private final CustomPasswordField confirmPasswordField;
    private final CustomPasswordField passwordField;
    private final CheckBox checkBox;

    /**
     * Constructs a SignUpHandler with the specified controllers and form components.
     *
     * @param mysqlController      the controller for interacting with the database
     * @param signInButton         the button for initiating the sign-in process
     * @param signUpButton         the button for initiating the sign-up process
     * @param confirmSignInButton  the button for confirming the sign-in process
     * @param confirmSignUpButton  the button for confirming the sign-up process
     * @param emailField           the text field for entering the email
     * @param confirmPasswordField the password field for confirming the password
     * @param passwordField        the password field for entering the password
     * @param checkBox             the checkbox for accepting the terms
     * @param formController       the controller for handling form-related actions
     */
    public SignUpHandler(MysqlController mysqlController, Button signInButton, Button signUpButton, Button confirmSignInButton,
                         Button confirmSignUpButton, CustomTextField emailField, CustomPasswordField confirmPasswordField,
                         CustomPasswordField passwordField, CheckBox checkBox, FormController formController) {
        this.mysqlController = mysqlController;
        this.signInButton = signInButton;
        this.signUpButton = signUpButton;
        this.confirmSignInButton = confirmSignInButton;
        this.confirmSignUpButton = confirmSignUpButton;
        this.emailField = emailField;
        this.confirmPasswordField = confirmPasswordField;
        this.passwordField = passwordField;
        this.checkBox = checkBox;
        this.formController = formController;
    }

    /**
     * Registers the event handlers for the sign-up and confirm sign-up buttons.
     * This method should be called to enable the sign-up functionality.
     */
    public void register() {
        signUpButton.setOnAction(this::handleSignUpButtonClick);
        confirmSignUpButton.setOnAction(this::handleConfirmSignUpButtonClick);
    }

    /**
     * Handles the sign-up button click event.
     * This method changes the button styles and updates the visibility of form components.
     *
     * @param event the ActionEvent triggered by clicking the sign-up button
     */
    private void handleSignUpButtonClick(ActionEvent event) {
        signUpButton.setStyle("-fx-background-color: linear-gradient(to left, #3366FF, #678ff6);");
        signInButton.setStyle("-fx-background-color: #ffffff;");

        checkBox.setText("Terms");

        confirmPasswordField.setVisible(true);
        confirmSignInButton.setVisible(false);
        confirmSignUpButton.setVisible(true);
    }

    /**
     * Handles the confirm sign-up button click event.
     * This method validates the user's input and interacts with the MysqlController
     * to create a new user account. If successful, it notifies the formController of the
     * successful sign-up.
     *
     * @param event the ActionEvent triggered by clicking the confirm sign-up button
     */
    private void handleConfirmSignUpButtonClick(ActionEvent event) {
        String email = emailField.getText();
        String confirmPassword = confirmPasswordField.getText();
        String password = passwordField.getText();

        if (email.isEmpty() || email.isBlank() || confirmPassword.isEmpty() ||
                confirmPassword.isBlank() || password.isEmpty() || password.isBlank()) {
            formController.sendFormErrorMessage("Please enter a valid email address and password");
            return;
        }

        if (!email.contains("@")) {
            formController.sendFormErrorMessage("Please enter a valid email address");
            return;
        }

        String databasePassword = mysqlController.containsPeople(email);

        if (databasePassword != null) {
            formController.sendFormErrorMessage("User already exists");
            return;
        }

        if (!password.equalsIgnoreCase(confirmPassword)) {
            formController.sendFormErrorMessage("Password does not match");
            return;
        }

        if (!checkBox.isSelected()) {
            formController.sendFormErrorMessage("Please accept the terms");
            return;
        }

        mysqlController.createPeople(new People(UUID.randomUUID(), "", email, null, password));
        formController.successfulSignUp();
    }
}
