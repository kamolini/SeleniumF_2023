package base;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import actions.wixkamolini.HomePageActions;
import util.P_util;

public class BaseTest {
	
	public HomePageActions homePageActions = null;
	
	
	public WebDriver getDriver() throws InterruptedException, IOException {
		
		WebDriver driver = null;
		if(P_util.getConfig("config").getProperty("Grid").equalsIgnoreCase("true")){		
			if(P_util.getConfig("config").getProperty("Saucelabs").equalsIgnoreCase("true")){
			
				ChromeOptions browserOptions = new ChromeOptions();
				browserOptions.setPlatformName("Windows 11");
				browserOptions.setBrowserVersion("latest");
				Map<String, Object> sauceOptions = new HashMap<>();
				sauceOptions.put("username", "kamolesh");
				sauceOptions.put("accessKey", "4649dfd4-58a4-43fc-b548-3245ac27b670");
				sauceOptions.put("build", "selenium-build-SOE69");
				sauceOptions.put("name", "Ui Automation");
				browserOptions.setCapability("sauce:options", sauceOptions);
				
				
				URL url = new URL("https://ondemand.us-west-1.saucelabs.com:443/wd/hub");
				driver = new RemoteWebDriver(url, browserOptions);
			}else {
				DesiredCapabilities capabilities = new DesiredCapabilities();
				//capabilities.setCapability("platformName", "Windows");
				capabilities.setPlatform(Platform.WIN11);
				
				//capabilities.setCapability("browserName", "chrome");
				capabilities.setBrowserName("chrome");
				
				
				driver = new RemoteWebDriver(new URL("http://localhost:4444"), capabilities);
			}
		}else {
			System.out.println("Local");
			driver = new ChromeDriver();
		
		}
		driver.manage().window().maximize();
		if(P_util.getConfig("config").getProperty("isResponsive").equalsIgnoreCase("true")) {
			Thread.sleep(2000);
			String devoceName = P_util.getConfig("config").getProperty("deviceName");
			String deviceDimension[] = P_util.getConfig("device").getProperty(devoceName).split(",");
			Dimension d = new Dimension(Integer.parseInt(deviceDimension[0]), Integer.parseInt(deviceDimension[1]));
			driver.manage().window().setSize(d);
		}
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
