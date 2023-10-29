package test.ui;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import actions.wixkamolini.CartPageActions;
import base.BaseTest_wixKamolini;

@Listeners(l.Listener.class)
public class KamoliniTest extends BaseTest_wixKamolini{
	
	CartPageActions cartPageActions = null;
	
	@Test(enabled = true)
	public void VerifyHomePageTitle() {
		Assert.assertTrue(homePageActions.verifyTitle("HOME | Kamolini"));
	}
	
	@Test(dependsOnMethods = "VerifyHomePageTitle", enabled = true)
	public void varifyCartPageAfterAddingandNavigateToCartPage() throws InterruptedException {
		
		cartPageActions = homePageActions.addProductToCartAndNavigateToCart(3);
		Assert.assertTrue(cartPageActions.verifyTitle("Cart Page | Kamolini"));

	}
	
	@Test(dependsOnMethods = "varifyCartPageAfterAddingandNavigateToCartPage", enabled = true)
	public void verifySubTotal() {
		
		double a = cartPageActions.getSubTotalOfAllProduct();
		double e = cartPageActions.getSubTotalOfAllProduct();
		Assert.assertEquals(a,e);		

	}
	
	
	@Test
	public void Tss() throws IOException {
		
		//homePageActions.takeSS();
		//System.out.println(9/0);
		 
		homePageActions.clickByJavascriptExecutor(homePageActions.cartButton);
		
		 
		 
		 
	}
}
