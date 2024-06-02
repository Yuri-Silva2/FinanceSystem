package org.financesystem.controller;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import org.financesystem.events.cards.AccountCardHandler;
import org.financesystem.events.cards.GeneralCardHandler;

public class CardsEventController {

    private final GeneralCardHandler generalCardHandler;
    private final AccountCardHandler accountCardHandler;

    public CardsEventController(MysqlController mysqlController, FormController formController, ObservableList<Node> generalCard,
                                ObservableList<Node> accountCard) {
        generalCardHandler = new GeneralCardHandler(mysqlController, formController, generalCard);
        accountCardHandler = new AccountCardHandler(mysqlController, formController, accountCard);
        initialize();
    }

    private void initialize() {
        generalCardHandler.register();
        accountCardHandler.register();
    }
}
