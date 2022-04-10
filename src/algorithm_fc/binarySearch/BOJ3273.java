package algorithm_fc.binarySearch;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ3273 {

    static int N;
    static int a[];
    static int X;

    static void input() {
        FastScan fc = new FastScan();

        N = fc.nextInt();
        a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = fc.nextInt();
        }

        X = fc.nextInt();
    }

    static void solve(){
        Arrays.sort(a);

        int cnt = 0;
        for(int i = 1; i < N; i++) {
            if(binarySearch(a, i, N-1, X-a[i-1], i-1)){
                cnt++;
            }
        }

        System.out.println(cnt);
    }

    static boolean binarySearch(int array[], int L, int R, int target, int targetIndex) {
        while(L<=R) {
            int mid = (L+R) /2;
            if(array[mid] == target) {
                if(targetIndex < mid) {
                    return true;
                }else {
                    return false;
                }
            }
            if(array[mid] < target) {
                L = mid + 1;
            }else {
                R = mid - 1;
            }

        }
        return false;
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
