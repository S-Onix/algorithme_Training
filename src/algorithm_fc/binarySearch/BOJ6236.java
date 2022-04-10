package algorithm_fc.binarySearch;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ6236 {

    static int N, M;
    static int [] spends;

    static void input(){
        FastScan fc = new FastScan();

        N = fc.nextInt();
        M = fc.nextInt();

        spends = new int [N+1];

        for(int i = 1 ; i <= N; i++) {
            spends[i] = fc.nextInt();
        }
    }

    static boolean determination(int K) {
        int cnt = 1;
        int sum = 0;
        for(int i = 0; i < N; i++) {
            if(sum+spends[i] > K) {
                cnt++;
                sum = spends[i];
            }else {
                sum += spends[i];
            }
        }

        return cnt <= M;
    }

    static void solve(){

        int L = spends[1];

        for(int i = 2; i <= N; i++) L = Math.max(L,spends[i]);

        int R = 1000000000;
        int result = 0;

        while(L<=R) {
            int mid = (L+R)/2;
            if(determination(mid)) {
                R = mid - 1;
                result = mid;
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
