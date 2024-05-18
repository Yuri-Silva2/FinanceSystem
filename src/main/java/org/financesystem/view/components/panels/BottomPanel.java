package org.financesystem.view.components.panels;

import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import org.financesystem.model.Icon;

/**
 * A custom AnchorPane used as the bottom panel in the application.
 */
public class BottomPanel extends AnchorPane {

    /**
     * Constructor for the BottomPanel class.
     */
    public BottomPanel() {
        super();
        configure();
    }

    /**
     * Configures the BottomPanel.
     */
    private void configure() {
        setId("bottom-panel");
        setPrefHeight(60.0);
        createUIComponents();
    }

    /**
     * Creates the components that will be displayed.
     */
    private void createUIComponents() {
        Circle circle = displayCircle();
        ImageView addIcon = displayAddIcon();

        addComponents(circle, addIcon);
    }

    /**
     * Displays the add icon.
     *
     * @return The ImageView containing the add icon
     */
    private ImageView displayAddIcon() {
        ImageView addView = Icon.create(Icon.ADD);
        addView.setLayoutX(708.0);
        addView.setLayoutY(20.0);
        return addView;
    }

    /**
     * Displays the circle.
     *
     * @return The Circle
     */
    private Circle displayCircle() {
        Circle circle = new Circle();
        circle.setCenterX(720.0);
        circle.setCenterY(32.0);
        circle.setRadius(25.0);
        circle.setId("bottom-panel-circle");
        circle.setFill(Color.rgb(51, 102, 255));
        return circle;
    }

    /**
     * Adds an array of Nodes to the BottomBar.
     *
     * @param nodes Nodes to be added to the BottomBar
     */
    private void addComponents(Node... nodes) {
        getChildren().addAll(nodes);
    }
}
