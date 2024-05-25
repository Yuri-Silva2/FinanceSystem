package org.financesystem;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.controlsfx.control.textfield.CustomPasswordField;
import org.financesystem.controller.FormController;
import org.financesystem.controller.MysqlController;
import org.financesystem.service.AlertService;
import org.financesystem.session.SessionManager;
import org.financesystem.view.FinanceDashboard;
import org.financesystem.view.FinanceForm;

import java.io.File;
import java.util.Objects;

/**
 * Main class for the Finance System application.
 */
public class Main extends Application {

    private static double x, y;

    private static Stage stage;

    /**
     * Launches the JavaFX application.
     *
     * @param args The command line arguments.
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Starts the JavaFX application.
     *
     * @param primaryStage The primary stage of the application.
     */
    @Override
    public void start(Stage primaryStage) {
        Main.stage = primaryStage;
        initializeApplication();
    }

    /**
     * Initializes the application.
     */
    private void initializeApplication() {
        File sessionFile = new File(System.getProperty("user.home") + "\\Documents\\FinanceSystem\\session.properties");
        SessionManager sessionManager = new SessionManager(sessionFile);
        AlertService alertService = new AlertService();
        MysqlController mysqlController = new MysqlController();
        mysqlController.initialize();
        FormController formController = new FormController(sessionManager, alertService);

        FinanceForm financeForm = new FinanceForm(formController, mysqlController);

        Scene scene = new Scene(financeForm, 450.0, 510.0);
        scene.getStylesheets().add(getCSSFile("FormStyle"));

        Main.stage.setTitle("Finance System");
        Main.stage.setScene(scene);
        Main.stage.centerOnScreen();
        Main.stage.setResizable(false);
        Main.stage.initStyle(StageStyle.UNDECORATED);
        Main.stage.show();

        financeForm.setOnMousePressed(event -> {
            x = event.getSceneX();
            y = event.getSceneY();
        });

        financeForm.setOnMouseDragged(event -> {
            stage.setX(event.getScreenX() - x);
            stage.setY(event.getScreenY() - y);
        });

        selectSignInPage();

        formController.autoLogin();
    }

    /**
     * Selects the sign-in page in start and configures the UI elements.
     */
    private void selectSignInPage() {
        Scene scene = Main.stage.getScene();

        Button signInButton = (Button) scene.lookup("#signIn-button");
        Button signUpButton = (Button) scene.lookup("#signUp-button");
        signInButton.requestFocus();
        signInButton.setStyle("-fx-background-color: linear-gradient(to right, #3366FF, #678ff6);");
        signUpButton.setStyle("-fx-background-color: #ffffff;");

        CustomPasswordField customPasswordField = (CustomPasswordField) scene.lookup("#confirmpassword-field");
        customPasswordField.setVisible(false);

        Button confirmSignInButton = (Button) scene.lookup("#confirm-signIn-button");
        Button confirmSignUpButton = (Button) scene.lookup("#confirm-signUp-button");
        confirmSignInButton.setVisible(true);
        confirmSignUpButton.setVisible(false);
    }

    /**
     * Shows the Finance Dashboard.
     */
    public static void showFinanceDashboard() {
        stage.close();
        createFinanceDashboard();
        stage.show();
    }

    /**
     * Creates the Finance Dashboard.
     */
    private static void createFinanceDashboard() {
        FinanceDashboard financeDashboard = new FinanceDashboard();

        Main.stage = new Stage();

        Scene scene = new Scene(financeDashboard, 1440.0, 990.0);
        scene.getStylesheets().add(getCSSFile("DashboardStyle"));

        Main.stage.setScene(scene);
        Main.stage.centerOnScreen();
        Main.stage.initStyle(StageStyle.UNDECORATED);
        Main.stage.setResizable(false);

        financeDashboard.setOnMousePressed(event -> {
            x = event.getSceneX();
            y = event.getSceneY();
        });

        financeDashboard.setOnMouseDragged(event -> {
            stage.setX(event.getScreenX() - x);
            stage.setY(event.getScreenY() - y);
        });
    }

    /**
     * Retrieves the CSS File with the specified name.
     *
     * @param name The name of the CSS file.
     * @return The path to the CSS file.
     */
    private static String getCSSFile(String name) {
        return Objects.requireNonNull(Main.class.getClassLoader()
                .getResource("style/" + name + ".css")).toExternalForm();
    }
}
