package org.financesystem.view.components;

import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import org.financesystem.model.Icon;

public class BottomBar extends AnchorPane {

    /**
     * Constructor for the BottomBar class.
     */
    public BottomBar() {
        super();
    }

    /**
     * Configures the BottomBar.
     */
    public void configure() {
        setId("bottom-bar");
        setPrefHeight(55.0);
        createUIComponents();
    }

    /**
     * Creates the components that will be displayed.
     */
    private void createUIComponents() {
        Circle circle = displayLeftBarCircle();

        addComponents(circle);
    }

    private ImageView displayAddIcon() {
        ImageView addView = Icon.create(Icon.ADD, 32.0, 32.0);

        return addView;
    }

    private Circle displayLeftBarCircle() {
        Circle circle = new Circle();
        circle.setCenterX(720.0);
        circle.setCenterY(27.0);
        circle.setRadius(25.0);
        circle.setFill(Color.rgb(51, 102, 255, 0.8));
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
