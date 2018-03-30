package ArrayGravity;

public class array0010selectionAl {
	public int[] selectionSort(int array[]) {
		int min = array[0];
		int minIndex = 0;
		int tempValue = 0;
		for(int i = 0; i<array.length; i++) {
			for(int j = 0; j<array.length; j++) {
				if(array[j] < min ) {
					min = array[j];
					minIndex = j;
				}
			}
			tempValue = array[i];
			array[i] = array[minIndex];
			array[minIndex] = tempValue;
		}
		
		return array;
	}
}
