package ArrayGravity;

import java.util.Arrays;
import java.util.Scanner;

public class array0012Ladder1210 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int testCaseNum;
		int map[][] = new int[100][100];
		int result[] = new int[10];

		for (int i = 0; i < 10; i++) {
			testCaseNum = scan.nextInt();
			for (int y = 0; y < 100; y++) {
				for (int x = 0; x < 100; x++) {
					map[y][x] = scan.nextInt();
				}
			}
			result[i] = ladder(map);
			
		}

		for (int i = 0; i < 10; i++) {
			System.out.println("#" + (i+1) + " " + result[i]);
		}

	}

	public static int ladder(int map[][]) {
		int trace[][] = new int[100][100];

		for (int x = 0; x < map[0].length; x++) {

			int y = 0;
			int mX = x;

			if (map[0][x] == 1) {
				for (int i = 0; i < trace.length; i++)
					Arrays.fill(trace[i], 0);
				trace[0][x] = 1;

				while (y < map.length - 1) {
					if (mX == 0) {
						if (map[y][mX + 1] == 1 && trace[y][mX + 1] == 0) {
							mX++;
							trace[y][mX] = 1;
							continue;
						}
					} else if (mX == map[0].length - 1) {
						if (map[y][mX - 1] == 1 && trace[y][mX - 1] == 0) {
							mX--;
							trace[y][mX] = 1;
							continue;
						}
					} else {
						if (map[y][mX + 1] == 1 && trace[y][mX + 1] == 0) {
							mX++;
							trace[y][mX] = 1;
							continue;
						} else if (map[y][mX - 1] == 1 && trace[y][mX - 1] == 0) {
							mX--;
							trace[y][mX] = 1;
							continue;
						}
					}
					y++;
					trace[y][mX] = 1;
				}
			}
			if (map[y][mX] == 2)
				return x;

		}
		return 100;
	}

}
