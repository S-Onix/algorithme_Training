package ArrayGravity;

public class array0008squenceSearch {
	public static int sqSearch(int [] array, int findValue) {
		int indexNum = 0;
		for(int i=0; i < array.length;i++) {
			if(array[i] == findValue) {
				indexNum = i;
				return indexNum;
			}
		}
		
		return -1;
	}
	
	public static int sqSearch2(int[] array, int findValue) {
		for(int i = 0; i < array.length; i++) {
			if(array[i] < findValue) {
				continue;
			}else if (array[i] == findValue) {
				return i;
			}else return -1;
		}
		return -1;
	}
	
	public static void main(String[] args) {
		
	}
}
