package ArrayGravity;

import java.lang.reflect.Array;

public class array0007doubleArray {
	public static void main(String[] args) {
		int array[][] = new int[100][100];

		// 행우선순회
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				array[i][j] = i + j;
			}
		}
		// 열우선순회
		for (int j = 0; j < 100; j++) {
			for (int i = 0; i < 100; i++) {
				array[i][j] = i + j;
			}
		}
		// 지그제그순회
//		for (int i = 0; i < 100; i++) {
//			for (int j = 0; j < 100; j++) {
//				array[i][j + (99 - 2 * j) * (i & 2)] = i + j;
//			}
//		}


	}
}
