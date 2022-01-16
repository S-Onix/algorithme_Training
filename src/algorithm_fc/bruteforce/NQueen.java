package algorithm_fc.bruteforce;

import java.io.*;
import java.util.StringTokenizer;

public class NQueen {

    /**
     * N의 열과 행을 가진 체스판 위에 Queen을 N개 놓을 수 있는 밥법의 수를 구하는 문제
     * 1. queen이 서로 공격할 수 있는 밥법에 대한 조건
     * 2. 기존에 놓은 queen과 공격이 가능한지 여부
     * */

    static int N;
    static int ans = 0;
    static int[] col;
    static FastReader fr = new FastReader();


    static boolean isAttackable(int row1, int col1, int row2, int col2){
        if(col1 == col2) return true;
        if(row1+col1 == row2+col2) return true;
        if(row1-col1 == row2-col2) return true;
        return false;
    }

    static void input(){
        N = fr.nextInt();
        col = new int[N+1];
    }

    static void reculSolve(int row) {
        if(row == N+1) { //각 열에 queen이 하나씩 배치된 경우 (마지막 열 도달 후)
            ans++;
        }else {
            for(int c = 1; c <=N; c++) {
                boolean isPass = true;

                // 첫번째 로우부터 위치한 퀸과 현재 놓으려고하는 퀸의 위치가 서로 공격 가능한지 비교하는 로직
                for(int i = 1; i < row-1; i++) {
                    if(isAttackable(i, col[i], row, c)){
                        isPass = false;
                        break;
                    }
                }

                if(isPass) {
                    col[row] = c;
                    reculSolve(row+1);
                    col[row] = 0;
                }
            }
        }

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
