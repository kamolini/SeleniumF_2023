package test;

import org.testng.Assert;

public class J {
	
	
	
	public static  void main(String[] args) {
		
		long a = Long.parseLong("1234567890");
		
		Double.parseDouble("");
		Integer.parseInt("");
		Float.parseFloat("");
		Short.parseShort("");
		Byte.parseByte("");
		Boolean.parseBoolean("");
		
		
		long b = 1234567890;
		
		
		Assert.assertEquals(a, b);
		
		
		String s = "We are in New York";
		
		char c[] =  s.toCharArray();
		
		String c1[] =  s.split("");
	}
	
	
	
	void sum(){
		
	}

}
