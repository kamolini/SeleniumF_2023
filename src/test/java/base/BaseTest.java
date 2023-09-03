package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import actions.wixkamolini.HomePageActions;

public class BaseTest {
	
	public WebDriver driver = null;
	public HomePageActions homePageActions = null;
	
	@BeforeClass
	public void init() throws InterruptedException {

		driver = new ChromeDriver();
		Thread.sleep(2000);
		driver.get("https://kamoleshbachar.wixsite.com/kamolini");
		homePageActions = new HomePageActions(driver);
	}
	
	@AfterClass

	public void closeDriver() {
		driver.close();
	}
	

}
