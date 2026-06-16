package programmers;

public class StringToNumber {
    public static void main(String[] args) {
        System.out.println(solution("+12345"));
        System.out.println(solution("-12345"));
        System.out.println(solution("012345"));
        System.out.println(solution("-120345"));
        System.out.println(solution("0"));
    }
    public static int solution(String s) {
        // 여기에 코드를 작성하세요
        int result = 0;
        for(int i = 0 ; i < s.length(); i++) {
            if(i == 0 && (s.charAt(0) == '+' || s.charAt(0) == '-')) continue;
            result = result * 10 + (s.charAt(i) - '0');
        }
        if(s.charAt(0) == '-') {
            result *= -1;
        }
        return result;
    }
}
