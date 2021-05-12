package PhysicsSimulatorApplication;

import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

public class ViewCoordinator {
    private Stage primaryStage;
    private AppSettings settings;

    public ViewCoordinator(Stage primaryStage, AppSettings settings) {
        this.primaryStage = primaryStage;
        this.settings = settings;
        System.out.println(start());
    }

    public boolean start() {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("StartScreen.fxml"));
        } catch (Exception e) {
            System.out.println("Error Creating Instance: " + e.getMessage());
            return false;
        }
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
        return true;
    }
}
