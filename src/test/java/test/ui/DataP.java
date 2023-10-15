package test.ui;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import actions.kamolini.LoginPageActions;
import base.BaseTest_kamolini;
import util.Excel;

public class DataP extends BaseTest_kamolini{
	
	LoginPageActions loginPageActions = null;
	
	@BeforeClass
	public void before() {
		loginPageActions = homePageActions.navigateToLoginPage();
	}
	
	@Test(dataProvider = "getDataFromDataProvider")
	public void ValidateLoginWithInvalidEmail(String data) {
		
		Map<String, String> currentData =  Excel.getData("Test", "EmailData",data);
		
		//System.out.println(data+ " ->" + currentData.get("Email") +" -  "+ currentData.get("Pass"));
		
		Assert.assertTrue(loginPageActions.validateLoginWithInvalidEmail(currentData.get("Email")));
	}
	
	@DataProvider
	public Object[][] getDataFromDataProvider(){
		/*
		 * Object [][] obj = new String[3][1];
		 * 
		 * obj[0][0] = "Without@";
		 * 
		 * obj[1][0] = "WithoutExt";
		 * 
		 * obj[2][0] = "withoutAddress";
		 */
		return Excel.getDataForDP("Test", "EmailData");
	}
	
	
	
	
	

}
