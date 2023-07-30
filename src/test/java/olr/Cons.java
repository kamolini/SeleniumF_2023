package olr;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

public class Cons {
	
	
	@Test
	public void t() {
		
		Bachar bachar = new Bachar(5);
		
		
		int x[]= {1,5,3};
		
		x[1] = 54;
		x[0] = 5425;
		
		x[0] = 41;
		
		List<Integer> li = new ArrayList<Integer>();
		
		li.add(2);
		li.add(5);
		li.add(7);
		
		li.remove(0);
		
		System.out.println(li.get(0));
		
	}
	

}
