package edu.chdtu.carverif;

import edu.chdtu.carverif.controllers.MainController;
import edu.chdtu.carverif.dbutil.SessionInitializer;
import javafx.application.Application;
import javafx.stage.Stage;

public class ApplicationLauncher extends Application {

    private static MainController mainController;

    @Override
    public void start(Stage primaryStage) throws Exception {
        mainController = new MainController(primaryStage);
    }

    public static MainController getMainController() {
        return mainController;
    }

    public static void setMainController(MainController mainController) {
        ApplicationLauncher.mainController = mainController;
    }

    public static void main(String[] args) {
        new SessionInitializer().run();
        launch(args);
    }
}
