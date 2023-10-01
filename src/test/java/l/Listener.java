package l;


import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

import driver.KamolDriver;

public class Listener implements ITestListener{
	
	@Override
	public void onTestFailure(ITestResult result) {
		
		try {
			KamolDriver.takeSS(KamolDriver.driver);;
		} catch (IOException e) {
			e.printStackTrace();
		}
	  }
	
	@Override
	public void onTestSuccess(ITestResult result) {
	   System.out.println("No SS test passed");
	  }
	

}
