package elements.kamolini;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import driver.KamolDriver;

public class LoginPageElements extends KamolDriver{
	
	public LoginPageElements(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	

}
