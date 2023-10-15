package base;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.fasterxml.jackson.databind.deser.Deserializers.Base;

import actions.kamolini.HomePageActions;
import util.P_util;

public class BaseTest_kamolini extends BaseTest{
	
	//BaseTest baseTest = null;
	
	public WebDriver driver = null;
	public HomePageActions homePageActions = null;
	public String testURL = null;
	
	@BeforeClass(alwaysRun = true)
	public void init() throws InterruptedException, IOException {
		
		driver = getDriver();
		
		System.out.println("In B");
		
		Properties config =  P_util.getConfig("config");
		String testEnv = config.getProperty("TestEnv").toLowerCase();
		
		testEnv = testEnv.equalsIgnoreCase("PROD")? "" : testEnv+".";
		
		/*
		if(testEnv.equalsIgnoreCase("PROD")) {
			testEnv = "";
		}else {
			testEnv = testEnv+".";
		}
		*/
		
		testURL = "https://"+testEnv+"kamolini.com/";

		driver.get(testURL);
		homePageActions = new HomePageActions(driver);
	}
	
	@AfterClass
	public void close() {
		closeDriver(driver);
	}
	
	
	

}
