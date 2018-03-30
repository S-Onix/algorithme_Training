package ArrayGravity;

import java.util.Scanner;

public class string0014Pal {
	public static void main(String[] args){
		
		Scanner sScan= new Scanner(System.in);
		Scanner iScan = new Scanner(System.in);
		
		char map[][] = new char[8][8];
		int testCase = 0;
		int result[] = new int [10];
		int inputNum;
		
		while(testCase < 10) {
			//숫자 입력
			inputNum = iScan.nextInt();
			
			//멥 초기화
			for(int i = 0 ; i < map.length; i ++) {
				String s = sScan.nextLine();
				for(int j = 0; j < map[i].length; j++) {
					map[i][j] = s.charAt(j);
				}
			}
			
			//결과 저장
			result[testCase] = palindrome(map, inputNum);
			testCase++;
		}
		
		//결과 출력
		for(int i = 0; i < result.length; i++) {
			System.out.println("#" + (i+1) + " " + result[i]);
		}

	}

	public static int palindrome(char[][] map, int inputNum) {
		int count = 0;
		
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j <= map[i].length - inputNum ; j++) {
				
				String rowTemp1 = "";
				String colTemp1 = "";
				String rowTemp2 = "";
				String colTemp2 = "";
				
				//열검사
				for(int startA = j; startA < inputNum+j; startA++) {
					colTemp1 += map[i][startA];
					rowTemp1 += map[startA][i];
				}
				
				for(int startB = (inputNum-1)+j ; startB >=j; startB--) {
					colTemp2 += map[i][startB];
					rowTemp2 += map[startB][i];
				}
				
				if(colTemp1.equals(colTemp2)) count++;
				if(rowTemp1.equals(rowTemp2)) count++;
			}
		}
		
		return count;
	}

}
