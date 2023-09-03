package base;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import actions.wixkamolini.HomePageActions;

public class BaseTest {
	
	public HomePageActions homePageActions = null;
	
	
	public WebDriver getDriver() throws InterruptedException, IOException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		Thread.sleep(2000);
		return driver;
	}
	
	public void closeDriver(WebDriver driver) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.close();
	}
	
}
