package algorithm_fc.graph;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ14502 {
    // 벽을 3개 세운 뒤 바이러스가 퍼져나가게한다 그 이후 0인 위치를 구한다.

    static FastScan fc = new FastScan();
    static int N, M;
    static boolean [][] visited;
    static int [][] map;
    static int [][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
    static int wallCnt = 0;

    static int res = 0;

    static void input(){
        N = fc.nextInt();
        M = fc.nextInt();
        visited = new boolean[N][M];
        map = new int [N][M];

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                map[i][j] = fc.nextInt();

                if(map[i][j] == 1 ){
                    wallCnt++;
                }
            }
        }
    }

    // 벽만들기
    static void dfs(int wCnt){
        if(wCnt == 3 ){
            bfs();
            return;
        }

        for(int i = 0 ; i < N; i++){
            for(int j = 0; j < M; j++){
                if(map[i][j] == 0){
                    map[i][j] = 1;
                    dfs(wCnt+1);
                    map[i][j] = 0;
                }
            }
        }
    }

    // 바이러스 퍼지기 bfs
    static void bfs(){
        int virusCnt = 0;
        LinkedList<Integer> queue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = false;
                if (map[i][j] == 2) {
                    queue.add(i);
                    queue.add(j);
                    visited[i][j] = true;
                    virusCnt++;
                }
            }
        }


            while (!queue.isEmpty()) {
              int x = queue.poll();
              int y = queue.poll();

                for (int d = 0; d < 4; d++) {
                    int nx = x + dir[d][0];
                    int ny = y + dir[d][1];

                    if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                    if (visited[nx][ny]) continue;
                    if (map[nx][ny] != 0) continue;

                    queue.add(nx);
                    queue.add(ny);
                    visited[nx][ny] = true;
                    virusCnt++;
                }
            }

        res = Math.max(res, (N*M) - wallCnt - 3 - virusCnt);
    }

    public static void main(String[] args) {
        input();
        dfs(0);
        System.out.println(res);
    }

    static class FastScan{
        BufferedReader br;
        StringTokenizer st;

        public FastScan(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastScan(String name) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(name));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
