package recursion;

public class RecursionMaze {

    private static int N = 8;
    private static int [][] maze = {
            {0,0,0,0,0,0,0,1}, //x좌표 0
            {0,1,1,0,1,1,0,1}, //x좌표 1
            {0,0,0,1,0,0,0,1}, //x좌표 2
            {0,1,0,0,1,1,0,0}, //x좌표 3
            {0,1,1,1,0,0,1,1}, //x좌표 4
            {0,1,0,0,0,1,0,1}, //x좌표 5
            {0,0,0,1,0,0,0,1}, //x좌표 6
            {0,1,1,1,0,1,0,0}  //x좌표 7
    };

    private static final int PATHWAY_COLOR = 0;
    private static final int WALL_COLOR = 1;
    private static final int BLOCKED_COLOR = 2;
    private static final int PATH_COLOR = 3;



    public static boolean findMazePath(int x, int y){
        //미로의 바깥 범위인 경우
        if(x < 0 || y < 0 || x >= N || y >= N)
            return false;
        else if (maze[x][y] != PATHWAY_COLOR)
            return false;
        else if(x==N-1 && y==N-1){
            maze[x][y] = PATH_COLOR;
            return true;
        }else{
            maze[x][y] = PATH_COLOR;
            //북동남서 방향으로 검색
            if(findMazePath(x-1, y) || findMazePath(x, y+1) || findMazePath(x+1, y)|| findMazePath(x,y-1))
                return true;
            //출구까지 가는 경로가 없을 경우
            maze[x][y] = BLOCKED_COLOR;
            return false;
        }
    }

    public static void main(String [] args){
        findMazePath(0,0);

    }
}
