package src.practrice.week1;

import java.util.ArrayList;
import java.util.List;

public class NotDuplicateFirestChar {
    public static void main(String[] args) {
        String test = "abCCadAabac";
        char result = solve(test);
        System.out.println(result);


    }
    
    public static char solve(String inputString) {
        /**
         * 문자가 반복되는가?
         * 문자중 먼저나온 순서는 어떻게 정하는가?
         * 
         * >> 빈도수로 체크 (1인 것들만)
         * >> 
         */
        int [] manyCount = new int[100];
        List<Character> notRepeatChar = new ArrayList<>();
        char result = '0';
        // 알파벳만 저장
        for(int i = 0; i < inputString.length(); i++) {
            if(Character.isLetter(inputString.charAt(i))) {
                manyCount[inputString.charAt(i) - 'A']++;
            }
        }

        for(int i = 0; i < manyCount.length; i++) {
            if(manyCount[i] == 1) {
                notRepeatChar.add((char)(i+'A'));
            }
        }

        for(char c : inputString.toCharArray()){
            if(notRepeatChar.contains(c)) {
                return c;
            }
        }

        return '_';
    }
}
