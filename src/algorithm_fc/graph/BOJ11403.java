package algorithm_fc.graph;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ11403 {
    //방향 그래프
    static int N;
    static ArrayList<Integer>[] A;
    static FastScan fc = new FastScan();
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    static void input(){
        N = fc.nextInt();

        for(int i = 0 ; i < N; i++){
            A[i] = new ArrayList<>();
        }

        visited = new boolean[N];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++){
                int isLink = fc.nextInt();
                if(isLink == 1) {
                    A[i].add(j);
                }
            }
        }
    }

    static void solve(){
        for(int i = 0; i < N; i++) {
            bfs(i);
        }
        System.out.println(sb);
    }

    static void bfs(int start) {
        for(int i = 0; i < N; i++){
            visited[i] = false;
        }
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(start);


        while(!queue.isEmpty()){
            int currentNode = queue.poll();
            for(int node : A[currentNode] ){
                if(visited[node]) continue;
                queue.add(node);
                visited[node] = true;
            }
        }

        for(int i = 0; i < N; i++){
            sb.append(visited[i] ? 1 : 0).append(' ');
        }
        sb.append('\n');

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
