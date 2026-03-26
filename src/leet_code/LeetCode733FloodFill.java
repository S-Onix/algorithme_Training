package src.leet_code;

public class LeetCode733FloodFill {
    static int [] dx = {-1,1,0,0};
    static int [] dy = {0,0,-1,1};
    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        /**
         * 시작지점이 정해져 있음
         * */
        int oriColor = image[sr][sc];
        if(oriColor != color) dfs(image, sr, sc, color, oriColor);

        return image;
    }

    public static void dfs(int [][] image, int x, int y, int color, int oriColor){
        if(x < 0 || y < 0 || x >= image.length || y >= image[0].length || image[x][y] != oriColor) return;
        image[x][y] = color;

        for(int i = 0; i < dx.length; i++){
            dfs(image, x+dx[i], y+dy[i], color, oriColor);
        }
    }
}
