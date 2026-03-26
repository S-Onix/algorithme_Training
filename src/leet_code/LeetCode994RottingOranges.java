package src.leet_code;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode994RottingOranges {
    Queue<int[]> queue = new LinkedList<>();
    int freshCount = 0;
    int [] dx = {-1, 1, 0, 0};
    int [] dy = {0, 0, -1, 1};

    public int orangesRotting(int[][] grid) {
        /**
         * 썩은 오랜지가 있으면 주변 오렌지도 썩게된다.
         * 2는 1에만 영향을 줄 수 있다.
         * 전체가 2 또는 0 이 되는 시점이 끝나는 시점이다.
         *
         * 1. 썩은 오랜지의 위치가 시작 지점이라고 생각해야함
         *    - 여러 장소일 수 있음
         * 2. 썩은 오렌지 주변이 다시 시작지점이 됨
         * 3. 썩은 오렌지 주변이 0 또는 저누 2일 경우 탐색 종료
         * */

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                }else if (grid[i][j] == 1){
                    freshCount++;
                }
            }
        }

        if(freshCount == 0){
            return 0;
        }

        int count = 0;
        while(!queue.isEmpty()){
            int loop = queue.size();
            for(int i = 0 ; i < loop; i++){
                int [] point = queue.poll();
                bfs(grid, point[0], point[1]);
            }

            if(!queue.isEmpty()){
                count++;
            }
        }

        return freshCount == 0 ? count : -1;
    }

    public void bfs(int[][] grid, int x, int y) {
        if(x < 0 || y < 0 || x >= grid.length || y >= grid[0].length) return;

        for (int i =0; i < dx.length; i++) {
            if(x+dx[i] < 0 || y+dy[i] < 0 || x+dx[i] >= grid.length || y+dy[i] >= grid[0].length || grid[x+dx[i]][y+dy[i]] == 2 || grid[x+dx[i]][y+dy[i]] == 0) continue;
            grid[x+dx[i]][y+dy[i]] = 2;
            freshCount--;
            queue.add(new int[]{x+dx[i], y+dy[i]});
        }
    }
}
