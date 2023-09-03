package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class P_util {
	
	public static Properties getConfig(String fileName) throws IOException {
		File file = new File(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\"+fileName+".properties");
		
		InputStream inputStream = new FileInputStream(file);
		Properties properties = new Properties();
		properties.load(inputStream);
		return properties;
	}
	
	

}
