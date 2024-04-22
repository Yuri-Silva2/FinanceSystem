package org.financesystem.view;

import javafx.scene.layout.BorderPane;
import org.financesystem.view.components.BottomBar;
import org.financesystem.view.components.CenterPanel;
import org.financesystem.view.components.LeftBar;
import org.financesystem.view.components.Taskbar;

public class FinanceWindow extends BorderPane {

    /**
     * Constructor for the FinanceWindow class.
     */
    public FinanceWindow() {
        super();
    }

    /**
     * Configures the FinanceWindow.
     */
    public void configure() {
        BottomBar bottomBar = displayBottomBar();
        CenterPanel centerPanel = displayCenterPanel();
        LeftBar leftBar = displayLeftBar();
        Taskbar taskbar = displayTaskbar();

        setBottom(bottomBar);
        setCenter(centerPanel);
        setLeft(leftBar);
        setTop(taskbar);
    }

    /**
     * Displays the BottomBar.
     *
     * @return The BottomBar
     */
    private BottomBar displayBottomBar() {
        BottomBar bottomBar = new BottomBar();
        bottomBar.configure();
        return bottomBar;
    }

    /**
     * Displays the CenterPanel.
     *
     * @return The CenterPanel.
     */
    private CenterPanel displayCenterPanel() {
        CenterPanel centerPanel = new CenterPanel();
        centerPanel.configure();
        return centerPanel;
    }

    /**
     * Displays the LeftBar.
     *
     * @return The LeftBar
     */
    private LeftBar displayLeftBar() {
        LeftBar leftBar = new LeftBar();
        leftBar.configure();
        return leftBar;
    }

    /**
     * Displays the Taskbar.
     *
     * @return The Taskbar
     */
    private Taskbar displayTaskbar() {
        Taskbar taskbar = new Taskbar();
        taskbar.configure();
        return taskbar;
    }
}
