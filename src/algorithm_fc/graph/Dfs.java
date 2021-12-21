package algorithm_fc.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Dfs {

    public void dfsSearch(String startNode){
        ArrayList<String> visitedList = new ArrayList<>();
        ArrayList<String> stackList = new ArrayList<>();

        HashMap<String, ArrayList<String>> map = this.initMap();

        stackList.add(startNode);

        while(stackList.size() > 0){
            String searchNode = stackList.remove(stackList.size()-1);
            if(!visitedList.contains(searchNode)) {
                visitedList.add(searchNode);
                stackList.addAll(map.get(searchNode));
            }
        }

        System.out.println(visitedList);

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
        Dfs test = new Dfs();
        test.dfsSearch("A");

    }
}
