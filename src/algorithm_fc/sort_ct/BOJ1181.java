package algorithm_fc.sort_ct;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ1181 {
    static int N;
    static ArrayList<Word> wordList = new ArrayList<>();

    public static void input(){
        FastScan fc = new FastScan();

        N = fc.nextInt();

        for(int i = 0 ; i < N ; i++) {
            Word word = new Word();
            word.word = fc.next();

            wordList.add(word);
        }
    }

    public static void solve(){
        Collections.sort(wordList);
        for(int i = 0; i <wordList.size(); i++) {
            if(i == 0 || wordList.get(i).compareTo(wordList.get(i-1)) != 0) {
                System.out.println(wordList.get(i).word);
            }
        }
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

class Word implements Comparable<Word> {
    String word;

    @Override
    public int compareTo(Word other){
        if(word.length() != other.word.length()) {
            return word.length() - other.word.length();
        }
        return word.compareTo(other.word);
    }
}