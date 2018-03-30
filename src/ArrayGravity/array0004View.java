package ArrayGravity;

import java.util.Scanner;

public class array0004View {

	public static void main(String[] args) {

		int loopCount = 0;
		int viewCount, width;
		int apt[];
		Scanner scan = new Scanner(System.in);
		int map[][] = new int[1000][1000];
		while(loopCount < 10) {
			viewCount = 0;
			width = scan.nextInt();
			apt = new int[width];
			
			//초기화작업
			for(int i = 0; i < apt.length; i++) {
				apt[i] = scan.nextInt();
			}
			for(int i = 0; i < width; i++) {
				for(int j = 0; j < apt[i]; j++) {
					map[i][j] = 1;
				}
			}
			

			//첫번째 조건만 있을경우  0 0 0 1 0 이어도 성립되므로 안됨
			for(int i = 2; i< (width-2) ; i++) {
				for(int j = 0; j < map[i].length; j++) {
					if(map[i-2][j] + map[i-1][j] + map[i][j] + map[i+1][j] + map[i+2][j] == 1 && map[i][j] == 1)
						viewCount += 1;
				}
			}
			
			
			for(int i = 0; i < map.length; i++) {
				for(int j = 0; j < map[i].length; j++) {
					map[i][j] = 0;
				}
			}
			loopCount++;
			

			System.out.println("#" + (loopCount + 1) + " " + viewCount);
		}

	}

	/*
	 * //main 메소드 public static void main (String[] args) { Scanner sc = new
	 * Scanner(System.in); int t; int[] apt; for(int i=1; i<=10; i++) { //테스트 케이스
	 * (10개) t = sc.nextInt(); apt = new int[t]; for(int j=0; j<apt.length; j++)
	 * apt[j] = sc.nextInt(); view(apt, i); } }
	 * 
	 * //조망권 판단 및 세대수 출력 public static void view(int[] apt, int t) { int result = 0;
	 * 
	 * for(int i=2; i<apt.length-2; i++) { int[] view = {apt[i-2], apt[i-1], apt[i],
	 * apt[i+1], apt[i+2]}; if(view[2]-view[1] < 0) continue; if(view[2]-view[0] <
	 * 0) continue; if(view[2]-view[3] < 0) continue; if(view[2]-view[4] < 0)
	 * continue; int[] view_check = {view[2]-view[1],view[2]-view[0],
	 * view[2]-view[3],view[2]-view[4]}; result += sort(view_check); }
	 * 
	 * System.out.println("#"+t+" "+result);
	 * 
	 * }
	 * 
	 * //view_check 에서 최소값(조망권 확보 세대수) 반환! public static int sort(int[] view_check)
	 * {
	 * 
	 * int min_idx = 0; int i; for(i=1; i<view_check.length; i++) {
	 * if(view_check[min_idx]>view_check[i]) min_idx = i; }
	 * 
	 * return view_check[min_idx]; }
	 */



}
