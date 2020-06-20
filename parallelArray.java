package parallelArray;

import java.util.Scanner;
import java.io.*;

public class parallelArray{
	public static void main(String[] args) throws Exception{
		Scanner input = new Scanner(new File("/Users/sebiseb/eclipse-workspace/Practice/src/parallelArray/parallelArray.txt"));
		PrintStream output = new PrintStream("/Users/sebiseb/eclipse-workspace/Practice/src/parallelArray/parallelArray2.txt");

		final int MAX = 10;
		String [] name = new String [MAX];
		double [] balance = new double[MAX];
		int size;
		
		size = readData(name, balance, input);
		printArray(name, balance, size, output);
		
		output.println("--------------------");
		output.println("Sorted numerically using Bubble sort:\n");
		bubSort(name, balance, size);
		printArray(name, balance, size, output);
		output.println("--------------------");
		output.println("Sorted alphabetically using Selection sort:\n");
		selectSort(name, balance, size);
		printArray(name, balance, size, output);
		
		
		
		input.close();
	}// End of the main method
	
	public static int readData(String [] name, double [] balance, Scanner input) {
		int cnt;
		
		for (cnt = 0; input.hasNext(); cnt++) {
			name[cnt] = input.next();
			balance[cnt] = input.nextDouble();
			
		}// End of the for loop
		
		return cnt;
	}// End of the readData method
	
	public static void bubSort(String [] name, double [] balance, int size) {
		double temp1;
		String temp2;
		boolean swapped;
		do {
			swapped = false;
			
			for (int i = 0; i < size - 1; i++) {
				if(balance[i] > balance[i + 1]) {
					
					temp1 = balance[i];
					balance[i] = balance[i + 1];
					balance[i + 1] = temp1;
					swapped = true;
					
					temp2 = name[i];
					name[i] = name[i + 1];
					name[i + 1] = temp2;
					
				}// End of the if statement
				
			}// End of the for loop
			
		} while(swapped);
	}// End of the bubSort method
	
	public static void selectSort(String [] name, double [] balance, int size) {
		String temp1;
		double temp2;
		
		int low;// Lowest index
		
		for (int i = 0; i < size - 1; i++) {
			low = i;
			for (int j = i + 1; j < size; j++) {
				if (name[low].compareTo(name[j]) > 0) {
					low = j;
				}// End of the if statement
				
				temp1 = name[i];
				name[i] = name[low];
				name[low] = temp1;
				
				temp2 = balance[i];
				balance[i] = balance[low];
				balance[low] = temp2;
			}// End of the j for loop
			
		}// End of the i for loop
	}// End of the selectSort method
	
	public static void printArray(String [] name, double [] balance, int size, PrintStream output) {
		for (int i = 0; i < size; i++) {
			output.println(name[i] + "\t" + balance[i]);
		}// End of the for loop
	}
	
}// End of the class