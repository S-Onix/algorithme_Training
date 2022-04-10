package algorithm_fc.twoPointer;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1253 {

    static int N;
    static int nums[];

    static void input(){
        FastScan fc = new FastScan();
        N = fc.nextInt();
        nums = new int [N+1];
        for(int i = 1; i <= N; i++) {
            nums[i] = fc.nextInt();
        }
    }

    static boolean func(int target_idx) {
        int L = 1;
        int R = N;
        int target = nums[target_idx];
        while(L<R) {
            if(L == target_idx) L++;
            else if(R == target_idx) R--;
            else {
                if(nums[L] + nums[R] == target) {
                    return true;
                }

                if(nums[L] + nums[R] > target) {
                    R--;
                }else {
                    L++;
                }
            }

        }
        return false;
    }

    static void solve(){
        Arrays.sort(nums, 1, N+1);
        int result = 0;

        for(int i = 1; i <= N; i++) {
            if(func(i)) result++;
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
