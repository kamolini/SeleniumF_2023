package test.ui;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import base.BaseTest;
import base.BaseTest_wixKamolini;
import driver.KamolDriver;

public class T extends BaseTest_wixKamolini{
	
	

	@Test
	public void main() {
		
		driver.manage().timeouts().pageLoadTimeout(2, TimeUnit.MINUTES);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
		
		
		
		driver.get("https://www.kamolini.com/signIn/v1/login.jsp");
		
		KamolDriver kamolDriver = new KamolDriver(driver);
		
		boolean b =  kamolDriver.verifyTitle("Kamol");
		System.out.println(b);
		
		WebElement nextB = null;
		

		/*
		 * WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 * driverWait.until(ExpectedConditions.elementToBeClickable(nextB));
		 * nextB.click();
		 */
		click(driver, nextB);
		
		WebElement nextB1 = null;
		
		/*
		 * driverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 * driverWait.until(ExpectedConditions.elementToBeClickable(nextB1));
		 * nextB1.click();
		 */
		click(driver, nextB1);
		
		
		WebElement nextB2 = null;
		/*
		 * driverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 * driverWait.until(ExpectedConditions.elementToBeClickable(nextB2));
		 * nextB2.click();
		 */
		click(driver, nextB2);
		
		WebElement nextB3 = null;
		/*
		 * driverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 * driverWait.until(ExpectedConditions.elementToBeClickable(nextB3));
		 * nextB3.click();
		 */
		click(driver, nextB3);
		
		WebElement nextB4 = null;
		/*
		 * driverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 * driverWait.until(ExpectedConditions.elementToBeClickable(nextB4));
		 * nextB4.click();
		 */
		click(driver, nextB4);
		
		WebElement nextB5 = null;
		/*
		 * driverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 * driverWait.until(ExpectedConditions.elementToBeClickable(nextB5));
		 * nextB5.click();
		 */
		
		click(driver, nextB5);
		
	
	}
	
	public void click(WebDriver driver, WebElement ele) {
		WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(30));
		driverWait.until(ExpectedConditions.elementToBeClickable(ele));
		
		ele.click();
	}

}















