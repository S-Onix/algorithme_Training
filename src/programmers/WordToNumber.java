package programmers;

public class WordToNumber {

    public static void main(String[] args) {
        System.out.println(solution("one4seveneight"));
        System.out.println(solution("23four5six7"));
        System.out.println(solution("2three45sixseven"));
        System.out.println(solution("twoone3four"));

    }

    public static int solution(String s) {
        // 여기에 코드를 작성하세요
        String [] words = {"zero", "one","two","three","four","five","six","seven","eight","nine"};
        for(int i = 0; i < words.length; i++) {
            s = s.replace(words[i], String.valueOf(i));
        }
        return Integer.parseInt(s);
    }
}
