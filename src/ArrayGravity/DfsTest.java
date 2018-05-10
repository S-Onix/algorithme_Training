package ArrayGravity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class DfsTest {
	/*
	 * 필요한 것 그래프, 각노드의 방문여부 
	 * 
	 * */
	//노드 방문여부

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner scan = new Scanner(System.in);
		int result;
		int start, end;
		int itc, way;
		DfsTest test = new DfsTest();
		for(int tc = 0; tc < 10; tc++) {
			
			itc = scan.nextInt();
			way = scan.nextInt();
		//맵 초기화
			int map[][] = new int[100][100];
			boolean visited[] = new boolean[100];
			for(int i = 0; i< way; i++) {
				start = scan.nextInt();
				end = scan.nextInt();
				map[start][end] = 1;
			}
			
			visited[0] = true;
			test.dfs(map, visited, 0);
			
			if(visited[99] == true) {
				result = 1;
			}else result = 0;
			
			
			
			System.out.println("#" + (tc+1) + " " + result);
		}
		
	}
	
	public void dfs(int map[][], boolean visited[], int startPoint) {
		for(int i = 1; i < map.length; i++) {
			if(map[startPoint][i] == 1 && visited[i] == false) {
				visited[i] = true;
				dfs(map, visited, i);
			}
		}
	}
	 
}
