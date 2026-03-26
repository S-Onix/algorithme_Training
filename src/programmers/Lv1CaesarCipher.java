package src.programmers;

public class Lv1CaesarCipher {
    // n 만큼 이후의 문자로 변환한다.
    // character는 int형이다. 이것을 이용하면 된다,
    // 고려해야할 점 끝에 있는 것은 어떻게 할 것인가?
    // 대문자와 소문자의 경우 어떻게 처리할 것인가?
    public static String solution(String s, int n) {
        StringBuilder sb= new StringBuilder();
        char [] chars = s.toCharArray();

        for(char c : chars) {
            if(Character.isLowerCase(c)) {
                sb.append((char) ('a' + (c - 'a' + n) % 26));
            }else if(Character.isUpperCase(c)) {
                sb.append((char) ('A' + (c - 'A' + n) % 26));
            }else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(solution("AZasdbcZz", 3));
    }
}
