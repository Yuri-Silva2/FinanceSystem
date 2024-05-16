package org.financesystem.view;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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
    }

    /**
     * Configures the FinanceForm by displaying its components.
     */
    public void configure() {
        setId("finance-form");
        createUIComponents();
    }

    /**
     * Creates the components that will be displayed.
     */
    private void createUIComponents() {
        Button confirmButton = displayConfirmButton();

        Label optionsButton = displayOptionsButton();
        Label optionsBackground = displayOptionsBackground();
        Label optionsButtonBlur = displayOptionsButtonBlur();

        CustomTextField emailField = displayEmailField();
        CustomTextField passwordField = displayPasswordField();

        CheckBox termsButton = displayTermsButton();

        addComponents(confirmButton, optionsButton,
                optionsBackground, optionsButtonBlur,
                emailField, passwordField, termsButton);
    }

    private Label displayOptionsBackground() {
        Label label = new Label("");
        label.setId("options-background");
        label.setLayoutX(105.0);
        label.setLayoutY(46.0);
        label.setPrefHeight(45.0);
        label.setPrefWidth(240.0);
        return label;
    }

    private Label displayOptionsButton() {
        Label label = new Label("    Sign in                     Sign up");
        label.setId("options-button");
        label.setLayoutX(105.0);
        label.setLayoutY(46.0);
        label.setPrefHeight(45.0);
        label.setPrefWidth(240.0);
        return label;
    }

    private Label displayOptionsButtonBlur() {
        Label label = new Label("           Sign in");
        label.setId("options-blur");
        label.setLayoutX(105.0);
        label.setLayoutY(46.0);
        label.setPrefHeight(45.0);
        label.setPrefWidth(122.5);
        return label;
    }

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

    private ImageView defineIcon(Icon ic) {
        ImageView icon = Icon.create(ic);
        icon.setFitHeight(23.0);
        icon.setFitWidth(23.0);
        return icon;
    }

    /**
     * Displays the button for the finance form.
     *
     * @return Button node
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
