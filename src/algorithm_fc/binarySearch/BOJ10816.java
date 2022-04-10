package algorithm_fc.binarySearch;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

//숫자 카드
public class BOJ10816 {
    static int N, M;
    static int a[];
    static int b[];

    static void input(){
        FastScan fc = new FastScan();

        N = fc.nextInt();
        a = new int [N];
        for(int i = 0 ; i < N; i++) {
            a[i] = fc.nextInt();
        }

        M = fc.nextInt();
        b = new int [M];
        for(int i = 0 ; i < M; i++) {
            b[i] = fc.nextInt();
        }

    }


    static void solve(){
        Arrays.sort(a);
        StringBuilder sb = new StringBuilder();

        for(int i = 0 ; i < M; i++) {
            int leftCandidate = binarySearchLeft(a, 0, N-1, b[i]);
            if(leftCandidate != -1) {
                int rightCandidate = binarySearchRight(a, leftCandidate, N-1, a[leftCandidate]);
                int cnt = rightCandidate - leftCandidate + 1;
                sb.append(cnt).append(' ');
            }else {
                sb.append('0').append(' ');
            }
        }

        System.out.println(sb.toString());
    }

    static int binarySearchLeft(int [] array, int L, int R, int target){
        int result = -1;
        while(L<=R) {
            int mid = (L+R)/2;
            if(array[mid] >= target) {
                if(array[mid] == target) {
                    result = mid;
                }
                R = mid - 1;
            }else {
                L = mid + 1;
            }
        }
        return result;
    }

    //오른쪽 구하기
    static int binarySearchRight(int [] array, int L, int R, int target){
        int result = -1;
        while(L<=R) {
            int mid = (L+R)/2;
            if(array[mid] <= target) {
                if(array[mid] == target) {
                    result = mid;
                }
                L = mid + 1;
            }else {
                R = mid - 1;
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
