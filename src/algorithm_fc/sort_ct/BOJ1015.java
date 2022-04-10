package algorithm_fc.sort_ct;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ1015 {

    static int N;
    static ArrayList<Number> inputList = new ArrayList<>();
    static int [] result;

    public static void input(){
        FastScan fc = new FastScan();
        N = fc.nextInt();

        result = new int[N];

        for(int i = 0 ; i < N; i++) {
            Number number = new Number(fc.nextInt(), i);
            inputList.add(number);
        }
    }

    public static void solve(){
        Collections.sort(inputList);

        for(int i = 0 ; i < inputList.size(); i++) {
            result[inputList.get(i).index] = i;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < result.length; i++) {
            sb.append(result[i]).append(' ');
        }



        System.out.println(sb.toString());

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

    public static void main(String[] args) {
        input();
        solve();
    }
}

class Number implements Comparable<Number> {
    int number;
    int index;

    public Number(int number, int index) {
        this.number = number;
        this.index = index;
    }

    @Override
    public int compareTo(Number other) {
        return this.number - other.number;
    }
}

