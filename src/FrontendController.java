import javafx.stage.Stage;

import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class FrontendController {
    //Instance
    private File settingsFile;
    private Scanner settingsScanner;
    private Stage primaryStage;

    //Create Application
    public void init(Stage primaryStage) {
        //Retrieve Primary Stage
        this.primaryStage = primaryStage;

        //Setup Read Settings. If no settings file is found, create one.
        try {
            String currentPath = new java.io.File(".").getCanonicalPath();
            settingsFile = new File(currentPath + "\\src\\Settings\\app.settings");
            settingsScanner = new Scanner(settingsFile);
            System.out.println(settingsScanner.nextLine());
        } catch (IOException e) {
            System.out.println("Settings App Not Found: " + e.getMessage());
        }
    }

}
