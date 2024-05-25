package org.financesystem.events.form;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import org.controlsfx.control.textfield.CustomPasswordField;
import org.controlsfx.control.textfield.CustomTextField;
import org.financesystem.controller.FormController;
import org.financesystem.controller.MysqlController;
import org.financesystem.events.Event;

/**
 * The SignInHandler class handles the sign-in related events for the form.
 * It manages the sign-in button click actions, validates user input, and interacts
 * with the MysqlController to authenticate users.
 */
public class SignInHandler implements Event {

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
     * Constructs a SignInHandler with the specified controllers and form components.
     *
     * @param mysqlController      the controller for interacting with the database
     * @param signInButton         the button for initiating the sign-in process
     * @param signUpButton         the button for initiating the sign-up process
     * @param confirmSignInButton  the button for confirming the sign-in process
     * @param confirmSignUpButton  the button for confirming the sign-up process
     * @param emailField           the text field for entering the email
     * @param confirmPasswordField the password field for confirming the password
     * @param passwordField        the password field for entering the password
     * @param checkBox             the checkbox for remembering the password
     * @param formController       the controller for handling form-related actions
     */
    public SignInHandler(MysqlController mysqlController, Button signInButton, Button signUpButton, Button confirmSignInButton,
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
     * Registers the event handlers for the sign-in and confirm sign-in buttons.
     * This method should be called to enable the sign-in functionality.
     */
    @Override
    public void register() {
        signInButton.setOnAction(this::handleSignInButtonClick);
        confirmSignInButton.setOnAction(this::handleConfirmSignInButtonClick);
    }

    /**
     * Handles the sign-in button click event.
     * This method changes the button styles and updates the visibility of form components.
     *
     * @param event the ActionEvent triggered by clicking the sign-in button
     */
    private void handleSignInButtonClick(ActionEvent event) {
        signInButton.setStyle("-fx-background-color: linear-gradient(to right, #3366FF, #678ff6);");
        signUpButton.setStyle("-fx-background-color: #ffffff;");

        checkBox.setText("Remember Password");

        confirmPasswordField.setVisible(false);
        confirmSignInButton.setVisible(true);
        confirmSignUpButton.setVisible(false);
    }

    /**
     * Handles the confirm sign-in button click event.
     * This method validates the user's input and interacts with the MysqlController
     * to authenticate the user. If successful, it notifies the formController of the
     * successful login.
     *
     * @param event the ActionEvent triggered by clicking the confirm sign-in button
     */
    private void handleConfirmSignInButtonClick(ActionEvent event) {
        String email = emailField.getText();
        String password = passwordField.getText();

        if (email.isEmpty() || email.isBlank() || password.isEmpty() || password.isBlank()) {
            formController.sendFormErrorMessage("Please enter a valid email address and password");
            return;
        }

        String databasePassword = mysqlController.containsPeople(email);

        if (databasePassword == null || !email.contains("@")) {
            formController.sendFormErrorMessage("Please enter a valid email address");
            return;
        }

        if (!password.equalsIgnoreCase(databasePassword)) {
            formController.sendFormErrorMessage("Password does not match");
            return;
        }

        String uuid = mysqlController.getIdByEmail(email);
        formController.successfulLogin(uuid, checkBox.isSelected());
    }
}
