package org.financesystem.view.components.cards;

import javafx.scene.Node;
import javafx.scene.layout.Pane;

/**
 * A custom Pane used as the Account Card in the application.
 */
public class AccountCard extends Pane {

    /**
     * Constructor for the AccountCard class.
     */
    public AccountCard() {
        super();
        configure();
    }

    /**
     * Configures the AccountCard.
     */
    private void configure() {
        setId("account-card");
        setPrefHeight(239.0);
        setPrefWidth(533.0);
        setLayoutX(50.25);
        setLayoutY(330.0);
        createUIComponents();
    }

    /**
     * Creates the components that will be displayed.
     */
    private void createUIComponents() {

    }

    /**
     * Adds an array of Nodes to the AccountCard.
     *
     * @param nodes Nodes to be added to the AccountCard
     */
    private void addComponents(Node... nodes) {
        getChildren().addAll(nodes);
    }
}
