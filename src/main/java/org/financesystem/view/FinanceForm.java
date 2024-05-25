package org.financesystem.view;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import org.controlsfx.control.textfield.CustomPasswordField;
import org.controlsfx.control.textfield.CustomTextField;
import org.financesystem.controller.FormController;
import org.financesystem.controller.FormEventController;
import org.financesystem.controller.MysqlController;
import org.financesystem.model.Icon;

/**
 * A custom AnchorPane representing the form window of the finance application.
 */
public class FinanceForm extends AnchorPane {

    private final FormController formController;
    private final MysqlController mysqlController;

    /**
     * Constructor for the FinanceForm class.
     */
    public FinanceForm(FormController formController, MysqlController mysqlController) {
        super();
        this.formController = formController;
        this.mysqlController = mysqlController;
        configure();
    }

    /**
     * Configures the FinanceForm by displaying its components.
     */
    private void configure() {
        setId("finance-form");
        createUIComponents();
    }

    /**
     * Creates the components that will be displayed.
     */
    private void createUIComponents() {
        Button confirmSignInButton = displayConfirmSignInButton();
        Button confirmSignUpButton = displayConfirmSignUpButton();

        Button signInButton = displaySignInButton();
        Button signUpButton = displaySignUpButton();

        CustomTextField emailField = displayEmailField();
        CustomPasswordField confirmPasswordField = displayConfirmPasswordField();
        CustomPasswordField passwordField = displayPasswordField();

        CheckBox checkBox = displayCheckBox();

        ImageView closeIcon = displayCloseIcon();

        addComponents(confirmSignInButton, confirmSignUpButton, signUpButton, signInButton,
                emailField, confirmPasswordField, passwordField,
                checkBox, closeIcon);

        new FormEventController(mysqlController, formController, signInButton, signUpButton, confirmSignInButton,
                confirmSignUpButton, emailField, confirmPasswordField, passwordField,
                checkBox, closeIcon);
    }

    /**
     * Creates and returns the button for signing in.
     *
     * @return Button for signing in
     */
    private Button displaySignInButton() {
        Button button = new Button("Sign in");
        button.setId("signIn-button");
        button.setLayoutX(102.5);
        button.setLayoutY(56.0);
        button.setPrefHeight(45.0);
        button.setPrefWidth(120.0);
        return button;
    }

    /**
     * Creates and returns the button for signing up.
     *
     * @return Button for signing up
     */
    private Button displaySignUpButton() {
        Button button = new Button("Sign up");
        button.setId("signUp-button");
        button.setLayoutX(222.0);
        button.setLayoutY(56.0);
        button.setPrefHeight(45.0);
        button.setPrefWidth(120.0);
        return button;
    }

    /**
     * Creates and returns a CustomTextField for the email input.
     *
     * @return CustomTextField for the email input
     */
    private CustomTextField displayEmailField() {
        CustomTextField textField = new CustomTextField();
        textField.setId("email-field");
        textField.setPromptText("Email");
        textField.setLeft(defineIcon(Icon.MAIL_FORM));
        textField.setLayoutX(57.0);
        textField.setLayoutY(183.0);
        textField.setPrefHeight(30.0);
        textField.setPrefWidth(335.0);
        return textField;
    }

    /**
     * Creates and returns a CustomPasswordField for the confirmation password input.
     *
     * @return CustomPasswordField for the confirmation password input
     */
    private CustomPasswordField displayConfirmPasswordField() {
        CustomPasswordField customPasswordField = new CustomPasswordField();
        customPasswordField.setId("confirmpassword-field");
        customPasswordField.setPromptText("Confirm Password");
        customPasswordField.setLeft(defineIcon(Icon.LOCK));
        customPasswordField.setLayoutX(57.0);
        customPasswordField.setLayoutY(240.0);
        customPasswordField.setPrefHeight(30.0);
        customPasswordField.setPrefWidth(335.0);
        return customPasswordField;
    }

    /**
     * Creates and returns a CustomTextField for the password input.
     *
     * @return CustomTextField for the password input
     */
    private CustomPasswordField displayPasswordField() {
        CustomPasswordField passwordField = new CustomPasswordField();
        passwordField.setId("password-field");
        passwordField.setPromptText("Password");
        passwordField.setLeft(defineIcon(Icon.LOCK));
        passwordField.setLayoutX(57.0);
        passwordField.setLayoutY(298.0);
        passwordField.setPrefHeight(30.0);
        passwordField.setPrefWidth(335.0);
        return passwordField;
    }

    /**
     * Creates and returns a CheckBox for the "Remember Password" option.
     *
     * @return CheckBox for the "Remember Password" option
     */
    private CheckBox displayCheckBox() {
        CheckBox checkBox = new CheckBox();
        checkBox.setId("terms-button");
        checkBox.setText("Remember Password");
        checkBox.setLayoutX(57.0);
        checkBox.setLayoutY(340.0);
        checkBox.setPrefHeight(20.0);
        checkBox.setPrefWidth(150.0);
        return checkBox;
    }

    /**
     * Creates and returns an ImageView for the specified icon.
     *
     * @param icon The icon to be displayed
     * @return ImageView representing the specified icon
     */
    private ImageView defineIcon(Icon icon) {
        ImageView image = Icon.create(icon);
        image.setFitHeight(23.0);
        image.setFitWidth(23.0);
        return image;
    }

    /**
     * Creates and returns the button for confirming the form submission.
     *
     * @return Button for form submission
     */
    private Button displayConfirmSignInButton() {
        return getButton("Sign In", "confirm-signIn-button");
    }

    /**
     * Creates and returns the button for confirming the form submission.
     *
     * @return Button for form submission
     */
    private Button displayConfirmSignUpButton() {
        return getButton("Sign Up", "confirm-signUp-button");
    }

    private Button getButton(String text, String id) {
        Button button = new Button();
        button.setText(text);
        button.setId(id);
        button.setLayoutX(60.0);
        button.setLayoutY(422.0);
        button.setPrefHeight(50.0);
        button.setPrefWidth(330.0);
        return button;
    }

    /**
     * Displays the close icon.
     *
     * @return The ImageView containing the close icon
     */
    private ImageView displayCloseIcon() {
        ImageView closeView = Icon.create(Icon.CLOSE_FORM);
        closeView.setLayoutX(430.0);
        closeView.setLayoutY(2.0);
        closeView.setFitHeight(18.0);
        closeView.setFitWidth(18.0);
        return closeView;
    }

    /**
     * Adds an array of Nodes to the FinanceForm.
     *
     * @param nodes Nodes to be added to the FinanceForm
     */
    private void addComponents(Node... nodes) {
        getChildren().addAll(nodes);
    }
}
