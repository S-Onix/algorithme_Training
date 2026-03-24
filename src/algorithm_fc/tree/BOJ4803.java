package src.algorithm_fc.tree;

import java.util.ArrayList;

public class BOJ4803 {
    /* 점검사항
    1. 사이클을 형성하는가
    2. 정점 N / 간선 N-1인가
    */
    static int nodeCnt;
    static int edgeCnt;
    static FastScan fc = new FastScan();
    static ArrayList<Integer>[] adj;
    static boolean [] visited;

    static boolean input(){
        nodeCnt = fc.nextInt();
        edgeCnt = fc.nextInt();
        adj = new ArrayList[nodeCnt+1];
        visited = new boolean[nodeCnt+1];

        if(nodeCnt == 0 && edgeCnt == 0) {
            return false;
        }else{
            for(int i = 1; i <= nodeCnt; i++){
                adj[i] = new ArrayList<>();
            }

            for(int i = 0 ; i < edgeCnt; i++){
                int node1 = fc.nextInt();
                int node2 = fc.nextInt();
                adj[node1].add(node2);
                adj[node2].add(node1);
            }
            return true;
        }
    }

    public static boolean dfs(int root, int x){
        visited[x] = true;
        for(int y : adj[x]){
            if(root == x) continue;
            if(visited[y]) return false;
            visited[y] = true;
            if(!dfs(x, y)) return false;
        }
        return true;
    }

    public static void solve(){
        StringBuilder sb = new StringBuilder();
        int treeCnt = 0;
        int caseCnt = 1;
        while(input()){
            for(int i = 1; i <= nodeCnt; i++){
                if(visited[i]) continue;
                if(dfs(-1, i)) treeCnt++;
            }


            sb.append("Case ").append(caseCnt).append(" : ");
            if(treeCnt == 1) {
                sb.append("There is one tree.").append("\n");
            }else if (treeCnt == 0) {
                sb.append("No trees.").append("\n");
            }else {
                sb.append("A forest of ").append(treeCnt).append(" trees").append("\n");
            }
            caseCnt++;
        }

        System.out.println(sb);
    }
}
