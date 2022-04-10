package algorithm_fc.binarySearch;

import java.io.*;
import java.util.StringTokenizer;

//랜선 자르기
public class BOJ1654 {

    static int K;
    static int N;

    static int lenLine[];

    static void input(){
        FastScan fc = new FastScan();

        K = fc.nextInt();
        lenLine = new int [K];
        N = fc.nextInt();

        for(int i = 0; i < K; i++) {
            lenLine[i] = fc.nextInt();
        }
    }

    static boolean determination(int lenLength){
        int result = 0;
        for(int i = 0 ; i < K; i++) {
            result += lenLine[i]/lenLength;
        }
        return result>=N;
    }

    static void solve(){
        long L = 1;
        long R = Integer.MAX_VALUE;
        int result = 0;

        while(L<=R) {
            long mid = (L+R)/2;
            if(determination((int)mid)) {
                L = mid + 1;
                result = (int) mid;
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
