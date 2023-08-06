package r;

import org.testng.annotations.Test;

public class A {
	
	int a[] = {10,20,42,15,63,41,10};
	
	
	@Test
	public void T() {
		int newV[]= reverse2(a);
		for(int i: newV) { 
			//System.out.println(i); 
		}
		
		
		int a = 0;
		int b = 0;
		
		if(a < b ) {
			
		}
		
		if(b > a ) {
			
		}
		
		
		
		
	}
	
	
	
	public int[] reverse(int value[]) {
		int x[] = new int[value.length];
		int temp = 0;
		for (int i = value.length-1; i >= 0; i--) {
			x [temp] = value[i];
			temp++;
		}
		return x;
	}
	
	public int[] reverse1(int value[]) {
		int x[] = new int[value.length];
		int temp = value.length-1;
		for(int i : value) {
			  x[temp] =  i;
			  temp --;
		  }
		return x;
	}
	
	
	
	
	public int[] reverse2(int value[]) {
		int temp ;

		int li = value.length-1;
		int it = value.length/2;
		
		for(int i=0; i<it; i++) {
			
			temp = value[i];
			value[i] = value[li];
			value[li] = temp;
			
			li --;
		}
		return value;
	}
	

}






