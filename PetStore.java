/*
 * Noah Alonso-Torres
 * HW 9 Bubblesort
 * CS101 Ames
 * 
 */


import java.io.*;
import java.util.*;


public class PetStore {

	Pet[] petArray = null;
	int size = 0;

	public void readData(String filename) {
		Scanner fileScanner = null;
		try {
			fileScanner = new Scanner(new File(filename));
		}  //Catches your error and terminates the program
		//wrong file name, dont have access, ect
		catch (FileNotFoundException e) {
			System.out.println(e);
			System.exit(1);
		}
		String stringSize = fileScanner.next();
		size = Integer.parseInt(stringSize);
		petArray = new Pet[size];

		for (int i = 0; i < petArray.length; i++) {
			String name  = fileScanner.next();
			String stringQuantity = fileScanner.next();
			int quantity = Integer.parseInt(stringQuantity);
			
			petArray[i] = new Pet(name, quantity);
		}
	}

	public void writeData(String filename) {
		PrintWriter outStream = null;
		try {
			outStream = new PrintWriter("sortedPets.txt");
		} catch (FileNotFoundException e) {
			System.out.println(e);
			System.exit(1);
		}
		outStream.println(size);
		for (int i = 0; i < petArray.length; ++i) {
			outStream.println(petArray[i].getName() + " " + petArray[i].getCount());
		}
		outStream.close();
	}

	public void sortAscendingByCount() {
		int count = 0;
		int stop = 0;
		do {
			for(int i = 1; i < petArray.length; i++) {
				if(petArray[i].compareCount(petArray[i-1]) == 1){
					swapPets(i, i-1);
					count++;
				}
			}
			if (count > 0) count = 0;
			else stop = 1;
		}
		while (stop < 1);
	}

	public void sortAscendingByName() {
		int count = 0;
		int stop = 0;
		do {
			for(int i = 1; i < petArray.length; i++) {
				if(petArray[i].compareName(petArray[i-1]) > 0){
					swapPets(i, i-1);
					count++;
				}
			}
			if (count > 0) count = 0;
			else stop = 1;
		}
		while (stop < 1);
	}

	public void sortDescendingByCount() {
		int count = 0;
		int stop = 0;
		do {
			for(int i = 1; i < petArray.length; i++) {
				if(petArray[i].compareCount(petArray[i-1]) == -1){
					swapPets(i, i-1);
					count++;
				}
			}
			if (count > 0) count = 0;
			else stop = 1;
		}
		while (stop < 1);
	}

	public void sortDescendingByName() {
		int count = 0;
		int stop = 0;
		do {
			for(int i = 1; i < petArray.length; i++) {
				if(petArray[i].compareName(petArray[i-1]) < 0){
					swapPets(i, i-1);
					count++;
				}
			}
			if (count > 0) count = 0;
			else stop = 1;
		}
		while (stop < 1);
	}

	public void swapPets(int i, int j){
		Pet[] tempArray = new Pet[1];
		tempArray[0] = petArray[j];
		petArray[j] = petArray[i];
		petArray[i] = tempArray[0];
	}

	public String toString() {
		//String name = Arrays.toString(petArray).replace(", ", "\n").replace("[", "").replace("]", "");
		//String friendly = size + "\n" + name;
		//return friendly;
		//System.out.println(petArray.toString());
		String legit = "fail00";
		String temp ="";

		for (int i = 0; i < petArray.length; i++) {
			legit = petArray[i].toString();
			temp += legit + "\n";
		}
		return temp;
	}
}
