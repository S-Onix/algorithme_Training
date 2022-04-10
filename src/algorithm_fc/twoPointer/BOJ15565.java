package algorithm_fc.twoPointer;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ15565 {
    static int N, K;
    static int [] array;

    static void input(){
        FastScan fc = new FastScan();
        N = fc.nextInt();
        K = fc.nextInt();

        array = new int [N+1];
        for(int i = 1; i <= N; i++) {
            array[i] = fc.nextInt();
        }
    }

    static void solve(){
        int cnt = 0;
        int R = 0;
        int result = N+1;
        for(int L = 1; L <=N; L++) {
            while(cnt < K && R+1 <= N) {
                if(array[++R] == 1) {
                    cnt++;
                }
            }

           if(cnt == K){
                result = Math.min(result, R-L+1);
                if(array[L] == 1) {
                    cnt--;
                }
            }
        }

        if(result == N+1) {
            result = -1;
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
