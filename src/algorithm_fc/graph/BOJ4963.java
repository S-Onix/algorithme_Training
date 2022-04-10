package algorithm_fc.graph;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ4963 {
    static int W, H;
    static int [][] map;
    static boolean [][] visited;
    static int [][] dir = {{-1,1},{0,1},{1,-1},{-1,0},{1,0},{-1,-1},{0,-1},{1,-1}};
    static FastScan fc = new FastScan();

    static void input(){
        W = fc.nextInt();
        H = fc.nextInt();


        map = new int [W][H];
        visited = new boolean [W][H];

        for(int h = 0; h < H; h++) {
            for(int w = 0; w < W; w++) {
                map[h][w] = fc.nextInt();
            }
        }
    }

    static void dfs(int x, int y) {
        visited[x][y] = true;
        for(int i = 0 ; i < 8; i++) {
            int nx = x+dir[i][0];
            int ny = y+dir[i][1];

            if(nx < 0 || ny < 0 || nx >= W || ny >= H) continue;
            if(visited[nx][ny]) continue;
            if(map[nx][ny] == 0) continue;

            dfs(nx,ny);
        }
    }

    static void solve(){
        int cnt = 0;
        for(int x = 0; x < W; x++) {
            for(int y = 0; y < H; y++) {
                if(!visited[x][y] && map[x][y] == 1) {
                       cnt++;
                       dfs(x,y);
                }
            }
        }
    }

    public static void main(String[] args) {
        input();
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
