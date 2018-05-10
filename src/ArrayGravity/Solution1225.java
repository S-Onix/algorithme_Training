package ArrayGravity;

import java.util.Queue;
import java.util.Scanner;

public class Solution1225{
	public static void main(String[] args) {
		// 기본 알고리즘 배열의0번째는 0번째의 값 -1 -> 배열의 가장 마지막으로 이동 -> 나머지 앞으로 이동 -> 만약 마지막 값이 0보다 작거나 같으면 계산 종료
		Scanner scan = new Scanner(System.in);
		int array[] = new int[8];
		int subCount, temp;

		for (int tc = 0; tc < 10; tc++) {
			
			scan.nextInt();
			temp = 0;
			subCount  = 0;
			
			for (int i = 0; i < array.length; i++) {
				array[i] = scan.nextInt();
			}

			while (true) {
				subCount++;
				array[0] = array[0] - subCount;
				temp = array[0];
				for (int i = 1; i < array.length; i++) {
					array[i - 1] = array[i];
				}
				array[7] = temp;
				subCount = subCount % 5;
				if (array[7] <= 0) {
					array[7] = 0;
					System.out.print("#" + (tc+1));
					for (int i = 0; i < array.length; i++) {
						System.out.print(" " + array[i]);
					}
					System.out.println();
					break;
				}
			}
		}
	}
}
