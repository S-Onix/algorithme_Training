package ArrayGravity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution1218{
	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int result[] = new int[10];
		for (int testCase = 0; testCase < 10; testCase++) {
			int length = Integer.parseInt(br.readLine());
			char[] array = new char[length];
			array = br.readLine().toCharArray();
			int[] count = new int[8];
			
			for (int i = 0; i < array.length; i++) {
				switch (array[i]) {
				case '(':
					count[0]++;
					break;
				case ')':
					count[1]++;
					break;
				case '[':
					count[2]++;
					break;
				case ']':
					count[3]++;
					break;
				case '{':
					count[4]++;
					break;
				case '}':
					count[5]++;
					break;
				case '<':
					count[6]++;
					break;
				case '>':
					count[7]++;
					break;
				}
			}
			if (count[0] == count[1] && count[2] == count[3] && count[4] == count[5] && count[6] == count[7])
				result[testCase] = 1;
			else
				result[testCase] = 0;

		}
		for (int i = 0; i < 10; i++) {
			System.out.println("#" + (i + 1) + " " + result[i]);
		}
	}
}

