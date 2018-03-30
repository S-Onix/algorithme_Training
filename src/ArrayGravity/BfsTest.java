package ArrayGravity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BfsTest {
	/*
	 * 필요한 것 그래프, 각노드의 방문여부 
	 * 
	 * */
	//노드 방문여부

	
	public static void dfs(int map[][], boolean visit[], int start) {
		for(int i = 1; i<map.length; i++) {
			if(map[start][i] == 1 && visit[i] == false) {
				visit[i] = true;
				dfs(map, visit, i);
			}
		}
		
	}
	
	static void solve() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int startNode;
		int endNode;
		int result [] = new int[10];
		int map[][];
		boolean visit[];
		for(int testCase = 0; testCase < 10; testCase++) {
			//맵 설정
			map = new int[100][100];
			visit= new boolean[100];
			
			for(int i = 0; i< map.length; i++) {
				startNode = Integer.parseInt(br.readLine());
				endNode = Integer.parseInt(br.readLine());
				map[startNode][endNode] = 1;
			}
			visit[0] = true;
			dfs(map,visit,0);
			if(visit[99] == true) {
				result[testCase] = 1;
			}
		}
	}
	
	public static void main(String[] args) throws IOException{

		
	}
	 
}
