package test.ui;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest_kamolini;
import util.Excel;

public class KT3 extends BaseTest_kamolini{
	
	
	@Test
	public void VerifyCurrentUrl() throws InterruptedException {
		
	 	Assert.assertEquals(testURL, driver.getCurrentUrl());
		
	}
	
	@Test(dependsOnMethods =  "VerifyCurrentUrl")
	public void VerifyHomePageTitle() {
		
		
		
		
		
		
		
		
		/*
		 * File file = new
		 * File(System.getProperty("user.dir")+"\\src\\test\\resources\\data\\Test.xlsx"
		 * );
		 * 
		 * 
		 * String dataName = "HomePage"; Map<String, String> map = new HashMap<String,
		 * String>(); String data = null;
		 * 
		 * InputStream inputStream = new FileInputStream(file);
		 * 
		 * Workbook workbook = new XSSFWorkbook(inputStream);
		 * 
		 * Sheet smoke = workbook.getSheet("Titles");
		 * 
		 * int numOfRow = smoke.getLastRowNum();
		 * 
		 * for(int i=0; i <= numOfRow; i++) {
		 * 
		 * int numOfCell = smoke.getRow(i).getLastCellNum();
		 * 
		 * if(smoke.getRow(i).getCell(0) != null) { String v =
		 * smoke.getRow(i).getCell(0).getStringCellValue();
		 * if(v.equalsIgnoreCase(dataName)){ for(int f=1; f<numOfCell; f++) {
		 * 
		 * map.put( smoke.getRow(0).getCell(f).getStringCellValue(),
		 * smoke.getRow(i).getCell(f).getStringCellValue() ); } } } }
		 */
		
		
		
	
		
		
	 	Assert.assertEquals(Excel.getData("Test", "Titles", "HomePage").get("PageTitle"), driver.getTitle());
		
	}
	
	@Test(dependsOnMethods = {"VerifyHomePageTitle"})
	public void VerifyLoginPageTitle() throws InterruptedException, IOException {
		
		homePageActions.navigateToLoginPage();
		
	 	Assert.assertEquals(Excel.getData("Test", "Titles", "LoginPage").get("PageTitle"), driver.getTitle());
		
	}
	

}
