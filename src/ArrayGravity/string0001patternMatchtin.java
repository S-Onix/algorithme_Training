package ArrayGravity;

import java.util.Scanner;

public class string0001patternMatchtin {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int i = 0;
		int testCase;
		int result[] = new int[10];
		int num = 0;
		String searchText, textCase;
		while (i < 10) {

			scan.nextLine();
			searchText = scan.nextLine();
			textCase = scan.nextLine();
			result[i] = patternMatching(searchText, textCase);
			i++;
		}
		for (int k = 0; k < result.length; k++) {
			System.out.println("#" + (k + 1) + " " + result[k]);
		}
	}

	public static int patternMatching(String pattern, String text) {
		int count = 0;
		String temp;
		for (int i = 0; i < text.length() - pattern.length(); i++) {
			if (pattern.charAt(0) == text.charAt(i)) {
				// 처음이 같다면 문자의 끝까지 검사
				temp = text.substring(i, i + pattern.length());
				if (temp.equals(pattern)) {
					count++;
				}
			}
		}

		return count;
	}
}
