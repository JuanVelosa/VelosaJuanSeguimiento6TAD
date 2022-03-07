package model;

import java.util.ArrayList;
import java.util.List;

public class Set {

	private List<Integer> elements;

	public int size;
	
	public Set(int size) {
		
		elements = new ArrayList<>();
		this.size = size;
	}
	
	public List<Integer> getElements() {
		return elements;
	}

	public int getSize() {
		return size;
	}

	public void setElements(List<Integer> elements) {
		this.elements = elements;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public boolean elementExists(int n) {
		for(int i = 0; i < size; i++) {
			
			if(elements.get(i) == n) {
				
				return true;
			}
		}
		
		return false;
	}
	public void addElement(int n) {
		
		if(!elementExists(n)) {
			
			elements.add(n);
			size++;
		}
	}
	
	public void removeElement(int n) {

		if(elementExists(n)) {
			
			elements.remove(n);
			size--;
		}
	}
	
	public Set findUnion (Set s) {

		List<Integer> unionSet = new ArrayList<>();
		List<Integer> aux = new ArrayList<>();
		
		aux.addAll(elements);
		for(int i = 0; i < s.size; i++) {
			if(!elements.contains(s.getElements().get(i))) {
				
				aux.add(s.getElements().get(i));
			}
		}
		
		unionSet = aux;
		Set union = new Set(0);
		union.setElements(unionSet);
		union.insertionSort();
		union.setSize(unionSet.size());
		return union;
	}
	
	public Set findIntersection(Set s) {

		List<Integer> intersectionSet = new ArrayList<>();
		List<Integer> aux = new ArrayList<>();
		aux.addAll(elements);
		for(int i = 0; i < aux.size(); i++) {
			
			if(elements.contains(aux.get(i)) && s.getElements().contains(aux.get(i))) {
				
				intersectionSet.add(aux.get(i));
			}
		}
		Set intersection = new Set(0);
		intersection.setElements(intersectionSet);
		intersection.insertionSort();;
		intersection.setSize(intersectionSet.size());
		
		return intersection;
	}
	
	public Set findSymmetricDifference(Set s) {

		List<Integer> symmDiffSet = new ArrayList<>();
		List<Integer> aux = new ArrayList<>();
		
		aux.addAll(elements);

		for(int i = 0; i < aux.size(); i++) {
			
			if(!elements.contains(aux.get(i)) || !s.getElements().contains(aux.get(i))) {
				
				symmDiffSet.add(aux.get(i));
			}
		}
		
		aux = s.getElements();
		
		for(int i = 0; i < aux.size(); i++) {
			
			if(!elements.contains(aux.get(i)) || !s.getElements().contains(aux.get(i))) {
				
				symmDiffSet.add(aux.get(i));
			}
		}
		
		Set symmDiff = new Set(0);
		symmDiff.setElements(symmDiffSet);
		
		symmDiff.insertionSort();

		symmDiff.setSize(symmDiffSet.size());
		
		return symmDiff;
	}
	
	public String print() {
		
		String line = "{";
		
		if(elements != null) {

			for(int i = 0; i < elements.size(); i++) {

				if(i == elements.size() - 1) {
					
					line += (elements.get(i));
				
				} else {
					
					line += (elements.get(i) + ", ");
				}
			}
		}
		
		line += "}";
		
		return line;
	}
	
	public void insertionSort() {

		int aux, j;

		for(int i = 1; i < size; i++) {

			aux = elements.get(i);
			j = i - 1;

			while(j >= 0 && aux < elements.get(j)) {

				elements.set(j+1, elements.get(j));
				j--;
			}
			
			elements.set(j+1, aux);
		}
	}
}