package base;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import actions.kamolini.HomePageActions;
import util.P_util;

public class BaseTest_kamolini {
	
	public WebDriver driver = null;
	public HomePageActions homePageActions = null;
	public String testURL = null;
	
	@BeforeClass
	public void init() throws InterruptedException, IOException {
		
		Properties config =  P_util.getConfig("config");
		String testEnv = config.getProperty("TestEnv").toLowerCase();
		
		testURL = "https://"+testEnv+".kamolini.com/";

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(testURL);
		homePageActions = new HomePageActions(driver);
	}
	
	@AfterClass
	public void closeDriver() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}
	

}
