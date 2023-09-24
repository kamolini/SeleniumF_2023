package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FU {
	
	@Test
	public void T() {
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://ps.uci.edu/~franklin/doc/file_upload.html");
		
		WebElement fileB =  driver.findElement(By.name("userfile"));
		
		String fileLocation = System.getProperty("user.dir")+"/src/test/resources/uploadFile/";
		String fileName = "Te.jpg";
	
		fileB.sendKeys(fileLocation+fileName);
		
		String value = fileB.getAttribute("value");
				
		
		int i  = value.lastIndexOf("\\");
		
		String s = value.substring(i+1);
		
		
		Assert.assertEquals(fileName, s);
		Assert.assertTrue(value.contains(fileName));
		
		
		
		
		
		
	}

}
