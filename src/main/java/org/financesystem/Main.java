package org.financesystem;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.financesystem.view.FinanceWindow;

import java.util.Objects;

public class Main extends Application {

    private static final String TITLE = "Finance System";
    private static final int INITIAL_SCENE_WIDTH = 1440;
    private static final int INITIAL_SCENE_HEIGHT = 990;

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage stage) throws Exception {
        try {
            FinanceWindow window = new FinanceWindow();
            window.configure();

            Scene scene = new Scene(window, INITIAL_SCENE_WIDTH, INITIAL_SCENE_HEIGHT);
            scene.getStylesheets().add(getCSSFile("WindowStyle.css"));

            System.out.println();

            stage.setTitle(TITLE);
            stage.setScene(scene);

            stage.centerOnScreen();
            stage.initStyle(StageStyle.UNDECORATED);
            stage.show();

        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    private String getCSSFile(String name) {
        return Objects.requireNonNull(Main.class.getClassLoader()
                .getResource("style/" + name)).toExternalForm();
    }
}
