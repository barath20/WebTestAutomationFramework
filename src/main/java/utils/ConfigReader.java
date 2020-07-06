package utils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class ConfigReader {
	
	public static String currentRelativePath;

	public ConfigReader() {
	}
	
	public ConfigReader(String currentRelativePath) {
		ConfigReader.currentRelativePath =currentRelativePath;
	}

	public String getPropValues(String key) throws IOException {
		
		String value = null;
		
		// TODO - make it more dynamic
		Path path = Paths.get(System.getProperty("user.dir")+"\\src\\test\\java\\makeMyTrip_test\\", "config.properties");
//		Path path = Paths.get(System.getProperty(currentRelativePath, "config.properties"));
		
		try (InputStream input = Files.newInputStream(path)) {

            Properties properties = new Properties();
            properties.load(input);        
            value = (String) properties.get(key);

		} catch (IOException ex) {
            ex.printStackTrace();
        }
		return value;
    }			
}