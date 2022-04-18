package programmers;

import java.util.LinkedList;

public class MatrixRotate {
    static int[][]map;

    static void initMap(int rows, int cols){
        map = new int[rows+1][cols+1];
        int index = 1;
        for(int i = 1; i <=rows; i++) {
            for(int j= 1; j <= cols; j++) {
                map[i][j] = index++;
            }
        }
    }

    public int rotate(int startX, int startY, int endX, int endY, int rows, int cols) {
        int minValue = Integer.MAX_VALUE;
        LinkedList<Integer> queue = new LinkedList<>();

        //상단정보
        for(int i = startY; i <= endY; i++){
            if(minValue > map[startX][i]) minValue = map[startX][i];
            queue.add(map[startX][i]);
        }
        //오른쪽측면 정보
        for(int i = startX + 1; i <=endX; i++) {
            if(minValue > map[i][endY]) minValue = map[i][endY];
            queue.add(map[i][endY]);
        }
        //하단 정보
        for(int i = endY-1; i >= startY; i--) {
            if(minValue > map[endX][i]) minValue = map[endX][i];
            queue.add(map[endX][i]);
        }
        //왼쪽측면 정보
        for(int i = endX-1; i >= startX+1; i--){
            if(minValue >map[i][startY]) minValue = map[i][startY];
            queue.add(map[i][startY]);
        }

        //기준점 세팅
        map[startX][startY] = queue.pollLast();
        //상단세팅
        for(int i = startY+1; i <= endY; i++){
            map[startX][i] = queue.poll();
        }
        //오른쪽 측면 세팅
        for(int i = startX + 1; i <=endX; i++) {
            map[i][endY] = queue.poll();
        }
        //하단세팅
        for(int i = endY-1; i >= startY; i--){
            map[endX][i] = queue.poll();
        }
        //왼쪽측면 세팅
        for(int i = endX -1; i >= startX+1; i--) {
            map[i][startY] = queue.poll();
        }
        return minValue;
    }
    public int[] solution(int rows, int columns, int[][] queries) {
        initMap(rows,columns);
        int[] answer = new int[queries.length];
        for(int i = 0; i < queries.length; i++) {
            int startX = queries[i][0];
            int startY = queries[i][1];
            int endX = queries[i][2];
            int endY = queries[i][3];
            answer[i]= rotate(startX,startY,endX,endY,rows,columns);
        }
        return answer;
    }

    public static void main(String[] args) {
        initMap(5,5);
        System.out.println();

        MatrixRotate r = new MatrixRotate();
        r.rotate(2,2,5,4, 6, 6);
    }
}
