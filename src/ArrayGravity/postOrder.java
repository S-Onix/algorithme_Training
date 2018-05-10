package ArrayGravity;

import java.util.Scanner;
import java.util.Stack;

public class postOrder {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Scanner sScan = new Scanner(System.in);
		Stack<Integer> op = new Stack<Integer>();


		for (int tc = 1; tc < 11; tc++) {
			int n = scan.nextInt();
			int a, b;
			String str = sScan.nextLine();
			char[] arr = str.toCharArray();
			
			for (int i = 0; i < n; i++) {
				if (arr[i] >= '0' && arr[i] <= '9') {
					Character item = arr[i];
					op.add(Integer.parseInt(item.toString()));
				}
			}
			for(int i = 0; i < n; i++) {
				if(arr[i] == '+') {
					b = op.pop();
					a = op.pop();
					op.push(a+b);
				}
				if(arr[i] == '-') {
					b = op.pop();
					a = op.pop();
					op.push(a-b);
				}
				if(arr[i] == '/') {
					b = op.pop();
					a = op.pop();
					op.push(a/b);
				}
				if(arr[i] == '*') {
					b = op.pop();
					a = op.pop();
					op.push(a*b);
				}
			}
			
			System.out.println("#" + tc + " " + op.pop());
		}

	}
}
