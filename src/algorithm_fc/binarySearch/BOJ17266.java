package algorithm_fc.binarySearch;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ17266 {

    static int N;
    static int M;
    static int []X;

    static void input(){
        FastScan fc = new FastScan();
        N = fc.nextInt();
        M = fc.nextInt();

        X = new int [M+1];
        X[0] = 0;
        for(int i = 1 ; i <= M; i++) {
            X[i] = fc.nextInt();
        }
    }

    static boolean determintaion(int H){
        for (int i = 1; i <= M; i++) {
            if((X[i] - X[i-1]) > H*2){
                return false;
            }
        }
        return true;
    }

    static void solve(){
        int L = X[1]-X[0];
        for(int i = 2; i <= M; i++) L = Math.max(L, (X[i]-X[i-1])/2);
        L = Math.max(L, N-X[M]);

        int R = 100000;
        int result = 0;

        while(L<=R) {
            int mid = (L+R)/2;
            if(determintaion(mid)) {
                result = mid;
                R = mid - 1;
            }else {
                L = mid + 1;
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
