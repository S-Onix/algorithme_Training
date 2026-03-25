package src.leet_code;

public class LeetCode200NumberOfIslands {
    int [] dx = {-1, 1, 0, 0};
    int [] dy = {0, 0, -1, 1};

    public int numIslands(char[][] grid) {
        /**
         * 0,0에서 시작해서 1인 위치 검색
         * 찾은 1의 위치에서 상하좌우에 1이 있는지 확인
         * 1이 있다면 다시 그 1을 중심으로 상하좌우 확인
         * 반복하다가 0을 만나면 섬의 섹션 종료
         * */

        int result = 0;

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1') {
                    result++;
                    dfs(grid,i,j);
                }
            }
        }

        return result;
    }

    private void dfs(char[][] grid, int x, int y) {
       if(x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == '0') {
           return;
       }

       grid[x][y] = '0';
       for(int k = 0; k < 4; k++) {
           dfs(grid,x+dx[k],y+dy[k]);
       }
    }
}
