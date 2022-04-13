package algorithm_fc.graph;

import java.util.LinkedList;

public class GameMinDIstance {
    public int solution(int[][] maps) {
        int [][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
        int [][] distance = new int[maps.length][maps[0].length];

        LinkedList<Integer> queue = new LinkedList<>();

        for(int i = 0 ; i < maps.length; i++){
            for(int j = 0 ; j < maps[0].length; j++) {
                distance[i][j] = -1;
            }
        }

        queue.add(0);
        queue.add(0);
        distance[0][0] = 1;

        while(!queue.isEmpty()) {
            int x = queue.poll();
            int y = queue.poll();

            for(int d = 0; d< 4; d++) {
                int nx = x + dir[d][0];
                int ny = y + dir[d][1];

                if(nx < 0 || ny < 0 || nx >= maps.length || ny >= maps[0].length) continue;
                if(maps[nx][ny] == 0) continue;
                if(distance[nx][ny] != -1) continue;

                distance[nx][ny] = distance[x][y] + 1;
                queue.add(nx);
                queue.add(ny);
            }
        }


        if(distance[maps.length-1][maps[0].length-1] == -1) {
            return -1;
        }else {
            return distance[maps.length-1][maps[0].length-1];
        }
    }

    public static void main(String[] args) {
        GameMinDIstance s = new GameMinDIstance();

        int [][] map = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
        System.out.println(s.solution(map));
    }
}
