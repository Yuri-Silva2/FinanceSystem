package org.financesystem.view.components.cards;

import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import org.financesystem.model.Icon;

/**
 * A custom Pane used as the General Card in the application.
 */
public class GeneralCard extends Pane {

    /**
     * Constructor for the GeneralCard class.
     */
    public GeneralCard() {
        super();
        configure();
    }

    /**
     * Configures the GeneralCard.
     */
    private void configure() {
        setId("general-card");
        setPrefHeight(239.0);
        setPrefWidth(533.0);
        setLayoutX(392.5);
        setLayoutY(25.0);
        createUIComponents();
    }

    /**
     * Creates the components that will be displayed.
     */
    private void createUIComponents() {
        Text month = displayMonth();
        Text balanceTitle = displayBalanceTitle();
        Text currentBalance = displayCurrentBalance();
        Text revenueTitle = displayRevenueTitle();
        Text revenueCurrentBalance = displayRevenueCurrentBalance();
        Text expenseTitle = displayExpenseTitle();
        Text expenseCurrentBalance = displayExpenseCurrentBalance();

        ImageView visibilityIcon = displayVisibilityIcon();
        ImageView expandMoreIcon = displayExpandMoreIcon();
        ImageView arrowCircleUpIcon = displayArrowCircleUp();
        ImageView arrowCircleDownIcon = displayArrowCircleDown();

        addComponents(month, balanceTitle, currentBalance, revenueTitle,
                revenueCurrentBalance, expenseTitle, expenseCurrentBalance,
                visibilityIcon, expandMoreIcon, arrowCircleUpIcon,
                arrowCircleDownIcon);
    }

    /**
     * Displays the current month.
     *
     * @return Text node containing the month name
     */
    private Text displayMonth() {
        Text text = new Text("April");
        text.setFont(Font.font("Arial", 25.0));
        text.setFill(Color.rgb(0, 0, 0));
        text.setLayoutX(240.5);
        text.setLayoutY(35.0);
        return text;
    }

    /**
     * Displays the title for the balance section.
     *
     * @return Text node containing the balance title
     */
    private Text displayBalanceTitle() {
        Text text = new Text("Current Balance");
        text.setFont(Font.font("Arial", 18.0));
        text.setFill(Color.rgb(75, 68, 68));
        text.setLayoutX(200.5);
        text.setLayoutY(75.0);
        return text;
    }

    /**
     * Displays the current balance.
     *
     * @return Text node containing the current balance
     */
    private Text displayCurrentBalance() {
        Text text = new Text("$0.00");
        text.setFont(Font.font("Arial", 25.0));
        text.setFill(Color.rgb(0, 0, 0));
        text.setId("current-balance");
        text.setLayoutX(233.5);
        text.setLayoutY(105.0);
        return text;
    }

    /**
     * Displays the visibility icon.
     *
     * @return ImageView node containing the visibility icon
     */
    private ImageView displayVisibilityIcon() {
        ImageView visibilityView = Icon.create(Icon.VISIBILITY);
        visibilityView.setFitHeight(18.0);
        visibilityView.setFitWidth(18.0);
        visibilityView.setLayoutX(258.5);
        visibilityView.setLayoutY(125.0);
        return visibilityView;
    }

    /**
     * Displays the expand more icon.
     *
     * @return ImageView node containing the expand more icon
     */
    private ImageView displayExpandMoreIcon() {
        ImageView expandMoreView = Icon.create(Icon.EXPAND_MORE);
        expandMoreView.setFitHeight(19.0);
        expandMoreView.setFitWidth(31.0);
        expandMoreView.setLayoutX(295.5);
        expandMoreView.setLayoutY(20.0);
        return expandMoreView;
    }

    /**
     * Displays the arrow circle up icon.
     *
     * @return ImageView node containing the arrow circle up icon
     */
    private ImageView displayArrowCircleUp() {
        ImageView arrowCircleUpView = Icon.create(Icon.ARROW_CIRCLE_UP);
        arrowCircleUpView.setFitHeight(40.0);
        arrowCircleUpView.setFitWidth(40.0);
        arrowCircleUpView.setLayoutX(45.0);
        arrowCircleUpView.setLayoutY(165.0);
        return arrowCircleUpView;
    }

    /**
     * Displays the title for the revenue section.
     *
     * @return Text node containing the revenue title
     */
    private Text displayRevenueTitle() {
        Text text = new Text("Revenues");
        text.setFont(Font.font("Arial", FontWeight.EXTRA_BOLD, 16.0));
        text.setFill(Color.rgb(75, 68, 68));
        text.setLayoutX(90.0);
        text.setLayoutY(180.0);
        return text;
    }

    /**
     * Displays the current revenue balance.
     *
     * @return Text node containing the current revenue balance
     */
    private Text displayRevenueCurrentBalance() {
        Text text = new Text("$0.00");
        text.setFont(Font.font("Arial", 16.0));
        text.setFill(Color.rgb(28, 150, 48));
        text.setLayoutX(90.0);
        text.setLayoutY(200.0);
        return text;
    }

    /**
     * Displays the arrow circle down icon.
     *
     * @return ImageView node containing the arrow circle down icon
     */
    private ImageView displayArrowCircleDown() {
        ImageView arrowCircleUpView = Icon.create(Icon.ARROW_CIRCLE_DOWN);
        arrowCircleUpView.setFitHeight(40.0);
        arrowCircleUpView.setFitWidth(40.0);
        arrowCircleUpView.setLayoutX(365.0);
        arrowCircleUpView.setLayoutY(165.0);
        return arrowCircleUpView;
    }

    /**
     * Displays the title for the expense section.
     *
     * @return Text node containing the expense title
     */
    private Text displayExpenseTitle() {
        Text text = new Text("Expenses");
        text.setFont(Font.font("Arial", FontWeight.EXTRA_BOLD, 16.0));
        text.setFill(Color.rgb(75, 68, 68));
        text.setLayoutX(410.0);
        text.setLayoutY(180.0);
        return text;
    }

    /**
     * Displays the current expense balance.
     *
     * @return Text node containing the current expense balance
     */
    private Text displayExpenseCurrentBalance() {
        Text text = new Text("$0.00");
        text.setFont(Font.font("Arial", 16.0));
        text.setFill(Color.rgb(255, 0, 0));
        text.setLayoutX(410.0);
        text.setLayoutY(200.0);
        return text;
    }

    /**
     * Adds an array of Nodes to the GeneralCard.
     *
     * @param nodes Nodes to be added to the GeneralCard
     */
    private void addComponents(Node... nodes) {
        getChildren().addAll(nodes);
    }
}
