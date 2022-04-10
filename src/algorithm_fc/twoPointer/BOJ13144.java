package algorithm_fc.twoPointer;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ13144 {
    static int N;
    static boolean usedNum[] = new boolean [100001];
    static int nums[];

    static void input(){
        FastScan fc = new FastScan();
        N = fc.nextInt();
        nums = new int [N+1];
        for(int i = 1; i <= N; i++) {
            nums[i] = fc.nextInt();
        }
    }

    static void solve(){
        int R = 0;
        long cnt = 0;

        for(int L = 1; L <= N; L++){
            while(R+1 <= N && !usedNum[nums[R+1]]) {
                R++;
                usedNum[nums[R]] = true;
            }

            cnt += R-L+1;
            usedNum[nums[L]] = false;
        }


        System.out.println(cnt);
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
