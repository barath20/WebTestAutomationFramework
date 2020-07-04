package utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
	
	String result = "";
	InputStream inputStream;
 
	public String getPropValues(String key) throws IOException {
 
		try {
			Properties prop = new Properties();
			String propFileName = System.getProperty("user.dir")+"\\src\\test\\java\\makeMyTrip_test\\config.properties";
			
			inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
			 
			if (inputStream != null) {
				prop.load(inputStream);
			} else {
				throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
			}
			
			result = getPropValues(key);

		} catch (Exception e) {
			System.out.println("Exception: " + e);
		} finally {
			inputStream.close();
		}
		return result;
	}
}
