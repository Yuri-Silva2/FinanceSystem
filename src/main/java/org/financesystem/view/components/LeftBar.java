package org.financesystem.view.components;

import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class LeftBar extends AnchorPane {

    /**
     * Constructor for the LeftBar class.
     */
    public LeftBar() {
        super();
    }

    /**
     * Configures the LeftBar.
     */
    public void configure() {
        setId("left-bar");
        setPrefWidth(51.0);
        createUIComponents();
    }

    /**
     * Creates the components that will be displayed.
     */
    private void createUIComponents() {
        Pane rectangle = displayLeftBarRectangle();

        addComponents(rectangle);
    }

    private Pane displayLeftBarRectangle() {
        Pane rectangle = new Pane();
        rectangle.setPrefHeight(94.0);
        rectangle.setPrefWidth(51.0);
        rectangle.setLayoutX(0.0);
        rectangle.setLayoutY(415.0);
        rectangle.setId("left-bar-rectangle");
        return rectangle;
    }

    /**
     * Adds an array of Nodes to the LeftBar.
     *
     * @param nodes Nodes to be added to the LeftBar
     */
    private void addComponents(Node... nodes) {
        getChildren().addAll(nodes);
    }
}
