package actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import elements.HomePageElements;

public class HomePageActions extends HomePageElements {

	
	  public HomePageActions(WebDriver driver) { 
		  super(driver); 
		  }
	  
	 

	public CartPageActions addProductToCartAndNavigateToCart(int numOfProduct) throws InterruptedException {
		for (int i = 1; i <= numOfProduct; i++) {
			Actions actions = new Actions(driver);

			if (i > 3) {
				nextProduct.click();
			}

			actions.moveToElement(product(i)).build().perform();
			Thread.sleep(4000);

			quickView(i).click();

			Thread.sleep(3000);

			driver.switchTo().frame(iframeElement);

			try {
				Select select = new Select(d1);
				select.selectByIndex(1);

				select = new Select(d2);
				select.selectByIndex(1);

			} catch (Throwable t) {
			}

			addToCart.click();

			Thread.sleep(3000);
			driver.switchTo().defaultContent();
			driver.switchTo().frame(1);

			if (i != numOfProduct) {
				icon.click();
			} else {
				viewCartButton.click();
			}
			Thread.sleep(3000);
			driver.switchTo().defaultContent();
		}
		return new CartPageActions(driver);
	}

}
