package test.ui;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class KT {
	
	
	@Test
	public void V() throws InterruptedException, IOException {
		
		File file = new File(System.getProperty("user.dir")+"\\src\\test\\resources\\data\\data.properties");
		
		InputStream inputStream = new FileInputStream(file);
		
		Properties properties = new Properties();
		
		properties.load(inputStream);
		
		
		
		String env = properties.getProperty("TestEnv");
		
		WebDriver driver = new ChromeDriver();
		
		driver = new ChromeDriver();
		Thread.sleep(2000);
		
		String testURL = "https://"+env+".kamolini.com/";
		
		if(env.equals("QA")) {
			testURL = "https://qa.kamolini.com/";
		}else if(env.equals("UAT")) {
			testURL = "https://uat.kamolini.com/";
		}
		
	
		driver.get(testURL);
		
	 	Assert.assertEquals(testURL, driver.getCurrentUrl());
		
		
		
	}
	

}
