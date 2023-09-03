package elements.kamolini;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import driver.KamolDriver;

public class HomePageElements extends KamolDriver{

	public HomePageElements(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[text()=' Login']")
	public WebElement loginLink;

}
