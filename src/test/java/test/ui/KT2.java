package test.ui;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest_kamolini;
import util.P_util;

public class KT2 extends BaseTest_kamolini{
	
	
	@Test
	public void VerifyCurrentUrl() throws InterruptedException {
		
	 	Assert.assertEquals(testURL, driver.getCurrentUrl());
		
	}
	
	@Test
	public void VerifyHomePageTitle() throws InterruptedException, IOException {
		
	 	Assert.assertEquals(P_util.getConfig("title").getProperty("HomePage"), driver.getTitle());
		
	}
	
	@Test(dependsOnMethods = "VerifyCurrentUrl")
	public void VerifyLoginPageTitle() throws InterruptedException, IOException {
		
		homePageActions.navigateToLoginPage();
		
	 	Assert.assertEquals(P_util.getConfig("title").getProperty("LoginPage"), driver.getTitle());
		
	}
	

}
