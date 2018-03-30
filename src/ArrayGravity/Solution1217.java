package ArrayGravity;

import java.util.Scanner;

public class Solution1217 {

	public static void main(String [] args) {
		Scanner scan = new Scanner(System.in);
		int testCase = 0;
		int a, b;
		
		while(testCase < 10) {
			scan.nextInt();
			a = scan.nextInt();
			b = scan.nextInt();
			testCase++;
			System.out.println("#" + testCase + " " + reculsiveFuntion(a, b));
		}
	}
	
	public static int reculsiveFuntion(int num1, int num2) {
		if(num2 == 0) return 1;
		else return num1 * reculsiveFuntion(num1, num2-1);
	}
}
