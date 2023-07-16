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
				//nextProduct.click();
				click(nextProduct);
			}

			actions.moveToElement(product(i)).build().perform();
			
			//Thread.sleep(4000);
			//quickView(i).click();
			staticWait(4);
			click(quickView(i));

		
			
			switchToFrame(iframeElement);

			try {
				Select select = new Select(d1);
				select.selectByIndex(1);

				select = new Select(d2);
				select.selectByIndex(1);

			} catch (Throwable t) {
			}

			//addToCart.click();
			click(addToCart);

			staticWait(3);
			//driver.switchTo().defaultContent();
			switchToDefaultContent();
			
			//driver.switchTo().frame(1);
			switchToFrame(1);

			if (i != numOfProduct) {
				//icon.click();
				click(icon);
			} else {
				//viewCartButton.click();
				click(viewCartButton);
			}
			staticWait(3);
			
			//driver.switchTo().defaultContent();
			switchToDefaultContent();
		}
		return new CartPageActions(driver);
	}

}
