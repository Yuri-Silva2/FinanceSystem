package org.financesystem.events.cards;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import org.financesystem.StringUtils;
import org.financesystem.controller.FormController;
import org.financesystem.controller.MysqlController;
import org.financesystem.events.Event;
import org.financesystem.model.account.AccountDTO;

import java.util.List;

public class AccountCardHandler implements Event {

    private final MysqlController mysqlController;
    private final FormController formController;

    private final Text totalBalance;

    private final ImageView addIconAccount2;
    private final ImageView addIconAccount3;
    private final ImageView walletIcon2;
    private final ImageView walletIcon3;

    private final Text firstAccountTitle;
    private final Text secondAccountTitle;

    private final Text walletBalance;
    private final Text firstAccountBalance;
    private final Text secondAccountBalance;

    public AccountCardHandler(MysqlController mysqlController, FormController formController, ObservableList<Node> accountCard) {
        this.mysqlController = mysqlController;
        this.formController = formController;
        totalBalance = (Text) accountCard.get(2);
        addIconAccount2 = (ImageView) accountCard.get(4);
        addIconAccount3 = (ImageView) accountCard.get(5);
        walletIcon2 = (ImageView) accountCard.get(7);
        walletIcon3 = (ImageView) accountCard.get(8);
        firstAccountTitle = (Text) accountCard.get(10);
        secondAccountTitle = (Text) accountCard.get(11);
        walletBalance = (Text) accountCard.get(12);
        firstAccountBalance = (Text) accountCard.get(13);
        secondAccountBalance = (Text) accountCard.get(14);
    }

    @Override
    public void register() {
        loadData();
    }

    public void reload() {
        loadData();
    }

    private void loadData() {
        hideAllIconsAndTitles();

        double currentTotalBalance = mysqlController.getWalletBalanceByUUID(formController.getIDLoggedSession());
        double currentWalletBalance = mysqlController.getWalletBalanceByUUID(formController.getIDLoggedSession());

        totalBalance.setText("$" + currentTotalBalance);
        walletBalance.setText("$" + currentWalletBalance);

        List<AccountDTO> accountDTOS = mysqlController.getAllAccounts(formController.getIDLoggedSession());
        updateAccountViews(accountDTOS);
    }

    private void hideAllIconsAndTitles() {
        addIconAccount2.setVisible(false);
        addIconAccount3.setVisible(false);
        walletIcon2.setVisible(false);
        walletIcon3.setVisible(false);
        firstAccountTitle.setVisible(false);
        secondAccountTitle.setVisible(false);
        firstAccountBalance.setVisible(false);
        secondAccountBalance.setVisible(false);
    }

    private void updateAccountViews(List<AccountDTO> accountDTOS) {
        if (accountDTOS.size() >= 2) {
            AccountDTO firstAccount = accountDTOS.get(1);
            firstAccountTitle.setText(StringUtils.capitalize(firstAccount.institution().toString()));
            firstAccountBalance.setText("$" + firstAccount.value());

            addIconAccount2.setVisible(true);
            walletIcon2.setVisible(true);
            firstAccountTitle.setVisible(true);
            firstAccountBalance.setVisible(true);
        }

        if (accountDTOS.size() == 3) {
            AccountDTO secondAccount = accountDTOS.get(2);
            secondAccountTitle.setText(StringUtils.capitalize(secondAccount.institution().toString()));
            secondAccountBalance.setText("$" + secondAccount.value());

            addIconAccount3.setVisible(true);
            walletIcon3.setVisible(true);
            secondAccountTitle.setVisible(true);
            secondAccountBalance.setVisible(true);
        }
    }
}
