package org.financesystem.view.components.cards;

import javafx.scene.Node;
import javafx.scene.layout.Pane;

/**
 * A custom Pane used as the Expense Card in the application.
 */
public class ExpenseCard extends Pane {

    /**
     * Constructor for the ExpenseCard class.
     */
    public ExpenseCard() {
        super();
        configure();
    }

    /**
     * Configures the ExpenseCard.
     */
    private void configure() {
        setId("expense-card");
        setPrefHeight(239.0);
        setPrefWidth(503.0);
        setLayoutX(80.25);
        setLayoutY(640.0);
        createUIComponents();
    }

    /**
     * Creates the components that will be displayed.
     */
    private void createUIComponents() {

    }

    /**
     * Adds an array of Nodes to the ExpenseCard.
     *
     * @param nodes Nodes to be added to the ExpenseCard
     */
    private void addComponents(Node... nodes) {
        getChildren().addAll(nodes);
    }
}
