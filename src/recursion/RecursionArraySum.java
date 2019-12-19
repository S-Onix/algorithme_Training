package recursion;

public class RecursionArraySum {
	public int sum(int[] array, int index) {
		if(index == 0) {
			return array[0];
		}
		return array[index] + sum(array, index-1);
	}
	
	public static void main(String[] args) {
		int [] array = {1,2,3,4,5,6};
		int [] resultArray = new int [array.length];
		RecursionArraySum test = new RecursionArraySum();
		for(int i = 0 ; i < array.length; i++) {
			resultArray[i] = test.sum(array, i);
		}
		
		for(int i = 0 ; i < resultArray.length; i++) {
			System.out.print(resultArray[i] + " ");
		}
		
	}
}
