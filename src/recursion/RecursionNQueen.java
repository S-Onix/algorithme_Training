package recursion;

import java.util.Scanner;

public class RecursionNQueen {

    //퀸이 위치할 각 행의 열 저장 배열
    private static int N;
    private static int col[];

    static boolean queens(int level){
        //제약조건에 걸리는 경우
        if(!promising(level))
            return false;
        else if(N==level) {
            for(int i = 1; i <=N ; i++)
                System.out.println("(" + i + ", " + col[i] + ")");
            return true;
        }

        for(int i = 1 ; i<=N; i++){
            col[level+1] = i;
            if(queens(level+1))
                return true;
        }
        return false;

    }

    static boolean promising(int level){
        for(int i = 1; i < level; i++){
            if(col[i] == col[level])
                return false;
            else if(level-i == Math.abs(col[level]-col[i])){
                return false;
            }
        }
        return true;
    }

    public static void main(String [] args){
        Scanner scan = new Scanner(System.in);
        System.out.print("N의 개수를 정해주세요 : ");
        N = scan.nextInt();
        col = new int[N+1];
        queens(0);
    }

}
