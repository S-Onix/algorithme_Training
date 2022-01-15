package algorithm_fc.bruteforce;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Boj15663 {

    static HashMap<Integer, Integer> numberCnt;
    static ArrayList<Integer> numberList;
    static int[] selected;
    static StringBuilder sb;
    static int N, M;
    static String inputFirstLine;
    static String inputSecondLine;

    static void input(){
        FastScan fc = new FastScan();
        inputFirstLine = fc.nextLine();
        String [] firstLines = inputFirstLine.split(" ");

        if(firstLines.length != 2) {
            System.out.println("N과 M을 제대로 입력해주세요");
            return;
        }

        N = Integer.parseInt(firstLines[0]);
        M = Integer.parseInt(firstLines[1]);

        inputSecondLine = fc.nextLine();
        String [] secondLines = inputSecondLine.split(" ");

        if(secondLines.length != N) {
            System.out.println("N의 개수가 맞지 않습니다");
            return;
        }

        numberList = new ArrayList<>();
        numberCnt = new HashMap<>();

        for(String number: secondLines) {
            int intNum = Integer.parseInt(number);
            if(!numberList.contains(intNum)){
                numberList.add(intNum);
            }
            numberCnt.merge(intNum, 1, Integer::sum);
        }

        selected = new int[M+1];
        sb = new StringBuilder();
        Collections.sort(numberList);
    }

    static void reculSolve(int k) {
        if(k == M+1){
            for(int i = 1; i < selected.length; i++) sb.append(selected[i]).append(' ');
            sb.append('\n');
        }else {
            for(Integer number : numberList){
                    selected[k] = number;
                    if(numberCnt.get(number) >= 1) {
                        numberCnt.put(number, numberCnt.get(number) - 1);
                        reculSolve(k + 1);
                        numberCnt.put(number, numberCnt.get(number)+1);
                    }

            }
        }
    }

    public static void main(String[] args) {
        input();

        System.out.println(numberCnt);
        System.out.println(numberList);

        reculSolve(1);
        System.out.println(sb.toString());
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
