package Graph.bfs;
import java.util.*;

public class Graph {
    private int V;
    private LinkedList<Integer> adj[];

    public Graph(int v){
        this.V = v;
        adj = new LinkedList[v];
        for(int i = 0 ; i < adj.length; i++){
            adj[i] = new LinkedList();
        }
    }

    public void addEdge(int node1, int node2){
        adj[node1].add(node2);
    }

    public void bfs(int startNode){
        boolean visited[] = new boolean[V];
        LinkedList<Integer> queue = new LinkedList<Integer>();

        visited[startNode] = true;
        queue.add(startNode);

        while(queue.size() != 0){
            int currentNode = queue.poll();
            System.out.print(currentNode + " ");

            Iterator<Integer> i = adj[currentNode].listIterator();
            while(i.hasNext()){
                int node = i.next();
                if(!visited[node]){
                    visited[node] = true;
                    queue.add(node);
                }
            }
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

        g.bfs(2);
    }
}
