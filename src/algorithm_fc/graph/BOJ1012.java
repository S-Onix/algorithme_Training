package algorithm_fc.graph;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ1012 {

    static int T;
    static int M, N, K;
    static boolean[][] visited;
    static int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
    static ArrayList<Integer> group = new ArrayList<>();
    static int group_cnt;
    static FastScan fc = new FastScan();
    static int[][] map;

    static void initMap(){
        M = fc.nextInt();
        N = fc.nextInt();
        K = fc.nextInt();
        map = new int [M][N];
        visited = new boolean[M][N];
        for(int k = 0; k < K; k++) {
            String xy = fc.nextLine();
            String xyStr[] = xy.split(" ");
            int x = Integer.parseInt(xyStr[0]);
            int y = Integer.parseInt(xyStr[1]);

            map[x][y] = 1;
        }
    }

    static void dfs(int x, int y) {
        visited[x][y] = true;
        //4방향으로 갈수 있는지 확인하기 >> dir를 이용해서
        for(int d = 0; d < 4; d++) {
            int nx = x + dir[d][0];
            int ny = y + dir[d][1];

            if(nx < 0 || ny < 0 || nx >= M || ny >= N) continue;
            if(visited[nx][ny]) continue;
            if(map[nx][ny] == 0) continue;

            dfs(nx,ny);
        }
    }

    static void solve(){
        T = fc.nextInt();
        for(int i = 0; i < T; i++) {
           initMap();
            //탐색 시작 (시작위치 0,0)
            for(int x = 0; x < M; x++) {
                for(int y = 0; y < N; y++) {
                    if(!visited[x][y] && map[x][y] == 1) {
                        dfs(x,y);
                        group_cnt++;
                    }
                }
            }
            group.add(group_cnt);
            group_cnt = 0;
        }
        StringBuilder sb = new StringBuilder();
        for(int group_cnt : group) sb.append(group_cnt).append('\n');
        System.out.println(sb);
    }

    public static void main(String[] args) {
        solve();
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
