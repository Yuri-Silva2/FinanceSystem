package org.financesystem.view;

import javafx.scene.layout.BorderPane;
import org.financesystem.controller.FormController;
import org.financesystem.controller.MysqlController;
import org.financesystem.view.components.panels.BottomPanel;
import org.financesystem.view.components.panels.CenterPanel;
import org.financesystem.view.components.panels.LeftPanel;
import org.financesystem.view.components.panels.TopPanel;

/**
 * A custom BorderPane representing the main window of the finance application.
 */
public class FinanceDashboard extends BorderPane {

    private final MysqlController mysqlController;
    private final FormController formController;

    /**
     * Constructor for the FinanceWindow class.
     */
    public FinanceDashboard(MysqlController mysqlController, FormController formController) {
        super();
        this.mysqlController = mysqlController;
        this.formController = formController;
        configure();
    }

    /**
     * Configures the FinanceWindow by displaying its components.
     */
    private void configure() {
        BottomPanel bottomPanel = new BottomPanel();
        CenterPanel centerPanel = new CenterPanel(mysqlController, formController);
        LeftPanel leftPanel = new LeftPanel();
        TopPanel topPanel = new TopPanel();

        setBottom(bottomPanel);
        setCenter(centerPanel);
        setLeft(leftPanel);
        setTop(topPanel);
    }
}
