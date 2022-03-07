package model;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

	private Set a;
	private Set b;
	
	public Calculator() {
		
		a = new Set(0);
		b = new Set(0);
	}
	
	public Set getA() {
		
		if(a.getElements() != null) {
			
			return a;
		}
		
		return a;
	}

	public void setA(Set a) {
		this.a = a;
	}

	public Set getB() {

		if(b.getElements() != null) {

			return b;
		}

		return b;
	}

	public void setB(Set b) {
		this.b = b;
	}
	
	public List<Integer> createSet(String data) {
		
		String[] aList = data.split(";");
		
		List<Integer> list = new ArrayList<>();
		
		for(int i = 0; i < aList.length; i++) {
			
			list.add(Integer.parseInt(aList[i]));
		}
		
		return list;
	}
}
