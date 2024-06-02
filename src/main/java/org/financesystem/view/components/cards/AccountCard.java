package org.financesystem.view.components.cards;

import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import org.financesystem.model.Icon;

/**
 * A custom Pane used as the Account Card in the application.
 */
public class AccountCard extends Pane {

    /**
     * Constructor for the AccountCard class.
     */
    public AccountCard() {
        super();
        configure();
    }

    /**
     * Configures the AccountCard.
     */
    private void configure() {
        setId("account-card");
        setPrefHeight(239.0);
        setPrefWidth(503.0);
        setLayoutX(80.25);
        setLayoutY(330.0);
        createUIComponents();
    }

    /**
     * Creates the components that will be displayed.
     */
    private void createUIComponents() {
        Line lineBreak = displayLineBreak();

        Text totalTitle = displayTotalTitle();
        Text totalBalance = displayTotalBalance();

        ImageView addIconAccount1 = displayAddIcon(30.0);
        ImageView addIconAccount2 = displayAddIcon(90.0);
        ImageView addIconAccount3 = displayAddIcon(150.0);
        ImageView walletIcon1 = displayWalletIcon(30.0);
        ImageView walletIcon2 = displayWalletIcon(85.0);
        ImageView walletIcon3 = displayWalletIcon(145.0);

        Text walletTitle = displayWalletTitle();
        Text firstAccountTitle = displayFirstAccountTitle();
        Text secondAccountTitle = displaySecondAccountTitle();
        Text walletBalance = displayWalletBalance();
        Text firstAccountBalance = displayFirstAccountBalance();
        Text secondAccountBalance = displaySecondAccountBalance();

        addComponents(lineBreak, totalTitle, totalBalance,
                addIconAccount1, addIconAccount2, addIconAccount3,
                walletIcon1, walletIcon2, walletIcon3, walletTitle,
                firstAccountTitle, secondAccountTitle, walletBalance,
                firstAccountBalance, secondAccountBalance);
    }

    /**
     * Displays the line break in the card.
     *
     * @return Line node
     */
    private Line displayLineBreak() {
        Line line = new Line();
        line.setFill(Color.rgb(0, 0, 0, 1));
        line.setLayoutX(231.0);
        line.setLayoutY(192.0);
        line.setStartX(-207.0);
        line.setEndX(249.66);
        return line;
    }

    private Text displayTotalTitle() {
        Text text = new Text("Total");
        text.setFont(Font.font("Arial", 18.0));
        text.setFill(Color.rgb(0, 0, 0));
        text.setLayoutX(25.0);
        text.setLayoutY(220.0);
        return text;
    }

    private Text displayTotalBalance() {
        Text text = new Text("$0.00");
        text.setFont(Font.font("Arial", 18.0));
        text.setFill(Color.rgb(0, 0, 0));
        text.setLayoutX(430.0);
        text.setLayoutY(220.0);
        return text;
    }

    private ImageView displayAddIcon(double y) {
        ImageView addView = Icon.create(Icon.ADD_BLUE);
        addView.setFitHeight(22.0);
        addView.setFitWidth(22.0);
        addView.setLayoutX(460.0);
        addView.setLayoutY(y);
        return addView;
    }

    private ImageView displayWalletIcon(double y) {
        ImageView walletView = Icon.create(Icon.WALLET);
        walletView.setFitHeight(30.0);
        walletView.setFitWidth(30.0);
        walletView.setLayoutX(25.0);
        walletView.setLayoutY(y);
        return walletView;
    }

    private Text displayWalletTitle() {
        Text text = new Text("Wallet");
        text.setFont(Font.font("Arial", 16.0));
        text.setFill(Color.rgb(0, 0, 0));
        text.setLayoutX(70.0);
        text.setLayoutY(40.0);
        return text;
    }

    private Text displayFirstAccountTitle() {
        Text text = new Text("Wallet");
        text.setFont(Font.font("Arial", 16.0));
        text.setFill(Color.rgb(0, 0, 0));
        text.setLayoutX(70.0);
        text.setLayoutY(97.0);
        return text;
    }

    private Text displaySecondAccountTitle() {
        Text text = new Text("Wallet");
        text.setFont(Font.font("Arial", 16.0));
        text.setFill(Color.rgb(0, 0, 0));
        text.setLayoutX(70.0);
        text.setLayoutY(157.0);
        return text;
    }

    private Text displayWalletBalance() {
        Text text = new Text("$0.00");
        text.setFont(Font.font("Arial", 15.0));
        text.setFill(Color.rgb(0, 0, 0));
        text.setLayoutX(70.0);
        text.setLayoutY(60.0);
        return text;
    }

    private Text displayFirstAccountBalance() {
        Text text = new Text("$0.00");
        text.setFont(Font.font("Arial", 15.0));
        text.setFill(Color.rgb(0, 0, 0));
        text.setLayoutX(70.0);
        text.setLayoutY(115.0);
        return text;
    }

    private Text displaySecondAccountBalance() {
        Text text = new Text("$0.00");
        text.setFont(Font.font("Arial", 15.0));
        text.setFill(Color.rgb(0, 0, 0));
        text.setLayoutX(70.0);
        text.setLayoutY(175.0);
        return text;
    }

    /**
     * Adds an array of Nodes to the AccountCard.
     *
     * @param nodes Nodes to be added to the AccountCard
     */
    private void addComponents(Node... nodes) {
        getChildren().addAll(nodes);
    }
}
