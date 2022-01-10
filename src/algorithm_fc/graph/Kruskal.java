package algorithm_fc.graph;

import javax.management.MBeanAttributeInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class Kruskal {

    public HashMap<String,String>  parent = new HashMap<>();
    public HashMap<String,Integer> rank = new HashMap<>();
    /**
     * 간선의 길이가 가장 짧은 것부터 연결한다. (싸이클이 형성시 해당 간선은 제거한다.)
     * 1. 간선의 크기를 정렬한다.
     * 싸이클 구분법 : 연결된 노드를 저장하는 자료구조를 하나 구현한다.
     *
     * 싸이클 구분을 위해서 Union-Find 알고리즘을 사용해야함.
     * */

    public ArrayList<Edge> kruskal(ArrayList<String> vetices,ArrayList<Edge> graph){
        ArrayList<Edge> mst = new ArrayList<>();
        Edge currentEdge;
        String nodeV, nodeU;

        for(int i = 0; i < vetices.size(); i++) {
            this.makeSet(vetices.get(i));
        }

        Collections.sort(graph);
        for(int i = 0; i < graph.size(); i++) {
            currentEdge = graph.get(i);
            nodeV = currentEdge.nodeV;;
            nodeU = currentEdge.nodeU;;

            if(this.find(nodeV) != this.find(nodeU)){
                this.union(nodeV, nodeU);
                mst.add(currentEdge);
            }
        }

        return mst;


    }

    public String find(String node) {
        if(this.parent.get(node) != node) {
            parent.put(node, find(parent.get(node)));
        }
        return parent.get(node);
    }

    public void union(String nodeV, String nodeU) {
        String root1 = find(nodeV);
        String root2 = find(nodeU);
        // union-by-rank 기법
        if(this.rank.get(root1) > this.rank.get(root2)){
            this.parent.put(root2, root1);
        }else {
            this.parent.put(root1, root2);
            if(this.rank.get(root1) == this.rank.get(root2)){
                this.rank.put(root2, this.rank.get(root2) + 1);
            }
        }
    }

    public void makeSet(String node) {
        this.parent.put(node, node);
        this.rank.put(node, 0);
    }



    public ArrayList<Edge> initGraph(){
        ArrayList<Edge> graph = new ArrayList<>();

        graph.add(new Edge(7, "A", "B"));
        graph.add(new Edge(5, "A", "D"));
        graph.add(new Edge(7, "B", "A"));
        graph.add(new Edge(8, "B", "C"));
        graph.add(new Edge(8, "B", "D"));
        graph.add(new Edge(7, "B", "E"));
        graph.add(new Edge(8, "C", "B"));
        graph.add(new Edge(5, "C", "E"));
        graph.add(new Edge(5, "D", "A"));
        graph.add(new Edge(9, "D", "B"));
        graph.add(new Edge(7, "D", "E"));
        graph.add(new Edge(6, "D", "F"));
        graph.add(new Edge(7, "E", "B"));
        graph.add(new Edge(5, "E", "C"));
        graph.add(new Edge(7, "E", "D"));
        graph.add(new Edge(8, "E", "F"));
        graph.add(new Edge(9, "E", "G"));
        graph.add(new Edge(6, "F", "D"));
        graph.add(new Edge(8, "F", "E"));
        graph.add(new Edge(11, "F", "G"));
        graph.add(new Edge(9, "G", "E"));
        graph.add(new Edge(11, "G", "F"));

        return graph;
    }

    public static void main(String[] args) {
        Kruskal k = new Kruskal();
        ArrayList<String> vetices = new ArrayList<>(Arrays.asList("A","B","C","D","E","F","G"));
        ArrayList<Edge> graph = k.initGraph();
    }

}


// 간선으로 객체 비교를 해야하기때문에 가중치를 정렬기준으로 세움
class Edge implements Comparable<Edge>{
    public int weight;
    public String nodeV;
    public String nodeU;

    public Edge(int weight, String nodeV, String nodeU){
        this.weight = weight;
        this.nodeV = nodeV;
        this.nodeU = nodeU;
    }

    public String toString(){
        return "(" + this.weight + ", " + this.nodeV + ", " + this.nodeU+ ")";
    }

    @Override
    public int compareTo(Edge o) {
        return this.weight - o.weight;
    }
}