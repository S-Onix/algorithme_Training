package algorithm_fc.sort_ct;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ11652 {
    public long solve(int n, long [] array){
        Arrays.sort(array, 1, n+1);

        long mode = array[1];
        int curCnt = 1, modeCnt = 1;

        for(int i = 1; i <= n; i++) {
            if(array[i-1] == array[i]) {
                curCnt++;
            }else {
                curCnt = 1;
            }

            if(curCnt > modeCnt) {
                mode = array[i];
            }
        }


        return mode;
    }

    public static void main(String[] args) {
        FastScan fc = new FastScan();
        int n = fc.nextInt();
        long [] array = new long[n+1];

        for(int i = 1; i < n ; i++) {
            array[i] = fc.nextLong();
        }

        Arrays.sort(array, 1, array.length+1);
        for(int i = 0; i < n ; i++) {
            System.out.println(array[i]);
        }


        BOJ11652 solve = new BOJ11652();
        solve.solve(n, array);
    }




    static class FastScan{
        BufferedReader br;
        StringTokenizer st;

        public FastScan(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastScan(String fileName) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(fileName)));
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
