package recursion;

public class RecursionBubbleSort {
	public void swap(int [] array, int num1, int num2) {
		int temp = array[num1];
		array[num1] = array[num2];
		array[num2] = temp;
	}
	public void nonRecursionBubbleSort(int [] array, int n) {
		for(int i = 0; i < n -1; i++) {
			for(int j = 0; j < n - i - 1; j++) {
				if(array[j] > array[j+1])
					swap(array, j, j+1);
			}
		}
		for(int i = 0 ; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
	}
	
	public void recursionBubbleSort(int [] array, int n) {
		if( n == 1)
			return;
		for(int i = 0 ; i < n-1; i++) {
			if(array[i] > array[i + 1]) {
				swap(array,i,i+1);
			}
		}
		recursionBubbleSort(array, n-1);
	}
	
	public static void main(String[] args) {
		RecursionBubbleSort test = new RecursionBubbleSort();
		int array [] = {1,4,2,56,7,23,23};
		test.nonRecursionBubbleSort(array, array.length);
		test.recursionBubbleSort(array, array.length);
	}
}
