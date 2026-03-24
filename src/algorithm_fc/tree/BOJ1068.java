package src.algorithm_fc.tree;

import java.util.ArrayList;

public class BOJ1068 {
    static FastScan fc = new FastScan();
    static int N;
    static ArrayList<Integer> [] child;
    static int [] leaf;
    static int erased;
    static int root;


    /*
    * 입력 : 노드 개수
    * 0~N-1 노드의 부모 입력
    * 제거할 노드 숫자 입력
    * */

    public static void input(){
        N = fc.nextInt();
        child = new ArrayList[N];
        leaf = new int[N];

        for(int i = 0 ; i < N; i++) {
            child[i] = new ArrayList<>();
        }

        for(int i = 0 ; i < N; i++){
            int parent = fc.nextInt();
            if(parent == -1){
                root = i;
                continue;
            }
            child[parent].add(i);
        }

        erased = fc.nextInt();
    }

    static void dfs(int x) {
        //가장 작은 단위부터 코딩
        if(child[x].isEmpty()){
            leaf[x] = 1;
        }

        for(int y : child[x]){
            dfs(y);
            //dp
            leaf[x] += leaf[y];
        }
    }

    public void solve(){
        for(int i = 0 ; i < N; i++){
            if(child[i].contains(erased)){
                child[i].remove(child[i].indexOf(erased));
            }
        }

        if(root != erased) dfs(root);
        System.out.println(leaf[root]);
    }

    public static void main(String[] args) {

    }

}
