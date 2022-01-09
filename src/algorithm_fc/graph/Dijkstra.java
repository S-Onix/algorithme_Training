package algorithm_fc.graph;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Dijkstra {
    /**
     * 1. 모든 노드의 가중치를 저장할 수 있는 배열을 하나 만든다(크기는 노드의 개수만큼);
     *    1-1. 배열의 값은 무한대로 초기화한다.
     * 2. 각 노드와 연결된 노드들의 arrayList를 만든다.
     * */

    public HashMap<String, Integer> dikstraFunc(HashMap<String, ArrayList<Node>> graph, String start) {
        HashMap<String, Integer> distances = new HashMap<>();
        Node edgeNode, adjacentNode;
        int currentDistance, weight, distance;
        String currentNode, adjcent;
        ArrayList<Node> nodeList;

        for(String key : graph.keySet()) {
            distances.put(key, Integer.MAX_VALUE);
        }
        distances.put(start, 0);

        PriorityQueue<Node> queue = new PriorityQueue<>();

        queue.add(new Node(start, distances.get(start)));

        while(queue.size() > 0) {
            edgeNode = queue.poll();
            currentDistance = edgeNode.distance;
            currentNode = edgeNode.vertex;

            if(currentDistance > distances.get(currentNode)){
                continue;
            }

            nodeList = graph.get(currentNode);
            for(int i = 0 ; i < nodeList.size(); i++) {
                adjacentNode = nodeList.get(i);
                adjcent = adjacentNode.vertex;
                weight = adjacentNode.distance;
                distance = weight+currentDistance;

                if(distances.get(adjcent) > distance) {
                    distances.put(adjcent, distance);
                    queue.add(new Node(adjcent, distance));
                }

            }
        }

        return distances;
    }

    public static void main(String[] args) {
        HashMap<String, ArrayList<Node>> graph = new HashMap<>();
        graph.put("A", new ArrayList<>(
                    Arrays.asList(
                            new Node("B", 8)
                            , new Node("C", 1)
                            , new Node("D", 2)
                    )
        ));
        graph.put("B", new ArrayList<>());
        graph.put("C", new ArrayList<>(
                Arrays.asList(
                        new Node("B", 5)
                        , new Node("D", 2)
                )
        ));
        graph.put("D", new ArrayList<>(
                Arrays.asList(
                        new Node("E", 3)
                        , new Node("F", 5)
                )
        ));
        graph.put("E", new ArrayList<>(
                Arrays.asList( new Node("F", 1)
                )
        ));
        graph.put("F", new ArrayList<>(
                Arrays.asList( new Node("A", 5)
                )
        ));


        Dijkstra solve = new Dijkstra();
        System.out.println(solve.dikstraFunc(graph, "A"));
        System.out.println(solve.dikstraFunc(graph, "C"));
        System.out.println(solve.dikstraFunc(graph, "D"));
        System.out.println(solve.dikstraFunc(graph, "E"));
        System.out.println(solve.dikstraFunc(graph, "F"));


    }



}


class Node implements Comparable<Node> {
    public String vertex;
    public int distance;

    public Node(String vertex, int distance) {
        this.vertex = vertex;
        this.distance = distance;
    }

    public String toString(){
        return "vertex : " + this.vertex + " / distance : " + this.distance;
    }

    @Override
    public int compareTo(Node node) {
        return this.distance - node.distance;
    }
}