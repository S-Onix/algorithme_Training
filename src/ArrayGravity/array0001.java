package ArrayGravity;

import java.util.Scanner;

/*
 * 정혹성 : 얼마나 정확히 동작하는가?
 * 작업성 : 얼마나 적은 연산으로 결과를 얻어내는가?
 * 메모리사용량 : 얼마나 적은 메모리를 사용하는가?
 * 단순성 : 얼마나 단순한가?
 * 최적성 : 더 개선할 점이 없는가?
 * 
 * 알고리즘에 따라 성능이 결정됨
 * 
 * 시간복잡도(Time Complexity) : 실행되는 명령문의 개수를 계산
 * 
 * */

public class array0001 {

	public static int[] sort(int input[]) {
		int minValue;

		for (int i = 0; i < input.length; i++) {
			for (int j = i + 1; j < input.length; j++) {
				minValue = input[j];
				if (minValue > input[j]) {
					minValue = input[j];
				}
				if (input[i] > minValue) {
					input[j] = input[i];
					input[i] = minValue;
				}
			}
		}

		return input;
	}

	public static boolean isBaby(int input[]) {
		
		int tmp[] = new int[input.length];
		for(int i = 0; i < tmp.length; i++) {
			tmp[i] = input[i];
		}
		
		for (int i = 0; i < tmp.length - 2; i++) {
			for (int j = i + 1; j < tmp.length - 1; j++) {
				for (int k = j + 1; k < tmp.length; k++) {
					if (tmp[i] == tmp[j] && tmp[j] == tmp[k]
							|| tmp[i] + 1 == tmp[j] && tmp[j] + 1 == tmp[k]) {
						tmp[i] = tmp[j] = tmp[k] = -1;
						for (int a = 0; a < tmp.length - 2; a++) {
							if (tmp[a] > 0) {
								for (int b = a + 1; b < tmp.length - 1; b++) {
									if (tmp[b] > 0) {
										for (int c = b + 1; c < tmp.length; c++) {
											if (tmp[c] > 0) {
												if (tmp[a] == tmp[b] && tmp[b] == tmp[c]
														|| tmp[a] + 1 == tmp[b] && tmp[b] + 1 == tmp[c])
													return true;
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {

		// 완전 탐색 (Exhaustive Search)
		// 경우의 수가 상대적으로 적을 때
		// 수행속도는 느리지만 해답을 못찾을 확률은 적음

		Scanner scan = new Scanner(System.in);
		int input[] = new int[6];

		for (int i = 0; i < input.length; i++) {
			input[i] = scan.nextInt();
		}
		input = sort(input);

		for (int i = 0; i < input.length; i++) {
			System.out.print(input[i]);
		}
		System.out.println();

		System.out.println(isBaby(input));

	}
}
