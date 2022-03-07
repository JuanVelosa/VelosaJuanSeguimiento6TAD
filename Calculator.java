package model;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

	private aSet a;
	private aSet b;
	
	public Calculator() {
		
		a = new aSet(0);
		b = new aSet(0);
	}
	
	public aSet getA() {
		
		if(a.getElements() != null) {
			
			return a;
		}
		
		return a;
	}

	public void setA(aSet a) {
		this.a = a;
	}

	public aSet getB() {

		if(b.getElements() != null) {

			return b;
		}

		return b;
	}

	public void setB(aSet b) {
		this.b = b;
	}
	
//	public List<Integer> inputSetData() {
//
//		return null;
//	}

	public List<Integer> createSet(String data) {
		
		String[] aList = data.split(";");
		
		List<Integer> list = new ArrayList<>();
		
		for(int i = 0; i < aList.length; i++) {
			
			list.add(Integer.parseInt(aList[i]));
		}
		
		return list;
	}
	
//	public Set<Integer> setUnion() {
//		
//		Set<Integer> c = new HashSet<>();
//		
////		c.addAll(a);
////		c.addAll(b);
//		
//		return c;
//	}
//	
//	public Set<Integer> setIntersection() {
//		
////		Set<Integer> c = new HashSet<>(a);
////		c.retainAll(b);
//		
////		System.out.println(c);
//
////		return c;
//		return null;
//	}
//	
//	public Set<Integer> setSymmetricDifference() {
//		
////		Set<Integer> c = new HashSet<>(a);
////		c.removeAll(b);
////		
////		Set<Integer> d = new HashSet<>(b);
////		d.removeAll(a);
////		
//		Set<Integer> e = new HashSet<>();
////		e.addAll(c);
////		e.addAll(d);
//		
////		System.out.println(c);
//		
//		return e;
//	}
}