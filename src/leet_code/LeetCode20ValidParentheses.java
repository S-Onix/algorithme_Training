package src.leet_code;

import java.util.ArrayDeque;
import java.util.Deque;

public class LeetCode20ValidParentheses {
    //stack에서 pop을 통해 짝이 맞는지 비교해야함

    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for(char c : s.toCharArray()) {
            if(c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }else {
                if(stack.isEmpty()) return false;
                char top = stack.pop();
                if(c == ')' && top != '(') return false;
                else if(c == '}' && top != '{') return false;
                else if(c == ']' && top != '[') return false;
            }
        }

        return stack.isEmpty();
    }
}
