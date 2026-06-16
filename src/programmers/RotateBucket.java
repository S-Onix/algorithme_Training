package programmers;

import java.util.Stack;

public class RotateBucket {
    public static void main(String[] args) {
        String s = "(){}[]";
        System.out.println(solution(s));
    }


    public static int solution(String s) {
        // 여기에 코드를 작성하세요
        /**
         * 왼쪽으로 회전하는 방법
         * 괄호끼리의 짝이 맞는지 확인
         *   - stack을 사용하여 완성여부 체크 (별도의 메서드로 boolean값 반환)
         * */
        if(s.length() % 2 != 0) return 0;

        String curr = s;
        int cnt = 0;


        for(int i = 0 ; i < s.length()-1 ; i++) {
            if(isPaired(curr)) {
                cnt++;
            }
            curr = curr.substring(1) + curr.charAt(0);
        }

        return cnt;
    }

    public static boolean isPaired(String s) {
        Stack<Character> stack = new Stack<>();

        if(s.charAt(0) == ')' || s.charAt(0) == ']' || s.charAt(0) == '}') return false;

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(' || c == '[' || c == '{'){
                //push
                stack.push(c);
            }else {
                //pop , 이전에 push로 (,[,{가 있어야함
                if (stack.isEmpty()) return false;
                Character compare = stack.peek();
                if((compare == '(' && c == ')') || (compare == '{' && c == '}') || (compare == '[' && c == ']')){
                    stack.pop();
                }else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
