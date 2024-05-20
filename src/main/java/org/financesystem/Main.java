package org.financesystem;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.controlsfx.control.textfield.CustomPasswordField;
import org.financesystem.controller.MysqlController;
import org.financesystem.view.FinanceForm;
import org.financesystem.view.FinanceWindow;

import java.util.Objects;

/**
 * Main class for the Finance System application.
 */
public class Main extends Application {

    private static double x, y;

    private static final int INITIAL_SCENE_WIDTH = 1440;
    private static final int INITIAL_SCENE_HEIGHT = 990;

    private static Stage stage;

    public static void main(String[] args) {
        MysqlController.initialize();
        launch(args);
    }

    /**
     * Initializes the Finance Window.
     */
    public static void initFinanceWindow() {
        Main.stage.close();
        createFinanceWindow();
        showFinanceWindow();
    }

    @Override
    public void start(Stage stage) throws Exception {
        try {
            Main.stage = stage;

            FinanceForm financeForm = new FinanceForm();

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

        } catch (Exception e) {
            throw new Exception(e);
        }
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
     * Creates the Finance Window.
     */
    private static void createFinanceWindow() {
        FinanceWindow financeWindow = new FinanceWindow();

        Main.stage = new Stage();

        Scene scene = new Scene(financeWindow, INITIAL_SCENE_WIDTH, INITIAL_SCENE_HEIGHT);
        scene.getStylesheets().add(getCSSFile("WindowStyle"));

        Main.stage.setScene(scene);
        Main.stage.centerOnScreen();
        Main.stage.initStyle(StageStyle.UNDECORATED);
        Main.stage.setResizable(false);

        financeWindow.setOnMousePressed(event -> {
            x = event.getSceneX();
            y = event.getSceneY();
        });

        financeWindow.setOnMouseDragged(event -> {
            stage.setX(event.getScreenX() - x);
            stage.setY(event.getScreenY() - y);
        });
    }

    /**
     * Shows the Finance Window.
     */
    private static void showFinanceWindow() {
        stage.show();
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
