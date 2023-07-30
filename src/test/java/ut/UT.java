package ut;

import org.testng.Assert;
import org.testng.annotations.Test;

public class UT {
	
	
	public int sum(int a, int b) {
		return a+b;
	}
	
	
	@Test
	public void t1() {
		Assert.assertEquals(sum(2,2),4);
	}
	
	@Test
	public void t2() {
		Assert.assertEquals(sum(2,3),5);
	}
	
	@Test
	public void t3() {
		Assert.assertNotEquals(sum(2,3),6);
	}
	

}
