package algorithm_fc.bruteforce;

import java.io.*;
import java.util.StringTokenizer;

public class Boj15651 {

    /**
     * 중복여부 / 순서여부
     * 1. 중복 허용 + 순서 x
     * 2. 중복 허용 + 순서 O (오름차순)
     * 3. 중복 x + 순서 x
     * 4. 중복 x + 순서 O (내림차순)
     * */

    static StringBuilder sb1 = new StringBuilder();
    static StringBuilder sb2_1 = new StringBuilder();
    static StringBuilder sb2_2 = new StringBuilder();
    static StringBuilder sb3 = new StringBuilder();
    static StringBuilder sb4 = new StringBuilder();

    static int N, M;
    static int[] selected1, selected2_1, selected2_2, selected3, selected4;
    static boolean[] used;


    static void input(){
        FastReader fs = new FastReader();
        N = fs.nextInt();
        M = fs.nextInt();
        selected1 = new int[M+1];
        selected2_1 = new int[M+1];
        selected2_2 = new int[M+1];
        selected3 = new int[M+1];
        selected4 = new int[M+1];
        used = new boolean[N+1];
    }

    /**
     * 중복 숫자를 허용하면서 정렬이 없는 경우
     * */
   static void reculSolve1(int k) {

        if(k == M+1) /* 모든 자리에 값 세팅 이후 */ {
            for(int i = 1 ; i < selected1.length; i++)
                sb1.append(selected1[i]).append(' ');
            sb1.append('\n');
        }else {
            for(int cand = 1; cand <= N; cand++) {
                selected1[k] = cand;
                reculSolve1(k+1);
            }
        }
   }

   /**
    * 중복 숫자를 허용하면서 정렬순서가 있는 경우
    * */
    static void reculSolve2_1(int k) {
        //오름차순
        if(k == M+1) /* 모든 자리에 값 세팅 이후 */ {
            for(int i = 1 ; i < selected2_1.length; i++)
                sb2_1.append(selected2_1[i]).append(' ');
            sb2_1.append('\n');
        }else {
            int start = selected2_1[k-1];
            if(start == 0) start = 1;
            for(int cand = start; cand <= N; cand++) {
                selected2_1[k] = cand;
                reculSolve2_1(k+1);
                selected2_1[k] = 0;
            }
        }
    }

    static void reculSolve2_2(int k) {
        //내림차순
        if(k == M+1) /* 모든 자리에 값 세팅 이후 */ {
            for(int i = 1 ; i < selected2_2.length; i++)
                sb2_2.append(selected2_2[i]).append(' ');
            sb2_2.append('\n');
        }else {
            int start = selected2_2[k-1];
            if(start == 0)  start = N;
            for(int cand = start; cand >= 1; cand--) {
                selected2_2[k] = cand;
                reculSolve2_2(k+1);
                selected2_2[k] = selected2_2[k-1];
            }
        }
    }

    /**
     * 중복숫자 허용하지 않으면서 정렬이 없는 경우
     * 숫자 사용여부를 체크해야함
     * */
    static void reculSolve3(int k) {
        if(k == M+1) /* 모든 자리에 값 세팅 이후 */ {
            for(int i = 1 ; i < selected3.length; i++)
                sb3.append(selected3[i]).append(' ');
            sb3.append('\n');
        }else {
            for(int cand = 1; cand <= N; cand++) {
                // 사용중인 숫자가 아니면 진행해야함 그렇다면 사용되는 숫자를 체크하는 로직이 필요함
                if(used[cand]) continue;

                selected3[k] = cand;
                used[cand] = true;
                reculSolve3(k+1);
                selected3[k] = 0;
                used[cand] = false;

            }
        }
    }

    /**
     * 중복숫자 허용하지 않으면서 정렬조건이 있는 경우
     * */
    static void reculSolve4(int k) {
        if(k == M+1) /* 모든 자리에 값 세팅 이후 */ {
            for(int i = 1 ; i < selected4.length; i++)
                sb4.append(selected4[i]).append(' ');
            sb4.append('\n');
        }else {
            for(int cand = selected4[k-1]+1 ; cand <= N; cand++){
                selected4[k] = cand;
                reculSolve4(k+1);
            }
        }
    }

    public static void main(String[] args) {
        input();
        reculSolve1(1);
        System.out.println(sb1.toString());

        reculSolve2_1(1);
        System.out.println(sb2_1.toString());

        reculSolve2_2(1);
        System.out.println(sb2_2.toString());

        reculSolve3(1);
        System.out.println(sb3.toString());

        reculSolve4(1);
        System.out.println(sb4.toString());
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
