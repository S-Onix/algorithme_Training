package programmers;

public class StringDivide {
    public static void main(String[] args) {
        System.out.println(solution("banana"));
        System.out.println(solution("aababcab"));
    }

    public static int solution(String s) {
        // 여기에 코드를 작성하세요
        /**
         * 기준 문자
         * 비교 문자
         * 기준 문자 카운트
         * 비교 문자 카운트
         *
         * */
        int standardCnt = 0;
        int otherCnt = 0;
        int resultCnt = 0;
        char x = s.charAt(0);

        for(int i = 0; i < s.length(); i++) {
            if(standardCnt == 0) x = s.charAt(i);

            if(s.charAt(i) == x ) standardCnt++;
            else otherCnt++;

            if(standardCnt == otherCnt) {
                resultCnt++;
                otherCnt = 0;
                standardCnt = 0;
            }
        }

        if(standardCnt > 0) resultCnt++;


        return resultCnt;
    }
}
