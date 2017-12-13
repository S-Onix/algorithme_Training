import java.util.Scanner;
import java.util.StringTokenizer;

public class sol1924 {
	public static void main(String [] args) {
		Scanner scan = new Scanner(System.in);
		
		String x = scan.nextLine();
		
		StringTokenizer st = new StringTokenizer(x, " ");
		String [] array = new String[st.countTokens()];
		int [] tempArray = new int[st.countTokens()];
		String [] dayArray = {"SUN","MON","TUE","WED","THU","FRI","SAT"};
		
		int i = 0;
		while(st.hasMoreTokens()) {
			array[i] = st.nextToken();
			tempArray[i] = Integer.parseInt(array[i]);
			i++;
		}

		int count = 0;
		
		if(tempArray[0] %2 == 1) {
			if(tempArray[0] > 2)
				count = ((tempArray[0]/2) * 31) + (((tempArray[0]/2) - 1) * 30) + 28 + tempArray[1];
			else
				count = tempArray[1];
		}else {
			if(tempArray[0] > 2) 
				count = ((tempArray[0]/2) * 31) + (((tempArray[0]/2) - 2) * 30) + 28 + tempArray[1];
			else
				count = 31 + tempArray[1];
		}
		
		System.out.println(dayArray[count%7]);
		
		scan.close();
	
		
	}
}
