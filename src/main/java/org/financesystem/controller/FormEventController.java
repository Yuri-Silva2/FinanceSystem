package org.financesystem.controller;

import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.image.ImageView;
import org.controlsfx.control.textfield.CustomPasswordField;
import org.controlsfx.control.textfield.CustomTextField;
import org.financesystem.events.form.CloseIconHandler;
import org.financesystem.events.form.SignInHandler;
import org.financesystem.events.form.SignUpHandler;

/**
 * Controller for handling events in the FinanceForm.
 */
public class FormEventController {

    private final SignInHandler signInHandler;
    private final SignUpHandler signUpHandler;
    private final CloseIconHandler closeIconHandler;

    /**
     * Initializes the FormEventController.
     *
     * @param formController       The FormController associated with this event controller.
     * @param signInButton         Button for signing in.
     * @param signUpButton         Button for signing up.
     * @param confirmSignInButton  Button for confirming sign in.
     * @param confirmSignUpButton  Button for confirming sign up.
     * @param emailField           Text field for email input.
     * @param confirmPasswordField Text field for confirming password input.
     * @param passwordField        Text field for password input.
     * @param checkBox             CheckBox for terms agreement.
     * @param closeIcon            Icon for closing the form.
     */
    public FormEventController(MysqlController mysqlController, FormController formController, Button signInButton, Button signUpButton, Button confirmSignInButton, Button confirmSignUpButton, CustomTextField emailField,
                               CustomPasswordField confirmPasswordField, CustomPasswordField passwordField, CheckBox checkBox, ImageView closeIcon) {
        this.signInHandler = new SignInHandler(mysqlController, signInButton, signUpButton, confirmSignInButton, confirmSignUpButton,
                emailField, confirmPasswordField, passwordField, checkBox, formController);
        this.signUpHandler = new SignUpHandler(mysqlController, signInButton, signUpButton, confirmSignInButton, confirmSignUpButton,
                emailField, confirmPasswordField, passwordField, checkBox, formController);
        this.closeIconHandler = new CloseIconHandler(closeIcon);
        initialize();
    }

    /**
     * Initializes the handlers by registering the necessary event handlers
     * for the sign-in, sign-up, and close icon functionalities.
     * This method should be called during the setup phase to ensure
     * that all handlers are properly registered and ready to use.
     */
    private void initialize() {
        signInHandler.register();
        signUpHandler.register();
        closeIconHandler.register();
    }
}
