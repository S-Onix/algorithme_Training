package algorithm_fc.graph;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ11724 {
    static int N,M;
    static int group_cnt;
    static boolean [] visited;
    static ArrayList<Integer>[] A;

    static FastScan fc = new FastScan();

    static void input(){
        N = fc.nextInt();
        M = fc.nextInt();

        A = new ArrayList[N+1];
        visited = new boolean[N+1];

        for(int i = 1; i <= N; i++) {
            A[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++) {
            String str = fc.nextLine();
            String nodes[] = str.split(" ");
            int node1 = Integer.parseInt(nodes[0]);
            int node2 = Integer.parseInt(nodes[1]);

            A[node1].add(node2);
            A[node2].add(node1);
        }

    }

    static void dfs(int start){
        visited[start] = true;

        for(int node : A[start]){
            if(visited[node]) continue;
            dfs(node);
        }
    }

    static void solve(){
        for(int i = 1; i <= N; i++) {
            if(!visited[i]){
                dfs(i);
                group_cnt++;
            }
        }
        System.out.println(group_cnt);
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
