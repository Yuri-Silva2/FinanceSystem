package org.financesystem.events.dashboard;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.text.Text;
import org.financesystem.controller.FormController;
import org.financesystem.controller.MysqlController;
import org.financesystem.events.Event;

public class LoadDashboardHandler implements Event {

    private final MysqlController mysqlController;
    private final FormController formController;
    private final Text currentBalance;

    public LoadDashboardHandler(MysqlController mysqlController, FormController formController, ObservableList<Node> generalCard) {
        this.mysqlController = mysqlController;
        this.formController = formController;
        currentBalance = (Text) generalCard.get(2);
    }

    @Override
    public void register() {
        loadCurrentBalanceFromData();
    }

    public void reload() {
        loadCurrentBalanceFromData();
    }

    private void loadCurrentBalanceFromData() {
        double currentBalanceValue = mysqlController.getCurrentBalanceByUUID(formController.getIDLoggedSession());
        currentBalance.setText("$" + currentBalanceValue);
    }
}
