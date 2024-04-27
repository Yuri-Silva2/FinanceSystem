package org.financesystem.view.components.panels;

import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import org.financesystem.model.Icon;

/**
 * A custom AnchorPane used as the left panel in the application.
 */
public class LeftPanel extends AnchorPane {

    /**
     * Constructor for the LeftPanel class.
     */
    public LeftPanel() {
        super();
    }

    /**
     * Configures the LeftPanel.
     */
    public void configure() {
        setId("left-panel");
        setPrefWidth(51.0);
        createUIComponents();
    }

    /**
     * Creates the components that will be displayed.
     */
    private void createUIComponents() {
        Pane rectangle = displayRectangle();
        ImageView arrowIcon = displayArrowIcon();

        addComponents(rectangle, arrowIcon);
    }

    /**
     * Displays the rectangle.
     *
     * @return The Rectangle
     */
    private Pane displayRectangle() {
        Pane rectangle = new Pane();
        rectangle.setPrefHeight(94.0);
        rectangle.setPrefWidth(51.0);
        rectangle.setLayoutX(0.0);
        rectangle.setLayoutY(415.0);
        rectangle.setId("left-panel-rectangle");
        return rectangle;
    }

    /**
     * Displays the arrow icon.
     *
     * @return The ImageView containing the arrow icon
     */
    private ImageView displayArrowIcon() {
        ImageView arrowView = Icon.create(Icon.ARROW);
        arrowView.setLayoutX(15.0);
        arrowView.setLayoutY(450.0);
        return arrowView;
    }

    /**
     * Adds an array of Nodes to the LeftPanel.
     *
     * @param nodes Nodes to be added to the LeftPanel
     */
    private void addComponents(Node... nodes) {
        getChildren().addAll(nodes);
    }
}
