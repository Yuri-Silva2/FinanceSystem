package org.financesystem.view.components.cards;

import javafx.scene.Node;
import javafx.scene.layout.Pane;

/**
 * A custom Pane used as the Creditcard Card in the application.
 */
public class CreditcardCard extends Pane {

    /**
     * Constructor for the CreditcardCard class.
     */
    public CreditcardCard() {
        super();
    }

    /**
     * Configures the CreditcardCard.
     */
    public void configure() {
        setId("creditcard-card");
        setPrefHeight(239.0);
        setPrefWidth(533.0);
        setLayoutX(753.75);
        setLayoutY(330.0);
        createUIComponents();
    }

    /**
     * Creates the components that will be displayed.
     */
    private void createUIComponents() {

    }

    /**
     * Adds an array of Nodes to the CreditcardCard.
     *
     * @param nodes Nodes to be added to the CreditcardCard
     */
    private void addComponents(Node... nodes) {
        getChildren().addAll(nodes);
    }
}
