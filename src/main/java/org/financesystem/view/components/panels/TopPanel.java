package org.financesystem.view.components.panels;

import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import org.financesystem.model.Icon;

/**
 * A custom AnchorPane used as the top panel in the application.
 */
public class TopPanel extends AnchorPane {

    /**
     * Constructor for the TopPanel class.
     */
    public TopPanel() {
        super();
    }

    /**
     * Configures the TopPanel.
     */
    public void configure() {
        setId("top-panel");
        setPrefHeight(33.0);
        createUIComponents();
    }

    /**
     * Creates the components that will be displayed.
     */
    private void createUIComponents() {
        ImageView profileIcon = displayProfileIcon();
        ImageView menuIcon = displayMenuIcon();
        ImageView closeIcon = displayCloseIcon();

        addComponents(profileIcon, menuIcon, closeIcon);
    }

    /**
     * Displays the profile icon.
     *
     * @return The ImageView containing the profile icon
     */
    private ImageView displayProfileIcon() {
        ImageView profileView = Icon.create(Icon.PROFILE, 22.24, 20);
        profileView.setLayoutX(10.0);
        profileView.setLayoutY(4.83);
        return profileView;
    }

    /**
     * Displays the menu icon.
     *
     * @return The ImageView containing the menu icon
     */
    private ImageView displayMenuIcon() {
        ImageView menuView = Icon.create(Icon.MENU, 29, 20);
        menuView.setLayoutX(50.0);
        menuView.setLayoutY(6.2);
        return menuView;
    }

    /**
     * Displays the close icon.
     *
     * @return The ImageView containing the close icon
     */
    private ImageView displayCloseIcon() {
        ImageView closeView = Icon.create(Icon.CLOSE, 29, 34);
        closeView.setLayoutX(1410.0);
        closeView.setLayoutY(6.2);
        return closeView;
    }

    /**
     * Adds an array of Nodes to the TopPanel.
     *
     * @param nodes Nodes to be added to the TopPanel
     */
    private void addComponents(Node... nodes) {
        getChildren().addAll(nodes);
    }
}
