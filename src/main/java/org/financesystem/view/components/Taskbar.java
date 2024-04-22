package org.financesystem.view.components;

import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import org.financesystem.model.Icon;

public class Taskbar extends AnchorPane {

    /**
     * Constructor for the Taskbar class.
     */
    public Taskbar() {
        super();
    }

    /**
     * Configures the Taskbar.
     */
    public void configure() {
        setId("taskbar");
        setPrefHeight(33.0);
        createUIComponents();
    }

    /**
     * Creates the components that will be displayed.
     */
    private void createUIComponents() {
        ImageView profileView = displayProfileIcon();
        ImageView menuView = displayMenuIcon();
        ImageView closeView = displayCloseIcon();

        addComponents(profileView, closeView, menuView);
    }

    /**
     * Displays an ImageView for an icon based on the specified Icon Enum.
     *
     * @return ImageView for the specified icon
     */
    private ImageView displayProfileIcon() {
        ImageView profileView = Icon.create(Icon.PROFILE, 22.24, 20);
        profileView.setLayoutX(10.0);
        profileView.setLayoutY(4.83);
        return profileView;
    }

    /**
     * Displays an ImageView for an icon based on the specified Icon Enum.
     *
     * @return ImageView for the specified icon
     */
    private ImageView displayMenuIcon() {
        ImageView menuView = Icon.create(Icon.MENU, 29, 20);
        menuView.setLayoutX(50.0);
        menuView.setLayoutY(6.2);
        return menuView;
    }

    /**
     * Displays an ImageView for an icon based on the specified Icon Enum.
     *
     * @return ImageView for the specified icon
     */
    private ImageView displayCloseIcon() {
        ImageView closeView = Icon.create(Icon.CLOSE, 29, 34);
        closeView.setLayoutX(1410.0);
        closeView.setLayoutY(6.2);
        return closeView;
    }

    /**
     * Adds an array of Nodes to the Taskbar.
     *
     * @param nodes Nodes to be added to the Taskbar
     */
    private void addComponents(Node... nodes) {
        getChildren().addAll(nodes);
    }
}
