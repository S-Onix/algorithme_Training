package algorithm_fc.twoPointer;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2230 {

    //차이가 M 이상이면서 격차가 가장 작은 수를 구하시오
    static int N;
    static int M;
    static int [] A;

    static void input(){
        FastScan fc = new FastScan();
        N =fc.nextInt();
        M = fc.nextInt();
        A = new int [N];
        for(int i = 0 ; i < N; i++) {
            A[i] = fc.nextInt();
        }
    }

    static void solve(){
        Arrays.sort(A);
        int R = 0;
        int result = 2000000001;

        for(int L = 0; L < N; L++) {

            while(R+1 < N && A[R]-A[L] < M){
                ++R;
            }

            if (A[R] - A[L] >= M) {
                result = Math.min(result, A[R]-A[L]);
            }
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
