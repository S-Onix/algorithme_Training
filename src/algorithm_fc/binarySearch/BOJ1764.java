package algorithm_fc.binarySearch;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1764 {
    static int N, M;

    static String A[], B[];

    static void input(){
        FastScan fc = new FastScan();
        N = fc.nextInt();
        A = new String[N];
        for(int i = 0; i < N; i++) {
            A[i] = fc.next();
        }

        M = fc.nextInt();
        B = new String[M];
        for(int i = 0; i < M; i++) {
            B[i] = fc.next();
        }
    }

    static void solve(){
        Arrays.sort(A);
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        String[] ans = new String[N];
        for(int i = 0; i < M; i++) {
            if(binarySearch(A, 0, N-1, B[i])){
                ans[cnt++] = B[i];
            }
        }

        Arrays.sort(ans);
        sb.append(cnt).append('\n');
        for (int i = 0; i < cnt; i++) {
            sb.append(ans[i]).append('\n');
        }
        System.out.println(sb);
    }

    static boolean binarySearch(String [] array, int L, int R, String target) {
        while(L <= R) {
            int mid = (L+R)/2;
            if(array[mid].equals(target)) {
                return true;
            }

            if (array[mid].compareTo(target) < 0){
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
