package org.financesystem.view.components;

import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;

public class CenterPanel extends AnchorPane {

    /**
     * Constructor for the CenterPanel class.
     */
    public CenterPanel() {
        super();
    }

    /**
     * Configures the CenterPanel.
     */
    public void configure() {
        setId("center-panel");
        createUIComponents();
    }

    /**
     * Creates the components that will be displayed.
     */
    private void createUIComponents() {

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
