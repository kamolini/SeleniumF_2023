package test.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Je {
	
	WebDriver driver = null;
	
	@BeforeMethod
	public void B() {
		driver = new ChromeDriver();
	}
	
	
	@Test
	public void T() throws InterruptedException {
		
		long from = 0;
		long to = 10000;
		
		
		 driver.get("https://www.yahoo.com/");
		
		
		 Thread.sleep(2000);
		 
		 
		 JavascriptExecutor javascriptExecutor = (JavascriptExecutor)driver;
		 
		 
		 for (int i=0; i<10; i++) {
			 javascriptExecutor.executeScript("window.scrollTo("+from+", "+to+")", new Object[0]);
				
			 Thread.sleep(2000);
			 
			 from = from + to;
			 to = to +1000;
		 }
		 
		 
		
		 javascriptExecutor.executeScript("window.scrollTo("+to+",0)", new Object[0]);
		 
		 
		 
		
	}
	
	@Test
	public void d() throws InterruptedException {
		
		driver.get("https://kamoleshbachar.wixsite.com/kamolini");
		
		
		
		 Thread.sleep(2000);
		 
			javascriptExecutor("arguments[0].scrollIntoView({block: \"center\"})", driver.findElement(By.xpath("//h2[text()='Hot This Week']")));

		
		//javascriptExecutor("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//h2[text()='Hot This Week']")));
			
			
			
			
			WebElement element =  driver.findElement(By.xpath("//a[@role='button']"));
			
			javascriptExecutor("arguments[0].scrollIntoView({block: \"center\"})", element);
			 Thread.sleep(2000);
			javascriptExecutor("arguments[0].click()", element);
	}
	
	
	
	public void javascriptExecutor(String a, WebElement b) {
		 JavascriptExecutor javascriptExecutor = (JavascriptExecutor)driver;
		 javascriptExecutor.executeScript(a, b);
	}

}


























