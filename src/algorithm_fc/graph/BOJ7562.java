package algorithm_fc.graph;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ7562 {

    //체스판 크기
    static int I;
    //나이트 초기 위치
    static int nx, ny;
    //나이트 최종 위치
    static int fx,fy;
    //나이트가 이동가능한 범위
    static int [][] dir = {{-2,1},{-1,2},{1,2},{2,1},{-2,-1},{-1,-2},{1,-2},{2,-1}};
    static int [][] dist;
    static boolean [][] visited;
    static FastScan fc = new FastScan();


    static void input(){
            I = fc.nextInt();
            nx = fc.nextInt();
            ny = fc.nextInt();
            fx = fc.nextInt();
            fy = fc.nextInt();

            visited = new boolean[I][I];
            dist = new int[I][I];
    }

    static void bfs(){
        for(int i = 0 ; i < I; i++){
            for(int j = 0; j < I; j++){
                dist[i][j] = 0;
            }
        }

        for(int i = 0 ; i < I; i++){
            for(int j = 0; j < I; j++){
                visited[i][j] = false;
            }
        }

        LinkedList<Integer> queue = new LinkedList<>();
        visited[nx][ny] = true;
        queue.add(nx);
        queue.add(ny);

        while(!queue.isEmpty()){
            int x = queue.poll();
            int y = queue.poll();

            for(int k = 0 ; k < 8; k++){
                int mx = x + dir[k][0];
                int my = y + dir[k][1];

                if(mx < 0 || my < 0 || mx >= I || my >= I) continue;
                if(visited[mx][my]) continue;

                queue.add(mx);
                queue.add(my);
                dist[mx][my] = dist[x][y] + 1;
                visited[mx][my] = true;
            }
        }


    }

    public static void main(String[] args) {
        int t = fc.nextInt();
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < t; i++) {
            input();
            bfs();
            sb.append(dist[fx][fy]).append('\n');
        }
        System.out.println(sb);
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
