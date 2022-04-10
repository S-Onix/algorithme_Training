package algorithm_fc.graph;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;


class State{
    int [] X;
    State(int[] _X){
        X = new int[3];
        for(int i = 0; i < 3; i++) X[i] = _X[i];
    }

    State move(int from, int to, int[] Limit){
        int [] nX = new int[]{X[0], X[1], X[2]};
        if(X[from] + X[to] >= Limit[to]){
            nX[from] -= Limit[to] - X[to];
            nX[to] = Limit[to];
        }else {
            nX[to] += X[from];
            nX[from] = 0;
        }

        return new State(nX);
    }
}

public class BOJ2251 {
    // 세가지 물통
    // 물통의 용량
    static int [] Limit;
    // 물통이 채워진 수
    static FastScan fc = new FastScan();
    static boolean [][][] visited;
    static boolean [] possible;

    static void input(){
        Limit = new int [3];
        for(int i = 0 ; i < 3; i++) Limit[i] = fc.nextInt();
        visited = new boolean[205][205][205];
        possible = new boolean[205];

    }

    static void bfs(int a, int b, int c){
        LinkedList<State> queue = new LinkedList<>();
        visited[a][b][c] = true;
        queue.add(new State(new int[]{a,b,c}));

        while(!queue.isEmpty()){
            State st = queue.poll();
            if(st.X[0] == 0) {
                possible[st.X[2]] = true;
            }
            for(int from = 0; from < 3; from++){
                for(int to = 0 ; to < 3; to++){
                    if(from == to) continue;
                    State nxt = st.move(from, to, Limit);
                    if(!visited[nxt.X[0]][nxt.X[1]][nxt.X[2]]) {
                        visited[nxt.X[0]][nxt.X[1]][nxt.X[2]] = true;
                        queue.add(nxt);
                    }
                }
            }
        }
    }

    static void solve(){
        StringBuilder sb = new StringBuilder();
        input();
        bfs(0,0, Limit[2]);
        for(int i = 0; i < Limit[2]; i++){
            if(possible[i]) sb.append(i).append(' ');
        }
        System.out.println(sb.toString());
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
