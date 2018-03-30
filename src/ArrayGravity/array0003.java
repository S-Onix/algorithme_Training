package ArrayGravity;

import java.util.Scanner;

/*
 * Sort : 두개이상의 자료를 정렬하는것
 * Bubble, Counting, Selection, Quick, Insertion
 * 
 * Bubble : 인접한 두개의 원소를 비교하여 자리를 계속 교환하는 방식 시간박잡도 O(n^2)
 * Counting : 항목들의 순서를 결정하기 위해 집합에 각 항목이 몇 개씩 있는지 세는 작업을 하여. 선형 시간에 정렬하는 효율적인 알고리즘(집합 내의 가장 큰 정수를 알아야함 시간복잡도 O(n+k) )
 * 
 * */
public class array0003 {
	public int[] bubleSort(int array[]) {

		int temp[] = new int[array.length];
		int tempValue;

		for (int i = 0; i < array.length; i++) {
			temp[i] = array[i];
		}

		for (int i = array.length - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (temp[j] > temp[j + 1]) {
					tempValue = temp[j];
					temp[j] = temp[j + 1];
					temp[j + 1] = tempValue;
				}
			}
		}

		return array;
	}

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
		int array[] = new int[10];
		Scanner scan = new Scanner(System.in);
		
		for(int i = 0; i < array.length; i++) {
			array[i] = scan.nextInt();
		}
		
		for(int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		
		System.out.println();
		
		array = CountingSort(array);
		
		for(int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		
		
	}
}
