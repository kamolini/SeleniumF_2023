package test.ui;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Ss {
	
	@Test
	public void T() throws IOException {
		

		
		 WebDriver driver = new ChromeDriver();
		 driver.get("https://kamoleshbachar.wixsite.com/kamolini");
		
		 driver.findElement(By.xpath("//a[@role='button']")).click();
		 
		 
		 
		 
	}

}
