import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Coordinator {
    //Instance
    private Stage primaryStage;
    private Scene currentScene;
    private AppSettings settings;

    //Create Application
    public void init(Stage primaryStage) {
        //Retrieve Primary Stage
        this.primaryStage = primaryStage;



        //Create Instance of Settings
        settings = new AppSettings();
        System.out.println(settings.getScreenSizeX());
        settings.setScreenSizeX(500);
        System.out.println(settings.getScreenSizeX());
    }
}
