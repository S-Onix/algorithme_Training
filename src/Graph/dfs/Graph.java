package Graph.dfs;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * 그래프의 DFS
 * */
public class Graph {
    private int V;
    private LinkedList<Integer> adj[];

    public Graph(int V){
        this.V = V;
        adj = new LinkedList[V];
        for(int i = 0 ; i < adj.length; i++){
            adj[i] = new LinkedList();
        }
    }

    public void addEdge(int node1, int node2){
        adj[node1].add(node2);
    }

    public void dfs(int node){
        boolean visited[] = new boolean[V];
        LinkedList<Integer> stack = new LinkedList<Integer>();

        visited[node] = true;
        stack.push(node);

        while(stack.size() != 0){
                 int currentNode = stack.pop();
                 Iterator<Integer> i = adj[currentNode].listIterator();

                 while(i.hasNext()){
                     int n = i.next();
                     if(!visited[n]){
                        visited[n] = true;
                        stack.push(n);
                     }
                 }
            System.out.print(currentNode + " ");
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(5);
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(1,2);
        g.addEdge(2,0);
        g.addEdge(2,3);
        g.addEdge(3,3);
        g.addEdge(1,4);

        g.dfs(2);
    }

}
