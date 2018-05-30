
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package whiskey.io.blessini;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

/*
 * @author Whiskeysim
 */

public class GeneralClasses {
    public static String getWorkingDirectory() {
        final String dir = System.getProperty("user.dir");
        return dir;
    }
    
    public static boolean isRunning(String processName) throws IOException {
        String line;
        String pidInfo = "";

        Process p = Runtime.getRuntime().exec(System.getenv("windir") + "\\system32\\" + "tasklist.exe");

        try (BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()))) {
            while ((line = input.readLine()) != null) {
                pidInfo+=line;
            } 
        }

        return pidInfo.contains(processName); 
    }
    
    public static String getOSType() {
        String sOS[] = System.getProperty("os.name").toLowerCase().split(" ", 2);
        
        return sOS[0];
        
    }
    
    public static String getUrl(String urlString) throws Exception {
        BufferedReader reader = null;
        try {
            URL url = new URL(urlString);
            reader = new BufferedReader(new InputStreamReader(url.openStream()));
            StringBuilder buffer = new StringBuilder();
            int read;
            char[] chars = new char[1024];
            while ((read = reader.read(chars)) != -1)
                buffer.append(chars, 0, read);
            return buffer.toString();
        } finally {
            if (reader != null)
                reader.close();
        }
    }   
}
