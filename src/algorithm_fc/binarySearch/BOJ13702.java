package algorithm_fc.binarySearch;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ13702 {

    static int N, K;
    static int [] A;

    static void input(){
        FastScan fc = new FastScan();
        N = fc.nextInt();
        K = fc.nextInt();

        A = new int[N+1];
        for(int i = 1; i <= N; i++) {
            A[i] = fc.nextInt();
        }

    }

    static boolean determination(long limit){
       if(limit == 0) {
           return false;
       }
       long sum = 0;

       for(int i = 1; i <= N; i++) {
           sum += A[i]/limit;
       }

       return sum >= K;
    }

    static void solve(){
        long L = 0;
        long R = 100000000000L;
        long result = 0;

        while(L<=R) {
            long mid = (L+R) /2;
            if(determination(mid)){
                result = mid;
                L = mid + 1;
            }else {

                R = mid - 1;
            }
        }

        System.out.println(result);

    }

    public static void main(String[] args) {
        input();
        solve();
    }


    static class FastScan{
        BufferedReader br;
        StringTokenizer st;

        public FastScan(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastScan(String name) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(name));
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
