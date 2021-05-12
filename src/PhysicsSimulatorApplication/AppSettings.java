package PhysicsSimulatorApplication;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;

public class AppSettings {
    private String[] currentSettings;
    private File settingsFile;
    private Scanner settingsScanner;
    private FileWriter settingsWriter;
    private String currentPath;

    //Constructor. No Inputs
    public AppSettings() {
        //Find Current Path. Fail if it cannot be found
        try {
            currentPath = new File(".").getCanonicalPath();
        } catch (IOException e) {
            System.out.println("Cannot Load FilePath: " + e.getMessage());
            System.exit(-1);
        }

        //Setup Read Settings. Fail if unable to find it.
        try {
            settingsFile = new File(currentPath + "\\src\\Settings\\app.settings");
            settingsScanner = new Scanner(settingsFile);

        } catch (IOException e) {
            System.out.println("Error Loading Settings: " + e.getMessage());
        }

        //Find Settings and Initialize Instance Array
        currentSettings = getSettingsArray();
    }

    //Returns an Array of all Settings
    public String[] getSettingsArray() {
        ArrayList<String> output = new ArrayList<String>();

        //Try to read settings. if there is an error, return empty;
        try {
            while (settingsScanner.hasNext()) {
                //Ignore label text
                settingsScanner.next();
                //Add value into array
                output.add(settingsScanner.next());
            }
        } catch (Exception e) {
            System.out.println("Error while reading settings: " + e.getMessage());
            return new String[0];
        }
        //Return Casted Array
        String[] out = new String[output.size()];
        out = output.toArray(out);
        return out;
    }

    //Returns Size X of Applet in Pixels
    public int getScreenSizeX() {
        return Integer.parseInt(currentSettings[0]);
    }

    //Returns Size Y of Applet in Pixels
    public int getScreenSizeY() {
        return Integer.parseInt(currentSettings[1]);
    }

    //Updates Settings for default size X
    public void setScreenSizeX(int size) {
        currentSettings[0] = size + "";
        updateSettings();
    }

    //Updates Settings for Default Size Y
    public void setScreenSizeY(int size) {
        currentSettings[1] = size + "";
        updateSettings();
    }

    //Updates the settings currently in CurrentSettings[] into the File
    public void updateSettings() {
        try {
            settingsWriter = new FileWriter(settingsFile);
            settingsWriter.write("WindowSizeX: " + currentSettings[0] + "\n");
            settingsWriter.write("WindowSizeY: " + currentSettings[1]);
            settingsWriter.close();
        } catch (IOException e) {
            System.out.println("Error in Writing Settings to File: " + e);
        }
    }
}
