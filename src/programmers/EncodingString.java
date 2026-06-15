package programmers;

import java.util.Arrays;

public class EncodingString {
    public static void main(String[] args) {
        String test = "aaabbccddeeabcabc";
        String test2 = "abcabcabcabcabc";
        solution(test);
        solution(test2);
    }


    public static int solution(String s) {
        // 여기에 코드를 작성하세요
        if (s.length() == 1) return 1;

        int [] result = new int [s.length() / 2];


        for(int i = 1; i <= s.length() /2 ; i++) {
            StringBuilder sb = new StringBuilder();
            String prev = s.substring(0, i);

            int count = 1;

            for(int j = i; j < s.length(); j += i) {
                String curr = s.substring(j, Math.min(j+i, s.length()));

                if (curr.equals(prev)) {
                    count++;
                }else {
                    if(count > 1) sb.append(count);
                    sb.append(prev);
                    prev = curr;
                    count = 1;

                }
            }
            if (count > 1) sb.append(count);
            sb.append(prev);

            result[i - 1] = sb.length();
        }

        /**
         * 최소값 구하기
         * */
        Arrays.sort(result);
        return result[0];
    }

}
