package olr;

import org.testng.annotations.Test;

public class OLR {
	
	@Test
	public void T() {
		double sumValue = sum(5,25);
		
		System.out.println(sumValue);
	}
	
	

	
	
	
	public double sum(double a, double b) {
		return a +b;
	}
	
	public double sum(double a, double b, double c) {
		return a + b +c;
	}
	
	public double sum(double a, double b, double c, double d) {
		return a + b + c + d;
	}
	
	public double sum(double a, double b, double c, double d, double e) {
		return a + b + c + d + e;
	}
	
	
	
	

}
