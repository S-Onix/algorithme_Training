package algorithm_fc.binarySearch;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2343 {

    static int N,M;
    static int [] lessons;

    static void input(){
        FastScan fc = new FastScan();

        N = fc.nextInt();
        M = fc.nextInt();

        lessons = new int [N];
        for(int i =0; i < N; i++) {
            lessons[i] = fc.nextInt();
        }
    }

    static boolean determination(int len) {
        int cnt = 1, sum = 0;
        for (int i = 0; i < N; i++) {
            if (sum + lessons[i] > len) {
                cnt++;
                sum = lessons[i];
            } else {
                sum += lessons[i];
            }
        }
        return cnt <= M;
    }

    static void solve(){
        Arrays.sort(lessons);

        int L = lessons[N-1];
        int R = 1000000000;
        int result = 0;

        while(L<=R) {
            int mid = (L+R) / 2;
            if(determination(mid)) {
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
