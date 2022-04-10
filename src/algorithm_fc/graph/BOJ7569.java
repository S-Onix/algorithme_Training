package algorithm_fc.graph;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ7569 {

    static int M, N;
    static int [][] map;
    static boolean [][] visited;
    static int [][] distance;
    static int [][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
    static LinkedList<Integer> queue = new LinkedList<>();

    static FastScan fc = new FastScan();

    static void input(){
        M = fc.nextInt();
        N = fc.nextInt();

        visited = new boolean[M][N];
        distance = new int[M][N];

        for (int i = 0; i < M; i++){
            for(int j = 0 ; j < N; j++){
                visited[i][j] = false;
                map[i][j] = fc.nextInt();
                if(map[i][j] == 1) {
                    queue.add(i);
                    queue.add(j);
                    visited[i][j] = true;
                    distance[i][j] = 0;
                }else if(map[i][j] == -1) {
                    distance[i][j] = 0;
                }else {
                    distance[i][j] = -1;
                }
            }
        }
    }

    static void bfs(){
        while(!queue.isEmpty()){
            int x = queue.poll();
            int y = queue.poll();

            for(int d = 0; d < 4; d++){
                int nx = x + dir[d][0];
                int ny = y + dir[d][1];

                if(nx < 0 || ny < 0|| nx >= M || ny >= N) continue;
                if(visited[nx][ny]) continue;

                distance[nx][ny] = distance[x][y] + 1;
                queue.add(nx);
                queue.add(ny);
                visited[nx][ny] = true;
            }
        }

        int max = 0;
        int result = 0;

        for(int i = 0; i < M; i++){
            for(int j = 0; j < N; j++){
                if(distance[i][j] == -1) {
                    result = -1;
                    break;
                }else {
                    max = Math.max(max,distance[i][j]);
                }
            }
        }

        if(result != -1){
            result = max;
        }

        System.out.println(result);
    }

    static void solve(){
        bfs();
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
