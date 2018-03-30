package ArrayGravity;

import java.util.Scanner;

public class array0005dump {
	
	public static int[] CountingSort(int array[]) {

		int maxValue = array[0];

		for (int i = 0; i < array.length; i++) {
			if (array[i] > maxValue) {
				maxValue = array[i];
			}
		}

		int countArray[] = new int[maxValue+1];
		for (int i = 0; i < countArray.length; i++) {
			countArray[i] = 0;
		}

		for (int i = 0; i < countArray.length; i++) {
			for (int j = 0; j < array.length; j++) {
				if (array[j] == i)
					countArray[i] += 1;
			}
			if (i > 0) {
				countArray[i] = countArray[i] + countArray[i-1];
			}
		}
		
		int temp[] = new int[array.length];
		
		for(int i = array.length-1; i>=0; i--) {
			countArray[array[i]] = countArray[array[i]] - 1;
			temp[countArray[array[i]]] = array[i];
		}
		

		return temp;
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int dumNum;
		int result;
		int maxValue = 0;
		int minValue = 0;
		
		int count = 0;
		
		while(count < 10) {
			int inputBox[] = new int [100];
			dumNum = scan.nextInt();
			for(int i = 0; i < inputBox.length; i++) {
				inputBox[i] = scan.nextInt();
			}
			
			for(int i = 0; i < dumNum; i++) {
				int tempValue = 0;
				inputBox = CountingSort(inputBox);
				inputBox[0] += 1;
				inputBox[inputBox.length-1] -= 1;
				
				if(inputBox[0] > inputBox[1]) {
					tempValue = inputBox[0];
					inputBox[0] = inputBox[1];
					inputBox[1] = tempValue;
				}
				
				if(inputBox[inputBox.length-2] > inputBox[inputBox.length-1]) {
					tempValue = inputBox[inputBox.length-1];
					inputBox[inputBox.length-1] = inputBox[inputBox.length-2];
					inputBox[inputBox.length-2] = tempValue;
				}
				result = inputBox[inputBox.length-1] - inputBox[0];
				if(result == 0 || result == 1)
					break;
			}
			result = inputBox[99] - inputBox[0];
			count++;
			System.out.println("#" + count + " " + result);
		}
		
		
		
		
		
	}
}
