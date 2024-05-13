package org.financesystem;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.financesystem.view.FinanceForm;
import org.financesystem.view.FinanceWindow;

import java.util.Objects;

public class Main extends Application {

    private static final int INITIAL_SCENE_WIDTH = 1440;
    private static final int INITIAL_SCENE_HEIGHT = 990;

    private static Stage stage;

    public static void main(String[] args) {
        initComponents();
        launch(args);
    }

    private static void initComponents() {

    }

    private static void initFinanceWindow() {
        createFinanceWindow();
    }

    public void start(Stage stage) throws Exception {
        try {
            Main.stage = stage;

            initFinanceWindow();

            FinanceForm financeForm = new FinanceForm();
            financeForm.configure();

            Scene scene = new Scene(financeForm, 473.0, 601.0);
            scene.getStylesheets().add(getCSSFile("FormStyle"));

            Main.stage.setTitle("Finance System");
            Main.stage.setScene(scene);
            Main.stage.centerOnScreen();
            Main.stage.setResizable(false);
            Main.stage.initStyle(StageStyle.DECORATED);
            Main.stage.show();

        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    private static void createFinanceWindow() {
        FinanceWindow window = new FinanceWindow();
        window.configure();

        Scene scene = new Scene(window, INITIAL_SCENE_WIDTH, INITIAL_SCENE_HEIGHT);
        scene.getStylesheets().add(getCSSFile("WindowStyle"));

        stage.setScene(scene);
        stage.centerOnScreen();
        stage.setResizable(false);
        stage.initStyle(StageStyle.UNDECORATED);
    }

    public static void showFinanceWindow() {
        stage.show();
    }

    private static String getCSSFile(String name) {
        return Objects.requireNonNull(Main.class.getClassLoader()
                .getResource("style/" + name + ".css")).toExternalForm();
    }
}
