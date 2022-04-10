package algorithm_fc.graph;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ2178 {
    static int N;
    static int M;
    static String []map;
    static boolean [][] visited;
    static int [][] dist;
    static int [][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
    static FastScan fc = new FastScan();

    static void input(){
        N = fc.nextInt();
        M = fc.nextInt();

        map = new String[N];
        visited = new boolean [N][M];
        dist = new int[N][M];

        for(int i = 0 ; i < N; i++){
            map[i] = fc.nextLine();
        }

    }

    static void bfs(int sX, int sY){
        // 0,0 애서 지작하여 N-1, M-1 에 도착하는 최소의 거리를 구하시오
        LinkedList<Integer> queue = new LinkedList<>();
        visited[sX][sY] = true;
        dist[sX][sY] = 1;
        queue.add(sX);
        queue.add(sY);

        while(!queue.isEmpty()){
            int x = queue.poll();
            int y = queue.poll();

            for(int d = 0 ; d < 4; d++){
                int nx = x + dir[d][0];
                int ny = y + dir[d][1];

                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if(visited[nx][ny]) continue;
                if(map[nx].charAt(ny) == '0') continue;

                visited[nx][ny] = true;
                dist[nx][ny] = dist[x][y] + 1;

                queue.add(nx);
                queue.add(ny);
            }
        }
    }

    public static void main(String[] args) {
        input();
        bfs(0,0);
        System.out.println(dist[N-1][M-1]);
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
