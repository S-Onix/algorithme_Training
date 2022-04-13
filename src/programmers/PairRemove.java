package programmers;

import java.util.LinkedList;
import java.util.Stack;

public class PairRemove {
    // 연속되는 문자가 된다면 제거한다 > stack문제

    public int solution(String s)
    {
        Stack<Character> stack = new Stack<Character>();

        for(char c : s.toCharArray()){
            if(!stack.isEmpty() && stack.peek() == c) stack.pop();
            else stack.push(c);
        }

        return stack.isEmpty() ? 1 : 0;
    }

    public static void main(String[] args) {
        PairRemove pr = new PairRemove();
        System.out.println(pr.solution("baabaa"));
    }
}
