package driver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class KamolDriver {
	
	public WebDriver driver = null;
	
	public KamolDriver(WebDriver driver) {
		this.driver = driver;
	}
	
	public double getPriceFromText(WebElement element){
		return Double.parseDouble(element.getText().replace("$", ""));
	}
	
	public String getTitle() {
		return driver.getTitle();
	}
	
	public boolean verifyTitle(String expectedTitle) {
		if(driver.getTitle().equals(expectedTitle)) {
			return true;
		}else {
			return false;
		}
		
	}
	
	
	public void click(WebElement ele) {
		if(isClickable(ele)) {
			ele.click();
		}else {
			
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
}
