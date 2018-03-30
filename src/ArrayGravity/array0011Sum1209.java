package ArrayGravity;

import java.util.Scanner;

public class array0011Sum1209 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[][] map = new int[100][100];
		int sumSpace[] = new int[map.length * 2 + 2];
		int testCase = 0;
		int testCaseNum;
		int rowSum;
		int colSum;
		int crossSum;
		int reverseCrossSum = 0;
		int result;

		while (testCase != 10) {
			testCase++;
			testCaseNum = scan.nextInt();
			
			//초기화
			for(int i = 0; i < sumSpace.length; i++) {
				sumSpace[i] = 0;
			}
			crossSum = reverseCrossSum = rowSum = colSum = result = 0;
			
			
			//행입력 초기화
			for(int i = 0; i < map.length ; i++) {
				for(int j = 0; j < map[i].length; j++) {
					map[j][i] = scan.nextInt();
				}
			}
			
			for(int i = 0; i < map.length; i++) {
				for(int j = 0; j < map.length; j++) {
					colSum += map[i][j];
					rowSum += map[j][i];
					if(i == j) {
						crossSum += map[i][j];
						sumSpace[200] = crossSum;
					}
					if((i+j) == 99) {
						reverseCrossSum += map[i][j];
						sumSpace[201] = reverseCrossSum;
					}
				}
				sumSpace[i] = colSum;
				sumSpace[i+100] = rowSum;
				colSum = 0;
				rowSum = 0;
			}
			
			for(int i = 0; i < sumSpace.length; i++) {
				if(sumSpace[i] > result) {
					result = sumSpace[i];
				}
			}
			System.out.println("#" + testCase + " " + result);
		}

	}
}
