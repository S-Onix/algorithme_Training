package algorithm_fc.twoPointer;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2470 {

    static int N;
    static int A[];

    static void input(){
        FastScan fc = new FastScan();
        N = fc.nextInt();

        A = new int[N];
        for(int i =0; i< N; i++) {
            A[i] = fc.nextInt();
        }
    }

    static void solve(){
        Arrays.sort(A);
        int R = N-1;
        int val1 = 0, val2 = 0;
        int bestSum = Integer.MAX_VALUE;
        StringBuilder sb = new StringBuilder();
        for(int L = 0; L <= R;) {
            int sum = A[L] + A[R];
            if(Math.abs(sum) < bestSum){
                bestSum = Math.abs(sum);
                val1 = A[L];
                val2 = A[R];
            }

            if(sum > 0) {
                R--;
            }else if(sum < 0){
                L++;
            }else {
                val1 = A[L];
                val2 = A[R];
                break;
            }
        }

        System.out.println(val1 + " " + val2);
    }

    static class FastScan {
        BufferedReader br;
        StringTokenizer st;

        public FastScan(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastScan(String name) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(name));
        }

        String next(){
            while(st == null || !st.hasMoreElements()){
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        public int nextInt(){
            return Integer.parseInt(next());
        }

        public double nextDouble(){
            return Double.parseDouble(next());
        }

        public long nextLong(){
            return Long.parseLong(next());
        }

        public String nextLine(){
            String str ="";

            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
