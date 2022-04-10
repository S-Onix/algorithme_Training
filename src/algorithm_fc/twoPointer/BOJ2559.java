package algorithm_fc.twoPointer;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ2559 {
    static int N;
    static int K;

    static int days[];

    static void input(){
        FastScan fc = new FastScan();
        N = fc.nextInt();
        K = fc.nextInt();
        days = new int[N+1];

        for(int i = 1; i <= N; i++) {
            days[i] = fc.nextInt();
        }
    }

    static int initSum(){
        int sum = 0;
        for(int i = 1; i <=K; i++) {
            sum += days[i];
        }
        return sum;
    }

    static void solve(){
        int L = 1;
        int result = initSum();
        int sum = result;
        // R = 3 부터 시작 L = 1
        for(int R = K+1 ; R <= N; R++) {
            sum = sum + days[R] - days[L++];
            result = Math.max(result, sum);
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
