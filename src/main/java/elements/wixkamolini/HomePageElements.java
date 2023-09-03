package elements.wixkamolini;

import org.openqa.selenium.By;
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
	
	/*
	 * public HomePageElements() { super(driver); }
	 */
	
	@FindBy(xpath = "//button[@aria-label='Next Product']")
	public WebElement nextProduct;

	public WebElement product(int indexOfProduct) {
		return driver.findElement(By.xpath("//div[@data-index=\"" + indexOfProduct + "\"]"));
	}

	public WebElement quickView(int indexOfProduct) {
		return driver.findElement(By.xpath("(//button[text()='Quick View'])[" + (indexOfProduct + 2) + "]"));
	}

	@FindBy(xpath = "//iframe[contains(@name,'tpaModal_rtby_')]")
	public WebElement iframeElement;

	@FindBy(xpath = "(//div[@data-hook='options-dropdown-title']/..//select)[1]")
	public WebElement d1;

	@FindBy(xpath = "(//div[@data-hook='options-dropdown-title']/..//select)[2]")
	public WebElement d2;

	@FindBy(xpath = "//button/*[text()='Add to Cart']")
	public WebElement addToCart;

	@FindBy(xpath = "//*[@class='icon']")
	public WebElement icon;

	@FindBy(id = "widget-view-cart-button")
	public WebElement viewCartButton;
	
	

}
