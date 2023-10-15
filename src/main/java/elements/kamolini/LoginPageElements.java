package elements.kamolini;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import driver.KamolDriver;

public class LoginPageElements extends KamolDriver{
	
	public LoginPageElements(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "username")
	public WebElement email_textBox;
	
	@FindBy(xpath = "//div[@id='email']/small")
	public WebElement email_error_text;
	
	@FindBy(xpath = "//button[text()='Next']")
	public WebElement next_button;

}
