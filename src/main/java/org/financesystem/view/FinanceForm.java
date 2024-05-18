package org.financesystem.view;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import org.controlsfx.control.textfield.CustomTextField;
import org.financesystem.model.Icon;

/**
 * A custom AnchorPane representing the form window of the finance application.
 */
public class FinanceForm extends AnchorPane {

    /**
     * Constructor for the FinanceForm class.
     */
    public FinanceForm() {
        super();
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
        Button confirmButton = displayConfirmButton();
        Button signInButton = displaySignInButton();
        Button signUpButton = displaySignUpButton();

        CustomTextField emailField = displayEmailField();
        CustomTextField passwordField = displayPasswordField();

        CheckBox termsButton = displayTermsButton();

        addComponents(confirmButton, signUpButton,
                signInButton, emailField, passwordField, termsButton);
    }

    private Button displaySignInButton() {
        Button button = new Button("Sign in");
        button.setId("signIn-button");
        button.setLayoutX(102.5);
        button.setLayoutY(46.0);
        button.setPrefHeight(45.0);
        button.setPrefWidth(120.0);
        return button;
    }

    private Button displaySignUpButton() {
        Button button = new Button("Sign up");
        button.setId("signUp-button");
        button.setLayoutX(222.0);
        button.setLayoutY(46.0);
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
        textField.setLayoutY(173.0);
        textField.setPrefHeight(30.0);
        textField.setPrefWidth(335.0);
        return textField;
    }

    /**
     * Creates and returns a CustomTextField for the password input.
     *
     * @return CustomTextField for the password input
     */
    private CustomTextField displayPasswordField() {
        CustomTextField textField = new CustomTextField();
        textField.setId("password-field");
        textField.setPromptText("Password");
        textField.setLeft(defineIcon(Icon.LOCK));
        textField.setLayoutX(57.0);
        textField.setLayoutY(278.0);
        textField.setPrefHeight(30.0);
        textField.setPrefWidth(335.0);
        return textField;
    }

    /**
     * Creates and returns a CheckBox for the "Remember Password" option.
     *
     * @return CheckBox for the "Remember Password" option
     */
    private CheckBox displayTermsButton() {
        CheckBox checkBox = new CheckBox();
        checkBox.setId("terms-button");
        checkBox.setText("Remember Password");
        checkBox.setLayoutX(57.0);
        checkBox.setLayoutY(320.0);
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
    private Button displayConfirmButton() {
        Button button = new Button();
        button.setText("Sign in");
        button.setId("confirm-button");
        button.setLayoutX(60.0);
        button.setLayoutY(412.0);
        button.setPrefHeight(50.0);
        button.setPrefWidth(330.0);
        return button;
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
