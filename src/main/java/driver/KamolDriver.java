package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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

}
