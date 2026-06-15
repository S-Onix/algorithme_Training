package programmers;

public class IdentityCreator {

    public String solution(String new_id) {
        /**
         * 1단계: 소문자 변환          "ABC" → "abc"
         * 2단계: 허용 문자만 남기기   소문자, 숫자, -, _, . 만 허용
         * 3단계: 연속된 . 제거        "a..b" → "a.b"
         * 4단계: 앞뒤 . 제거          ".abc." → "abc"
         * 5단계: 빈 문자열이면        "aaa" 로 대체
         * 6단계: 16자 이상이면        15자로 자르고 끝 . 제거
         * 7단계: 2자 이하이면         길이가 3이 될 때까지 마지막 문자 반복
         * */
        // 여기에 코드를 작성하세요
        // 1단계: 소문자 변환
        String s = new_id.toLowerCase();

        // 2단계: 허용 문자만 남기기
        s = s.replaceAll("[^a-z0-9\\-_.]", "");

        // 3단계: 연속된 . 제거
        s = s.replaceAll("\\.{2,}", ".");

        // 4단계: 앞뒤 . 제거
        s = s.replaceAll("^\\.|\\.$", "");

        // 5단계: 빈 문자열이면 "aaa"
        if (s.isBlank()) s = "aaa";

        // 6단계: 16자 이상이면 15자로 자르고 끝 . 제거
        if (s.length() >= 16) {
            s = s.substring(0, 15);
            s = s.replaceAll("\\.$", "");
        }

        // 7단계: 2자 이하이면 마지막 문자 반복
        while (s.length() < 3) {
            s += s.charAt(s.length() - 1);
        }

        return s;
    }
}
