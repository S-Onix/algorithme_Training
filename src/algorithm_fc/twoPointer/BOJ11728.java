package algorithm_fc.twoPointer;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ11728 {

    static int N, M;
    static int[] result;

    static void input(){
        FastScan fc = new FastScan();
        N = fc.nextInt();
        M = fc.nextInt();
        result = new int [N+M];
        for(int i = 0; i < N+M; i++) {
            result[i] = fc.nextInt();
        }
    }

    static void solve(){
        Arrays.sort(result);
        StringBuilder sb = new StringBuilder();

        for (int j : result) {
            sb.append(j).append(' ');
        }
        System.out.println(sb.toString());
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
