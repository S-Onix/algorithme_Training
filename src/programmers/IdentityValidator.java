package programmers;

public class IdentityValidator {
    public int solution(String[] ids) {
        int count = 0;
        for (String id : ids) {
            if (isValid(id)) count++;
        }
        return count;
    }

    boolean isValid(String s) {
        // 여기에 코드를 작성하세요
        /**
         * 1. 길이: 4자 이상 20자 이하
         * 2. 사용 가능 문자: 영소문자, 숫자, '_', '-', '.'
         * 3. 첫 번째, 마지막 문자: 영소문자 또는 숫자만 허용
         * 4. '.' 는 연속으로 올 수 없음 ("a..b" 불가)
         * 5. '__', '--' 등 '_', '-' 연속은 허용
         * */
        if ( s.length() <4 || s.length() > 20) return false;
        if(!s.matches("[a-z0-9._\\-]+")) return false;
        if(!Character.isLetterOrDigit(s.charAt(0)) || !Character.isLetterOrDigit(s.charAt(s.length()-1))) return false;
        if(s.contains("..")) return false;

        return true;
    }
}
