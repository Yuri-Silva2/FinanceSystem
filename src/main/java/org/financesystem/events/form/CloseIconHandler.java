package org.financesystem.events.form;

import javafx.application.Platform;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import org.financesystem.events.Event;

/**
 * The CloseIconHandler class is responsible for handling the close icon click event.
 * When the close icon is clicked, the application will exit.
 */
public class CloseIconHandler implements Event {

    private final ImageView closeIcon;

    /**
     * Constructs a CloseIconHandler with the specified close icon.
     *
     * @param closeIcon the ImageView representing the close icon
     */
    public CloseIconHandler(ImageView closeIcon) {
        this.closeIcon = closeIcon;
    }

    /**
     * Registers the click event handler for the close icon.
     * This method should be called to enable the close functionality.
     */
    @Override
    public void register() {
        closeIcon.setOnMouseClicked(this::handleCloseIconClick);
    }

    /**
     * Handles the close icon click event.
     * When the close icon is clicked, this method will be called to exit the application.
     *
     * @param mouseEvent the MouseEvent triggered by clicking the close icon
     */
    private void handleCloseIconClick(MouseEvent mouseEvent) {
        Platform.exit();
    }
}
