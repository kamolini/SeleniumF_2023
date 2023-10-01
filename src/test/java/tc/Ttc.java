package tc;

import org.openqa.selenium.ElementNotInteractableException;
import org.testng.annotations.Test;

public class Ttc {
	
	
	@Test
	public void T() {
		
		System.out.println("before Try catch block ");
		
		try {
			System.out.println("In Try block Line 1");
			System.out.println("In Try block Line 2");
			System.out.println( 3+0 +"In Try block Line 3");
			System.out.println("In Try block Line 4");
			System.out.println(3/0 + "In Try block Line5 ");
			
			
		} catch (ElementNotInteractableException e) {
			e.printStackTrace();
			System.out.println("in Catch Block Line 1.1");
			System.out.println("in Catch Block Line 1.2");
		} finally {
			
		}
		
		
		
		
		
		
		try {
			System.out.println("In Try block Line 6");
			System.out.println("In Try block Line 7");
		} catch (ElementNotInteractableException e) {
			
		}
		System.out.println("After Try catch block Line ");
		
		
		
		
	}

}
