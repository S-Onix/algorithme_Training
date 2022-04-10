package algorithm_fc.twoPointer;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ3273 {
    static int N;
    static int X;
    static int [] A;

    static void input(){
        FastScan fc = new FastScan();
        N = fc.nextInt();
        A = new int[N];
        for(int i = 0 ; i < N; i++) {
            A[i] = fc.nextInt();
        }
        X= fc.nextInt();
    }

    static void solve(){
        Arrays.sort(A);
        int L = 0;
        int R = N-1;
        int result = 0;
        while(L<R) {
            if(A[R]+A[L] == X) result++;
            if(A[R]+A[L] >= X) R--;
            else L++;
        }

        System.out.println(result);
    }

    public static void main(String[] args) {
        input();
        solve();
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
