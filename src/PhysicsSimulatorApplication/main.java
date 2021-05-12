package PhysicsSimulatorApplication;

import javafx.application.Application;
import javafx.stage.Stage;

public class main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Physics Simulator");
        Coordinator f = new Coordinator();
        f.init(primaryStage);
    }
}