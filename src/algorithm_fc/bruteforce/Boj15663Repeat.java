package algorithm_fc.bruteforce;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Boj15663Repeat {
    /**
     * 첫번째 줄에는 N과 M이 입력된다.
     * 두번째 줄은 N개 만큼 숫자를 입력한다. (1<=N<=1000000)
     * <p>
     * N은 숫자의 갯수 M은 자리 수를 나타낸다.
     * M자리수를 나타낼 수 있는 값들을 출력하시오
     * <p>
     * 3 3
     * 1 1 3
     * >>
     * 1 1 3
     * 1 3 1
     * 3 1 1
     */

    //사용되는 숫자를 가진 arrayList
    static ArrayList<Integer> numList = new ArrayList<>();
    // 입력된 숫자 중 중복된 숫자를 카운트하는 변수
    static HashMap<Integer, Integer> numCntMap = new HashMap<>();
    static FastReader fr = new FastReader();
    static int N, M;
    static int [] selected;
    static StringBuilder sb;

    static void initialize(){
        String firstLine = fr.nextLine();
        String secondLine = fr.nextLine();

        String [] first = firstLine.split(" ");
        String [] second = secondLine.split(" ");

        N = Integer.parseInt(first[0]);
        M = Integer.parseInt(first[1]);

        if(N != second.length) {
            return;
        }

        for(String numStr : second) {
            int num = Integer.parseInt(numStr);
            if(!numList.contains(num)){
                numList.add(num);
            }

            numCntMap.merge(num,1,Integer::sum);
        }

        Collections.sort(numList);
        selected = new int[M+1];
        sb = new StringBuilder();
    }

    static void reculSolve(int k){
        // 탈출조건 : k가 자릿수를 넘었을 경우
        if(k == M+1) {
            for(int i = 1; i <= M; i++) {
                sb.append(selected[i]).append(" ");
            }
            sb.append("\n");
        }else {
            for(Integer number : numList) {
                selected[k] = number;
                if(numCntMap.get(number) > 0){
                    numCntMap.put(number, numCntMap.get(number)-1);
                    reculSolve(k+1);
                    numCntMap.put(number, numCntMap.get(number)+1);
                }
            }
        }

    }

    public static void main(String[] args) {

    }


    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String name) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(name)));
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

        double nextDouble() {
            return Double.parseDouble(next());
        }

        long nextLong() {
            return Long.parseLong(next());
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
