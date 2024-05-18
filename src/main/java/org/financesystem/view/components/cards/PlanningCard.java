package org.financesystem.view.components.cards;

import javafx.scene.Node;
import javafx.scene.layout.Pane;

/**
 * A custom Pane used as the Planning Card in the application.
 */
public class PlanningCard extends Pane {

    /**
     * Constructor for the PlanningCard class.
     */
    public PlanningCard() {
        super();
        configure();
    }

    /**
     * Configures the PlanningCard.
     */
    private void configure() {
        setId("planning-card");
        setPrefHeight(239.0);
        setPrefWidth(533.0);
        setLayoutX(753.75);
        setLayoutY(640.0);
        createUIComponents();
    }

    /**
     * Creates the components that will be displayed.
     */
    private void createUIComponents() {

    }

    /**
     * Adds an array of Nodes to the PlanningCard.
     *
     * @param nodes Nodes to be added to the PlanningCard
     */
    private void addComponents(Node... nodes) {
        getChildren().addAll(nodes);
    }
}
