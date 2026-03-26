package src.programmers;

public class Lv2RightParentheses {
    boolean solution(String s) {
        // 여기에 코드를 작성하세요
        char [] chars = s.toCharArray();
        int count = 0;
        for(char c : chars) {
            if(c == '(') {
                count++;
            }else {
                count--;
            }
            if(count < 0 ) {
                return false;
            }
        }

        return count == 0;
    }
}
