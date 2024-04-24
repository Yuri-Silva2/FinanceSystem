package org.financesystem.view;

import javafx.scene.layout.BorderPane;
import org.financesystem.view.components.panels.BottomPanel;
import org.financesystem.view.components.panels.CenterPanel;
import org.financesystem.view.components.panels.LeftPanel;
import org.financesystem.view.components.panels.TopPanel;

/**
 * A custom BorderPane representing the main window of the finance application.
 */
public class FinanceWindow extends BorderPane {

    /**
     * Constructor for the FinanceWindow class.
     */
    public FinanceWindow() {
        super();
    }

    /**
     * Configures the FinanceWindow by displaying its components.
     */
    public void configure() {
        BottomPanel bottomPanel = displayBottomPanel();
        CenterPanel centerPanel = displayCenterPanel();
        LeftPanel leftPanel = displayLeftPanel();
        TopPanel topPanel = displayTopPanel();

        setBottom(bottomPanel);
        setCenter(centerPanel);
        setLeft(leftPanel);
        setTop(topPanel);
    }

    /**
     * Displays the BottomPanel.
     *
     * @return The BottomPanel instance
     */
    private BottomPanel displayBottomPanel() {
        BottomPanel bottomPanel = new BottomPanel();
        bottomPanel.configure();
        return bottomPanel;
    }

    /**
     * Displays the CenterPanel.
     *
     * @return The CenterPanel instance
     */
    private CenterPanel displayCenterPanel() {
        CenterPanel centerPanel = new CenterPanel();
        centerPanel.configure();
        return centerPanel;
    }

    /**
     * Displays the LeftPanel.
     *
     * @return The LeftPanel instance
     */
    private LeftPanel displayLeftPanel() {
        LeftPanel leftPanel = new LeftPanel();
        leftPanel.configure();
        return leftPanel;
    }

    /**
     * Displays the TopPanel.
     *
     * @return The TopPanel instance
     */
    private TopPanel displayTopPanel() {
        TopPanel topPanel = new TopPanel();
        topPanel.configure();
        return topPanel;
    }
}
