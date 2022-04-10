package algorithm_fc.binarySearch;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1920 {

    static int N;
    static int M;
    static int A[], B[];

    static void input(){
        FastScan fc = new FastScan();

        N = fc.nextInt();
        A = new int [N];

        for(int i = 0 ; i < N; i++) {
            A[i] = fc.nextInt();
        }

        M = fc.nextInt();
        B = new int [M];

        for(int i = 0 ; i < M; i++) {
            B[i] = fc.nextInt();
        }
    }

    static void solve(){
        Arrays.sort(A);
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < M; i++) {
            sb.append(binarySearch(A, 0, N-1, B[i])).append('\n');
        }

        System.out.println(sb.toString());
    }

    static int binarySearch(int [] array, int L, int R, int target){
        int result = 0;
        while(L<=R) {
            int mid = (L+R)/2;
            if(array[mid] == target) {
                result = 1;
                break;
            }else if (array[mid] > target){
                R = mid - 1;
            }else {
                L  = mid + 1;
            }
        }
        return result;
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
