package r;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.testng.annotations.Test;

public class S {
	
	int a[] = {10,9,42,15,9,41,10,9,15,41,15};
	
	
	@Test
	public void T() {
	
	int total = 0;
	Map<Integer, Integer> m = new HashMap<Integer, Integer>();
	
	for(int i : a) {
		if(m.containsKey(i)) {
			m.put(i, m.get(i)+1);
		}else {
			m.put(i, 1);
		}
	}
	
	
	for(int i : m.keySet()) {
		System.out.println("Color "+i+" count "+ m.get(i)+ " p - "+ m.get(i)/2);
		total = total +  m.get(i)/2;
	}

	System.out.println(total);
	
	
	}
	
	@Test
	public void T1() {
	
		int total = 0;
		Map<Integer, Integer> m = new HashMap<Integer, Integer>();
		
		for(int i : a) {
			if(m.containsKey(i)) {
				total ++;
				m.remove(i);
			}else {
				m.put(i, 1);
			}
		}	
		System.out.println(total);
	
	
	}	
	
	@Test
	public void T2() {
	
	int total = 0;
	Set<Integer> m = new HashSet<Integer>();
	
	for(int i : a) {
		if(m.contains(i)) {
			total ++;
			m.remove(i);
		}else {
			m.add(i);
		}
	}	
	System.out.println(total);
	
	
	}
	

}
