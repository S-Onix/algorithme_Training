package algorithm_fc.graph;

import java.io.*;
import java.util.*;

public class BOJ1260 {
    //BFS 와 DFS
    //노드가 작은순부터 탐색
    // >> 정렬필요
    //양방향
    static FastScan fc = new FastScan();
    static int N;
    static int M;
    static int V;
    static ArrayList<Integer>[] A;
    static int matrix[][];
    static boolean visited[];
    static StringBuilder sb_list = new StringBuilder();
    static StringBuilder sb_matrix = new StringBuilder();


    static void input1(){

        N = fc.nextInt();
        M = fc.nextInt();
        V = fc.nextInt();

        A = new ArrayList[N+1];
        for(int i=1; i <= N; i++) {
           A[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++) {
            int node = fc.nextInt();
            int node2 = fc.nextInt();
            A[node].add(node2);
            A[node2].add(node);
        }

        for(int i = 1; i <= N; i++) {
            Collections.sort(A[i]);
        }
    }

    static void input2(){
        N = fc.nextInt();
        M = fc.nextInt();
        V = fc.nextInt();

        matrix = new int [N+1][N+1];
        for(int i = 1; i<= M; i++) {
            int node = fc.nextInt();
            int node2 = fc.nextInt();
            matrix[node][node2] = 1;
            matrix[node2][node] = 1;
        }

    }

    static void solve(){
        visited = new boolean[N+1];
        DFS_List(V);
        for(int i = 1; i <= N; i++) visited[i] = false;
        BFS_List(V);
        for(int i = 1; i <= N; i++) visited[i] = false;
        DFS_Matrix(V);
        for(int i = 1; i <= N; i++) visited[i] = false;
        BFS_Matrix(V);
    }


    //BFS는 너비우선 탐색 queue방식으로(정방향)
    static void BFS_List(int start) {
        LinkedList<Integer> queue = new LinkedList<>();
        visited[start]= true;
        queue.add(start);

        while(!queue.isEmpty()) {
            int currentNode = queue.poll();
            sb_list.append(currentNode).append(' ');
            for(int x : A[currentNode]) {
                if(visited[x]) continue;
                queue.add(x);
                visited[x] = true;
            }
        }
    }

    //DFS는 깊이우선 탐색 stack방식으로 (따라서 stack에 쌓을때에는 반대로 쌓아야함);
    static void DFS_List(int start) {
        visited[start] = true;
        sb_list.append(start).append(' ');

        for(int x : A[start]) {
            if(visited[x]) continue;
            DFS_List(x);
        }
    }

    //BFS는 너비우선 탐색 queue방식으로(정방향)
    static void BFS_Matrix(int start) {
        LinkedList<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.add(start);

        while(!queue.isEmpty()) {
            int node = queue.poll();
            sb_matrix.append(node).append(' ');

            for(int i = 1; i <= N; i++) {
                if(matrix[node][i] == 0) continue;
                if(visited[i]) continue;

                queue.add(i);
                visited[i] = true;
            }
        }
    }

    //DFS는 깊이우선 탐색 stack방식으로 (따라서 stack에 쌓을때에는 반대로 쌓아야함);
    static void DFS_Matrix(int start) {
        visited[start] = true;
        sb_matrix.append(start).append(' ');

        for(int i = 1; i <= N; i++) {
            if(matrix[start][i] == 0) continue;
            if(visited[i]) continue;

            DFS_Matrix(i);
        }
    }

    public static void main(String[] args) {

        input1();
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
