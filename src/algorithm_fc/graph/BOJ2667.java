package algorithm_fc.graph;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ2667 {

    static FastScan fc = new FastScan();
    static int N;
    static int group_cnt;
    static String map [];
    static boolean visited[][];
    static int dir[][] = {{1,0},{0,1},{-1,0},{0,-1}};
    static StringBuilder sb = new StringBuilder();
    static ArrayList<Integer> group;


    static void input(){
        N = fc.nextInt();
        map = new String [N];

        for(int y = 0 ; y < N; y++) {
            map[y] = fc.nextLine();
        }
        visited = new boolean [N][N];

    }



    static void dfs(int x, int y) {
        group_cnt++;
        visited[x][y] = true;
        for(int i = 0 ; i < 4; i++) {
            int nx = x + dir[i][0];
            int ny = y + dir[i][1];

            if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
            if(map[nx].charAt(ny) == '1' && !visited[nx][ny]){
                dfs(nx,ny);
            }
        }

    }

    static void solve(){
        group = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(!visited[i][j] && map[i].charAt(j) == 1) {
                    // 방문도 안하고 마을인 경우
                    group_cnt = 0;
                    dfs(i,j);
                    group.add(group_cnt);
                }
            }
        }
        Collections.sort(group);
        sb.append(group.size()).append('\n');
        for(int cnt : group) sb.append(cnt).append('\n');
        System.out.println(sb);


    }

    public static void main(String[] args) {
        input();
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
