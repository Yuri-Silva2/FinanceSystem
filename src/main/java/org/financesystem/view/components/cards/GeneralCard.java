package org.financesystem.view.components.cards;

import javafx.scene.Node;
import javafx.scene.layout.Pane;

/**
 * A custom Pane used as the General Card in the application.
 */
public class GeneralCard extends Pane {

    /**
     * Constructor for the GeneralCard class.
     */
    public GeneralCard() {
        super();
    }

    /**
     * Configures the GeneralCard.
     */
    public void configure() {
        setId("general-card");
        setPrefHeight(239.0);
        setPrefWidth(533.0);
        setLayoutX(392.5);
        setLayoutY(25.0);
        createUIComponents();
    }

    /**
     * Creates the components that will be displayed.
     */
    private void createUIComponents() {

    }

    /**
     * Adds an array of Nodes to the GeneralCard.
     *
     * @param nodes Nodes to be added to the GeneralCard
     */
    private void addComponents(Node... nodes) {
        getChildren().addAll(nodes);
    }
}
