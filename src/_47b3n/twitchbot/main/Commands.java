package _47b3n.twitchbot.main;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Commands {
	
	public Commands() {
		
	}
	
	public String readProperties(String propName, String string) {
		Properties prop = new Properties();
		InputStream input = null;
		String return1 = null;
		
		try {
			
			input = new FileInputStream(string);
			
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
