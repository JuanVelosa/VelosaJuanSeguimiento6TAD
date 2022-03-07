package ui;

import java.util.List;
import java.util.Scanner;

import model.Calculator;
import model.Set;

public class Menu {
	
	private Scanner sc;
	private Calculator calc;
	private boolean hasSets;

	public Menu() {
		
		sc = new Scanner(System.in);
		calc = new Calculator();
		hasSets = false;
	}
	
	public void mainMenu() {
		
		int option = 0;

		System.out.println("\n\n--------MAIN MENU--------\n");

		System.out.println("-Set A: " + calc.getA().print());
		System.out.println("-Set B: " + calc.getB().print());

		System.out.println(
				"\nSelect an option:\n" + 
						"(1) to Add Sets" + 
						"\n(2) for Operations" +
						"\n(3) for Deleting Sets" + 

				"\n\n(0) to exit");

		option = sc.nextInt();
		sc.nextLine();

		if(option != 0) {

			switch(option) {

			default:
				System.out.println("\n---Invalid Option");
				mainMenu();;
				break;

			case 1:
				
				if(!hasSets) {
					
					List<Integer> setA = calc.createSet(inputData('A'));
					
					for(int i = 0; i < setA.size(); i++) {
						
						calc.getA().addElement(setA.get(i));
					}
					
					calc.getA().insertionSort();
					
					List<Integer> setB = calc.createSet(inputData('B'));
					
					for(int i = 0; i < setB.size(); i++) {
						
						calc.getB().addElement(setB.get(i));
					}
					
					calc.getB().insertionSort();;
					hasSets = true;
					
				} else {
					
					System.out.println("--Sets already values");
				}
				
				mainMenu();
				break;
				
			case 2:
				
				if(hasSets) {
					
					System.out.println();
					
					Set union = calc.getA().findUnion(calc.getB());
					Set intersection = calc.getA().findIntersection(calc.getB());
					Set symmDiff = calc.getA().findSymmetricDifference(calc.getB());
					
					System.out.println("-Union: " + union.print());
					System.out.println("-Intersection: " + intersection.print());
					System.out.println("-Symmetric Difference: " + symmDiff.print());

				} else {

					System.out.println("--Sets have no values");
				}
				
				mainMenu();
				break;
				
			case 3:
				
				if(hasSets) {
					
					calc.getA().getElements().removeAll(calc.getA().getElements());
					calc.getA().setSize(0);
					calc.getB().getElements().removeAll(calc.getB().getElements());
					calc.getB().setSize(0);

					hasSets = false;
					
				} else {
					
					System.out.println("--Sets have no values");
				}
				
				mainMenu();
				break;
			} 
			
		} else if (option == 0) {
			
			System.out.println("\n-----OPERATION ENDED-----\n");
		}
	}
	
	private String inputData(char x) {
		
		if(x == 'A') {
			
			System.out.print("\nTerms for A: ");
			
		} else if(x == 'B') {
			
			System.out.print("\nTerms for B: ");
		}
		
		String data = sc.nextLine();
		return data;
	}
}
