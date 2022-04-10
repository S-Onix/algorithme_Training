package algorithm_fc.graph;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ3184 {
    //수평과 수직으로만 이동가능
    static int [][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
    static boolean [][] visited;
    static String [][] map;
    static FastScan fc = new FastScan();
    static int R, C;
    static int sheep, wolf;
    static int totalSheep, totalWolf;

    static void input(){
        R = fc.nextInt();
        C = fc.nextInt();

        map = new String [R][C];
        visited = new boolean [R][C];

        for(int x = 0; x < R; x++) {
            String inputY = fc.nextLine();
            String [] yStr = inputY.split("");

            for(int y = 0; y < C; y++) {
                map[x][y] = yStr[y];
            }
        }
    }

    static void dfs(int x, int y) {
        visited[x][y] = true;

        if(map[x][y].equals("v")) wolf++;
        if(map[x][y].equals("o")) sheep++;

        for(int d = 0; d < 4; d++) {
            int nx = x + dir[d][0];
            int ny = y + dir[d][1];

            if(nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
            if(visited[nx][ny]) continue;
            if(map[nx][ny].equals("#")) continue;

            dfs(nx,ny);
        }

    }

    static void solve(){
        totalSheep = 0;
        totalWolf = 0;

        for(int x = 0 ; x < R; x++){
            for(int y = 0; y < C; y++) {
                if(!visited[x][y] && !map[x][y].equals("#")) {
                    dfs(x,y);
                    totalSheep += sheep;
                    totalWolf += wolf;
                    sheep = 0;
                    wolf = 0;
                }
            }
        }

        System.out.println(totalSheep + " " + totalWolf);
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
