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
		
		if(tempArray[0] %2 == 0) {
			if(tempArray[0] > 2) 
				count = ((tempArray[0]/2) * 31) + (((tempArray[0]/2) - 2) * 30) + 28 + tempArray[1];
			else
				count = 31 + tempArray[1];
			
		}else {
			if(tempArray[0] > 2)
				count = ((tempArray[0]/2) * 31) + (((tempArray[0]/2) - 1) * 30) + 28 + tempArray[1];
			else
				count = tempArray[1];
		}
		
		System.out.println(dayArray[count%7]);
		
		scan.close();
	
		
	}
}


/*
 
import java.util.Scanner;
 
public class Main {
 
    public static void main(String[] args) {
        // TODO Auto-generated method stub
         
        Scanner sc = new Scanner(System.in);
         
        int m = sc.nextInt();
        int d = sc.nextInt();
         
        int[] mdays = new int[13];
        mdays[1] = mdays[3] = mdays[5] = mdays[7] = mdays[8] = mdays[10] = mdays[12] = 31;
        mdays[4] = mdays[6] = mdays[9] = mdays[11] = 30;
        mdays[2] = 28;
         
        int sum = 0;
         
        for(int i = 1; i <= 12; i++) {
            if(i == m)  {
                break;
            }
             
            sum = sum + mdays[i];
        }
         
        sum = sum + d;
         
        switch(sum % 7) {
        case 0 :
            System.out.println("SUN");
            break;
        case 1 :
            System.out.println("MON");
            break;
        case 2 :
            System.out.println("TUE");
            break;
        case 3 :
            System.out.println("WED");
            break;
        case 4 :
            System.out.println("THU");
            break;
        case 5 :
            System.out.println("FRI");
            break;
        case 6 :
            System.out.println("SAT");
            break;
        }
 
    }
 
}


 
 */
