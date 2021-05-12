import javafx.scene.Scene;
import javafx.stage.Stage;

public class Coordinator {
    //Instance
    private Stage primaryStage;
    private AppSettings settings;

    //Create Application
    public void init(Stage primaryStage) {
        //Retrieve Primary Stage
        this.primaryStage = primaryStage;

        //Create Instance of Settings
        settings = new AppSettings();

        //Create Instance of View Controller
        ViewCoordinator v = new ViewCoordinator(this.primaryStage, settings);
    }
}
