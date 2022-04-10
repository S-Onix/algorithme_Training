package algorithm_fc.binarySearch;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2512 {

    static int N;
    static int M;

    static int contries[];

    static void input(){
        FastScan fc = new FastScan();
        N = fc.nextInt();
        contries = new int [N];
        for(int i = 0; i < N; i++) {
            contries[i] = fc.nextInt();
        }

        M = fc.nextInt();
    }

    static boolean determination(int budget) {
        int sum = 0;

        for(int i = 0; i < N; i++) {
            if(contries[i] <= budget){
                sum+=contries[i];
            }else {
                sum+=budget;
            }
        }

        return sum <= M;
    }

    static void solve(){
        Arrays.sort(contries);

        int L = 0;
        int R = contries[contries.length-1];
        int result = 0;
        while(L<=R) {
            int mid = (L+R)/2;
            if(determination(mid)) {
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
