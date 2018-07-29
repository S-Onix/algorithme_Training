package recursion;

public class RecursionBlob {
    private static int [][] map = {
            {1,0,0,0,0,0,0,1},
            {0,1,1,0,0,1,0,0},
            {1,1,0,0,1,0,1,0},
            {0,0,0,0,0,1,0,0},
            {0,1,0,1,0,1,0,0},
            {0,1,0,1,0,1,0,0},
            {1,0,0,0,1,0,0,1},
            {0,1,1,0,0,1,1,1}
    };

    private static int BACKGROUND_COLOR = 0;
    private static int IMAGE_PIXEL = 1;
    private static int CHECK_PIXEL = 2;
    private static final int MAP_SIZE = 7;

    public static int countingCell(int x, int y){
        if(x < 0 || y < 0 || x>=MAP_SIZE || y>=MAP_SIZE)
            return 0;
        else if(map[x][y] != IMAGE_PIXEL)
            return 0;
        else{
            map[x][y] = CHECK_PIXEL;
            return 1 + countingCell(x-1,y) + countingCell(x-1,y+1)
                    + countingCell(x,y+1) + countingCell(x+1,y+1)
                    + countingCell(x+1,y) + countingCell(x+1,y)
                    + countingCell(x,y-1) + countingCell(x-1,y-1);
        }
    }

}
