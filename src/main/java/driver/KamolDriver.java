package driver;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class KamolDriver {
	
	public static WebDriver driver = null;
	
	public KamolDriver(WebDriver driver) {
		this.driver = driver;
	}
	
	
	public void fillText(WebElement ele, String text) {
		System.out.println("Test data -> "+text );
		ele.sendKeys(text);
	}
	
	public void clearAndFillText(WebElement ele, String text) {
		ele.clear();
		fillText(ele,text);
	}
	
	public boolean isDisplayed(WebElement ele) {
		return ele.isDisplayed();
	}
	
	public boolean isEnabled(WebElement ele) {
		return ele.isEnabled();
	}
	
	public boolean isDisabled(WebElement ele) {
		return !isEnabled(ele);
	}
	
	public String getText(WebElement element) {
		return element.getText();
	}
	
	public boolean verifyText(String actual, String expected) {
		System.out.println("actual["+actual+"] expectex ["+expected+"]");
		return actual.contentEquals(expected);
	}
	
	public double getPriceFromText(WebElement element){
		return Double.parseDouble(element.getText().replace("$", ""));
	}
	
	public String getTitle() {
		return driver.getTitle();
	}
	
	public boolean verifyTitle(String expectedTitle) {
		
		return driver.getTitle().equals(expectedTitle) ? true : false;
		
		/*
		if(driver.getTitle().equals(expectedTitle)) {
			return true;
		}else {
			return false;
		}
		*/
	}
	
	
	public void click(WebElement ele) {
		
		if(isClickable(ele)) {
			ele.click();
		}else {
			throw new ElementClickInterceptedException("Element is not clickable");
		}
	}
	
	public boolean isClickable(WebElement ele) {
		WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(30));
		driverWait.until(ExpectedConditions.elementToBeClickable(ele));
		return true;
	}
	
	public void staticWait(int sec) {
		try {
			Thread.sleep(sec*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void switchToFrame(int indexOf){
		staticWait(3);
		driver.switchTo().frame(indexOf);
	}
	public void switchToFrame(WebElement element){
		staticWait(3);
		driver.switchTo().frame(element);
	}
	
	public void switchToDefaultContent(){
		staticWait(3);
		driver.switchTo().defaultContent();
	}
	
	public void c() {
		Cookie cookie1 = new Cookie("name", "value");
		driver.manage().addCookie(cookie1);
		
		Cookie cookie =  driver.manage().getCookieNamed("name");
		driver.manage().deleteCookie(cookie);
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.MICROSECONDS);
	}
	
	public static void takeSS(WebDriver driver) throws IOException {
		TakesScreenshot screenshot = (TakesScreenshot)driver;
		 File file =  screenshot.getScreenshotAs(OutputType.FILE);
		 
		 
		 String date = LocalDateTime.now().toString();
		 
		 date = date.replace(":", "_");
		 
		 System.out.println(date);

		 File dFile = new File(System.getProperty("user.dir")+"/src/test/resources/ss/"+date+".png");
		 
		FileUtils.copyFile(file, dFile);
	}
	
	public void javascriptExecutor(String a, WebElement b) {
		 JavascriptExecutor javascriptExecutor = (JavascriptExecutor)driver;
		 javascriptExecutor.executeScript(a, b);
	}
	
	public void clickByJavascriptExecutor(WebElement b) {
		javascriptExecutor("arguments[0].click()", b);
	}
	
}
