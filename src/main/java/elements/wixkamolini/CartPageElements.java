package elements.wixkamolini;


import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import driver.KamolDriver;

public class CartPageElements extends KamolDriver{
	
	public CartPageElements(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[@class='apzZQq']")
	public List<WebElement> listOfE;
	
	@FindBy(xpath = "//dd[@data-hook='SubTotals.subtotalText']")
	public WebElement subtotalText;
	
	
	

}
