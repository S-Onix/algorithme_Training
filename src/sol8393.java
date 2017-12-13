import java.util.Scanner;

public class sol8393 {
	public static void main(String [] args) {
		Scanner scan = new Scanner(System.in);
		
		//solution way number 1
		int n = scan.nextInt();
		int result = (n*(n+1))/2;
		System.out.println(result);
		
		//solution way number2
		int sum = 0;
		for(int i = 1; i<= n; i++) {
			sum += i;
		}
		System.out.println(sum);
		
	}
}
