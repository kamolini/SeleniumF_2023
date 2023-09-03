package iok;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.testng.annotations.Test;

public class Pro {
	
	@Test
	public void T() throws IOException {
		
		File file = new File(System.getProperty("user.dir")+"\\src\\test\\resources\\data\\data.properties");
		
		InputStream inputStream = new FileInputStream(file);
		
		Properties properties = new Properties();
		
		properties.load(inputStream);
		
		System.out.println(properties.get("TestEnv"));
		
		
		
		
	}

}
