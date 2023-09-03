package base;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import actions.wixkamolini.HomePageActions;

public class BaseTest_wixKamolini {
	BaseTest baseTest = null;
	
	public WebDriver driver = null;
	public HomePageActions homePageActions = null;
	
	@BeforeClass
	public void init() throws InterruptedException, IOException {
		baseTest = new BaseTest();
		driver = baseTest.getDriver();
		
		driver.get("https://kamoleshbachar.wixsite.com/kamolini");
		homePageActions = new HomePageActions(driver);
	}
	
	@AfterClass
	public void close() {
		baseTest.closeDriver(driver);
	}
	

}
