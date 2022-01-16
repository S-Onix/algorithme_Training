package algorithm_fc.bruteforce;

import java.io.*;
import java.util.StringTokenizer;

public class Boj9663 {
    /**
     * N Queen 문제
     *
     * 검사조건을 통과하면 x좌표 혹은 y좌표 를 더하여 재귀반복한다.
     * */
    static int N;
    static int[] col; // col[index] = col >> index 열의 행의 위치는 col 이다.
    static int ans = 0;
    static FastReader fr = new FastReader();

    static void input(){
        N = fr.nextInt();
        col = new int[N+1];
    }

    static boolean attackable(int standRow, int standCol, int row, int col){
        if(standCol == col ) return true;
        if( (standRow + standCol) == (row + col)) return true;
        if((standRow - standCol) == (row - col)) return true;
        return false;
    }


    static void reculSolve(int row) {
        if(row == N+1) {
            ans++;
        }else {
            for(int c = 1; c<= N; c++){
                boolean isPossible = true;

                //기존에 놓인 queen들과 공격이 가능한지 비교하기 위해서 for루프를 돌리는거임
                for(int i = 1; i <= row-1; i++) {
                    if(attackable(row, c, i, col[i])){
                        isPossible = false;
                        break;
                    }
                }
                if(isPossible) {
                    col[row] = c;
                    reculSolve(row + 1);
                    col[row] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        input();
        reculSolve(1);
        System.out.println(ans);
    }


    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
