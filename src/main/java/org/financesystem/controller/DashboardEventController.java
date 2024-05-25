package org.financesystem.controller;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import org.financesystem.events.dashboard.LoadDashboardHandler;

public class DashboardEventController {

    private final LoadDashboardHandler loadDashboardHandler;

    public DashboardEventController(MysqlController mysqlController, FormController formController, ObservableList<Node> generalCard) {
        loadDashboardHandler = new LoadDashboardHandler(mysqlController, formController, generalCard);
        initialize();
    }

    private void initialize() {
        loadDashboardHandler.register();
    }
}
