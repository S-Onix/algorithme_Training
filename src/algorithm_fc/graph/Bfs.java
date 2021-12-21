package algorithm_fc.graph;

import java.util.*;

/**
 * 1. 그래프를 구성해야한다.
 *   - HashMap으로 구성한다.
 *
 * 그래프의 종류에 따라 Node의 구성이 달라진다.
 *
 * 무방향 그래프
 *   - 보통 연결된 표시를 (A,B) (B,A) 등으로 표시됨
 * 방향 그래프
 *
 * 가중치 그래프
 *   - edge에 비용이 있어서 가중치가 적용되는 그래프
 *
 * 연결 그래프
 *    - 모든 노드가 연결되어 있는경우
 * 비연결 그래프
 *    - 연결되어 있지 않는 노드가 존재하는 경우
 * 완전 그래프
 *    - 모든 노드가 서로 연결되어있는 그래프
 *
 *
 * */

public class Bfs {

    public void dfs(String startNode){
        HashMap<String, ArrayList<String>> map = this.initMap();
        ArrayList<String> needVisited = new ArrayList<>();
        ArrayList<String> searchOrder = new ArrayList<>();

        needVisited.add(startNode);

        while(needVisited.size() > 0){
            String node = needVisited.remove(0);

            if(!searchOrder.contains(node)){
                searchOrder.add(node);
                needVisited.addAll(map.get(node));
            }
        }

        System.out.println(searchOrder);
    }

    public boolean isVisited(HashMap<String, String> visitedNodeMap, String node){
        if(visitedNodeMap.get(node) != null) {
            visitedNodeMap.put(node, "true");
            return false;
        }else {
            return true;
        }
    }

    public HashMap<String, ArrayList<String>> initMap(){
        HashMap<String, ArrayList<String>> map = new HashMap<>();

        map.put("A", new ArrayList<>(Arrays.asList("B","C")));
        map.put("B", new ArrayList<>(Arrays.asList("A","D")));
        map.put("C", new ArrayList<>(Arrays.asList("A","G","H","I")));
        map.put("D", new ArrayList<>(Arrays.asList("B","E", "F")));
        map.put("E", new ArrayList<>(Arrays.asList("D")));
        map.put("F", new ArrayList<>(Arrays.asList("D")));
        map.put("G", new ArrayList<>(Arrays.asList("C")));
        map.put("H", new ArrayList<>(Arrays.asList("C")));
        map.put("I", new ArrayList<>(Arrays.asList("J","C")));
        map.put("J", new ArrayList<>(Arrays.asList("I")));

        return map;
    }

    public static void main(String[] args) {
        Bfs test = new Bfs();
        test.dfs("A");
        test.dfs("B");
        test.dfs("C");
        test.dfs("D");
        test.dfs("E");
        test.dfs("F");
        test.dfs("H");





    }

}
