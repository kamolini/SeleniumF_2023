package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import actions.CartPageActions;
import base.BaseTest;

public class KamoliniTest extends BaseTest{
	
	CartPageActions cartPageActions = null;
	
	@Test
	public void VerifyHomePageTitle() {
		Assert.assertEquals(homePageActions.getTitle(), "HOME | Kamolini");
	}
	
	@Test(dependsOnMethods = "VerifyHomePageTitle")
	public void varifyCartPageAfterAddingandNavigateToCartPage() throws InterruptedException {
		
		cartPageActions = homePageActions.addProductToCartAndNavigateToCart(3);
		Assert.assertEquals(cartPageActions.getTitle(), "Cart Page | Kamolini");
	}
	

	@Test(dependsOnMethods = "varifyCartPageAfterAddingandNavigateToCartPage")
	public void verifySubTotal() {
		
		double a = cartPageActions.getSubTotalOfAllProduct();
		double e = cartPageActions.getSubTotalOfAllProduct();
		Assert.assertEquals(a,e);
	}

}
