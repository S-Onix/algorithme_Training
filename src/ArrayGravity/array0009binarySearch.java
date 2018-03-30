package ArrayGravity;

public class array0009binarySearch {
	public static int binarySearch(int [] array, int findValue) {
		int start = 0;
		int end = array.length-1;
		int middle;
		
		while(end >= start) {
			middle = (start+end)/2;
			if(array[middle] == findValue) {
				return middle;
			}else if (array[middle] > findValue) {
				end = middle -1;
			}else start = middle +1;
		}
		
		return -1;
	}
}
