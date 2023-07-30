package r;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

public class R {
	
	int a = 102;
	
	String s = "tet";
	
	@Test
	public void T() {
		//System.out.println(isP(s));
		
		
		String st[] = {"ten", "ana", "sdfs", "dad", "mom"};
		
		System.out.println(listOfNonP(st));
		
		
	}
	
	
	
	public boolean isP(String s) {
		String newS = reverse(s);		
		if(s.equals(newS)) {
			return true;
		}else {
			return false;
		}
	}
	
	public int totalNumberOfP(String [] st){
		int total =0;
		for(int i =0; i<st.length; i++) {
			if(st[i].equals(reverse(st[i]))) {
				System.out.println(st[i]);
				total++;
			}
		}
		return total;	
	}
	
	public List<String> listOfNonP(String [] st){
		
		List<String> li = new ArrayList<String>();
		
		for(int i =0; i<st.length; i++) {
			if(!st[i].equals(reverse(st[i]))) {
				li.add(st[i]);
			}
		}
		return li;	
	}
	
	public List<String> listOfP(String [] st){
		
		List<String> li = new ArrayList<String>();
		
		for(int i =0; i<st.length; i++) {
			if(st[i].equals(reverse(st[i]))) {
				li.add(st[i]);
			}
		}
		return li;	
	}
	
	public boolean isEven(int x) {

		if(a%2==0) {
			return true;
		}else {
			return false;
		}
	}
	
	
	
	
	public String reverse(String s) {
		String newS = "";
		
		String a [] = s.split("");
		
		for (int i = a.length-1; i >= 0; i-- ) {
			newS = newS+a[i];
		}
		return newS;
	}
	

	
	
	
	
	
	

}
