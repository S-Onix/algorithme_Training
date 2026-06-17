package programmers;

import java.util.Stack;

public class DecodingString {
    public String solution(String s) {
        // 여기에 코드를 작성하세요
        /**
         * 숫자가 나올때
         *   - 다음이 괄호가 나올때
         *     - 괄호가 끝날때까지 조회
         *       - 괄호가 끝나면 괄호 안의 내용을 숫자만큼 반복 작성
         *   - 다음이 문자가 나올 때
         *     - 숫자만큼 반복 작성
         *   - 다음이 숫자가 나올 때
         *     이전 숫자 * 10 + 다음 숫자
         * */
        Stack<String> strStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        StringBuilder curr = new StringBuilder();
        int num = 0;


        for(int i = 0 ; i < s.length(); i++) {
            Character standChar = s.charAt(i);

            if(Character.isDigit(standChar)) {
                num = (num * 10) + (standChar - '0');
            }else if (standChar == '(') {
                strStack.push(curr.toString());
                numStack.push(num);
                num = 0;
                curr = new StringBuilder();
            }else if (standChar == ')') {

                String popStr = strStack.pop();
                int repeatNum = numStack.pop();
                String repeated = curr.toString().repeat(repeatNum);
                curr = new StringBuilder(popStr + repeated);

            } else {
                if(num > 0) {
                    curr.append(String.valueOf(standChar).repeat(num));
                    num = 0;
                }else {
                    curr.append(standChar);
                }
            }
        }
        return curr.toString();
    }
}
