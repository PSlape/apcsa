package Random_Stuff.Installer;

import java.net.URL;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;


/**
 * Write a description of class FileInstaller here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class FileInstaller
{
    private final URL url;
    private final HttpURLConnection connection;
    private final BufferedReader reader;
    
    public FileInstaller(String urlStr) throws MalformedURLException, IOException {
        url = new URL(urlStr);
        connection = (HttpURLConnection) url.openConnection();
        
        connection.setConnectTimeout(5000);
        connection.setReadTimeout(5000);
        
        reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        
        String inputLine;
        StringBuffer content = new StringBuffer();
        
        while((inputLine = reader.readLine()) != null) {
            content.append(inputLine);
        }
        connection.disconnect();
    }
}
