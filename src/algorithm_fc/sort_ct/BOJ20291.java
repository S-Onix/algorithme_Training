package algorithm_fc.sort_ct;

import java.io.*;
import java.util.*;

public class BOJ20291 {

    static int N;
    static String[] extendArray;

    public static void input(){
        FastScan fc =new FastScan();

        N = fc.nextInt();
        extendArray = new String[N];

        for(int i = 0; i < N; i++) {
            extendArray[i] = fc.nextLine().split("\\.")[1];
        }

        for(int i = 0 ; i < extendArray.length;i++) {
            System.out.println(extendArray[i]);
        }
    }

    public static void solve(){
        Arrays.sort(extendArray);

        System.out.println();

        for(int i = 0 ; i < extendArray.length;i++) {
            System.out.println(extendArray[i]);
        }
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < N;) {
            int cnt = 1;
            int j = i+1;
            for(; j < N; j++) {
                if(extendArray[j].compareTo(extendArray[i]) == 0){
                    cnt++;
                }else {
                    break;
                }
            }
            sb.append(extendArray[i]).append(' ').append(cnt).append("\n");

            i = j;
        }

        System.out.println(sb.toString());
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