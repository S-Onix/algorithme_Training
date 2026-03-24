package src.practrice.week3;

import java.util.Stack;

public class CorrectOperator {
    public static void main(String[] args) {
        String s = "()()((()))";
        String s2 = "())(";
        String s3 = ")((())";
        String s4 = "((()()())";

        System.out.println(solve(s));
        System.out.println(solve(s2));
        System.out.println(solve(s3));
        System.out.println(solve(s4));

    }

    public static boolean solve(String s) {
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            if (i == 0 && s.charAt(i) == ')') {
                return false;
            }
            if(stack.isEmpty() && s.charAt(i) == ')') {
                return false;
            }

            char c = s.charAt(i);
            if(c == '(') {
                stack.push(c);
            }else {
                stack.pop();
            }
        }

        if(!stack.isEmpty()) {
            return false;
        }else {
            return true;
        }

    }
}
