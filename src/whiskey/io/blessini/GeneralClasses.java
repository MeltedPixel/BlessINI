/*
* This work is licensed under the Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 
* International License. To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/ 
* or send a letter to Creative Commons, PO Box 1866, Mountain View, CA 94042, USA.
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
