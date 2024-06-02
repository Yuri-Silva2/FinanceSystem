package org.financesystem.view.components.panels;

import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import org.financesystem.controller.CardsEventController;
import org.financesystem.controller.FormController;
import org.financesystem.controller.MysqlController;
import org.financesystem.view.components.cards.*;

/**
 * A custom AnchorPane used as the center panel in the application.
 */
public class CenterPanel extends AnchorPane {

    private final MysqlController mysqlController;
    private final FormController formController;

    /**
     * Constructor for the CenterPanel class.
     */
    public CenterPanel(MysqlController mysqlController, FormController formController) {
        super();
        this.mysqlController = mysqlController;
        this.formController = formController;
        configure();
    }

    /**
     * Configures the CenterPanel.
     */
    private void configure() {
        setId("center-panel");
        createUIComponents();
    }

    /**
     * Creates the components that will be displayed.
     */
    private void createUIComponents() {
        AccountCard accountCard = new AccountCard();
        CreditcardCard creditcardCard = new CreditcardCard();
        ExpenseCard expenseCard = new ExpenseCard();
        GeneralCard generalCard = new GeneralCard();
        PlanningCard planningCard = new PlanningCard();

        Text accountText = displayTitle("Contas", 95.25, 315.0);
        Text creditcardText = displayTitle("Cartões de crédito", 798.75, 315.0);
        Text expenseText = displayTitle("Despesas por categoria", 95.25, 625.0);
        Text planningText = displayTitle("Planejamento mensal", 798.75, 625.0);

        addComponents(accountCard, creditcardCard, expenseCard,
                generalCard, planningCard, accountText,
                creditcardText, expenseText, planningText);

        new CardsEventController(mysqlController, formController, generalCard.getChildren(),
                accountCard.getChildren());
    }

    /**
     * Displays a title text with the specified properties.
     *
     * @param title The title text
     * @param x     The x-coordinate of the text
     * @param y     The y-coordinate of the text
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
     * Adds an array of Nodes to the BottomBar.
     *
     * @param nodes Nodes to be added to the BottomBar
     */
    private void addComponents(Node... nodes) {
        getChildren().addAll(nodes);
    }
}
