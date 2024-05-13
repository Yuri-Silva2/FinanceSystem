package org.financesystem.view;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
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

        addComponents(confirmButton, optionsButton,
                optionsBackground, optionsButtonBlur);
    }

    private Label displayOptionsBackground() {
        Label label = new Label("");
        label.setId("options-background");
        label.setLayoutX(114.0);
        label.setLayoutY(46.0);
        label.setPrefHeight(50.0);
        label.setPrefWidth(245.0);
        return label;
    }

    private Label displayOptionsButton() {
        Label label = new Label("         Sign in                 Sign up");
        label.setId("options-button");
        label.setLayoutX(114.0);
        label.setLayoutY(46.0);
        label.setPrefHeight(50.0);
        label.setPrefWidth(245.0);
        return label;
    }

    private Label displayOptionsButtonBlur() {
        Label label = new Label("           Sign in");
        label.setId("options-blur");
        label.setLayoutX(114.0);
        label.setLayoutY(46.0);
        label.setPrefHeight(50.0);
        label.setPrefWidth(122.5);
        return label;
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
        button.setLayoutX(38.0);
        button.setLayoutY(511.0);
        button.setPrefHeight(50.0);
        button.setPrefWidth(397.0);
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
