package org.financesystem.view.components.panels;

import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import org.financesystem.view.components.cards.*;

/**
 * A custom AnchorPane used as the center panel in the application.
 */
public class CenterPanel extends AnchorPane {

    /**
     * Constructor for the CenterPanel class.
     */
    public CenterPanel() {
        super();
    }

    /**
     * Configures the CenterPanel.
     */
    public void configure() {
        setId("center-panel");
        createUIComponents();
    }

    /**
     * Creates the components that will be displayed.
     */
    private void createUIComponents() {
        AccountCard accountCard = displayAccountCard();
        CreditcardCard creditcardCard = displayCreditcardCard();
        ExpenseCard expenseCard = displayExpenseCard();
        GeneralCard generalCard = displayGeneralCard();
        PlanningCard planningCard = displayPlanningCard();

        Text accountText = displayTitle("Contas", 65.25, 315.0);
        Text creditcardText = displayTitle("Cartões de crédito", 768.75, 315.0);
        Text expenseText = displayTitle("Despesas por categoria", 65.25, 625.0);
        Text planningText = displayTitle("Planejamento mensal", 768.75, 625.0);

        addComponents(accountCard, creditcardCard, expenseCard,
                generalCard, planningCard, accountText,
                creditcardText, expenseText, planningText);
    }

    /**
     * Displays a title text with the specified properties.
     *
     * @param title The title text
     * @param x The x-coordinate of the text
     * @param y The y-coordinate of the text
     * @return The created Text node
     */
    private Text displayTitle(String title, double x, double y) {
        Text fTitle = new Text(title);
        fTitle.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 17.0));
        fTitle.setFill(Color.rgb(0, 0, 0, 0.8));
        fTitle.setLayoutX(x);
        fTitle.setLayoutY(y);
        return fTitle;
    }

    /**
     * Displays the AccountCard.
     *
     * @return The AccountCard instance
     */
    private AccountCard displayAccountCard() {
        AccountCard accountCard = new AccountCard();
        accountCard.configure();
        return accountCard;
    }

    /**
     * Displays the CreditcardCard.
     *
     * @return The CreditcardCard instance
     */
    private CreditcardCard displayCreditcardCard() {
        CreditcardCard creditcardCard = new CreditcardCard();
        creditcardCard.configure();
        return creditcardCard;
    }

    /**
     * Displays the ExpenseCard.
     *
     * @return The ExpenseCard instance
     */
    private ExpenseCard displayExpenseCard() {
        ExpenseCard expenseCard = new ExpenseCard();
        expenseCard.configure();
        return expenseCard;
    }

    /**
     * Displays the GeneralCard.
     *
     * @return The GeneralCard instance
     */
    private GeneralCard displayGeneralCard() {
        GeneralCard generalCard = new GeneralCard();
        generalCard.configure();
        return generalCard;
    }

    /**
     * Displays the PlanningCard.
     *
     * @return The PlanningCard instance
     */
    private PlanningCard displayPlanningCard() {
        PlanningCard planningCard = new PlanningCard();
        planningCard.configure();
        return planningCard;
    }

    /**
     * Adds an array of Nodes to the BottomBar.
     *
     * @param nodes Nodes to be added to the BottomBar
     */
    private void addComponents(Node... nodes) {
        getChildren().addAll(nodes);
    }
}
