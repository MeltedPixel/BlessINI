/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package whiskey.io.blessini;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import org.ini4j.Config;
import org.ini4j.Ini;
import org.ini4j.InvalidFileFormatException;
import org.ini4j.Wini;
import static whiskey.io.blessini.Main.isDebugRunning;

/**
 *
 * @author MPHI14
 */
public class test {
    // GENERAL-STATEMENTS ---
    public static Boolean fovFix;
    public static String bSmooth;
    public static Boolean mouseSmooth;
    public static Boolean lookupFix;
    public static String sIniFileName = "settings.ini";
    public static String sIniFileLocation = "";
    public static final String sWorkingPath = GeneralClasses.getWorkingDirectory();
    // END-GENERAL-STATEMENTS ---
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        Ini iBaseEngine = new Wini();
        Config config = new Config();
        config.setMultiOption(true);
        iBaseEngine.setConfig(config);
        try {
            iBaseEngine = new Wini(new File("C:\\Users\\mphi14\\Desktop\\SteamLibrary\\steamapps\\common\\Bless Online\\Engine\\Config\\BaseEngine.ini"));
        } catch (FileNotFoundException ex) {
            // Debug Statement
            if (isDebugRunning) {
                System.out.println("Debug: " + "BaseEngine ini not found");
            }
        } catch (InvalidFileFormatException ex) {
            // Debug Statement
            if (isDebugRunning) {
                System.out.println("Debug: " + "BaseEngine Not Correct Format");
            }
        } catch (IOException ex) {
            if (isDebugRunning) {
                System.out.println("Debug: " + "General Error");
            }
        }
        // bSmoothFrameRate
        bSmooth = iBaseEngine.get("Engine.Engine", "bSmoothFrameRate", String.class);
        // Debug Statement
        if (isDebugRunning) {
            System.out.println("Debug: " + "bSmoothFrameRate = " + bSmooth);
        }
        
        /*
        iBaseEngine.add("Engine.Engine", "bSmoothFrameRate", "false");
        try {
            iBaseEngine.store(new File("C:\\Users\\mphi14\\Desktop\\SteamLibrary\\steamapps\\common\\Bless Online\\Engine\\Config\\BaseEngine.ini"));
        } catch (IOException ex) {

        }
        */
        saveMe();
    }
    
    public static void setVariable(int lineNumber, String data) throws IOException {
        Path path = Paths.get("C:\\Users\\mphi14\\Desktop\\SteamLibrary\\steamapps\\common\\Bless Online\\Engine\\Config\\BaseEngine.ini");
        List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
        lines.set(lineNumber - 1, data);
        Files.write(path, lines, StandardCharsets.UTF_8);
    }
    
    public static void saveMe() throws IOException{
        String value = "true";
        setVariable(219, "bSmoothFrameRate=" + value);
        setVariable(555, "bSmoothFrameRate=" + value);
        
    }
    
}
