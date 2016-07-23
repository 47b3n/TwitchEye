package _47b3n.twitcheye.classes;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadPropertiesFile {
	
	public ReadPropertiesFile() {
		
	}
	
	public String readProperties(String propName, String propertiesFilePath) {
		Properties prop = new Properties();
		InputStream input = null;
		String return1 = null;
		
		try {
			
			input = new FileInputStream(propertiesFilePath);
			
			prop.load(input);			

			return1 = prop.getProperty(propName);
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
 
		return return1;
	}
	
}
