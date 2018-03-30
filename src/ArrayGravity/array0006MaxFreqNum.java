package ArrayGravity;

import java.util.Arrays;
import java.util.Scanner;

/*
 * Greedy Algorithm : 여러 경우 중 하나를 결정해야 할때마다 그 순간에 최적이라고 생각되는 것을 선택해 나가는 방식 // 단 최종적인 답을 얻었다고 최적이라는 보장은 없음
 * 
 *  현재 상태에서 부분 문제의 최적 해를 구한 후 부분해 집합을 추가함
 *  새로운 부분 해 집합이 실행 가능한지 확인 후 문제의 제약조건을 검사함
 *  새로운 부분 해집합이 문제의 해가 되는지를 확인 후 전체 문제의 해가 완성되지 않았다면 다시 1의 해부터시 시작
 *  
 *  
 *  
 *  
 * */
public class array0006MaxFreqNum {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int testCase = 10;
		int count = 0;
		int maxData;
		int maxMode;
		int modeIndex;
		int result;
		int inputData[] = new int [1000];
		int dataCount[];
		
		
		while (testCase > count) {
			maxData = 0;
			maxMode = 0;
			result = 0;
			modeIndex = 0;
			
			//데이터 입력 + 데이터의 가장 큰값 max에 저장
			for(int i = 0; i < inputData.length; i++) {
				inputData[i] = scan.nextInt();
				if(inputData[i] > maxData) {
					maxData = inputData[i];
				}
			}
			
			dataCount = new int[maxData+1];
			Arrays.fill(dataCount, 0);
			
			for(int i = 0; i < inputData.length; i++) {
				dataCount[inputData[i]]++;
			}
			
			//최빈값 찾기
			for(int i = 0; i < dataCount.length; i++) {
				if(dataCount[i] > maxMode) {
					maxMode = dataCount[i];
					modeIndex = i;
					result = maxMode;
				}
				if (dataCount[modeIndex] == dataCount[i]) {
					result = i;
				}
			}
			count++;
			System.out.println("#" + count + " " + result);
		}
	}
}
